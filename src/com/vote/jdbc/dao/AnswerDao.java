package com.vote.jdbc.dao;

import com.vote.jdbc.domain.Answer;
import com.vote.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnswerDao {
/*****
 Created by IntelliJ IDEA.
 Author: mushan
 Date: 2018/12/13 19:39
 Version 1.0
 Description: 对答案进行增删改查
 *****/

    public boolean insert(Answer answer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "INSERT INTO answer(problem_id, `option`, `count`)VALUES(?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, answer.getProblem());
            preparedStatement.setString(2, answer.getOption());
            preparedStatement.setInt(3, answer.getCount());

            if (preparedStatement.executeUpdate() > 0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(preparedStatement, connection);
        }
        return false;
    }

    public Answer findOne(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "SELECT problem_id, `option`, `count` FROM answer WHERE id = ? AND is_delete = 0";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            Answer answer = new Answer();
            if (resultSet.next()) {
                answer.setId(id);
                answer.setProblem(resultSet.getInt("problem_id"));
                answer.setOption(resultSet.getString("option"));
                answer.setCount(resultSet.getInt("count"));
            }

            return answer;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(resultSet, preparedStatement, connection);
        }

        return null;
    }

    public List<Answer> find(int problem) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "SELECT id, `option`, `count` FROM answer WHERE problem_id = ? AND is_delete = 0";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, problem);
            resultSet = preparedStatement.executeQuery();

            List<Answer> answers = new ArrayList<Answer>();
            while (resultSet.next()) {
                Answer answer = new Answer();
                answer.setId(resultSet.getInt("id"));
                answer.setProblem(problem);
                answer.setOption(resultSet.getString("option"));
                answer.setCount(resultSet.getInt("count"));

                answers.add(answer);
            }

            return answers;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(resultSet, preparedStatement, connection);
        }

        return null;
    }

    public boolean update(Answer answer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "UPDATE answer SET `option`=?, `count`=? WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, answer.getOption());
            preparedStatement.setInt(2, answer.getCount());
            preparedStatement.setInt(3, answer.getId());

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

            String sql = "UPDATE answer SET is_delete=1 WHERE id=?";
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
