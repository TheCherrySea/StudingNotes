<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 27449
  Date: 2024/11/14
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示页面</title>
    <link rel="stylesheet" href="https://cdn.staticfile.net/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.net/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.net/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h3>
    <a href="${pageContext.request.contextPath}/user/allUser">展示用户页面</a>

</h3>
<form action="${pageContext.request.contextPath}/user/queryUser" method="post">
    <input type="text" name="queryName" placeholder="输入要查询的用户信息">
    <input type="submit" value="查询" class="btn btn-default">
</form>
<div class="row">
    <div class="col-md-4 colum">
        <a href="${pageContext.request.contextPath}/user/addUserPage">新增用户</a>

    </div>
</div>
<table class="table table-striped">
    <caption>展示用户信息</caption>
    <thead>
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>手机号</th>
        <th>登录名</th>
        <th>密码</th>
        <th>操作</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.phone}</td>
            <td>${user.loginName}</td>
            <td>${user.loginPwd}</td>
            <td>
                <a href="${pageContext.request.contextPath}/user/toUpdate?id=${user.id}">修改</a>&nbsp;|&nbsp;
                <a href="${pageContext.request.contextPath}/user/deleteUser/${user.id}">删除</a>
            </td>
        </tr>

    </c:forEach>


    </tbody>
</table>

</body>
</html>
