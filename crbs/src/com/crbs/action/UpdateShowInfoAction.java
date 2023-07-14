package com.crbs.action;

import com.crbs.bean.User;
import com.crbs.service.IUserService;
import com.crbs.service.impl.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: wangjuyuan
 * @Date: Created in 11:47 2021-03-16
 * @Description: 更新时加载当前用户信息到表单中
 * @Version: 1.0
 */
@WebServlet("/updateshowinfo.action")
public class UpdateShowInfoAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建用户业务逻辑对象
        IUserService userService = new IUserServiceImpl();
        // 获取前端参数
        String uidStr = req.getParameter("uid");
        // 类型转换
        int uid = Integer.valueOf(uidStr);
        // 调用方法查询用户信息
        User user = userService.findUserByuid(uid);
        // 将用户添加到请求中
        req.setAttribute("userInfo",user);
        // 请求转发
        req.getRequestDispatcher("updateuser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
