package com.jiang.seven.common.config.Initial;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 建立一个Initial Class (SecurityWebApplicationInitializer.java)，
 * 以注册刚才所建立的Configuration SecurityConfiguration.class
 * @author jiangzhongge
 *
 */
public class SecurityWebApplicationInitializer{}
/*public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer{

}*/
/*
 *  <filter>  
	    <filter-name>springSecurityFilterChain</filter-name>  
	    <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>  
	</filter>  
   
	<filter-mapping>  
	    <filter-name>springSecurityFilterChain</filter-name>  
	    <url-pattern>/*</url-pattern>  
	</filter-mapping>  
 * 
 */
