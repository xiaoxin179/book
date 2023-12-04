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

@WebServlet(name = "StaffDeleteServlet", value = "/StaffDeleteServlet")
public class StaffDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        接受传递进来的职工号
        request.setCharacterEncoding("UTF-8");
        HttpSession sessions = request.getSession();
        String staffId = request.getParameter("s_no");
        String div = request.getParameter("div");
        String res = null;
        String deleteRes = null;
        if (div.equals("J")) {
            deleteRes = "0";
        } else deleteRes = "1";
        StaffRolesViewDao staffRolesViewdao = new StaffRolesViewDao();


//        调用dao层方法修改is_delete
        StaffDao dao=new StaffDao();
        try {
            res = dao.deleteStaff(staffId,deleteRes);
//            更新了用户信息，删除掉原有的session
            sessions.removeAttribute("StaffList");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        执行跳转
        if (res != null) {
            sessions.setAttribute("State", "工作人员状态修改成功！！！");
        } else {
            sessions.setAttribute("State", "工作人员状态修改失败！！！");
        }
        response.sendRedirect("state.jsp");
    }
}
