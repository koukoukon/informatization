package me.hibiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.hibiki.domain.UserFile;
import me.hibiki.domain.UserFileExtend;
import me.hibiki.mapper.UserFileMapper;
import me.hibiki.service.UserFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserFileServiceImpl implements UserFileService{

    @Resource
    private UserFileMapper userFileMapper;

    @Override
    public int deleteByPrimaryKey(Long userFileId) {
        return userFileMapper.deleteByPrimaryKey(userFileId);
    }

    @Override
    public int insert(UserFile record) {
        return userFileMapper.insert(record);
    }

    @Override
    public int insertSelective(UserFile record) {
        return userFileMapper.insertSelective(record);
    }

    @Override
    public UserFile selectByPrimaryKey(Long userFileId) {
        return userFileMapper.selectByPrimaryKey(userFileId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserFile record) {
        return userFileMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserFile record) {
        return userFileMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<UserFileExtend> listUserFileExtends(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserFileExtend> userFileExtends = userFileMapper.listUserFileExtends();
        return new PageInfo<UserFileExtend>(userFileExtends);
    }

    @Override
    public PageInfo<UserFileExtend> listByUserPidUserFileExtends(Long userPid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserFileExtend> userFileExtends = userFileMapper.listByUserPidUserFileExtends(userPid);
        return new PageInfo<UserFileExtend>(userFileExtends);
    }
}
