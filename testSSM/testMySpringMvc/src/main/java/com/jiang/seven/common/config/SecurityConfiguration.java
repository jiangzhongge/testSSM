package com.jiang.seven.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *  建立Spring Security 的configure class
 * @author jiangzhongge
 * 
 */
/*@Configuration
@EnableWebSecurity*/
public class SecurityConfiguration {
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("test").password("test")
				.roles("USER");
		auth.inMemoryAuthentication().withUser("root").password("root")
				.roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("dba")
				.roles("ADMIN", "DBA");// dba have two roles.
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/home").permitAll()
				.antMatchers("/admin/**").access("hasRole('ADMIN')")
				.antMatchers("/db/**")
				.access("hasRole('ADMIN') and hasRole('DBA')")
				.and()
				.formLogin().loginPage("/login")
				.usernameParameter("ssoId").passwordParameter("password") 
				.and().csrf() 
				
				 * 这段代码指定url为"/login"作为自定义的登录界面，并用ssoId 作为用户名和password 作为密码参数。
				      我们也添加了一个可选方法csrf()的调用，默认在Spring Security 4中该方法是激活的。
				      然而此调用是需要的，如果你先关闭csrf保护可以通过调用csrf().disable() 来实现，
				      虽然这不是一个好主意。
				 
				.and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}*/
	/*
	 *  (1) 在configureGlobalSecurity这个方法中为特定的使用者绑定相对应的Role​​​
		(2) 这边采用的是inMemory的认证机制，另外還有提供JDBC, LDAP ...等其他認證機制
		(3) 在configure这个方法中我们设定了哪些路径下只允许拥有哪些Role的使用者进入，permitAll()表示不用验证可直接进入
		(4) .formLogin()方法可让Spring Security自动产生一个简易的使用者认证页面
		(5) .exceptionHandling().accessDeniedPage用来导向所有产生403错误的页面(即Access Denied的错误)
	 */
}

	/* 此类相当于下面配置文件
	 * <beans:beans xmlns="http://www.springframework.org/schema/security"  
	    xmlns:beans="http://www.springframework.org/schema/beans"  
	    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
	    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.1.xsd  
	    http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security-4.0.xsd">  
	        
	    <http auto-config="true" >  
	        <intercept-url pattern="/" access="permitAll" />  
	        <intercept-url pattern="/home" access="permitAll" />  
	        <intercept-url pattern="/admin**" access="hasRole('ADMIN')" />  
	        <intercept-url pattern="/dba**" access="hasRole('ADMIN') and hasRole('DBA')" />  
	        <form-login  login-page="/login" username-parameter="ssoId" password-parameter="password" authentication-failure-url="/Access_Denied" />  
	        <csrf/>  
	    </http>  
	    
	    <authentication-manager >  
	        <authentication-provider>  
	            <user-service>  
	                <user name="bill"  password="abc123"  authorities="ROLE_USER" />  
	                <user name="admin" password="root123" authorities="ROLE_ADMIN" />  
	                <user name="dba"   password="root123" authorities="ROLE_ADMIN,ROLE_DBA" />  
	            </user-service>  
	        </authentication-provider>  
	    </authentication-manager>  
	       
	</beans:beans>  
	 */
