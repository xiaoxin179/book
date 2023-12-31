<%@ page import="com.xiaoxin.bean.BookView" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.xiaoxin.bean.BorrowRecordView" %><%--
  Created by IntelliJ IDEA.
  User: XIAOXIN
  Date: 2023/12/05 0005
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>还书</title>
    <%
        ArrayList<BorrowRecordView> books = (ArrayList<BorrowRecordView>) session.getAttribute("ReturnBook");
        System.out.println("ReturnBook:"+books);
    %>
    <div class="container">
        <table class="table table-bordered table-striped" style="width: 1000px">
            <thead class="table-dark">
            <tr>
                <th>借阅记录编号</th>
                <th>书籍名</th>
                <th>借阅者</th>
                <th>最晚归还时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <% int i=-1;
                for (BorrowRecordView book_view : books) { i++;%>
            <tr>
                <td><%=book_view.getRecord_id()%></td>
                <td><%= book_view.getBook_name() %></td>
                <td><%=book_view.getUsername()%></td>
                <td><%=book_view.getReturn_time()%></td>

                <td style="width: 200px"><a href="../../../../ReturnBookServlet?record_id=<%= book_view.getRecord_id()%>">还书</a>   </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</head>
<body>
<script src="../static/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../static/css/bootstrap.min.css">
<script src="../static/js/bootstrap.bundle.min.js"></script>
</body>
</html>
