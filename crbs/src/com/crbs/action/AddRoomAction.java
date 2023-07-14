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

/**
 * @author lilong
 * @version 1.0
 * @#category 增加教室控制器
 * @date 2021-03-14 11:58
 */
@WebServlet("/addroom.action")
public class AddRoomAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //创建教室业务逻辑
        IroomService iroomService=new IroomServiceImpl();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
         Room room=new Room();
         String name=req.getParameter("roomname");


             String size = req.getParameter("roomsize");
             String status = req.getParameter("roomstatus");
             room.setRname(name);
             room.setSize(size);
             room.setStatus(status);
             int i = iroomService.insertRoom(room);

             if (i > 0) {
                 System.out.println("添加教室成功");
                 resp.sendRedirect("roomlist.action");

             } else {
                 req.setAttribute("message", "添加失败");
                 req.getRequestDispatcher("error.jsp").forward(req, resp);
             }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
