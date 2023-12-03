package com.xiaoxin.dao;

import com.xiaoxin.bean.RoleDivisition;
import com.xiaoxin.uitl.DbUtils2;

import javax.management.relation.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author:XIAOXIN
 * @date:2023/12/03
 **/
public class RoleDivisitionDao {
    public String insertRoleDivisition(RoleDivisition role) throws SQLException {
        Connection connection = DbUtils2.getConn();
        String sql = "INSERT INTO role_divisition (staff_username,role) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, role.getStaff_username());
        statement.setString(2, role.getRole());
        int res = statement.executeUpdate();
        System.out.println("执行添加员工的时候编译之后的sql" + statement.toString());
        String isAdd = "NO";
        if (res > 0) {
            isAdd = "YES";
        }
        return isAdd;


    }


}