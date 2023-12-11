package com.xiaoxin.dao;

import com.xiaoxin.uitl.DbUtils2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author:XIAOXIN
 * @date:2023/12/05
 **/
public class BookRecordDao {
    public String BorrowBook(int reader_id, int bookID) throws SQLException {
        Connection connection = DbUtils2.getConn();
        String sql = "insert into borrow_record (record_readerid, record_bookid, record_isdelete, is_return, return_time) values (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, reader_id);
        ps.setInt(2, bookID);
        ps.setInt(3, 0);
        ps.setString(4, "NO");
        // 获取当前时间
        java.util.Date currentDate = new java.util.Date();
        // 添加30天
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        // 获取添加30天后的日期
        java.util.Date returnDate = calendar.getTime();
        // 转换为java.sql.Date
        java.sql.Date returnTime = new java.sql.Date(returnDate.getTime());
        ps.setDate(5, returnTime);
        int i = ps.executeUpdate();
        if (i > 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public String returnBookByRecordId(int record_id) throws SQLException {
        Connection connection = DbUtils2.getConn();
        String sql = "update borrow_record set is_return ='YES' where record_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, record_id);
        int i = ps.executeUpdate();
        if (i > 0) {
            return "YES";
        } else {
            return "NO";
        }

    }
}