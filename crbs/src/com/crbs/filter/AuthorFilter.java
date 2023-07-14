package com.crbs.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: wangjuyuan
 * @Date: Created in 20:02 2021-03-15
 * @Description: 权限过滤, 未登录时不能访问其他页面
 * @Version: 1.0
 */
@WebFilter("*.jsp")
public class AuthorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("权限过滤中....");
        // 类型转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 获取Session对象
        HttpSession session = request.getSession();
        // 获取Session中存储的对象
        Object obj = session.getAttribute("user");
        // 获取请求路径
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        // 登录页面无需过滤
        if (requestURI.indexOf("/login_User.jsp") > -1 || requestURI.indexOf("login_admin.jsp") > -1) {
            System.out.println("登录界面");
            filterChain.doFilter(request, response);
            return;
        }
        // 判断Session中的对象是否为空
        if (obj != null) {
            // 已经登录,继续本次请求
            filterChain.doFilter(request, response);
        } else {
            // 未登录跳转到登录界面
            response.sendRedirect("login_User.jsp");
        }

    }

    @Override
    public void destroy() {

    }
}
