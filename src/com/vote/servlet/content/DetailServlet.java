package com.vote.servlet.content;

import com.vote.jdbc.dao.ContentDao;
import com.vote.jdbc.dao.UsersDao;
import com.vote.jdbc.domain.Content;
import com.vote.jdbc.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "DetailServlet", urlPatterns = "/detail")
public class DetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("vote"));
        ContentDao contentDao = new ContentDao();
        Content content = contentDao.findOne(id);
        UsersDao usersDao = new UsersDao();
        String user = usersDao.find(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        request.setAttribute("vote", id);
        request.setAttribute("title", content.getTitle());
        request.setAttribute("content", content.getContent());
        request.setAttribute("start_time", simpleDateFormat.format(content.getStartTime()));
        request.setAttribute("end_time", simpleDateFormat.format(content.getEndTime()));
        request.setAttribute("user", user);
        request.setAttribute("problems", content.getProblems());

        Date now_date = new Date();
        // 1：未开始 2：正在进行 3：已结束
        if (content.getStartTime().getTime() - now_date.getTime() > 0) {
            response.setHeader("Refresh", "3;URL=/");
            request.setAttribute("info", "该投票尚未开始，请浏览其他投票。");
            request.getRequestDispatcher("prompt.jsp").forward(request, response);
        }
        else if (content.getEndTime().getTime() - now_date.getTime() > 0)
            request.setAttribute("state", 2);
        else {
            request.setAttribute("state", 3);
            request.setAttribute("button", "disabled");
        }

        request.getRequestDispatcher("jsp/content/detail.jsp").forward(request, response);
    }
}
