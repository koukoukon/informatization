package me.hibiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.hibiki.domain.Apply;
import me.hibiki.domain.ApplyExtend;
import me.hibiki.mapper.ApplyMapper;
import me.hibiki.service.ApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {

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

    @Override
    public PageInfo<ApplyExtend> listApplyForApprove(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ApplyExtend> applyExtends = applyMapper.listApplyForApprove();
        return new PageInfo<ApplyExtend>(applyExtends);
    }

    @Override
    public ApplyExtend getApplyExtendById(Long applyId) {
        return applyMapper.getApplyExtendById(applyId);
    }

    @Override
    public PageInfo<ApplyExtend> listByUserPidApply(Long userPid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ApplyExtend> applyExtends = applyMapper.listByUserPidApply(userPid);
        return new PageInfo<ApplyExtend>(applyExtends);
    }
}
