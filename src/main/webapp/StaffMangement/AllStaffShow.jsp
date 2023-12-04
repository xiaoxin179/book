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
      <td style="width: 200px">
        <% if (sta.getStaff_isdelete().equals("0")) { %>
        <a href="../../../../StaffDeleteServlet?s_no=<%= sta.getStaff_id() %>&div=D" style="color: red">冻结</a>
        <% } else if (sta.getStaff_isdelete().equals("1")) { %>
        <a href="../../../../StaffDeleteServlet?s_no=<%= sta.getStaff_id() %>&div=J">解冻</a>
        <% } %>
        <a style="margin-left: 50px" href="StaffUpdate.jsp?n=<%= i %>" >修改</a>
      </td>
    </tr>
    <% } %>
    </tbody>
  </table>

  <script>
    let openBtn = document.getElementById('openBtn');
    let myDialog = document.getElementById('myDialog');
    let submitBtn = document.getElementById('submitBtn');
    let inputName = document.getElementById('inputName');

    openBtn.addEventListener('click', function() {
      myDialog.showModal();
    });
    let isSubmit=0;
    submitBtn.addEventListener('click', function() {
      isSubmit=0
      let value = inputName.value;
      getVale(value);
      myDialog.close();
      isSubmit=1;
      if(isSubmit===1) alert("用户信息修改成功！！！！")
    });


    inputName.addEventListener('keydown', function(event) {
      if (event.key === 'Enter') {
        event.preventDefault(); // 阻止默认的 Enter 键行为
        submitBtn.click(); // 模拟点击提交按钮
      }
    });

    function getVale(value) {
      console.log('输入的员工姓名是：', value);
    }
  </script>
</div>
<script src="../static/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../static/css/bootstrap.min.css">
<script src="../static/js/bootstrap.bundle.min.js"></script>

</body>
</html>