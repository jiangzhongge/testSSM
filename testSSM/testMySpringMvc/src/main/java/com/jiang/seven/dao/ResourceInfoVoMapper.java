package com.jiang.seven.dao;

import com.jiang.seven.common.annotation.MyBatisDao;
import com.jiang.seven.entity.ResourceInfoVo;

@MyBatisDao
public interface ResourceInfoVoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResourceInfoVo record);

    int insertSelective(ResourceInfoVo record);

    ResourceInfoVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ResourceInfoVo record);

    int updateByPrimaryKey(ResourceInfoVo record);
}