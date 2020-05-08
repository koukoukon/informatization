package me.hibiki.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import me.hibiki.mapper.ApproveMapper;
import me.hibiki.domain.Approve;
import me.hibiki.service.ApproveService;
@Service
public class ApproveServiceImpl implements ApproveService{

    @Resource
    private ApproveMapper approveMapper;

    @Override
    public int deleteByPrimaryKey(Long approveId) {
        return approveMapper.deleteByPrimaryKey(approveId);
    }

    @Override
    public int insert(Approve record) {
        return approveMapper.insert(record);
    }

    @Override
    public int insertSelective(Approve record) {
        return approveMapper.insertSelective(record);
    }

    @Override
    public Approve selectByPrimaryKey(Long approveId) {
        return approveMapper.selectByPrimaryKey(approveId);
    }

    @Override
    public int updateByPrimaryKeySelective(Approve record) {
        return approveMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Approve record) {
        return approveMapper.updateByPrimaryKey(record);
    }

}
