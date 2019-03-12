package com.lxj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DbUtil
 */
public class DbUtil {
    private String dbUrl = "jdbc:mysql://localhost:3306/db_studentInfo";
    private String dbUser = "root";
    private String dbPwd = "root";
    private String jdbcName = "com.mysql.jdbc.Driver";

    /**
     * 数据库链接
     */
    public Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName(jdbcName);

        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        return conn;
    }

    /**
     * 关闭数据库链接
     */
    public void closeConn(Connection conn) throws SQLException {
        if(conn != null) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        DbUtil dbutil = new DbUtil();
        try {
            dbutil.getConn();
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            System.out.println("链接失败");
            //TODO: handle exception
        }
    }
    
}