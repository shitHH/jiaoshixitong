package com.crbs.action;

import com.crbs.bean.Room;
import com.crbs.service.IroomService;
import com.crbs.service.impl.IroomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lilong
 * @version 1.0
 * @#category 更新教室控制器
 * @date 2021-03-14 13:05
 */
@WebServlet("/updateroom.action")
public class UpdateRoomAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //创建业务逻辑对象
        IroomService iroomService=new IroomServiceImpl();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
//        HttpSession session= req.getSession();
//     Object rid=session.getAttribute ("rid");
//        System.out.println(rid);
        String rid=req.getParameter("roomrid");

        String name= req.getParameter("roomname");
        String size=req.getParameter("roomsize");
        String status=req.getParameter("roomstatus");

        Room room=new Room();

//        System.out.println((Integer)rid);
        room.setRid(Integer.valueOf(rid));
        room.setRname(name);
        room.setSize(size);
        room.setStatus(status);

        System.out.println(room);
  int i=      iroomService.update(room);
        if(i>0){
            System.out.println("更新成功");
            resp.sendRedirect("roomlist.action");

        }else{
            req.setAttribute("message","更新失败");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
