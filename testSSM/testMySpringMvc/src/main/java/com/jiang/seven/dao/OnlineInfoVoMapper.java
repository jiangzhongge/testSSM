package com.jiang.seven.dao;

import com.jiang.seven.common.annotation.MyBatisDao;
import com.jiang.seven.entity.OnlineInfoVo;

@MyBatisDao
public interface OnlineInfoVoMapper {
    int deleteByPrimaryKey(String id);

    int insert(OnlineInfoVo record);

    int insertSelective(OnlineInfoVo record);

    OnlineInfoVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OnlineInfoVo record);

    int updateByPrimaryKey(OnlineInfoVo record);
}