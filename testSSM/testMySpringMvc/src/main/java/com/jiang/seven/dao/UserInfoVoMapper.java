package com.jiang.seven.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiang.seven.common.annotation.MyBatisDao;
import com.jiang.seven.entity.UserInfoVo;

@MyBatisDao
public interface UserInfoVoMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(UserInfoVo record);

    int insertSelective(UserInfoVo record);

    UserInfoVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfoVo record);

    int updateByPrimaryKey(UserInfoVo record);
    
    List<UserInfoVo> getAll();
    
    List<UserInfoVo> getAll1();
    
    List<UserInfoVo> getAll2();
    
    UserInfoVo getUserInfoVoBySelective(@Param(value="userName") String userName);
}