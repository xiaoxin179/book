package com.xiaoxin.servlet;

import com.xiaoxin.bean.Staff;
import com.xiaoxin.dao.StaffDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/StaffUpdateServlet")
public class StaffUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessions = request.getSession();
        Staff staff=new Staff();
        staff.setStaff_id(Integer.parseInt(request.getParameter("staff_id").trim()));
        staff.setStaff_username(request.getParameter("staff_username"));
        staff.setPassword(request.getParameter("password"));
        staff.setStaff_name(request.getParameter("staff_name"));
        staff.setStaff_isdelete("0");
        staff.setRole(request.getParameter("role"));
        StaffDao dao=new StaffDao();
        try {
            String res = dao.updateStaff(staff);
            if (res.equals("YES")) {
                sessions.setAttribute("State","用户信息更新成功");
                sessions.setAttribute("LOGINPERSON",staff);
            }else{
                sessions.setAttribute("State","用户信息更新失败");
            }
            response.sendRedirect("state.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
