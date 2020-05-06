package me.hibiki.service;

import com.github.pagehelper.PageInfo;
import me.hibiki.domain.User;
import me.hibiki.domain.UserExtend;

public interface UserService{
    User getUserByLogin(User user);
    PageInfo<UserExtend> listSelectiveUserExtends(User user,int pageNum,int pageSize);
    int insertUser(User user);
    int deleteUserByUserId(String[] userIds);
    int deleteUserByUserIds(String[] userIds);
    User getUserById(Long userId);
    int updateByIdSelective(User user);
}
