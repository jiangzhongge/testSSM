package com.jiang.seven.dao;

import com.jiang.seven.common.annotation.MyBatisDao;
import com.jiang.seven.entity.RoleInfoVo;

@MyBatisDao
public interface RoleInfoVoMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleInfoVo record);

    int insertSelective(RoleInfoVo record);

    RoleInfoVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleInfoVo record);

    int updateByPrimaryKey(RoleInfoVo record);
}