package com.crbs.action;

import com.crbs.service.IUserService;
import com.crbs.service.impl.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lilong
 * @version 1.0
 * @#category
 * @date 2021-03-16 16:15
 */
@WebServlet("/checkutel.action")
public class CheckUtelAction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //导入控制器
        IUserService iUserService= new IUserServiceImpl();
        //获取用户输入的手机号
        String utel= req.getParameter("name");
        System.out.println("utel="+utel.toString());
        Boolean flag= iUserService.findUserBytel(utel);
        System.out.println("flag="+flag);
        if(flag){
            resp.getWriter().println("OK");
        }else {
            // //名自己已存在，提示用户更换用户名
            resp.getWriter().print("nook");
        }

    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
