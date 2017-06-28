package com.jiang.seven.dao;

import com.jiang.seven.common.annotation.MyBatisDao;
import com.jiang.seven.entity.UserRoleInfoVo;

@MyBatisDao
public interface UserRoleInfoVoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserRoleInfoVo record);

    int insertSelective(UserRoleInfoVo record);

    UserRoleInfoVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRoleInfoVo record);

    int updateByPrimaryKey(UserRoleInfoVo record);
}