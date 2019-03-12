package com.lxj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lxj.model.User;

/**
 * UserDao
 */
public class UserDao {

    public static boolean login(Connection c, User user) throws SQLException {
        String sql = "select count(*) from t_user where userName=? and password=?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, user.getUser_name());
        ps.setString(2, user.getPassword());

        ResultSet rs = ps.executeQuery();
        
        boolean result = false;
        if(rs.next()) {
            if(rs.getInt(1) == 1) {
                result = true;
            } 
        }

        return result;
    }
}