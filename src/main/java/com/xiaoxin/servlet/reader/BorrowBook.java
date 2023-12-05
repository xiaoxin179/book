package com.xiaoxin.servlet.reader;

import com.xiaoxin.bean.Reader;
import com.xiaoxin.dao.BookRecordDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/BorrowBook")
public class BorrowBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessions = request.getSession();
        BookRecordDao bookRecordDao = new BookRecordDao();
        Reader login = (Reader) sessions.getAttribute("LOGINPERSON");
        int reader_id = login.getReaderId();
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        try {
            String res = bookRecordDao.BorrowBook(reader_id, book_id);
            if (res.equals("YES")) {
                sessions.setAttribute("State", "借书成功");
                response.sendRedirect("state.jsp");
            } else {
                sessions.setAttribute("State", "借书失败");
                response.sendRedirect("state.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
