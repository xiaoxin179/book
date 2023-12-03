<%@ page import="com.xiaoxin.bean.Staff" %><%--
  Created by IntelliJ IDEA.
  User: XIAOXIN
  Date: 2023/11/26 0026
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<script src="../static/js/bootstrap.bundle.min.js"></script>
<script src="../static/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../static/css/bootstrap.min.css">
<head>
<% Staff staff;
  staff = (Staff) session.getAttribute("LOGINPERSON");
%>
  <div class="container" style="margin:30px auto;border-radius: 8px;height: 700px;align-items: center;display:flex;justify-content: center">
    <form style="margin:30px auto" action="../../../../StaffUpdateServlet">
      <div class="mb-3">
        <label for="staffId" class="form-label">工作人员编号</label>
        <input type="text" class="form-control width" id="staffId" readonly value="<%=staff.getStaff_id()  %> " name="staff_id" >
      </div>
      <div class="mb-3">
        <label for="staffUsername" class="form-label">用户名</label>
        <input type="text" class="form-control width" id="staffUsername" readonly value="<%=staff.getStaff_username()%>" name="staff_username">
      </div>
      <div class="mb-3">
        <label for="staffName" class="form-label">姓名</label>
        <input type="text" class="form-control width" id="staffName"  value="<%=staff.getStaff_name()%>" name="staff_name">
      </div>
      <div class="mb-3">
        <label for="role" class="form-label">职位</label>
        <input type="text" class="form-control width" id="role" readonly value="<%=staff.getRole()%>" name="role">
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">密码</label>
        <input type="password" class="form-control width" id="password"  value="<%=staff.getPassword()%>" name="password">
      </div>
      <button type="submit" class="btn btn-primary width" style="margin-top:30px">提交</button>
    </form>
  </div>
</head>
<style>
  .width{
    width: 600px;
  }
</style>
<body>


</body>
</html>
