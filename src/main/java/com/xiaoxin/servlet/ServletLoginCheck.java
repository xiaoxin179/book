package com.xiaoxin.servlet;



import com.xiaoxin.bean.BorrowRecordView;
import com.xiaoxin.bean.Reader;
import com.xiaoxin.bean.Staff;
import com.xiaoxin.dao.*;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet( "/ServletLoginCheck")
public class ServletLoginCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String staff_username=request.getParameter("staff_username");
        String password=request.getParameter("password");
        String jueSe = request.getParameter("jueSe");
        System.out.println("登录页面用户选择的角色："+jueSe);
        StaffDao dao = new StaffDao();
        StaffRolesViewDao viewDao=new StaffRolesViewDao();
        ReaderDao readerDao=new ReaderDao();
        HttpSession sessions = request.getSession();
        try {
            Staff loginStaff = viewDao.getOne(staff_username);
            Reader loginReader = readerDao.getOneReader(staff_username);
            RolesDao rolesDao = new RolesDao();
//            储存工作人员列表
            sessions.setAttribute("RoleNameList", rolesDao.getAllRoles());
            System.out.println("查询所有的工作人员"+sessions.getAttribute("RoleNameList"));
            if (jueSe.equals("工作人员")) {
                if (loginStaff != null) {
                    String role=loginStaff.getRole();
                    if (password.equals(loginStaff.getPassword())) {
                        sessions.setAttribute("LOGININFO","用户的密码输入正确");
                        System.out.println("第一次存入session中的值LOGININFO:"+sessions.getAttribute("LOGININFO"));
                        System.out.println("登录用户的身份：" + role);
                        if (role.equals("人事部")) {
                            response.sendRedirect("StaffMangementIframe/main.html");
                            sessions.setAttribute("LOGINPERSON",loginStaff);
                        } else if (role.equals("图书管理员")) {
                            response.sendRedirect("experiment3/frame/BookMangement/main.html");
                            sessions.setAttribute("LOGINPERSON",loginStaff);
                            System.out.println("登录成功之后存储到session中的值LOGINPERSON:"+sessions.getAttribute("LOGINPERSON"));
                        }
                        else response.sendRedirect("404.html");
                    }else {
                        response.sendRedirect("login.html");
                        sessions.setAttribute("LOGININFO","密码错误");
                    }
                }else sessions.setAttribute("LOGININFO", "用户不存在");
            }else{
                if (loginReader != null) {
                    System.out.println("从数据库中查询到的用户信息：" + loginReader.toString());
                    if (password.equals(loginReader.getPassword())) {
                        sessions.setAttribute("LOGININFO", "读者的密码输入正确");
                        System.out.println("读者登录成功");
//                        储存借阅信息
                        BorrowReacordDao borrowReacordDao = new BorrowReacordDao();
                        ArrayList<BorrowRecordView> allRecord = borrowReacordDao.getAllRecord();
                        sessions.setAttribute("ReturnBook",allRecord);
                        System.out.println("登陆的时候直接存储ReturnBook" + sessions.getAttribute("ReturnBook"));
                        response.sendRedirect("ReaderIframe/main.html");
                        sessions.setAttribute("LOGINPERSON", loginReader);
                        System.out.println("存到session中的登录读者的用户信息"+sessions.getAttribute("LOGINPERSON"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
