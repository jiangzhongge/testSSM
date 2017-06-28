package com.jiang.seven.test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiang.seven.entity.UserInfoVo;
import com.jiang.seven.service.UserService;
import com.jiang.seven.service.mongo.Impl.UserInfoMongoServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
//相当于extends SpringJUnit4ClassRuuner
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-mybatis.xml","classpath:spring-mongodb.xml"})
public class SpringTestMyBatis {
	
	@Autowired
	private UserService userService ;
	
	@Autowired
	private MongoTemplate mongoTemplate ;

	@Autowired
	private UserInfoMongoServiceImpl userInfoMongoService;

/*	public UserService getUserService() {
		return userService;
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}*/
	
	@Test
	public void test1() {
		
		UserInfoVo userInfoVo = userService.getUserById("1");
		System.out.println(userInfoVo);
		System.out.println(userInfoVo.getName());
		System.out.println(userInfoVo.getCreateTime());
//		mongoTemplate.insert(userInfoVo, "person");
		UserInfoVo userInfoVo2 = new UserInfoVo();
		userInfoVo2.setId(UUID.randomUUID().toString());
		userInfoVo2.setCreateTime(new Date());
		userInfoVo2.setName("jiangzg");
		userInfoVo2.setPwd("123qwe");
		
		int num = userInfoMongoService.insert(userInfoVo2);
		System.out.println(num+"====");
		
		List<UserInfoVo> reuslt = userInfoMongoService.queryList(new Query().addCriteria(new Criteria().and("pwd").regex("123")));
		if(reuslt != null && reuslt.size() > 0){
			System.out.println(reuslt.size());
			for(UserInfoVo vo : reuslt){
				System.out.println(vo.getName());
			}
		}
	}
	
	
}
