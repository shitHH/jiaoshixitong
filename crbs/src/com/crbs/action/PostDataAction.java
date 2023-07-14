package com.crbs.action;

import com.crbs.bean.Room;
import com.crbs.service.IroomService;
import com.crbs.service.impl.IroomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author lilong
 * @version 1.0
 * @#category 跨页面传输数据控制器  给下一个页面传输Room的属性
 * @date 2021-03-15 14:59
 */
@WebServlet("/postdata.action")
public class PostDataAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IroomService iroomService=new IroomServiceImpl();
      int rid=Integer.valueOf(req.getParameter("rid"));
        System.out.println(rid);
       Room room= iroomService.findByrid(rid);
        HttpSession session= req.getSession();
      session.setAttribute("room",room);
      resp.sendRedirect("updateroom.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
