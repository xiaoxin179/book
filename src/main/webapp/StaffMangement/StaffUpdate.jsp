<%@ page import="com.xiaoxin.bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.xiaoxin.bean.Staff" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

<%
  ArrayList stu_arraylist=(ArrayList)session.getAttribute("StaffList");

  String n1=request.getParameter("n");
  int n2=Integer.parseInt(n1);
  Staff stu=(Staff)stu_arraylist.get(n2);
%>

<form method="post" action="../../StaffUpdateServlet">
  <table border="1" bordercolor="blue" align="center">
    <tr>
      <td>学号：<input name="s_no" type="text" size="16" value="<%=stu.getStaff_id()%>" readonly="true"></td>
    </tr>
    <tr>
      <td>姓名：<input name="s_name" type="text" size="16" value="<%=stu.getS_name()%>" ></td>
    </tr>
    <tr>
      <td>年龄：<input name="s_age" type="text" size="16" value="<%=stu.getSa_age()%>"></td>
    </tr>
    <tr>
      <td>性别 <input name="s_sex" type="text" value="<%=stu.getS_ex()%>" >  </td>
    </tr>
    <tr>
      <td>系或学院：<input name="s_dept" type="text" size="16" value="<%=stu.getS_department()%>"></td>
    </tr>
    <tr>
      <td>密码：<input name="s_password" type="text" size="18" value="<%=stu.getS_password()%>"></td>
    </tr>
    <tr>
      <td><input type=submit value="提交"></td>
    </tr>
  </table>
</form>
</body>
</html>
