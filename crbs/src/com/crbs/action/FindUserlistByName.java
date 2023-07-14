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
 * Time：14:47
 * Description：TODO
 *
 * @author 王永祺
 * @version 1.0
 * @category  通过姓名模糊查询用户集合控制器
 */
@WebServlet("/finduserlistbyauname.action")
public class FindUserlistByName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用控制器
        IUserService iUserService= new IUserServiceImpl();
        //通过req获取用户姓名
        String uname= req.getParameter("uname");
        if(uname!=null&&uname!=""){
            List<User> list= iUserService.findUserlistByname(uname);
            if (list!=null&&list.size()!=0){
                //把集合放进session中
                HttpSession session= req.getSession();
                req.setAttribute("list",list);
                req.getRequestDispatcher("userlist.action").forward(req,resp);
            }else {
                req.setAttribute("messageunamenull","请输入正确的用户名");
                req.getRequestDispatcher("userlist.action").forward(req,resp);
            }
        }else{
            req.setAttribute("message1","姓名不能为空");
            req.getRequestDispatcher("userlist.action").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
