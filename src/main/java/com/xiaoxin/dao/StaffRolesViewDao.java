package com.xiaoxin.dao;

import com.xiaoxin.bean.Staff;
import com.xiaoxin.uitl.DbUtils2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author:XIAOXIN
 * @date:2023/12/03
 **/
public class StaffRolesViewDao {
    public Staff getOne(String staff_username) throws SQLException {
        Connection connection = DbUtils2.getConn();
        String sql = "select * from staff_roles_view where staff_username=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, staff_username);
        ResultSet resultSet = statement.executeQuery();
        Staff staffNew = new Staff();
        if (resultSet.next()) {
            staffNew.setStaff_id(resultSet.getInt("staff_id"));
            staffNew.setStaff_username(resultSet.getString("staff_username"));
            staffNew.setStaff_name(resultSet.getString("staff_name"));
            staffNew.setRole(resultSet.getString("role"));
            staffNew.setStaff_isdelete(resultSet.getString("staff_isdelete"));
            staffNew.setPassword(resultSet.getString("password"));
        }
        resultSet.close();
        statement.close();
        connection.close();
        return staffNew;

    }
    public ArrayList<Staff> getStaffList() throws SQLException {
        ArrayList<Staff> list = new ArrayList<Staff>();
        Connection connection = DbUtils2.getConn();
        String sql = "SELECT * FROM staff_roles_view where staff_isdelete=0";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Staff staffNew = new Staff();
            staffNew.setStaff_id(resultSet.getInt("staff_id"));
            staffNew.setStaff_username(resultSet.getString("staff_username"));
            staffNew.setStaff_name(resultSet.getString("staff_name"));
            staffNew.setRole(resultSet.getString("role"));
            staffNew.setStaff_isdelete(resultSet.getString("staff_isdelete"));
            staffNew.setPassword(resultSet.getString("password"));
            list.add(staffNew);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return list;
    }
}
