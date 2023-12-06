package com.xiaoxin.dao;

import com.xiaoxin.bean.Reader;
import com.xiaoxin.uitl.DbUtils2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:XIAOXIN
 * @date:2023/11/30
 **/
public class ReaderDao {
    public Reader getOneReader(String username) throws SQLException {
        Connection conn = DbUtils2.getConn();
        String sql = "select * from reader where username=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        Reader reader = new Reader();
        ps.setString(1, username);
        ResultSet resultSet = ps.executeQuery();
        if(resultSet.next()) {
            reader.setReaderId(resultSet.getInt("reader_id"));
            reader.setUsername(resultSet.getString("username"));
            reader.setName(resultSet.getString("name"));
            reader.setPassword(resultSet.getString("password"));
            reader.setReaderEmail(resultSet.getString("reader_email"));
            reader.setReaderIsDelete(resultSet.getInt("reader_isdelete"));
        }
        resultSet.close();
        ps.close();
        conn.close();

        return reader;




    }

    public String updateReader(Reader reader) throws SQLException {
        Connection connection = DbUtils2.getConn();
        String sql = "update reader set  name=? , password=? ,reader_email=? where reader_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,reader.getName() );
        statement.setString(2, reader.getPassword());
        statement.setString(3, reader.getReaderEmail());
        statement.setInt(4, reader.getReaderId());
        int res = statement.executeUpdate();
        System.out.println("修改用户信息updateStaff时候的sql：" + statement.toString());
        connection.close();
        if (res > 0) {
            return "YES";
        } else {
            return "NO";
        }

    }
}
