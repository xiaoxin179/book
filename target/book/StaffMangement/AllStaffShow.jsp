<%@ page import="java.util.ArrayList" %>
<%@ page import="com.xiaoxin.bean.Staff" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>学生信息查询</title>
</head>
<body bgcolor="CCCFFF">

<br> <br> <br> <br> <br>
<%
  ArrayList<Staff> staffs = (ArrayList<Staff>) session.getAttribute("StaffList");
  System.out.println("session中存储的变量StaffList:"+staffs);
%>
<div class="container">
  <table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
      <th>工号</th>
      <th>用户名</th>
      <th>姓名</th>
      <th>职位</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <% int i=-1;
      for (Staff sta : staffs) { i++;%>
    <tr>
      <td><%= sta.getStaff_id() %></td>
      <td><%= sta.getStaff_username() %></td>
      <td><%= sta.getStaff_name() %></td>
      <td><%= sta.getRole() %></td>
      <td style="width: 200px"><a href="../../StaffDeleteServlet?s_no=<%= sta.getStaff_id()%>">删除</a>   <a style="margin-left: 50px" href="StaffUpdate.jsp?n=<%=i%>">修改</a></td>
    </tr>
    <% } %>
    </tbody>
  </table>
</div>
<script src="../static/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../static/css/bootstrap.min.css">
<script src="../static/js/bootstrap.bundle.min.js"></script>

</body>
</html>