package com.jiang.seven.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.jiang.seven.entity.UserInfoVo;
import com.jiang.seven.entity.UserRoleInfoVo;
import com.jiang.seven.service.UserService;
import com.sun.istack.internal.logging.Logger;

public class TestMyBatise {
	
	private ApplicationContext applicationContext;
	private UserService userService ;
	private static final Logger logger = Logger.getLogger(TestMyBatise.class);
	
	
	@Before
	public void before(){
		applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml","spring-mongodb.xml"});
		userService = (UserService)applicationContext.getBean("userService");
	}
	
	@Test
	public void test1() {
		UserInfoVo userInfoVo = userService.getUserById("1");
		logger.info(userInfoVo.getName());
		logger.info(JSON.toJSONString(userInfoVo));
		//加入格式化时间
		logger.info(JSON.toJSONStringWithDateFormat(userInfoVo, "yyyy-MM-dd HH:mm:ss SSS"));
	}
	
	@Test
	public void testList(){
		List<UserInfoVo> userList = userService.getAll();
		logger.info(userList.get(0).getName());
		if(userList != null && userList.size() > 0){
			logger.info(JSON.toJSONStringWithDateFormat(userList, "yyyy-MM-dd HH:mm:ss SSS"));
			for(UserInfoVo vo : userList){
				List<UserRoleInfoVo> userRoleInfoVos = vo.getUserRoles();
				for(UserRoleInfoVo uroInfoVo : userRoleInfoVos){
					logger.info(JSON.toJSONStringWithDateFormat(uroInfoVo, "yyyy-MM-dd HH:mm:ss SSS"));
					logger.info(uroInfoVo.getRoleId());
					logger.info(uroInfoVo.getUserId());
				}
			}
		}
	}
	
	@Test
	public void testList1(){
		List<UserInfoVo> userList = userService.getAll1();
		logger.info(userList.get(0).getName());
		if(userList != null && userList.size() > 0){
			logger.info(JSON.toJSONStringWithDateFormat(userList, "yyyy-MM-dd HH:mm:ss SSS"));
			/*for(UserInfoVo vo : userList){
				List<UserRoleInfoVo> userRoleInfoVos = vo.getUserRoles();
				for(UserRoleInfoVo uroInfoVo : userRoleInfoVos){
					logger.info(JSON.toJSONStringWithDateFormat(uroInfoVo, "yyyy-MM-dd HH:mm:ss SSS"));
					logger.info(uroInfoVo.getRoleId());
					logger.info(uroInfoVo.getUserId());
				}
			}*/
		}
	}
	
	@Test
	public void testList2(){
		List<UserInfoVo> userList = userService.getAll2();
		logger.info(userList.get(0).getName());
		if(userList != null && userList.size() > 0){
			logger.info(JSON.toJSONStringWithDateFormat(userList, "yyyy-MM-dd HH:mm:ss SSS"));
			/*for(UserInfoVo vo : userList){
				List<UserRoleInfoVo> userRoleInfoVos = vo.getUserRoles();
				for(UserRoleInfoVo uroInfoVo : userRoleInfoVos){
					logger.info(JSON.toJSONStringWithDateFormat(uroInfoVo, "yyyy-MM-dd HH:mm:ss SSS"));
					logger.info(uroInfoVo.getRoleId());
					logger.info(uroInfoVo.getUserId());
				}
			}*/
		}
	}
	
	@Test
	public void testGetUser(){
		String userName = "李白";
		System.out.println(userName);
		UserInfoVo userInfoVo = userService.getUserInfoVoBySelective(userName);
		if(userInfoVo != null){
			logger.info(JSON.toJSONStringWithDateFormat(userInfoVo, "yyyy-MM-dd HH:mm:ss SSS"));
		}
	}

}
