package com.crbs.servlet;

import com.crbs.bean.Admin;
import com.crbs.dao.IAdminDao;
import com.crbs.service.IAdminService;
import com.crbs.service.impl.IAdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lilong
 * @version 1.0
 * @#category 管理员登录控制器
 * @date 2021-03-12 17:29
 */
@WebServlet("/login_admin.action")
public class Login_adminAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //创建业务逻辑对象
        IAdminService adminService=new IAdminServiceImpl();
        //得到用户和密码
        String atel=req.getParameter("atel");
        String apass=req.getParameter("apass");
        //将用户信息传输给业务逻辑
        Admin admin= adminService.findlogin(atel,apass);
        //根据返回值显示
        if(admin!=null){
            HttpSession session=req.getSession();
            session.setAttribute("user",admin);
            req.getRequestDispatcher("admin_index.jsp").forward(req,resp);
//            resp.sendRedirect("admin_index.jsp");
        }else {
            req.setAttribute("message","用户名或密码输入错误");
            req.getRequestDispatcher("login_admin.jsp").forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
