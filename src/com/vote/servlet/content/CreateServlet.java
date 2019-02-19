package com.vote.servlet.content;

import com.vote.jdbc.dao.AnswerDao;
import com.vote.jdbc.dao.ContentDao;
import com.vote.jdbc.dao.ProblemDao;
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

@WebServlet(name = "CreateServlet", urlPatterns = "/create")
public class CreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Content content = new Content();
        ContentDao contentDao = new ContentDao();
        Problem problem = new Problem();
        ProblemDao problemDao = new ProblemDao();
        Answer answer = new Answer();
        AnswerDao answerDao = new AnswerDao();
        User user = (User) request.getSession().getAttribute("user");
        content.setUser(user.getId());
        content.setTitle(request.getParameter("title"));
        content.setContent(request.getParameter("content"));
        try {
            content.setStartTime(simpleDateFormat.parse(request.getParameter("start_time")));
            content.setEndTime(simpleDateFormat.parse(request.getParameter("end_time")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (request.getSession().getAttribute("describe_id") == null) {
            int content_id = contentDao.insert(content);
            String problem_text = null;
            String answer_text = null;
            for (int i = 1; i <= 5; ++i) {
                problem.setDescribe(content_id);
                problem_text = request.getParameter("problem" + i);
                if (!problem_text.trim().equals("")) {
                    problem.setContent(problem_text.trim());
                    int problem_id = problemDao.insert(problem);
                    for (int j = 1; j <= 5; ++j) {
                        answer.setProblem(problem_id);
                        answer_text = request.getParameter("answer" + i + "_" + j);
                        if (!answer_text.trim().equals("")) {
                            answer.setOption(answer_text.trim());
                            answerDao.insert(answer);
                        } else
                            break;
                    }
                } else
                    break;
            }
            request.setAttribute("info", "创建成功！");
        } else {
            int content_id = (int) request.getSession().getAttribute("describe_id");
            request.getSession().removeAttribute("describe_id");
            content.setId(content_id);
            contentDao.update(content);
            String problem_text = null;
            String answer_text = null;
            for (int i = 1; i <= 5; ++i) {
                problem.setDescribe(content_id);
                if (request.getSession().getAttribute("problem" + i + "_id") != null) {
                    int problem_id = (int) request.getSession().getAttribute("problem" + i + "_id");
                    request.getSession().removeAttribute("problem" + i + "_id");
                    problem_text = request.getParameter("problem" + i);
                    problem.setId(problem_id);
                    problem.setContent(problem_text.trim());
                    problemDao.update(problem);
                    for (int j = 1; j <= 5; ++j) {
                        if (request.getSession().getAttribute("answer"+i+"_"+j+"_id") != null) {
                            int answer_id = (int) request.getSession().getAttribute("answer"+i+"_"+j+"_id");
                            request.getSession().removeAttribute("answer"+i+"_"+j+"_id");
                            answer.setId(answer_id);
                            answer.setProblem(problem_id);
                            answer_text = request.getParameter("answer" + i + "_" + j);
                            answer.setOption(answer_text.trim());
                            answerDao.update(answer);
                        }
                        else {
                            answer.setProblem(problem_id);
                            answer_text = request.getParameter("answer" + i + "_" + j);
                            if (!answer_text.trim().equals("")) {
                                answer.setOption(answer_text.trim());
                                answerDao.insert(answer);
                            } else
                                break;
                        }
                    }
                } else {
                    problem.setDescribe(content_id);
                    problem_text = request.getParameter("problem" + i);
                    if (!problem_text.trim().equals("")) {
                        problem.setContent(problem_text.trim());
                        int problem_id = problemDao.insert(problem);
                        for (int j = 1; j <= 5; ++j) {
                            answer.setProblem(problem_id);
                            answer_text = request.getParameter("answer" + i + "_" + j);
                            if (!answer_text.trim().equals("")) {
                                answer.setOption(answer_text.trim());
                                answerDao.insert(answer);
                            } else
                                break;
                        }
                    } else
                        break;
                }
            }
            request.setAttribute("info", "修改成功！");
        }
        response.setHeader("Refresh", "3; URL=/edit");
        request.getRequestDispatcher("prompt.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/content/create.jsp").forward(request, response);
    }
}
