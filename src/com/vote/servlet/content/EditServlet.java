package com.vote.servlet.content;

import com.vote.jdbc.dao.ContentDao;
import com.vote.jdbc.domain.Answer;
import com.vote.jdbc.domain.Content;
import com.vote.jdbc.domain.Problem;
import com.vote.jdbc.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "EditServlet", urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        User user = (User) request.getSession().getAttribute("user");
        ContentDao contentDao = new ContentDao();
        List<Content> contents = contentDao.find(user.getId());
        request.setAttribute("contents", contents);
        if (request.getParameter("vote") != null) {
            Content content = contentDao.findOne(Integer.parseInt(request.getParameter("vote")));
            request.getSession().setAttribute("describe_id", content.getId());
            request.setAttribute("title", content.getTitle());
            request.setAttribute("content", content.getContent());
            int i = 1;
            for (Problem problem: content.getProblems()) {
                request.getSession().setAttribute("problem"+i+"_id", problem.getId());
                request.setAttribute("problem"+i, problem.getContent());
                int j = 1;
                for (Answer answer: problem.getAnswers()) {
                    request.getSession().setAttribute("answer"+i+"_"+j+"_id", answer.getId());
                    request.setAttribute("answer"+i+"_"+j, answer.getOption());
                    j++;
                }
                i++;
            }
            request.setAttribute("start_time", simpleDateFormat.format(content.getStartTime()));
            request.setAttribute("end_time", simpleDateFormat.format(content.getEndTime()));
            request.getRequestDispatcher("jsp/content/create.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("jsp/content/list.jsp").forward(request, response);
        }
    }
}
