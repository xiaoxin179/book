<%--
  Created by IntelliJ IDEA.
  User: XIAOXIN
  Date: 2023/12/05 0005
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>中转跳转</title>
</head>
<body>
<form id="myForm" action="../../../../ReturnBook" method="post">
  <button type="submit" id="submitButton">
    查看所有我的借阅信息
  </button>
</form>

<script>
  window.onload = function() {
    document.getElementById("submitButton").click();
  };
</script>
</body>
</html>
