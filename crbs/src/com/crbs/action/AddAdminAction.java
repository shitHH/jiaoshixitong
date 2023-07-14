package com.crbs.action;

import com.crbs.bean.Admin;
import com.crbs.service.IAdminService;
import com.crbs.service.impl.IAdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lixiaobin
 * @version 1.0
 * @category 添加管理员信息控制器
 * @date 2021/3/13  13:39
 */
@WebServlet("/addadmin.action")
public class AddAdminAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAdminService adminService=new IAdminServiceImpl();
        //创建管理员对象，通过request得到输入的信息
        Admin admin=new Admin();
        String aname=req.getParameter("aname");
        String asex=req.getParameter("asex");
        String aagestr=req.getParameter("aage");
        String atel=req.getParameter("atel");
        String apass1=req.getParameter("apass1");
        String apass2 = req.getParameter("apass2");
        System.out.println(aname);
        System.out.println(asex);
        System.out.println(aagestr);
        System.out.println(atel);
        System.out.println(apass1);
        //通过调用管理员业务逻辑对象，如果电话和密码在数据库中不存在，则可以录入
        Boolean flag=adminService.find(atel,apass1);
        int aage=Integer.valueOf(aagestr);
        if(flag) {
            if(apass1.equals(apass2)) {
                //调用业务逻辑对象方法
                boolean flag1 = adminService.addadmin(aname, asex, aage, atel, apass1);
                System.out.println(flag1);
                if (flag1) {
                    //添加成功，重定向到管理员信息界面
                    resp.sendRedirect("adminlist.action");
                } else {
                    //添加失败，进入添加用户界面
                    req.setAttribute("message", "添加管理员失败");
                    resp.sendRedirect("addadmin.jsp");
                }
            }else{
                resp.sendRedirect("error_updateadmin.jsp");
            }
        }else{
            //账号已存在，添加失败，进入添加用户页面
            req.setAttribute("message","添加管理员失败");
            resp.sendRedirect("addadmin.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
