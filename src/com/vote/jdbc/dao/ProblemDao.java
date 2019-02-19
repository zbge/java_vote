package com.vote.jdbc.dao;

import com.vote.jdbc.domain.Answer;
import com.vote.jdbc.domain.Problem;
import com.vote.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProblemDao {
/*****
 Created by IntelliJ IDEA.
 Author: mushan
 Date: 2018/12/13 19:38
 Version 1.0
 Description: 对问题进行增删改查
 *****/

    public int insert(Problem problem) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "INSERT INTO problem(describe_id, content)VALUES(?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, problem.getDescribe());
            preparedStatement.setString(2, problem.getContent());

            if (preparedStatement.executeUpdate() > 0) {
                sql = "SELECT id FROM problem WHERE describe_id=? AND is_delete=0 ORDER BY id DESC LIMIT 1";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, problem.getDescribe());
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(preparedStatement, connection);
        }
        return 0;
    }

    public List<Problem> find(int describe) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "SELECT id, content FROM problem WHERE describe_id = ? AND is_delete = 0";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, describe);
            resultSet = preparedStatement.executeQuery();

            List<Problem> problems = new ArrayList<Problem>();
            AnswerDao answerDao = new AnswerDao();
            while (resultSet.next()) {
                Problem problem = new Problem();
                problem.setId(resultSet.getInt("id"));
                problem.setContent(resultSet.getString("content"));
                problem.setDescribe(describe);
                problem.setAnswers(answerDao.find(problem.getId()));

                problems.add(problem);
            }

            return problems;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(resultSet, preparedStatement, connection);
        }

        return null;
    }

    public boolean update(Problem problem) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "UPDATE problem SET content=? WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, problem.getContent());
            preparedStatement.setInt(2, problem.getId());

            if (preparedStatement.executeUpdate() > 0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(preparedStatement, connection);
        }
        return false;
    }

    public boolean delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "UPDATE problem SET is_delete=1 WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            if (preparedStatement.executeUpdate() > 0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(preparedStatement, connection);
        }
        return false;
    }
}
