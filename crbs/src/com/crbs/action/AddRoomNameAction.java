package com.crbs.action;

import com.crbs.bean.Room;
import com.crbs.service.IroomService;
import com.crbs.service.impl.IroomServiceImpl;
import com.mysql.cj.util.DnsSrv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lilong
 * @version 1.0
 * @#category 增加教室时判断教室名是否存在控制器
 * @date 2021-03-16 14:55
 */
@WebServlet("/addroomname.action")
public class AddRoomNameAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建业务逻辑对象
        IroomService iroomService=new IroomServiceImpl();
        String roomname=req.getParameter("name");
        System.out.println(roomname);
        Room room=iroomService.findByrname(roomname);
        System.out.println(room);
         if(room!=null){
            resp.getWriter().println("教室已存在");
         }else {
             resp.getWriter().println("ok");
         }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
