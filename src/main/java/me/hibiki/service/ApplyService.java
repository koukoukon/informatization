package me.hibiki.service;

import com.github.pagehelper.PageInfo;
import me.hibiki.domain.Apply;
import me.hibiki.domain.ApplyExtend;

public interface ApplyService{


    int deleteByPrimaryKey(Long applyId);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Long applyId);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);

    PageInfo<ApplyExtend> listApplyForApprove(int pageNum,int pageSize);

}
