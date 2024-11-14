<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.5.1.min.js"></script>
</head>
<body>
	<div class="page">
		<div class="loginwarrp">
			<div class="logo">用户登陆</div>
			<div class="login_form">
				<form id="Login" name="Login" method="post" onsubmit="return login()" action="${pageContext.request.contextPath }/login/doLogin.do">
					<ul>
						<li class="login-item"><span>用户名：</span>
						 	<input type="text"	id="username" name="username" class="login_input">
						 </li>
						<li class="login-item"><span>密 码：</span>
							 <input	type="password" id="password" name="password" class="login_input">
						</li>
						<span style="color:red">${msg }</span>
						<li class="login-sub"><input type="submit" name="Submit"
							value="登录" /> <input type="reset" name="Reset" value="重置" /></li>
					</ul>
				</form>
			</div>
		</div>
	</div>
<script type="text/javascript">
/**
 * 校验用户名和密码是否为空
 */
	function login(){
		var name = $("#username").val();
		var password = $("#password").val();
		if(name==undefined || name.trim()==""){
			alert("请输入用户名！");
			return false;
		}
		if(password==undefined || password.trim()==""){
			alert("请输入密码！");
			return false;
		}
		return true;
	}
</script>
</body>
</html>