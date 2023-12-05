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
<form action="../../../../GetAllServlet" method="post" id="myForm">
    <button type="submit" id="submitButton">
        查看所有书籍
    </button>
</form>
</body>
<script>
    window.onload = function() {
        document.getElementById("submitButton").click();
    };
</script>
</html>
