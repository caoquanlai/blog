package cn.fairyzww.blog.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Yg
 * @Date: 2019/11/26
 * @Time: 16:03
 * @Description: No Description
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (null == request.getSession().getAttribute("user")) {
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}
