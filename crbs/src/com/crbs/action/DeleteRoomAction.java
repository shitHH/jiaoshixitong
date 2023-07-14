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
 * @#category  删除教室控制器
 * @date 2021-03-14 12:42
 */
@WebServlet("/deleteroom.action")
public class DeleteRoomAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建业务逻辑对象
        IroomService iroomService=new IroomServiceImpl();
        String  rid=req.getParameter("rid");
        Room room=new Room();
        room.setRid(Integer.valueOf(rid));
        //调用方法
      Boolean q=  iroomService.deleteRoom(room);
  if(q==true){
            resp.sendRedirect("roomlist.action");
   } else {
      req.getRequestDispatcher("roomlist.action").forward(req, resp);
  }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
