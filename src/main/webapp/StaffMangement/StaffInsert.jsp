<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <script src="../static/js/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="../static/css/bootstrap.min.css">
    <script src="../static/js/bootstrap.bundle.min.js"></script>
    <title>添加员工</title>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    body{
        height: 100vh;
        overflow: hidden;
    }
    .wave{
        /* 弹性布局 */
        display: flex;
        /* 设置投影 */
        filter: drop-shadow(120px 0 0 rgba(149,191,218,0.5));
        position: absolute;
        bottom: 0;
    }
    .wave div{
        position: relative;
        width: 40px;
        height: 200px;
        margin: 10px;
        border-radius: 3px;
        overflow: hidden;
    }
    .wave div::before{
        content: "";
        width: 300%;
        height: 100%;
        background-color: rgba(149,191,218,1);
        position: absolute;
        left: -100%;
        top: 50%;
        /* 执行动画：动画名 时长 贝塞尔曲线 无限播放 来回轮流播放 */
        animation: upDown 2s cubic-bezier(0.445, 0.05, 0.55, 0.95) infinite alternate, wave 2s cubic-bezier(0.445, 0.05, 0.55, 0.95) infinite alternate;
        /* 通过var函数调用自定义属性--d1、--d2，设置动画延迟 */
        animation-delay: var(--d1), var(--d2);
    }

    /* 定义动画 */
    @keyframes upDown {
        0%{
            top: 70%;
        }
        100%{
            top: 30%;
        }
    }
    @keyframes wave {
        0%{
            transform: rotateZ(-20deg);
        }
        100%{
            transform: rotateZ(20deg);
        }
    }
</style>
<body>
<div style="color:white;width: 600px;margin:25px auto ;border-radius: 5px">
    <div class="card">
        <div class="card-body" style="width: 600px;">
            <div class="container">
                <h1 style="color: black;font-weight: bolder;text-align: center">新增员工</h1>
                <form action="../../../../StaffInsertServlet" method="post">
                    <div class="form-group">
                        <label for="name">姓名</label>
                        <input type="text" class="form-control" id="name" name="staff_name" placeholder="请输入姓名">
                    </div>
                    <div class="form-group">
                        <label>用户名</label>
                        <input type="text" class="form-control" id="staff_username" name="staff_username" placeholder="输入员工用户名">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                    </div>
                    <div class="form-group">
                        <label for="password">职称</label>
                        <select class="form-control" id="s_department" name="role">
                            <%-- 从 session 中获取职称数组 --%>
                            <% ArrayList<String> roleNameList = (ArrayList<String>) session.getAttribute("RoleNameList"); %>
                            <% for (String roleName : roleNameList) { %>
                            <option value="<%= roleName %>"><%= roleName %></option>
                            <% } %>
                        </select>
                    </div>
                    <div style="display: flex;justify-content: space-between">
                        <button type="reset" class="btn btn-secondary">重置</button>
                        <button type="submit" class="btn btn-primary" id="sub">添加</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>

</html></html>