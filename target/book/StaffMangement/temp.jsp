<%--
  Created by IntelliJ IDEA.
  User: XIAOXIN
  Date: 2023/11/26 0026
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <title>Title</title>
  <form action="../../../../GetAllStaffServlet" method="post">
      <button type="submit" id="submitButton">查看全部员工信息</button>
  </form>
</head>
<body>
<script>
    window.onload = function() {
        document.getElementById("submitButton").click();
    };
</script>
</body>
</html>
