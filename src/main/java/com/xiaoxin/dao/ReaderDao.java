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
            reader.setPassword(resultSet.getString("password"));
            reader.setCreateTime(reader.getCreateTime());
            reader.setUpdateTime(reader.getUpdateTime());
            reader.setReaderEmail(resultSet.getString("reader_email"));
            reader.setReaderIsDelete(resultSet.getInt("reader_isdelete"));
        }
        resultSet.close();
        ps.close();
        conn.close();

        return reader;




    }
}
