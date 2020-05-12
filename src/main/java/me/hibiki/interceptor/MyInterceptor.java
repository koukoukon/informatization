package me.hibiki.interceptor;

import me.hibiki.domain.User;
import me.hibiki.exception.SystemException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 高弘昆
 * @date 2020/5/12 16:18
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User)request.getSession().getAttribute("user");
        if (user==null){
            throw new SystemException("当前未登录，没有权限访问该地址");
        }
        return true;
    }
}
