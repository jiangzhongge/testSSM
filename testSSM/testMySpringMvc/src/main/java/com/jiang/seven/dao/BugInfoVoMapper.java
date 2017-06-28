package com.jiang.seven.dao;

import com.jiang.seven.common.annotation.MyBatisDao;
import com.jiang.seven.entity.BugInfoVo;

@MyBatisDao
public interface BugInfoVoMapper {
    int deleteByPrimaryKey(String id);

    int insert(BugInfoVo record);

    int insertSelective(BugInfoVo record);

    BugInfoVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BugInfoVo record);

    int updateByPrimaryKeyWithBLOBs(BugInfoVo record);

    int updateByPrimaryKey(BugInfoVo record);
}