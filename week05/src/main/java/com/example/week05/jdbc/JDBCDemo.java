
package com.example.week05.jdbc;

import java.sql.*;

/**
 * 原生的JDBC代码示例
 * 事务的代码和批处理的代码在 addUser() 方法体内
 */
public class JDBCDemo {

    public static String DRIVER_CLAS_NAME = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/employee";
    public static String USERNAME = "root";
    public static String PASSWORD = "luke";

    public static void main(String[] args) {
//        addUser();
//        updateUserById();
        findUser();
    }


    public static void addUser() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(DRIVER_CLAS_NAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            con.setAutoCommit(false); // 手动开启事务
            String sql = "INSERT INTO USER VALUES(?,?,?)";
            // 删除时使用下列语句
//            String deleteSql = "delete from user where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(1));
            pstmt.setString(2, "john");
            pstmt.setString(3, "student");
            pstmt.executeUpdate();
            con.commit(); // 没有问题就提交事务
        }catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback(); // 出现异常回滚事务
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();  //必须要关
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateUserById() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(DRIVER_CLAS_NAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "update user set name = ?, job = ? where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "tom");
            pstmt.setString(2, "teacher");
            pstmt.setString(3, "1");
            pstmt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();  //必须要关
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static User findUser() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(DRIVER_CLAS_NAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM USER WHERE id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setNString(1, String.valueOf(1));

            rs = pstmt.executeQuery();
            if (rs == null) {
                return null;
            }
            if (rs.next()) {
                User user = new User();
                user.setId(Long.valueOf(rs.getString("id")));
                user.setName(rs.getString("username"));
                user.setJob(rs.getString("password"));
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
