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
 * Date：2021/3/15
 * Time：15:07
 * Description：TODO
 *
 * @author 王永祺
 * @version 1.0
 * @category 根据姓名查询姓名
 */
@WebServlet("/finduserbyauname.action")
public class FindUserByName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //    创建业务逻辑
        IUserService iUserService = new IUserServiceImpl();
        //获取用户姓名
        String uname = req.getParameter("uname");
        if (uname != null && uname != "") {
            User user = iUserService.findUserByname(uname);
            if (user != null) {
                //将User对象存放到request中
                req.setAttribute("user", user);
                //跳转到人员详情页面
                req.getRequestDispatcher("userinfo.jsp").forward(req, resp);
            } else {
                req.setAttribute("messageunamenull", "请输入正确的用户名");
                req.getRequestDispatcher("userlist.action").forward(req, resp);
            }
        } else {
//            如果姓名为空，转发到错误页面
            req.setAttribute("message1", "姓名不能为空");
            req.getRequestDispatcher("userlist.action").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
