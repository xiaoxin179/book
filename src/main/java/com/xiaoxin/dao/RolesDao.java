package com.xiaoxin.dao;

import com.xiaoxin.bean.Roles;
import com.xiaoxin.uitl.DbUtils2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:XIAOXIN
 * @date:2023/12/03
 **/
public class RolesDao {
    public ArrayList getAllRoles() throws SQLException {
        Connection connection = DbUtils2.getConn();
        String sql = "select role_name from roles";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        ArrayList list = new ArrayList();
        while(rs.next()) {
            list.add(rs.getString("role_name"));
        }
        return list;
    }

    public String getRole(String role_name) throws SQLException {
        Connection connection = DbUtils2.getConn();
        String sql = "select role from roles where role_name=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, role_name);
        ResultSet rs = statement.executeQuery();
        String role = null;
        if (rs.next()) {
            role = rs.getString("role");
        }
        return role;
    }
}
