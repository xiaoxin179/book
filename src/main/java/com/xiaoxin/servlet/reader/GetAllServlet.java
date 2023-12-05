package com.xiaoxin.servlet.reader;

import com.xiaoxin.bean.BookView;
import com.xiaoxin.dao.BookBorrowViewDao;
import com.xiaoxin.dao.ReaderDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/GetAllServlet")
public class GetAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessions = request.getSession();
        ReaderDao dao=new ReaderDao();
        BookBorrowViewDao bookBorrowViewDao =new BookBorrowViewDao();
        try {
            ArrayList<BookView> bookArrayList = bookBorrowViewDao.getAllBook();
            sessions.setAttribute("BookList",bookArrayList);
            response.sendRedirect("ReaderMangement/ReaderBorrow.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
