package com.jiang.seven.entity.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jiang.seven.entity.UserInfoVo;

public  interface UserInfoRepository extends MongoRepository<UserInfoVo, String>{
	
}
