<%@ page import="com.xiaoxin.bean.BookView" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: XIAOXIN
  Date: 2023/12/05 0005
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借书</title>
    <%
        ArrayList<BookView> books = (ArrayList<BookView>) session.getAttribute("BookList");
        System.out.println("session中存储的变量BookList:"+books);
    %>
    <div class="container">
        <table class="table table-bordered table-striped ">
            <thead class="table-dark">
            <tr>
                <th>编号</th>
                <th>书名</th>
                <th>分类</th>
                <th>内容</th>
                <th>房间</th>
                <th>书架</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <% int i=-1;
                for (BookView book_view : books) { i++;%>
            <tr>
                <td><%= book_view.getBook_id() %></td>
                <td><%= book_view.getBook_name()%></td>
                <td><%= book_view.getCategory_name() %></td>
                <td><%=book_view.getBook_content()%></td>
                <td><%=book_view.getRoom_number()%></td>
                <td><%=book_view.getBookshelf_id()%></td>
                <td style="width: 200px"><a href="../../../../BorrowBook?book_id=<%= book_view.getBook_id()%>">借书</a>   </td>
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
