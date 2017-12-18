<%@ page pageEncoding="utf-8" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<style>
			span{
				position:absolute;
				padding-left:8px;
				color:red;
				font-size:14px;
			}
		</style>
		<script type="text/javascript">
			window.onload = function(){
				var form = document.getElementById("userForm");
				 var f = true;
				 
				 var uname = document.getElementById("uname");
				 var unpass = document.getElementById("upass");
				 var truename = document.getElementById("truename");
				 form.onsubmit = function(){
					 //表单验证
					 if(uname.value == ""){
						 uname.nextElementSibling.innerHTML = "用户名不能为空";
						 f = false;
					 }else{
						 uname.nextElementSibling.innerHTML = "";
					 }
					 var reg= /^\d{3,8}$/ig;
					 if(!reg.test(upass.value)){
						 upass.nextElementSibling.innerHTML="密码长度不符";
						 f = false;
					 }else{
						 upass.nextElementSibling.innerHTML=""; 
					 }
					 var reg=/.+/ig;
					 if(!reg.test(truename.value)){
						 truename.nextElementSibling.innerHTML="用户名必填";
						 f=false;
					 }else{
						 truename.nextElementSibling.innerHTML="";
					 }
					 return f;
				 }
			}
		</script>
	</head>
	<body>
		<h3  align="center">新建用户列表</h3>
		<form id="userForm" action="userUpdate.do" method="post">
			<table align="center">
				<tr>
					<td>用户编号</td>
					<td><input type="text" name="uno" value="${user.uno }" id="uno" readonly="readonly"/><span></span></td>
				</tr>
				<tr>
					<td>用户名</td>
					<td><input type="text"  name="uname" value="${user.uname }" id="uname"/><span></span></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password"  name="upass" value="${user.upass}" id="upass" readonly="readonly"/><span></span></td>
				</tr>
				<tr>
					<td>真实姓名</td>
					<td><input type="text"  name="truename" value="${user.truename }" id="truename"/><span></span></td>
				</tr>
				<tr>
					<td>用户状态</td>
					<c:choose>
						<c:when test="${user.flag ==1 }">
						<td>
						<input type="radio"  name="flag" value="1" checked="checked"/>启用
						<input type="radio" name="flag" value="2"/>禁用
						</td>
						</c:when>
						<c:otherwise>
							<td>
							<input type="radio"  name="flag" value="1" />启用
							<input type="radio" name="flag" value="2" checked="checked"/>禁用
							</td>
						</c:otherwise>
					</c:choose>
					
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>