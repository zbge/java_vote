package com.vote.servlet.content;

import com.vote.jdbc.dao.AnswerDao;
import com.vote.jdbc.dao.ContentDao;
import com.vote.jdbc.domain.Answer;
import com.vote.jdbc.domain.Content;
import com.vote.jdbc.domain.Problem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResultServlet", urlPatterns = "/result")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vote = Integer.parseInt(request.getParameter("vote"));
        ContentDao contentDao = new ContentDao();
        Content content = contentDao.findOne(vote);
        AnswerDao answerDao = new AnswerDao();
        Answer answer = null;
        content.setNumber(content.getNumber()+1);
        contentDao.update(content);
        for (Problem problem: content.getProblems()) {
            int id = Integer.parseInt(request.getParameter("problem"+problem.getId()));
            answer = answerDao.findOne(id);
            answer.setCount(answer.getCount()+1);
            answerDao.update(answer);
        }
        request.setAttribute("info", "投票成功！投票截止后可查看投票结果，敬请期待");
        response.setHeader("Refresh", "3; URL=/");
        request.getRequestDispatcher("prompt.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
