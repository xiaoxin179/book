package com.xiaoxin.dao;

import com.xiaoxin.bean.BookView;
import com.xiaoxin.uitl.DbUtils2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author:XIAOXIN
 * @date:2023/12/05
 **/
public class BookBorrowViewDao {
    public ArrayList<BookView> getAllBook() throws SQLException {
        ArrayList<BookView> list = new ArrayList<BookView>();
        Connection connection = DbUtils2.getConn();
        String sql = "select * from book_view";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            BookView book_view = new BookView();
            book_view.setBook_id(resultSet.getInt("book_id"));
            book_view.setBook_name(resultSet.getString("book_name"));
            book_view.setCategory_name(resultSet.getString("category_name"));
            book_view.setBook_content(resultSet.getString("book_content"));
            book_view.setRoom_number(resultSet.getString("room_number"));
            book_view.setBookshelf_id(resultSet.getInt("bookshelf_id"));
            book_view.setBook_isdelete(resultSet.getInt("book_isdelete"));
            list.add(book_view);
        }
        return list;
        }


}
