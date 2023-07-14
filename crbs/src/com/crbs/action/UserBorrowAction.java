package com.crbs.action;

import com.crbs.bean.Borrow;
import com.crbs.service.IBorrowService;
import com.crbs.service.impl.IBorrowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author 李英
 * @date 2021年3月14日17:01:32
 * @category 用户借用教室记录
 */
@WebServlet("/userborrow.action")
public class UserBorrowAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建业务逻辑实现类
        IBorrowService borrowService = new IBorrowServiceImpl();
        String struid = req.getParameter("uid");
        int uid = Integer.valueOf(struid);
        //从数据库获得列表信息
        List<Borrow> list = borrowService.findByUid(uid);
        //创建session，将信息存放在session中
        HttpSession session = req.getSession();
        if(list.size()>0){
            session.setAttribute("list",list);
            req.getRequestDispatcher("userborrow.jsp").forward(req,resp);
            //将session信息传递给页面
        }else{
            session.setAttribute("message101","该学生没有申请记录");
            req.getRequestDispatcher("message.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
