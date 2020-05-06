package me.hibiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.hibiki.domain.User;
import me.hibiki.domain.UserExtend;
import me.hibiki.mapper.UserMapper;
import me.hibiki.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByLogin(User user) {
        if (user.getUserName() == null || "".equals(user.getUserName()) || user.getUserPassword() == null || "".equals(user.getUserPassword())) {
            throw new RuntimeException("用户名或密码为空");
        }
        return userMapper.getUserByLogin(user);

    }

    @Override
    public PageInfo<UserExtend> listSelectiveUserExtends(User user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserExtend> userExtends = userMapper.listSelectiveUsers(user);
        return new PageInfo<UserExtend>(userExtends);
    }

    @Override
    public int insertUser(User user) {
        int i = userMapper.countUserByUserName(user.getUserName());
        //-1代表已查询到
        if (i > 0) {
            return -1;
        }
        int j = userMapper.insertSelective(user);
        return j;
    }

    @Override
    public int deleteUserByUserId(String[] userIds) {
        int i = 0;
        for (String userId : userIds) {
            i += userMapper.deleteByUserId(Long.parseLong(userId));
        }
        return i;
    }

    @Override
    public int deleteUserByUserIds(String[] userIds) {
        return userMapper.deleteByUserIds(userIds);
    }

    @Override
    public User getUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByIdSelective(User user) {
        int i = userMapper.countUserByUserName(user.getUserName());
        if (i > 0) {
            return -1;
        }
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
