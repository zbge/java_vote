package com.vote.jdbc.dao;

import com.vote.jdbc.domain.Content;
import com.vote.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ContentDao {
/*****
 Created by IntelliJ IDEA.
 Author: mushan
 Date: 2018/12/13 19:37
 Version 1.0
 Description: 对内容进行增删改查
 *****/

    public int insert(Content content) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            connection = JDBCUtils.getConnection();

            String sql = "INSERT INTO `describe`(user_id, title, content, start_time, end_time)VALUES(?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, content.getUser());
            preparedStatement.setString(2, content.getTitle());
            preparedStatement.setString(3, content.getContent());
            preparedStatement.setString(4, simpleDateFormat.format(content.getStartTime()));
            preparedStatement.setString(5, simpleDateFormat.format(content.getEndTime()));

            if (preparedStatement.executeUpdate() > 0) {
                sql = "SELECT id FROM `describe` WHERE user_id=? AND is_delete=0 ORDER BY id DESC LIMIT 1";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, content.getUser());
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

    public Content findOne(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "SELECT title, content, user_id, `number`, start_time, end_time FROM `describe` WHERE id = ? AND is_delete = 0";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            ProblemDao problemDao = new ProblemDao();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Content content = new Content();
            if (resultSet.next()) {
                content.setId(id);
                content.setTitle(resultSet.getString("title"));
                content.setContent(resultSet.getString("content"));
                content.setNumber(resultSet.getInt("number"));
                content.setUser(resultSet.getInt("user_id"));
                content.setStartTime(simpleDateFormat.parse(resultSet.getString("start_time")));
                content.setEndTime(simpleDateFormat.parse(resultSet.getString("end_time")));
                content.setProblems(problemDao.find(content.getId()));
            }

            return content;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(resultSet, preparedStatement, connection);
        }

        return null;
    }

    public List<Content> find(int user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "SELECT id, title, content, `number`, start_time, end_time FROM `describe` WHERE user_id = ? AND is_delete = 0 ORDER BY id DESC ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user);
            resultSet = preparedStatement.executeQuery();

            List<Content> contents = new ArrayList<Content>();
            ProblemDao problemDao = new ProblemDao();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            while (resultSet.next()) {
                Content content = new Content();
                content.setId(resultSet.getInt("id"));
                content.setTitle(resultSet.getString("title"));
                content.setContent(resultSet.getString("content"));
                content.setNumber(resultSet.getInt("number"));
                content.setUser(user);
                content.setStartTime(simpleDateFormat.parse(resultSet.getString("start_time")));
                content.setEndTime(simpleDateFormat.parse(resultSet.getString("end_time")));
                content.setProblems(problemDao.find(content.getId()));

                contents.add(content);
            }

            return contents;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(resultSet, preparedStatement, connection);
        }

        return null;
    }

    public List<Content> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "SELECT id, user_id, title, content, `number`, start_time, end_time FROM `describe` WHERE is_delete = 0 ORDER BY id DESC ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            List<Content> contents = new ArrayList<Content>();
            ProblemDao problemDao = new ProblemDao();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            while (resultSet.next()) {
                Content content = new Content();
                content.setId(resultSet.getInt("id"));
                content.setUser(resultSet.getInt("user_id"));
                content.setTitle(resultSet.getString("title"));
                content.setContent(resultSet.getString("content"));
                content.setNumber(resultSet.getInt("number"));
                content.setStartTime(simpleDateFormat.parse(resultSet.getString("start_time")));
                content.setEndTime(simpleDateFormat.parse(resultSet.getString("end_time")));
                content.setProblems(problemDao.find(content.getId()));

                contents.add(content);
            }

            return contents;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(resultSet, preparedStatement, connection);
        }

        return null;
    }

    public boolean update(Content content) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            connection = JDBCUtils.getConnection();

            String sql = "UPDATE `describe` SET title=?, content=?, `number`=?, start_time=?, end_time=? WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, content.getTitle());
            preparedStatement.setString(2, content.getContent());
            preparedStatement.setInt(3, content.getNumber());
            preparedStatement.setString(4, simpleDateFormat.format(content.getStartTime()));
            preparedStatement.setString(5, simpleDateFormat.format(content.getEndTime()));
            preparedStatement.setInt(6, content.getId());

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

            String sql = "UPDATE `describe` SET is_delete=1 WHERE id=?";
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
