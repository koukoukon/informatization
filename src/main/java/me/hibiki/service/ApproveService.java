package me.hibiki.service;

import me.hibiki.domain.Approve;
import me.hibiki.domain.ApproveExtend;
import me.hibiki.domain.User;

import java.util.List;

public interface ApproveService{


    int deleteByPrimaryKey(Long approveId);

    int insert(Approve record);

    int insertSelective(Approve record, User user);

    Approve selectByPrimaryKey(Long approveId);

    int updateByPrimaryKeySelective(Approve record);

    int updateByPrimaryKey(Approve record);
    List<ApproveExtend> listByApplyPidApproves(Long applyPid);

}
