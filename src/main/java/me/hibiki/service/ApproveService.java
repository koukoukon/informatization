package me.hibiki.service;

import me.hibiki.domain.Approve;
public interface ApproveService{


    int deleteByPrimaryKey(Long approveId);

    int insert(Approve record);

    int insertSelective(Approve record);

    Approve selectByPrimaryKey(Long approveId);

    int updateByPrimaryKeySelective(Approve record);

    int updateByPrimaryKey(Approve record);

}
