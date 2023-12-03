<%--
  Created by IntelliJ IDEA.
  User: XIAOXIN
  Date: 2023/11/26 0026
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作状态</title>
</head>
<body>
    <% String state = (String)session.getAttribute("State");%>
    <h3><%=state%></h3>
<script>
    alert("<%=state%>")
</script>
</body>
</html>
