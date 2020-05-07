package me.hibiki.service;

import me.hibiki.domain.Apply;
public interface ApplyService{


    int deleteByPrimaryKey(Long applyId);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Long applyId);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);

}
