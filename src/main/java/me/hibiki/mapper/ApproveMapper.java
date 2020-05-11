package me.hibiki.mapper;

import me.hibiki.domain.Approve;
import me.hibiki.domain.ApproveExtend;

import java.util.List;

public interface ApproveMapper {
    int deleteByPrimaryKey(Long approveId);

    int insert(Approve record);

    int insertSelective(Approve record);

    Approve selectByPrimaryKey(Long approveId);

    int updateByPrimaryKeySelective(Approve record);

    int updateByPrimaryKey(Approve record);

    List<ApproveExtend> listByApplyPidApproves(Long applyPid);
}