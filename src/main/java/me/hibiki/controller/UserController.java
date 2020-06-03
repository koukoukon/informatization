package me.hibiki.controller;

import com.github.pagehelper.PageInfo;
import me.hibiki.domain.User;
import me.hibiki.domain.UserExtend;
import me.hibiki.domain.UserJson;
import me.hibiki.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 高弘昆
 * @date 2020/4/29 14:23
 */
@Controller
@RequestMapping(path = "/admin/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(path = "/manage", method = RequestMethod.GET)
    public String manageHtml() {
        return "forward:/WEB-INF/view/admin/user/userManage.html";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addHtml() {
        return "forward:/WEB-INF/view/admin/user/userForm.html";
    }

    @RequestMapping(path = "/list", method = RequestMethod.POST)
    @ResponseBody
    public UserJson listUsers(User user, String pageNum, String pageSize) {
        if (user == null) {
            user = new User();
        }
        PageInfo<UserExtend> pageInfo = userService.listSelectiveUserExtends(user, Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        List<UserExtend> userExtends = pageInfo.getList();
        long total = pageInfo.getTotal();
        UserJson userJson = new UserJson();
        userJson.setUsers(userExtends);
        userJson.setTotal(total);
        return userJson;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> addUser(User user) {
        user.setAuthorityPid(1);
        user.setUserDeleteFlag(0);
        int i = userService.insertUser(user);
        Map<String, Integer> map = new HashMap<String, Integer>(1);
        map.put("success", i);
        return map;
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> deleteUser(String userIds) {
        String[] userIdArray = userIds.split(",");
        int i = userService.deleteUserByUserIds(userIdArray);
        Map<String, Integer> map = new HashMap<>(1);
        map.put("success", i);
        return map;
    }

    @RequestMapping(path = "/edit",method = RequestMethod.GET)
    public String editHtml() {
        return "forward:/WEB-INF/view/admin/user/userForm.html";
    }

    @GetMapping(path = "/{userId}")
    @ResponseBody
    public User getUserByUserId(@PathVariable String userId) {
        return userService.getUserById(Long.parseLong(userId));
    }

    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> editUser(User user) {
        //谨记 忘记加@ResponseBody 会导致404
        System.out.println(user);
        int i = userService.updateByIdSelective(user);
        Map<String, Integer> map = new HashMap<String, Integer>(1);
        map.put("success", i);
        return map;
    }
}
