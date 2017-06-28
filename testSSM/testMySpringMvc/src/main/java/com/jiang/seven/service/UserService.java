package com.jiang.seven.service;

import java.util.List;

import com.jiang.seven.entity.UserInfoVo;

public interface UserService {
	
	public UserInfoVo getUserById(String id);
	
	public List<UserInfoVo> getAll();
	
	List<UserInfoVo> getAll1();
	
	List<UserInfoVo> getAll2();
	
	UserInfoVo getUserInfoVoBySelective(String userName);
}
