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
 * @category 传递管理员信息控制器
 * @date 2021/3/16  16:07
 */
@WebServlet("/postadmin.action")
public class PostAdminAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAdminService adminService=new IAdminServiceImpl();
        int aid=Integer.valueOf(req.getParameter("aid"));
        Admin admin=adminService.selectAdminByAid(aid);
        HttpSession session=req.getSession();
        session.setAttribute("admin",admin);
        resp.sendRedirect("updateadmin.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
