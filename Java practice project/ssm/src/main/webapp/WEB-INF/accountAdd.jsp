<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增银行账户信息</title>
	<style type="text/css">
			div{
				border: 1px saddlebrown gray;
			}
			.wrap{
				width: 40%;
				margin: 20vh auto;
			}
			.title{
				font-size: 25px;
				font-weight: bolder;
				text-align: center;
			}
			.lableName{
				width: 30%;
				text-align: center;
			}
			td>input{
				width: 70%;
				height: 24px;
				line-height: 24px;
				border: 1px solid gray;
			}
			table{
				width: 100%;
			}
			.btn{
				width: 30%;
			}
			.btn_container{
				margin: 0 auto;
				text-align: center;
			}
			.type{
				width: 20%;
			}
		</style>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.5.1.min.js"></script>
</head>
<body>

<div class="wrap">
	<form action="${pageContext.request.contextPath }/addAccount.do" method="post" id="addFrm" enctype="multipart/form-data">
		<div class="infoDiv">
			<div class="title">
				添加信息
			</div>
			<table border="1" cellspacing="0" cellpadding="0"  id="infoTable">
					<tr>
						<td class="lableName">姓名：</td>
						<td>
							<input type="text" name="name" id="" value="" />
						</td>
					</tr>
					<tr>
						<td class="lableName">卡号：</td>
						<td>
							<input type="text" name="number" id="" value="" />
						</td>
					</tr>
					<tr>
						<td class="lableName">存钱：</td>
						<td>
							<input type="text" name="money" id="" value="" />
						</td>
					</tr>
					<tr>
						<td class="lableName">性别：</td>
						<td>
							<input type="radio" name="sex" id="" value="" />女 &nbsp;<input type="radio" name="sex" id="" value="" />男
						</td>
					</tr>
					<tr>
						<td class="lableName">开户类型：</td>
						<td>
							<select name="typeId">
								<option value="-1">请选择：</option>
								<option value="1">一类户</option>
								<option value="2">二类户</option>
								<option value="3">VIP户</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="lableName">卡片效果图：</td>
						<td>
							<input type="file" name="myfile" id="" value="" />
						</td>
					</tr>
				</table>
		</div>
		
		<div class="btn_container">
			<input class="btn" type="submit" value="添加"/>
			<input class="btn" type="reset" value="重置"/>
		</div>
		
	</form>
</div>
</body>
</html>