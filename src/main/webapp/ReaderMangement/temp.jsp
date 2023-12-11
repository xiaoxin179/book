<%--
  Created by IntelliJ IDEA.
  User: XIAOXIN
  Date: 2023/12/05 0005
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读者端</title>
</head>
<body>
<form action="../../../../GetAllServlet" method="post" id="myForm" class="mar" style="justify-content: center; align-items: center; height: 100vh;">
    <div style="display: flex; align-items: center;">
        <input type="text" name="book_name" placeholder="输入书籍名称" style="padding: 5px; border: 1px solid #ccc; border-radius: 4px; margin-right: 10px;">
        <button type="submit" id="submitButton" style="padding: 10px 20px; background-color: #4CAF50; border: none; color: white; border-radius: 4px; cursor: pointer;">
            查询
        </button>
    </div>
</form>
</body>
<script>
    // window.onload = function() {
    //     document.getElementById("submitButton").click();
    // };
</script>
<script src="../static/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../static/css/bootstrap.min.css">
<script src="../static/js/bootstrap.bundle.min.js"></script>
<style>
    .mar{
        margin:30px auto;
    }
</style>
</html>
