package com.jiang.seven.dao;

import com.jiang.seven.common.annotation.MyBatisDao;
import com.jiang.seven.entity.MenuInfoVo;

@MyBatisDao
public interface MenuInfoVoMapper {
    int deleteByPrimaryKey(String id);

    int insert(MenuInfoVo record);

    int insertSelective(MenuInfoVo record);

    MenuInfoVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MenuInfoVo record);

    int updateByPrimaryKey(MenuInfoVo record);
}