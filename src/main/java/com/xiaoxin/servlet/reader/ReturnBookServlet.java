package com.xiaoxin.servlet.reader;

import com.xiaoxin.bean.BorrowRecordView;
import com.xiaoxin.dao.BookRecordDao;
import com.xiaoxin.dao.BorrowReacordDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessions = request.getSession();
        int record_id = Integer.parseInt(request.getParameter("record_id"));
        BookRecordDao bookRecordDao = new BookRecordDao();
        BorrowReacordDao borrowReacordDao = new BorrowReacordDao();
        try {
            String res = bookRecordDao.returnBookByRecordId(record_id);
            if (res.equals("YES")) {
                sessions.setAttribute("State", "还书成功");
                ArrayList<BorrowRecordView> allRecord = borrowReacordDao.getAllRecord();
//                还书成功之后重新为session中替换值
                sessions.setAttribute("ReturnBook", allRecord);
//                还书成功之后修改借阅信息
                ArrayList<BorrowRecordView> allRecordYesAndNo = borrowReacordDao.getAllRecordYesAndNo();
                sessions.setAttribute("AllBWMethod", allRecordYesAndNo);
                response.sendRedirect("state.jsp");
            } else {
                sessions.setAttribute("State", "还书失败");
                response.sendRedirect("state.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
