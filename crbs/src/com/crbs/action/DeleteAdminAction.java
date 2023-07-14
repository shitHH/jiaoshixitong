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
 * @category 删除管理员信息控制器
 * @date 2021/3/13  13:35
 */
@WebServlet("/deleteadmin.action")
public class DeleteAdminAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAdminService adminService=new IAdminServiceImpl();
        //通过request获得管理员id的值
        String aidstr=req.getParameter("aid");
        if(aidstr!=null){
            int aid=Integer.valueOf(aidstr);
            boolean flag=adminService.deleteAdminByAid(aid);
            if(flag){
                //删除成功怎么重定向到管理员信息界面
                resp.sendRedirect("adminlist.action");
            }else{
                //删除失败则转发到错误页面
                req.setAttribute("message","删除失败id不存在");
                req.getRequestDispatcher("error.jsp").forward(req,resp);
            }
        }else{
            //id为空转发到错误页面
            req.setAttribute("message","管理员id不能为空");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
