package com.xiaoxin.servlet;

import com.xiaoxin.bean.RoleDivisition;
import com.xiaoxin.bean.Staff;
import com.xiaoxin.dao.RoleDivisitionDao;
import com.xiaoxin.dao.RolesDao;
import com.xiaoxin.dao.StaffDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/StaffInsertServlet")
public class StaffInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessions = request.getSession();
        String staff_name = request.getParameter("staff_name");
        String staff_username = request.getParameter("staff_username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        RolesDao rolesDao = new RolesDao();
        String roleForRoles = null;
        try {
            roleForRoles = rolesDao.getRole(role);
            System.out.println("根据前端选择的职位从后端查出roles表中对应的英文："+roleForRoles);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Staff staff = new Staff();
        staff.setStaff_username(staff_username);
        staff.setStaff_name(staff_name);
        staff.setPassword(password);
        staff.setStaff_isdelete("0");
        StaffDao staffDao = new StaffDao();
        RoleDivisitionDao roleDivDao = new RoleDivisitionDao();
        RoleDivisitionDao roleDiv = new RoleDivisitionDao();
        RoleDivisition roleDivisition = new RoleDivisition();
        roleDivisition.setStaff_username(staff_username);
        roleDivisition.setRole(roleForRoles);
        try {
            String insertStaff = staffDao.addStaff(staff);
            String instRoleDiv = roleDivDao.insertRoleDivisition(roleDivisition);
            if (insertStaff.equals("YES") && instRoleDiv.equals("YES")) {
                sessions.setAttribute("State","添加新员工成功！！！！");
                response.sendRedirect("state.jsp");

            }else {
                sessions.setAttribute("State","添加员工失败！！！！");
                response.sendRedirect("state.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
