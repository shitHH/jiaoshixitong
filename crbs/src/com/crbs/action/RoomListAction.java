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
 * @#category 管理员教室查询 页面 控制器
 * @date 2021-03-13 17:49
 */
@WebServlet("/roomlist.action")
public class RoomListAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //创建教室业务逻辑
        IroomService iroomService=new IroomServiceImpl();
        List<Room>list=iroomService.findAll();
        System.out.println(list);
        //创建session对象，将列表放入session中
        HttpSession session=req.getSession();
        session.setAttribute("list",list);
        //重定向到管理员信息列表界面
        resp.sendRedirect("room.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
