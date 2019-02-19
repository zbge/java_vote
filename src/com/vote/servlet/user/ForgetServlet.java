package com.vote.servlet.user;

import com.vote.jdbc.dao.UsersDao;
import com.vote.jdbc.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForgetServlet", urlPatterns = "/forget")
public class ForgetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("password").equals(request.getParameter("again_pwd"))) {
            UsersDao usersDao = new UsersDao();
            User user = usersDao.find(request.getParameter("username"));
            if (user != null) {
                if (user.getEmail().equals(request.getParameter("email"))) {
                    user.setPassword(request.getParameter("password"));
                    usersDao.update(user);
                    response.sendRedirect("/");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
