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
 * Project：crbs
 * Date：2021/3/16
 * Time：15:29
 * Description：TODO
 *
 * @author 王永祺
 * @version 1.0
 * @category 局部刷新验证手机号是否重复(未实现)，留给v3.0更新
 *
 */
//@WebServlet("/checktel.action")
public class ChicktelAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("aaa");
        //导入控制器
        IUserService iUserService = new IUserServiceImpl();
        //获取用户输入的手机号
        String utel = req.getParameter("utel");
        boolean flag = iUserService.findUserBytel(utel);
        System.out.println(flag + "--------------------------------------------------------");
        resp.getWriter().print(flag);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

