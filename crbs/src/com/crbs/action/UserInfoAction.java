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
 * Date：2021/3/13
 * Time：14:40
 * Description：TODO
 *
 * @author 王永祺
 * @version 1.0
 * @category 用户信息的显示控制器
 */
@WebServlet("/userinfo.action")
public class UserInfoAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //调用业务逻辑对象
        IUserService iUserService= new IUserServiceImpl();
        //得到人员UID
        String idstr= req.getParameter("uid");
        System.out.println(idstr);
        if (idstr!=null&&idstr!=""){
            int uid = Integer.valueOf(idstr);
            //调用业务逻辑对象，得到返回值对象
            User user= iUserService.findUserByuid(uid);
            if (user!=null) {
                //将User对象存放到request中
                req.setAttribute("user", user);
                //跳转到人员详情页面
                req.getRequestDispatcher("userinfo.jsp").forward(req, resp);
            }else{
                    req.setAttribute("messageuidnull","请输入正确的uid");
                    req.getRequestDispatcher("userlist.action").forward(req,resp);
            }
        }else{
//            如果姓名为空，转发到错误页面
            req.setAttribute("message2","uid不能为空");
            req.getRequestDispatcher("userlist.action").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
