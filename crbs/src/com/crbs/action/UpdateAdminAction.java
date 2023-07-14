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

/**
 * @author lixiaobin
 * @version 1.0
 * @category 更新管理员信息控制器
 * @date 2021/3/13  13:35
 */
@WebServlet("/updateadmin.action")
public class UpdateAdminAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAdminService adminService = new IAdminServiceImpl();
        //从前端页面的session中获得需要更新的管理员id
        HttpSession session = req.getSession();
        Object aidobj = session.getAttribute("aid");
        int aid = Integer.parseInt(aidobj.toString());
        //调用管理员业务逻辑对象，通过id找到这个需要更新的管理员对象
        Admin admin = adminService.selectAdminByAid(aid);
        //获得需要更新的信息
        String aname = req.getParameter("aname");
        String asex = req.getParameter("asex");
        String aagestr = req.getParameter("aage");
        String atel = req.getParameter("atel");
        String apass1 = req.getParameter("apass1");
        String apass2 = req.getParameter("apass2");
        System.out.println(aname);
        System.out.println(asex);
        System.out.println(aagestr);
        System.out.println(atel);
        System.out.println(apass1);
        int aage = Integer.valueOf(aagestr);
        //如果两次密码相同更新信息
        if(apass1.equals(apass2)) {
            admin.setAname(aname);
            admin.setAsex(asex);
            admin.setAage(aage);
            admin.setAtel(atel);
            admin.setApass(apass1);
            adminService.updateAdmin(admin);
            //重定向到管理员信息界面
            resp.sendRedirect("adminlist.action");
        }else {
            resp.sendRedirect("error_updateadmin.jsp");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
