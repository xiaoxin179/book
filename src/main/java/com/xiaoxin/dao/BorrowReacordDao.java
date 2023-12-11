package com.xiaoxin.dao;

import com.xiaoxin.bean.BorrowRecordView;
import com.xiaoxin.uitl.DbUtils2;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author:XIAOXIN
 * @date:2023/12/05
 **/
//查看所有的书籍
public class BorrowReacordDao {
    public ArrayList<BorrowRecordView> getAllRecord() throws SQLException {
        ArrayList<BorrowRecordView>records = new ArrayList<BorrowRecordView>();
        Connection connection = DbUtils2.getConn();

        String sql = "SELECT * FROM borrow_view WHERE is_return='NO'";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            BorrowRecordView borrowRecordView = new BorrowRecordView();
            borrowRecordView.setRecord_id(resultSet.getInt("record_id"));
            borrowRecordView.setRecord_readerid(resultSet.getInt("record_readerid"));
            borrowRecordView.setUsername(resultSet.getString("username"));
            borrowRecordView.setBook_name(resultSet.getString("book_name"));
            borrowRecordView.setIs_return(resultSet.getString("is_return"));
            borrowRecordView.setReturn_time(resultSet.getDate("return_time"));
            records.add(borrowRecordView);
        }
        return records;
    }


}
