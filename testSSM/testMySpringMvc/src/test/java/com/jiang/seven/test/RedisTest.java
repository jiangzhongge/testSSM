package com.jiang.seven.test;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiang.seven.service.Impl.redis.RedisServiceImpl;

public class RedisTest {

	private static ConfigurableApplicationContext context;  
	  
    RedisServiceImpl service;  
  
    @Test  
    public void testSave() throws InterruptedException {  
        context = new ClassPathXmlApplicationContext(  
                "classpath:spring-redis.xml");  
        service = (RedisServiceImpl) context.getBean("redisService");  
  
        int i = 1;  
        while (true) {  
            Thread.sleep(1);  
            try {  
//                service.mulitThreadSaveAndFind("" + i);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
            i++;  
        }  
    }  

}
