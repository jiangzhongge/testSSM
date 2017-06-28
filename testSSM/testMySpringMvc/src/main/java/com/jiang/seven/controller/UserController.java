package com.jiang.seven.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.druid.filter.AutoLoad;
import com.jiang.seven.entity.UserInfoVo;
import com.jiang.seven.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController {
	
	@Autowired
	private UserService userService ;
	
	
	
/*	
 	<!-- 该 BeanPostProcessor 将自动对标注 @Autowired 的 Bean 进行注入 -->     
    <bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>  
    
 	public UserService getUserService() {
		return userService;
	}


	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
*/

//	@RequestMapping(value = "/showUser" , method={RequestMethod.GET,RequestMethod.POST})
//	访问：http://localhost:8090/testmybatis/userController/showUser.do?id=1	
	@RequestMapping(value = "/showUser/{id}" , method={RequestMethod.GET,RequestMethod.POST})
//	访问：http://localhost:8090/testmybatis/userController/showUser/1.do
//  或者@RequestMapping(value = "/{id}/showUser" , method={RequestMethod.GET,RequestMethod.POST})
	public String showUser(@PathVariable String id , HttpServletRequest request){
		UserInfoVo userInfoVo = userService.getUserById(id);
		request.setAttribute("user", userInfoVo);
		return "showUser";
	}
	
}
