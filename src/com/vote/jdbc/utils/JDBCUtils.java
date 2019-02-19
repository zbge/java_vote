package com.vote.jdbc.utils;

import java.sql.*;

public class JDBCUtils {
/*****
 Created by IntelliJ IDEA.
 Author: mushan
 Date: 2018/12/7 19:07
 Version 1.0
 Description: TODO
 *****/

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/vote?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "mushan";

        return DriverManager.getConnection(url, username, password);
    }

    public static void release(PreparedStatement preparedStatement, Connection connection) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            preparedStatement = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            connection = null;
        }
    }

    public static void release(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            resultSet = null;
        }
        release(preparedStatement, connection);
    }
}
