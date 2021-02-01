package com.example.demo.Intercepter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    //登录检查逻辑
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI=request.getRequestURI();

        log.info("拦截的亲求路径是{}",requestURI);
        log.info("拦截的亲求路径是{}",requestURI);
        HttpSession session = request.getSession();

        Object user = session.getAttribute("user");
//        String password = request.getParameter("password");
        System.out.println(user);

        if (user!=null){

            return true;

        }else {
            //重定向到登录页面
            session.setAttribute("msg","请先登录！");
            response.sendRedirect("/");
            return false;

        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
