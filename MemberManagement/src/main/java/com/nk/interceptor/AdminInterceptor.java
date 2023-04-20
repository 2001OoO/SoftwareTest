package com.nk.interceptor;

import com.nk.domain.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        User user = (User) session.getAttribute("UserSession");
        if(session.getAttribute("UserSession")!=null && user.getJurisdiction_id()==1){
            return true;
        }
        request.setAttribute("msg","您还没有登录，请先登录！");
        request.getRequestDispatcher("/admin/admin_login.jsp").forward(request,response);
        return false;
    }
}
