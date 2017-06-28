package com.jiang.seven.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * 建立Spring MVC的Configuration Class (SpringMvcConfiguration.java)
 * @author jiangzhongge
 *
 */
/*@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jiang.seven.controller")*/
public class SpringMvcConfiguration {
	/*@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	  
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc... 
       
 
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {  
	     registry.addResourceHandler("/static/**").addResourceLocations("/static/");  
	 }*/
	  /* 这个配置对应 addResourceHandlers 方法
	 <!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->  
	   <mvc:resources mapping="<span style="font-family: 'Open Sans', sans-serif;">/static/**</span>" location="<span style="font-family: 'Open Sans', sans-serif;">/static/</span>" />  
	     
	  <!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->  
	   <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">  
	       <beans:property name="prefix" value="/WEB-INF/views/" />  
	       <beans:property name="suffix" value=".jsp" />  
	   </beans:bean> 
	  */
}
