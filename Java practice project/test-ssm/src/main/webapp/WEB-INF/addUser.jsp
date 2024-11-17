<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示页面</title>
    <link rel="stylesheet" href="https://cdn.staticfile.net/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.net/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.net/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>



<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/user/addUser1" method="post">
    <%--需要提交信息的input表单的name需要与实体类一一对应--%>
    <div class="form-group">
        <label  class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control"
                   placeholder="用户名" name="name">
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-2 control-label">手机号</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="phone"
                   placeholder="手机号">
        </div>
    </div>

     <div class="form-group">
        <label  class="col-sm-2 control-label">登录名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="loginName"
                   placeholder="登录名">
        </div>
     </div>

     <div class="form-group">
        <label  class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="loginPwd"
                   placeholder="密码">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">添加</button>
        </div>
    </div>
</form>
</body>
</html>
