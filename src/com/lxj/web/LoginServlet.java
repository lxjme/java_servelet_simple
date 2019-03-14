package com.lxj.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lxj.dao.UserDao;
import com.lxj.model.User;
import com.lxj.util.DbUtil;
import com.lxj.util.StringUtil;

/**
 * LoginServlet
 */
public class LoginServlet extends HttpServlet  {

    private static final long serialVersionUID = -8962447452483592472L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // super.service(arg0, arg1);
        System.out.println(req.getMethod());
        System.out.println(req.getParameter("arg0"));
        System.out.println(req.getParameter("userName"));
        System.out.println(req.getParameter("password"));

        String user_name = req.getParameter("userName");    // 用户名
        String password = req.getParameter("password");     // 密码

        // 1.判断请求过来的账号信息是否为空
        if(StringUtil.isEmpty(user_name) || StringUtil.isEmpty(password)) {
            req.setAttribute("error", "用户名或密码为空");
            req.getRequestDispatcher("index.jsp").forward(req, res);
            return;
        }

        User user = new User(user_name, password);

        DbUtil dUtil = new DbUtil();
        Connection c = null;
        try {
            c = dUtil.getConn();
            if(UserDao.login(c, user)) {
                // 登录成功
                // 客户端跳转
                HttpSession session = req.getSession();
                session.setAttribute("currentUser", user_name);
                
                res.sendRedirect("main.jsp");
            } else {
                // 登录失败
                req.setAttribute("error", "用户名或密码错误");
                // 服务器跳转
                req.getRequestDispatcher("index.jsp").forward(req, res);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dUtil.closeConn(c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    
}