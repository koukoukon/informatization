package me.hibiki.service.impl;

import me.hibiki.domain.Apply;
import me.hibiki.domain.Approve;
import me.hibiki.domain.ApproveExtend;
import me.hibiki.domain.User;
import me.hibiki.mapper.ApplyMapper;
import me.hibiki.mapper.ApproveMapper;
import me.hibiki.service.ApproveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ApproveServiceImpl implements ApproveService{

    @Resource
    private ApproveMapper approveMapper;
    @Resource
    private ApplyMapper applyMapper;

    @Override
    public int deleteByPrimaryKey(Long approveId) {
        return approveMapper.deleteByPrimaryKey(approveId);
    }

    @Override
    public int insert(Approve record) {
        return approveMapper.insert(record);
    }

    @Override
    public int insertSelective(Approve record,User user) {
        int i =0;
        if (record.getApproveStatus()==2||record.getApproveStatus()==-1){
            Apply apply = applyMapper.selectByPrimaryKey(record.getApplyPid());
            apply.setApproveComment(record.getApproveComment());
            apply.setApproveUserPid(user.getUserId());
            apply.setApplyStatus(record.getApproveStatus());
            apply.setApplyEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            i = applyMapper.updateByPrimaryKeySelective(apply);
        }
        int j = approveMapper.insertSelective(record);
        return i+j;
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

    @Override
    public List<ApproveExtend> listByApplyPidApproves(Long applyPid) {
        return approveMapper.listByApplyPidApproves(applyPid);
    }
}
