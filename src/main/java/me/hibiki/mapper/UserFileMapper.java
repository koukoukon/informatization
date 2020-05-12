package me.hibiki.mapper;

import me.hibiki.domain.UserFile;
import me.hibiki.domain.UserFileExtend;

import java.util.List;

public interface UserFileMapper {
    int deleteByPrimaryKey(Long userFileId);

    int insert(UserFile record);

    int insertSelective(UserFile record);

    UserFile selectByPrimaryKey(Long userFileId);

    int updateByPrimaryKeySelective(UserFile record);

    int updateByPrimaryKey(UserFile record);
    List<UserFileExtend> listUserFileExtends();
    List<UserFileExtend> listByUserPidUserFileExtends(Long userPid);
}