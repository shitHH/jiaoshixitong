package com.crbs.action;

import com.crbs.bean.User;
import com.crbs.service.IUserService;
import com.crbs.service.impl.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
/**
 * Project：crbs
 * Date：2021/3/14
 * Time：14:40
 * Description：TODO
 *
 * @author 王永祺
 * @version 1.0
 * @category 查询用户信息集合的控制器
 */
@WebServlet("/userlist.action")
public class UserlistAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserService iUserService= new IUserServiceImpl();
//        创建接收信息列表
        List<User> list = iUserService.findAllUser();
        if (list!=null) {
            //创建session接收对象
            HttpSession session = req.getSession();
            session.setAttribute("list", list);
            //跳转到人员详情页面
            req.getRequestDispatcher("userList.jsp").forward(req, resp);
        }else{
            req.setAttribute("message","用户列表为空");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
