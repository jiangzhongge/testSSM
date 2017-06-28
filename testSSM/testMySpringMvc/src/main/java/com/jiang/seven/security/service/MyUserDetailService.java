package com.jiang.seven.security.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jiang.seven.dao.UserInfoVoMapper;
import com.jiang.seven.entity.UserInfoVo;

public class MyUserDetailService implements UserDetailsService{

	//登陆验证时，通过username获取用户的所有权限信息，
    //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
	@Autowired
	private UserInfoVoMapper userInfoVoMapper ;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		System.out.println("输出请求的编码格式======="+request.getCharacterEncoding());
		if(username == null){
			throw new AuthenticationServiceException("用户名不能为空！");
		}
		UserInfoVo userInfoVo = userInfoVoMapper.getUserInfoVoBySelective(username) ;
		if(userInfoVo == null){
			throw new AuthenticationServiceException("用户名不存在！");
		}
		
		Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>(); 
		GrantedAuthority auth1 = new SimpleGrantedAuthority("ROLE_USER");
		GrantedAuthority auth2 =new SimpleGrantedAuthority("ROLE_ADMIN");
		if(userInfoVo != null && "李白".equalsIgnoreCase(userInfoVo.getName())){
		     auths=new ArrayList<GrantedAuthority>(); 
		     auths.add(auth1);
		     auths.add(auth2);     
		}    
		//匹配参数
		boolean enables = true;  
        boolean accountNonExpired = true;  
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
		User user = new User(username, userInfoVo.getPwd().toString(),enables,accountNonExpired,credentialsNonExpired,accountNonLocked,auths); 
		return user;  
	}
}
/*
 * 其中UserDetailsService接口是spring提供的，必须实现的。
 * 别看这个类只有一个方法，而且这么简单，其中内涵玄机。 
 * 读者看到这里可能就大感疑惑了，不是说好的用数据库吗？对，但别急，等笔者慢慢给你们解析。 
 * 首先，笔者为什么不用数据库，还不是为了读者们测试方便，并简化spring security的流程，让读者抓住主线，
 * 而不是还要烦其他事（导入数据库，配置数据库，写dao等）。 
 * 这里笔者只是用几个数据模拟了从数据库中拿到的数据，
 * 也就是说ROLE_ADMIN、ROLE_USER、lcy(第一个是登陆账号)、lcy(第二个是密码)是从数据库拿出来的，
 * 这个不难实现吧，如果需要数据库时，读者可以用自己写的dao通过参数username来查询出这个用户的权限信息
 * （或是角色信息，就是那个ROLE_*，对必须是ROLE_开头的，不然spring security不认账的，
 * 其实是spring security里面做了一个判断，必须要ROLE_开头，读者可以百度改一下），
 * 再返回spring自带的数据模型User即可。 这个写应该比较清晰、灵活吧，总之数据读者们通过什么方法获取都行，
 * 只要返回一个User对象就行了。（这也是笔者为什么要重写这个类的原因） 
 * 通过MyUserDetailService拿到用户信息后，authenticationManager对比用户的密码（即验证用户），
 * 然后这个AuthenticationProcessingFilter拦截器就过咯。 
*/