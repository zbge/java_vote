package com.vote.servlet.user;

import com.vote.jdbc.dao.UsersDao;
import com.vote.jdbc.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyServlet", urlPatterns = "/modify")
public class ModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        User user = (User) request.getSession().getAttribute("user");
        user.setNickname(request.getParameter("nickname").trim());
        user.setEmail(request.getParameter("email").trim());
        if (!request.getParameter("password").trim().equals("") &&
                request.getParameter("password").equals(request.getParameter("again_pwd"))) {
            user.setPassword(request.getParameter("password").trim());
        }
        UsersDao usersDao = new UsersDao();
        if (usersDao.update(user)) {
//            request.setAttribute("modify", "修改成功");
            response.sendRedirect("/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
