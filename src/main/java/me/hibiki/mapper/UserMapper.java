package me.hibiki.mapper;

import me.hibiki.domain.User;
import me.hibiki.domain.UserExtend;

import java.util.List;

public interface UserMapper {

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    User getUserByLogin(User user);
    List<UserExtend> listSelectiveUsers(User user);
    int countUserByUserName(String userName);
    int deleteByUserId(Long userId);
    int deleteByUserIds(String[] userIds);
}