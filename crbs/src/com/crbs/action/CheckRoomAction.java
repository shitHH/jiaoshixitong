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
 * @author 李英
 * @date 2021年3月16日14:36:21
 * @category 检查教室状态，如果教室状态不可用或教室id为空，则添加不成功
 */
@WebServlet("/checkroom.action")
public class CheckRoomAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建业务逻辑对象
        IroomService roomService = new IroomServiceImpl();
        //创建session
        HttpSession session = request.getSession();
        //调用对应的方法，并返回对应的值
        //获取用户输入的rid,根据rid得到room对象
        String strrid = request.getParameter("rid");
        int rid = Integer.valueOf(strrid);
        Room room = roomService.findByrid(rid);
        if(room!=null && room.getStatus().equals("可用")){
            response.getWriter().println("ok");
        }else{
         response.getWriter().println("该教室不可用，请重新输入教室编号");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
