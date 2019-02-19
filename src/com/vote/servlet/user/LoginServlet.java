package com.vote.servlet.user;

import com.vote.jdbc.dao.UsersDao;
import com.vote.jdbc.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    /*****
     Created by IntelliJ IDEA.
     Author: mushan
     Date: 2018/12/8 20:20
     Version 1.0
     Description: 实现用户登录功能
     *****/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        UsersDao usersDao = new UsersDao();
        User user = usersDao.find(request.getParameter("username"));
        PrintWriter out = response.getWriter();
        if (user != null && user.getPassword().equals(request.getParameter("password").trim())) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/");
        }
        else {
            request.setAttribute("error", "fail......username or password error");
            request.getRequestDispatcher("/").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
