package com.crbs.action;


import com.crbs.service.IBorrowVOservice;
import com.crbs.service.impl.IBorrowVOServiceImpl;
import com.crbs.vo.BorrowVO;

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
 * @date 2021年3月13日16:24:34
 * @category 展示所有借用信息控制器
 */
@WebServlet("/showborrow.action")
public class ShowBorrowAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建业务逻辑实现对象
        IBorrowVOservice borrowVOservice = new IBorrowVOServiceImpl();
        //从数据库获得列表信息
        List<BorrowVO> list = borrowVOservice.findAll();
        //创建session，将信息存放在session中
        HttpSession session = request.getSession();
        //遍历list，获得需要的信息
        if (list!=null){
            session.setAttribute("list",list);
            request.getRequestDispatcher("borrow.jsp").forward(request,response);
        }else{
            session.setAttribute("message","查询的列表为空");
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
