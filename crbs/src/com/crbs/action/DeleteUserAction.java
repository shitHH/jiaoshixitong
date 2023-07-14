package com.crbs.action;

import com.crbs.bean.User;
import com.crbs.service.IUserService;
import com.crbs.service.impl.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Project：crbs
 * Date：2021/3/14
 * Time：14:40
 * Description：TODO
 *
 * @author 王永祺
 * @version 1.0
 * @category 删除用户的控制器
 */
@WebServlet("/deleteUser.action")
public class DeleteUserAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserService iUserService= new IUserServiceImpl();


//        得到用户输入的uid
        String uidstr= req.getParameter("uid");
        System.out.println(uidstr);
        if (uidstr!=null){
            int uid= Integer.valueOf(uidstr);
            boolean flag= iUserService.deleteUser(uid);
            if(flag){
                //重定向到用户列表控制器
                resp.sendRedirect("userlist.action");
            }else{
                //转发到错误页面
                req.setAttribute("message","人员删除失败");
//                req.getRequestDispatcher("error.jsp").forward(req,resp);
            }
        }else{
            req.setAttribute("message","人员uid为空");
//            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
