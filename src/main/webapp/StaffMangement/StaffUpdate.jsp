<%@ page import="java.util.ArrayList" %>
<%@ page import="com.xiaoxin.bean.Staff" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>修改员工信息</title>
</head>
<body>
<%
  ArrayList stu_arraylist=(ArrayList)session.getAttribute("StaffList");

  String n1=request.getParameter("n");
  int n2=Integer.parseInt(n1);
  Staff stu=(Staff)stu_arraylist.get(n2);
%>

<div class="container mt-5">
  <form method="post" action="../../../../StaffUpdateServlet">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-body">
            <div class="mb-3">
              <label for="staff_no" class="form-label">学号：</label>
              <input id="staff_no" name="staff_no" type="text" class="form-control" value="<%=stu.getStaff_id()%>" readonly="true">
            </div>
            <div class="mb-3">
              <label for="staff_username" class="form-label">用户名：</label>
              <input id="staff_username" name="staff_username" type="text" class="form-control" value="<%=stu.getStaff_username()%>" readonly="true">
            </div>
            <div class="mb-3">
              <label for="staff_name" class="form-label">姓名：</label>
              <input id="staff_name" name="staff_name" type="text" class="form-control" value="<%=stu.getStaff_name()%>">
            </div>
            <div class="mb-3">
              <label for="password" class="form-label">密码：</label>
              <input id="password" name="password" type="text" class="form-control" value="<%=stu.getPassword()%>">
            </div>
            <div class="d-grid" style="float: right">
              <input type="submit" value="提交" class="btn btn-primary" style="width: 500px">
            </div>
          </div>
        </div>
      </div>
    </div>
  </form>
</div>

<!-- 引入 Bootstrap JS -->
<script src="../static/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../static/css/bootstrap.min.css">
<script src="../static/js/bootstrap.bundle.min.js"></script>
</body>
</html>