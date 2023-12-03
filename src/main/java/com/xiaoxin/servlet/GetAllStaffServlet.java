package com.xiaoxin.servlet;

import com.xiaoxin.bean.Staff;
import com.xiaoxin.dao.StaffDao;
import com.xiaoxin.dao.StaffRolesViewDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/GetAllStaffServlet")
public class GetAllStaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessions = request.getSession();
        StaffRolesViewDao dao=new StaffRolesViewDao();
        try {
            ArrayList<Staff> staffList = dao.getStaffList();
            sessions.setAttribute("StaffList",staffList);
            response.sendRedirect("StaffMangement/AllStaffShow.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
