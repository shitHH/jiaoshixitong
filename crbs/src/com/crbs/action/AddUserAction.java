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
 * Project：crbs
 * Date：2021/3/14
 * Time：14:57
 * Description：TODO
 *
 * @author 王永祺
 * @version 1.0
 * @category
 */
@WebServlet("/adduser.action")
public class AddUserAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        调用业务逻辑
        IUserService iUserService= new  IUserServiceImpl();
//        得到页面上的注册信息
        String utel = req.getParameter("utel");
        String upass= req.getParameter("pass1");
        String upass2=req.getParameter("pass2");
        String uname= req.getParameter("uname");
        String usex = req.getParameter("sex");
        String agestr= req.getParameter("age");
        boolean flag= iUserService.findUserBytel(utel);
    if(flag) {
        User user = new User();
        user.setUtel(utel);
        user.setUpass(upass);
        user.setUname(uname);
        user.setUsex(usex);
        int uage = Integer.valueOf(agestr);
        user.setUage(uage);
        iUserService.addUser(user);
        //将User对象存放到request中
        req.setAttribute("user", user);

        //跳转到人员详情页面
        req.getRequestDispatcher("userinfo.jsp").forward(req, resp);
    } else {
        //添加失败，站到错误页面
        req.setAttribute("message", "添加用户失败。");
        req.getRequestDispatcher("adduser.jsp").forward(req, resp);
       }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
