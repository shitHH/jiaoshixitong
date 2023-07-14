package com.crbs.servlet;

import com.crbs.bean.Admin;
import com.crbs.bean.User;
import com.crbs.dao.IAdminDao;
import com.crbs.service.IUserService;
import com.crbs.service.impl.IUserServiceImpl;

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
@WebServlet("/login_user.action")
public class Login_UserAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //创建业务逻辑对象
        IUserService userService=new IUserServiceImpl();
        //得到用户和密码
        String utel=req.getParameter("utel");
        String upass=req.getParameter("upass");
        //将用户信息传输给业务逻辑

        User user=userService.findUserBytp(utel,upass);
        //根据返回值显示
        if(user!=null){
            HttpSession session=req.getSession();
            session.setAttribute("user",user);
           resp.sendRedirect("user_index.jsp");
        }else {
            req.setAttribute("message","用户名或密码输入错误");
            req.getRequestDispatcher("login_User.jsp").forward(req,resp);

        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
