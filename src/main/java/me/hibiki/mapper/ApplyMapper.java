package me.hibiki.mapper;

import me.hibiki.domain.Apply;
import me.hibiki.domain.ApplyExtend;

import java.util.List;

public interface ApplyMapper {
    int deleteByPrimaryKey(Long applyId);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Long applyId);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
    List<ApplyExtend> listApplyForApprove();
    ApplyExtend getApplyExtendById(Long applyId);
    List<ApplyExtend> listByUserPidApply(Long userPid);
}