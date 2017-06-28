package com.jiang.seven.service.mongo.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.jiang.seven.entity.UserInfoVo;
import com.jiang.seven.service.mongo.MongoDBService;
import com.mongodb.WriteResult;

@Service("userInfoMongoService")
public class UserInfoMongoServiceImpl extends MongoDBService<UserInfoVo>{

	@Override
	public int insert(UserInfoVo entity) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(entity);
		return 1;
	}

	@Override
	public int insertByBatch(List<UserInfoVo> entities) {
		// TODO Auto-generated method stub
		mongoTemplate.insertAll(entities);
		return 1;
	}

	@Override
	public WriteResult updateMulti(Query query, Update update) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WriteResult upsert(Query query, Update update) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long queryCount(Query query) {
		// TODO Auto-generated method stub
		return mongoTemplate.count(query,UserInfoVo.class);
	}

	@Override
	public List<UserInfoVo> queryList(Query query) {
		// TODO Auto-generated method stub
		return mongoTemplate.find(query, UserInfoVo.class);
	}

	@Override
	public List<UserInfoVo> queryListDistinct(Query query, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoVo findAndRemove(Query query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> queryStringListDistinct(Query query, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long mapReduce(String map, String reduce) {
		// TODO Auto-generated method stub
		return 0;
	}

}
