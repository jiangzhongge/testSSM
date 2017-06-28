package com.jiang.seven.dao;

import com.jiang.seven.common.annotation.MyBatisDao;
import com.jiang.seven.entity.RoleResourceInfoVo;

@MyBatisDao
public interface RoleResourceInfoVoMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleResourceInfoVo record);

    int insertSelective(RoleResourceInfoVo record);

    RoleResourceInfoVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleResourceInfoVo record);

    int updateByPrimaryKey(RoleResourceInfoVo record);
}