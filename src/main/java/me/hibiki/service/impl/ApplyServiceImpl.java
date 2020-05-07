package me.hibiki.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import me.hibiki.domain.Apply;
import me.hibiki.mapper.ApplyMapper;
import me.hibiki.service.ApplyService;
@Service
public class ApplyServiceImpl implements ApplyService{

    @Resource
    private ApplyMapper applyMapper;

    @Override
    public int deleteByPrimaryKey(Long applyId) {
        return applyMapper.deleteByPrimaryKey(applyId);
    }

    @Override
    public int insert(Apply record) {
        return applyMapper.insert(record);
    }

    @Override
    public int insertSelective(Apply record) {
        return applyMapper.insertSelective(record);
    }

    @Override
    public Apply selectByPrimaryKey(Long applyId) {
        return applyMapper.selectByPrimaryKey(applyId);
    }

    @Override
    public int updateByPrimaryKeySelective(Apply record) {
        return applyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Apply record) {
        return applyMapper.updateByPrimaryKey(record);
    }

}
