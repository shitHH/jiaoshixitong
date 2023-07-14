package com.crbs.action;

import com.crbs.bean.Borrow;
import com.crbs.bean.Room;
import com.crbs.service.IBorrowService;
import com.crbs.service.IroomService;
import com.crbs.service.impl.IBorrowServiceImpl;
import com.crbs.service.impl.IroomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: wangjuyuan  lilong
 * @Date: Created in 11:58 2021-03-14
 * @Description: 审批控制器
 * @Version: 1.0
 */
@WebServlet("/consentapply.action")
public class ConsentApplyAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建教室借用表业务逻辑对象
        IBorrowService borrowService = new IBorrowServiceImpl();
        // 获取前端数据
        String bidStr = req.getParameter("bid");
        System.out.println(bidStr);
        // 获取apply参数值: 1,审批通过; 0,审批未通过
        String apply = req.getParameter("apply");
        if (bidStr != null) {
            // 类型转换
            int bid = Integer.valueOf(bidStr);
            // 调用方法获取借用表对象
            Borrow borrow = borrowService.findBorrowByBid(bid);
            System.out.println(borrow);
            if (borrow != null) {
                // 判断审批是否通过
                if ("1".equals(apply)) {
                    // 修改借用表审批状态
                    borrow.setStatus("通过");
                    IroomService iroomService=new IroomServiceImpl();
                    Room room=new Room();
                    room.setRid(borrow.getRid());
                    room.setStatus("不可");
                    iroomService.update(room);
                } else if ("0".equals(apply)) {
                    // 修改借用表审批状态
                    borrow.setStatus("拒绝");
                }
                // 调用方法,修改申请状态
                boolean flag = borrowService.updateSta(borrow);
//                System.out.println(flag);
                // 输出flag
                resp.getWriter().println(flag);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
