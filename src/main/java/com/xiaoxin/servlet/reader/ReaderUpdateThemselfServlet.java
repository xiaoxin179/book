package com.xiaoxin.servlet.reader;

import com.xiaoxin.bean.Reader;
import com.xiaoxin.bean.Staff;
import com.xiaoxin.dao.ReaderDao;
import com.xiaoxin.dao.StaffDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ReaderUpdateThemselfServlet")
public class ReaderUpdateThemselfServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessions = request.getSession();
        Reader reader=new Reader();
        Reader loginperson = (Reader)sessions.getAttribute("LOGINPERSON");
        int reader_id = loginperson.getReaderId();
        reader.setUsername(request.getParameter("username"));
        reader.setReaderId(reader_id);
        reader.setReaderIsDelete(0);
        reader.setName(request.getParameter("name"));
        reader.setPassword(request.getParameter("password"));
        reader.setReaderEmail(request.getParameter("reader_email"));
        ReaderDao readerDao=new ReaderDao();
        String res = null;
        try {
            res = readerDao.updateReader(reader);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (res.equals("YES")) {
            sessions.setAttribute("State","用户信息更新成功");
            sessions.setAttribute("LOGINPERSON",reader);
        }else{
            sessions.setAttribute("State","用户信息更新失败");
        }
        response.sendRedirect("state.jsp");
    }
    }

