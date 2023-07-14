package com.crbs.action;

import com.crbs.bean.Admin;
import com.crbs.service.IAdminService;
import com.crbs.service.impl.IAdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author lixiaobin
 * @version 1.0
 * @category 管理员信息列表控制器
 * @date 2021/3/13  11:01
 */
@WebServlet("/adminlist.action")
public class AdminListAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建业务逻辑对象
        IAdminService adminService=new IAdminServiceImpl();
        //创建列表接收管理员信息列表
        List<Admin> list=adminService.selectAllAdmin();
        System.out.println(list);
        //创建session对象，将列表放入session中
        HttpSession session=req.getSession();
        session.setAttribute("list",list);
        //重定向到管理员信息列表界面
        resp.sendRedirect("adminlist.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
