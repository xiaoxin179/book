<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">

    <title>工作人员登录</title>
    <script src="./static/js/jquery-3.6.0.min.js"></script>
    <script>
        $(function() {
            $('#password').focus(function() {
                // 密码框获得焦点，追加样式.password
                $('#owl').addClass('password');
            }).blur(function() {
                // 密码框失去焦点，移除样式.password
                $('#owl').removeClass('password');
            });
        });
    </script>
</head>


<script>
    function gotoLogin() {
        window.location.href = "./login.html";
    }
    gotoLogin()
</script>
</html>