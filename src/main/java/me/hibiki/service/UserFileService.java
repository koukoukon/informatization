package me.hibiki.service;

import com.github.pagehelper.PageInfo;
import me.hibiki.domain.UserFile;
import me.hibiki.domain.UserFileExtend;

public interface UserFileService{


    int deleteByPrimaryKey(Long userFileId);

    int insert(UserFile record);

    int insertSelective(UserFile record);

    UserFile selectByPrimaryKey(Long userFileId);

    int updateByPrimaryKeySelective(UserFile record);

    int updateByPrimaryKey(UserFile record);
    PageInfo<UserFileExtend> listUserFileExtends(int pageNum,int pageSize);
    PageInfo<UserFileExtend> listByUserPidUserFileExtends(Long userPid,int pageNum,int pageSize);
}
