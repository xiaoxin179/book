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
 * @date:2023/11/25
 **/
public class StaffDao {
    public String StaffDelete(int staff_id) throws SQLException {
        Connection connection = DbUtils2.getConn();
        String sql = "update staff set staff_isdelete=1 where staff_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, staff_id);
        ResultSet resultSet = statement.executeQuery();
        statement.close();
        connection.close();
        if(resultSet.next()) {
            return "YES";
        }return "NO";

    }

    public String updateStaff(Staff staff) throws SQLException {
        Connection connection = DbUtils2.getConn();
        String sql = "update staff set staff_isdelete=? , staff_name=? , password=? , staff_username=? where staff_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, staff.getStaff_isdelete());
        statement.setString(2, staff.getStaff_name());
//        statement.setString(3, staff.getRole());
        statement.setString(3, staff.getPassword());
        statement.setString(4, staff.getStaff_username());
        statement.setInt(5, staff.getStaff_id());
        int res = statement.executeUpdate();
        System.out.println("修改用户信息updateStaff时候的sql："+statement.toString());
        connection.close();
        if (res > 0) {
            return "YES";
        } else {
            return "NO";
        }

    }

    public String  addStaff(Staff staff) throws SQLException {
        Connection connection = DbUtils2.getConn();
        String sql = "INSERT INTO staff (staff_username,staff_name,password,staff_isdelete) values(?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, staff.getStaff_username());
        statement.setString(2, staff.getStaff_name());
        statement.setString(3, staff.getPassword());
        statement.setString(4, staff.getStaff_isdelete());
        int res = statement.executeUpdate();
        connection.close();
        if (res > 0) {
            return "YES";
        } else return "NO";
    }
}
