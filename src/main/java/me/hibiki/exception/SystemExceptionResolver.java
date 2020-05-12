package me.hibiki.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 高弘昆
 * @date 2020/5/12 16:33
 */
@Component
public class SystemExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        if (ex instanceof SystemException) {
            SystemException e = (SystemException) ex;
            e.printStackTrace();
            modelAndView.addObject("errorMessage", e.getMessage());
        } else {
            ex.printStackTrace();
            modelAndView.addObject("errorMessage", ex.getMessage());
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
