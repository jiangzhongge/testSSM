package com.jiang.seven.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class MyAccessDecisionManager implements AccessDecisionManager{
	
	//检查用户是否够权限访问资源
    //参数authentication是从spring的全局缓存SecurityContextHolder中拿到的，里面是用户的权限信息
    //参数object是url
    //参数configAttributes所需的权限

	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if(configAttributes == null){
			return;      
		} 

		Iterator<ConfigAttribute> ite=configAttributes.iterator();
		while(ite.hasNext()){

			ConfigAttribute ca=ite.next();  

			String needRole=((SecurityConfig)ca).getAttribute();

			for(GrantedAuthority ga : authentication.getAuthorities()){ 
				if(needRole.equals(ga.getAuthority())){ 
					return;             
				}           
			}
		}
		throw new  AccessDeniedException("noright");  
		//注意：执行这里，后台是会抛异常的，但是界面会跳转到所配的access-denied-page页面
	}
	
	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}

/*
 * 接口AccessDecisionManager也是必须实现的。
 *  decide方法里面写的就是授权策略了，笔者的实现是，没有明说需要权限的（即没有对应的权限的资源），可以访问，
 *  用户具有其中一个或多个以上的权限的可以访问。
 *  这个就看需求了，需要什么策略，读者可以自己写其中的策略逻辑。
 *  通过就返回，不通过抛异常就行了，spring security会自动跳到权限不足页面（配置文件上配的）。 
 *	就这样，整个流程过了一遍。 
 */
