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
 * @category 判断电话是否存在控制器
 * @date 2021/3/16  16:17
 */
@WebServlet("/telhas.action")
public class TelHasAction  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String atel=req.getParameter("name");
        IAdminService adminService=new IAdminServiceImpl();
        Admin admin=adminService.selectAdminByAtel(atel);
        System.out.println(admin);
        if(admin==null){
            resp.getWriter().print("ok");
        }else{
            resp.getWriter().print("电话已存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
