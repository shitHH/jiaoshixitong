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
 * Date：2021/3/16
 * Time：14:04
 * Description：TODO
 *
 * @author 王永祺
 * @version 1.0
 * @category 通过uid查询用户集合
 */
@WebServlet("/finduserlistbyuid.action")
public class FindUserlistByUid extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserService iUserService= new IUserServiceImpl();
      String uidstr=  req.getParameter("uid");
        System.out.println(uidstr);
        if (uidstr!=null&&uidstr!=""){
            int uid= Integer.valueOf(uidstr);
            List<User> list= iUserService.findUserBylistuid(uid);
            if (list!=null&&list.size()!=0){
                HttpSession session= req.getSession();
                session.setAttribute("list",list);
                req.getRequestDispatcher("userList.jsp").forward(req, resp);
            }else{
                req.setAttribute("messageuidnull","请输入正确的uid");
                req.getRequestDispatcher("userlist.action").forward(req,resp);
            }
        }else{
            req.setAttribute("message2","uid不能为空");
            req.getRequestDispatcher("userlist.action").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
