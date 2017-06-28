package com.jiang.seven.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.jiang.seven.tools.AntUrlPathMatcher;
import com.jiang.seven.tools.UrlMatcher;

public class MyInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	private UrlMatcher urlMatcher = new AntUrlPathMatcher();

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	// tomcat启动时实例化一次

	public MyInvocationSecurityMetadataSource() {
		loadResourceDefine();
	}

	// tomcat开启时加载一次，加载所有url和权限（或角色）的对应关系
	private void loadResourceDefine() {

		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

		Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
		ConfigAttribute ca = new SecurityConfig("ROLE_USER");
		atts.add(ca);
		resourceMap.put("/index.jsp", atts);
		Collection<ConfigAttribute> attsno = new ArrayList<ConfigAttribute>();
		ConfigAttribute cano = new SecurityConfig("ROLE_NO");
		attsno.add(cano);
		resourceMap.put(
				"/http://blog.csdn.net/u012367513/article/details/other.jsp",
				attsno);
	}

	// 参数是要访问的url，返回这个url对于的所有权限（或角色）
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// 将参数转为url
		String url = ((FilterInvocation) object).getRequestUrl();
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {

			String resURL = ite.next();
			if (urlMatcher.pathMatchesUrl(resURL, url)) {
				return resourceMap.get(resURL);
			}
		}
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}
}

/*
 * 实现FilterInvocationSecurityMetadataSource接口也是必须的。 
 * 首先，这里也是模拟了从数据库中获取信息。 
 * 其中loadResourceDefine方法不是必须的，这个只是加载所有的资源与权限的对应关系并缓存起来，避免每次获取权限都访问数据库（提高性能），
 * 然后getAttributes根据参数（被拦截url）返回权限集合。 这种缓存的实现其实有一个缺点，因为loadResourceDefine方法是放在构造器上调用的，
 * 而这个类的实例化只在web服务器启动时调用一次，那就是说loadResourceDefine方法只会调用一次，如果资源和权限的对应关系在启动后发生了改变，那么缓存起来的就是脏数据，
 * 而笔者这里使用的就是缓存数据，那就会授权错误了。
 * 但如果资源和权限对应关系是不会改变的，这种方法性能会好很多。
 * 现在说回有数据库的灵活实现，读者看到这，可能会说，这还不简单，和上面MyUserDetailService类一样使用dao灵活获取数据就行啦。
 * 如果读者这样想，那只想到了一半，想一下spring的机制（依赖注入），dao需要依赖注入吧，但这是在启动时候，那个dao可能都还没加载，所以这里需要读者自己写sessionFactory，自己写hql或sql，
 * 对，就在loadResourceDefine方法里面写（这个应该会写吧，基础来的）。
 * 那如果说想用第二种方法呢（就是允许资源和权限的对应关系改变的那个），那更加简单，根本不需要loadResourceDefine方法了，直接在getAttributes方法里面调用dao
 * （这个是加载完，后来才会调用的，所以可以使用dao），通过被拦截url获取数据库中的所有权限，封装成Collection返回就行了。
 * （灵活、简单） 注意：接口UrlMatcher和实现类AntUrlPathMatcher是笔者自己写的，这本来是spring以前版本有的，现在没有了，但是觉得好用就用会来了，直接上代码
 * （读者也可以自己写正则表达式验证被拦截url和缓存或数据库的url是否匹配）：
 */
