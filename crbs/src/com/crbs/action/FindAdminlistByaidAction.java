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
import java.util.List;

/**
 * @author lixiaobin
 * @version 1.0
 * @category 通过管理员编号查询管理员信息控制器
 * @date 2021/3/13  13:38
 */
@WebServlet("/findadminlistbyaid.action")
public class FindAdminlistByaidAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAdminService adminService=new IAdminServiceImpl();
        //通过request获得管理员id的值
        String aidstr=req.getParameter("aidinput1");
        if(aidstr!=null&& aidstr!="") {
            int aid = Integer.valueOf(aidstr);
            List<Admin> list =adminService.selectAdminlistByAid(aid);
            if(list!=null&& list.size()!=0) {
                //创建session对象，将要查询的管理员放入session中
                HttpSession session = req.getSession();
                session.setAttribute("list", list);
                //重定向到查询的管理员信息页面
                resp.sendRedirect("findadminlist.jsp");
            }else {
                HttpSession session=req.getSession();
                session.setAttribute("messagenull1","编号不存在");
                resp.sendRedirect("adminlist.action");
            }
        }else{
            //id为空重定向到管理员信息界面
            resp.sendRedirect("adminlist.action");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
