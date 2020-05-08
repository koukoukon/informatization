package me.hibiki.mapper;

import me.hibiki.domain.Approve;

public interface ApproveMapper {
    int deleteByPrimaryKey(Long approveId);

    int insert(Approve record);

    int insertSelective(Approve record);

    Approve selectByPrimaryKey(Long approveId);

    int updateByPrimaryKeySelective(Approve record);

    int updateByPrimaryKey(Approve record);
}