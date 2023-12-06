<%@ page import="com.xiaoxin.bean.Staff" %>
<%@ page import="com.xiaoxin.bean.Reader" %><%--
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
    <% Reader reader;
        reader = (Reader) session.getAttribute("LOGINPERSON");
    %>
    <div class="container" style="margin:30px auto;border-radius: 8px;height: 700px;align-items: center;display:flex;justify-content: center">
        <form style="margin:30px auto" action="../../../../ReaderUpdateThemselfServlet">
            <div class="mb-3">
                <label for="staffId" class="form-label">读者用户名</label>
                <input type="text" class="form-control width" id="staffId" readonly value="<%=reader.getUsername()  %> " name="username" >
            </div>
            <div class="mb-3">
                <label for="staffUsername" class="form-label">姓名</label>
                <input type="text" class="form-control width" id="staffUsername"  value="<%=reader.getName()%>" name="name">
            </div>
            <div class="mb-3">
                <label for="staffName" class="form-label">密码</label>
                <input type="text" class="form-control width" id="staffName"  value="<%=reader.getPassword()%>" name="password">
            </div>
            <div class="mb-3">
                <label for="role" class="form-label">邮箱</label>
                <input type="text" class="form-control width" id="role"  value="<%=reader.getReaderEmail()%>" name="reader_email">
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
