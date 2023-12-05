package com.xiaoxin.servlet.reader;

import com.xiaoxin.bean.BorrowRecordView;
import com.xiaoxin.dao.BorrowReacordDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ReturnBook", value = "/ReturnBook")
public class ReturnBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessions = request.getSession();
        BorrowReacordDao borrowRecordView = new BorrowReacordDao();
        try {
            ArrayList<BorrowRecordView> allRecord = borrowRecordView.getAllRecord();
            sessions.setAttribute("ReturnBook", allRecord);
            response.sendRedirect("ReaderMangement/ReaderReturn.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
