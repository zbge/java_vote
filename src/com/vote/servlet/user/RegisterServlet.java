package com.vote.servlet.user;

import com.vote.jdbc.dao.UsersDao;
import com.vote.jdbc.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if (request.getParameter("password").trim().equals(request.getParameter("again_pwd").trim())) {
            User user = new User();
            user.setUsername(request.getParameter("username").trim());
            user.setPassword(request.getParameter("password").trim());
            user.setNickname(request.getParameter("nickname").trim());
            user.setEmail(request.getParameter("email").trim());
            UsersDao usersDao = new UsersDao();
            if (usersDao.find(request.getParameter("username")) == null) {
                if (usersDao.insert(user)) {
                    request.setAttribute("info", "注册成功，三秒后返回首页");
                }
                else {
                    request.setAttribute("info", "服务器响应无效，请重试。。。");
                }
            }
            else {
                request.setAttribute("info", "注册失败，该用户名已被占用！");
            }
        }
        else {
            request.setAttribute("info", "两次密码不相同，请重新输入！");
        }
        response.setHeader("Refresh", "3; URL=/");
        request.getRequestDispatcher("prompt.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
