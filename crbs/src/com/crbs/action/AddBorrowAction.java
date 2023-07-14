package com.crbs.action;

import com.crbs.bean.Borrow;
import com.crbs.service.IroomService;
import com.crbs.service.impl.IroomServiceImpl;
import com.crbs.service.IBorrowService;
import com.crbs.service.impl.IBorrowServiceImpl;
import com.crbs.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * @author 李英
 * @date 2021年3月13日17:47:38
 * @category 增加借用记录控制器
 */
@WebServlet("/addborrow.action")
public class AddBorrowAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建业务实现类
        IBorrowService borrowService = new IBorrowServiceImpl();
        IroomService roomService = new IroomServiceImpl();
        HttpSession session = request.getSession();
        //获得用户输入的信息
        String struid = request.getParameter("ad_uid");
        String strrid = request.getParameter("ad_rid");
        String strstarttime = request.getParameter("ad_starttime");
        String strendtime = request.getParameter("ad_endtime");
        //将获得的string类型的数据转化为int类型
        int uid = Integer.valueOf(struid);
        int rid = Integer.valueOf(strrid);
        //将获得的string类型的日期数据转化为日期并传递给后端
        Date starttime = DateUtil.getDate(strstarttime);
        Date endtime = DateUtil.getDate(strendtime);
        Date inputtime = new Date();
        Borrow borrow = new Borrow();
        borrow.setUid(uid);
        borrow.setRid(rid);
        borrow.setStarttime(starttime);
        borrow.setEndtime(endtime);
        borrow.setInputtime(inputtime);
        boolean flag = borrowService.add(borrow);
            if (flag) {
                //判断是否保存成功，成功则跳转到列表页面，否则则跳转错误页面
                session.setAttribute("message101", "申请提交成功");
                request.getRequestDispatcher("message.jsp").forward(request, response);
            } else {
                session.setAttribute("message101", "申请提交失败");
                request.getRequestDispatcher("message.jsp").forward(request, response);
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
