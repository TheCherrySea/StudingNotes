<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>银行账户信息管理</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
</head>
<body>
<div style="margin:auto;width:70%">
<h2 style="text-align:center;">银行账户信息管理系统</h2>
	<fieldset>
	<legend>搜索</legend>
	<form action="${pageContext.request.contextPath }/getList.do" method="post" id="dataFrm">
		<input type="hidden" name="pageNumber" value=""  id="pageNumber"/> 
		<input type="hidden" name="pageSize"  id="pageSize"  value="5"/> 
		
		姓名：<input type="text" name="name" value="${ac.name }"/> &nbsp;
		性别：<input type="radio" name="sex" value="1"  ${ac.sex=='1'?checked:'' }/>女 &nbsp;
		<input type="radio" name="sex" value="2"  ${ac.sex=='2'?checked:'' }/>男&nbsp;
		账户类别：
		<select name="typeId">
			<option value="">请选择账户类别：</option>
			<option value="1">一类户</option>
			<option value="2">二类户</option>
			<option value="3">VIP户</option>
		</select>
		<input type="submit" value="搜索"  />&nbsp;
		<input type="button" value="批量删除"  id="batchDel"/>
	</form>
	</fieldset>
<hr/>
<div style="margin:auto;width:100%">
<table border="1" width="100%" >
	<tr style="background-color:gray">
		<th width="8%">全选<input type="checkbox"  id="chkAll"/></th>
		<th width="8%">序号</th>
		<th width="14%">姓名</th>
		<th width="30%">卡号</th>
		<th width="10%">余额</th>
		<th width="5%">性别</th>
		<th width="24%">操作</th>
	</tr>
	<form action="${pageContext.request.contextPath }/batchDelet.do"  method="post"  id="batchFrm">
	<c:forEach items="${accountList}" var="info" varStatus="stat">
	<tr>
		<td><input type="checkbox" name="allTr" value="${info.id }"/></td>
		<td>${stat.index+1 }</td>
		<td>${info.name }</td>
		<td>${info.number }</td>
		<td>${info.money }</td>
		<td>${info.sexStr }</td>
		<td><a  href="#" onclick="del('${info.id}')">删除</a>&nbsp;&nbsp;<a href="">修改</a></td>
	</tr>
	</c:forEach>
	</form>
	<tr>
		<td></td>
		<td><a href="${pageContext.request.contextPath }/toAdd.do">新增</a></td>
		<td colspan="4">共计${pager.total }条数据&nbsp;共${pager.totalPage }页
		<c:if test="${pager.pageNumber!=1 }">
			<a href="#"  onclick="select(1);">首页</a>&nbsp;
			<a href="#"  onclick="select(${pager.pageNumber-1});">上一页</a>&nbsp;
		</c:if>
			<c:forEach begin="${pager.startPage }" end="${pager.endPage }" var="i">
				<c:if test="${pager.pageNumber==i }">
					${i }&nbsp;
				</c:if>
				<c:if test="${pager.pageNumber!=i }">
					<a href="#"   onclick="select(${i});">${i }</a>&nbsp;
				</c:if>
			</c:forEach>
			
			<c:if test="${pager.pageNumber!=pager.totalPage }">
					<a href="#" onclick="select(${pager.pageNumber+1});">下一页</a>&nbsp;
					<a href="#" onclick="select(${pager.totalPage});">尾页</a>
			</c:if>
	
		</td>
	</tr>
</table>
</div>
<hr>
</div>
<script type="text/javascript">
function del(id){
	if(confirm("确定要删除吗？")){
		location.href="delAccount/"+id;
	}
}
//提交搜索表单，完成分页查询
function select(pageNum){
	$("#pageNumber").val(pageNum);//给隐藏域赋值
	$("#dataFrm").submit();//提交表单
}
//给全选框添加单击事件，实现全选和反选
$("#chkAll").click(function (){
	if(this.checked){//全选复选框为勾选状态
		//设置所有name属性为allTr的input元素的checked属性为选中
		$("input[name=allTr]").prop("checked",true);
	}else{
		//设置所有name属性为allTr的input元素的checked属性为不选选中
		$("input[name=allTr]").prop("checked",false);
	}
});
//给批量删除按钮添加单击事件,完成提交到后端的批量删除
$("#batchDel").click(function (){
	var deleteIds = [];
	//循环遍历表格里所有勾选的复选框
	$("input[name=allTr]:checked").each(function(){
		deleteIds.push($(this).val());
	});
	if(deleteIds==null || deleteIds.length<=0){
		alert("请先选择您要删除的数据！");
	}else{
		if(window.confirm("您确定要删除选择的数据吗？")){
			$("#batchFrm").submit();
		}
	}
});
</script>
</body>
</html>