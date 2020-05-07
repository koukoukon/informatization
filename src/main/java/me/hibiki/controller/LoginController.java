package me.hibiki.controller;

import me.hibiki.domain.User;
import me.hibiki.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 高弘昆
 * @date 2020/4/29 13:50
 */
@Controller
@SessionAttributes(value = {"user"},types = {User.class})
public class LoginController {
    @Resource
    private UserService userService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String welcome() {
        return "forward:/WEB-INF/view/login.html";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "forward:/WEB-INF/view/login.html";
    }
    @RequestMapping(path = "/admin/menu")
    public String menu(){
        return "forward:/WEB-INF/view/admin/menu.html";
    }
    @RequestMapping(path = "/admin/index")
    public String index(){
        return "forward:/WEB-INF/view/admin/index.html";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST, params = {"username", "password"})
    @ResponseBody
    public Map<String,Integer> login(String username, String password, Model model, HttpSession httpSession) {
        User user = new User();
        user.setUserName(username);
        user.setUserPassword(password);
        User loginUser = userService.getUserByLogin(user);
        Map<String, Integer> statusMap = new HashMap<>();
        if (loginUser == null) {
            statusMap.put("status", -1);
        } else {
            System.out.println("登录成功:"+loginUser);
            model.addAttribute("user",loginUser);
            statusMap.put("status", 1);
        }
        return statusMap;
    }
}
