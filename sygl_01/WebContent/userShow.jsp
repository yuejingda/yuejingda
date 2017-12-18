<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	<script type="text/javascript">
		window.onload = function(){
			var trs = document.getElementsByTagName("tr");
			for(var i=1;i<trs.length;i++){
				if(i%2==0){
					trs[i].style.background="#cfc";
				}
			}
			var all = document.getElementById("all");
			all.onclick = function(){
				var inputs = document.getElementsByTagName("input");
				for(var i=0;i<inputs.length;i++){
					var input = inputs[i];
					if(input.name == "uno"){
						input.checked = all.checked;
					}
				}	
			}
		}
		function toDelete(uno){
			var f = confirm("是否确认删除");
			if(!f)return;
			location = "userDelete.do?uno="+uno;
		}
		function userBatchDelete(){
			var nos = document.getElementsByName("unos");
			for(var i=0;i<nos.length;i++){
				if(nos[i].checked == true){
					var f = confirm("是否确认删除");
					if(!f)return;
					var deleteForm = document.getElementById("deleteForm");
					deleteForm.submit();
					return ;
				}
			}
			alert("请选择删除的记录");
		}
	</script>
	</head>
	<body>
		<h3 align="center">用户列表</h3>
		<p align="center">
			<a href="userAdd.jsp">用户创建</a>
			<a href="javascript:userBatchDelete()">批量删除</a>
		</p>
		<form id="deleteForm" action="userBatchDelete.do" method="post">
		 <table align="center" border="2" cellspacing="0" width="80%">
		 	<thead>
		 		<tr>
		 			<th><input type="checkbox" id="all"/></th>
		 			<th>用户编号</th>
		 			<th>用户名称</th>
		 			<th>用户真实姓名</th>
		 			<th>用户状态</th>
		 			<th>操作</th>
		 		</tr>
		 	</thead>
		 	<tbody>
		 		<c:choose>
		 			<c:when test="${users==null or users.size()==0 }">
		 				<tr align="center">
		 					<th colspan="6">没有任何记录</th>
		 				</tr>
		 			</c:when>
		 			<c:otherwise>
		 				<c:forEach items="${users}" var="user">
		 					<tr>
		 						<th><input type="checkbox" name="unos" value="${user.uno}"/></th>
		 						<th>${user.uno }</th>
		 						<th>${user.uname }</th>
		 						<th>${user.truename}</th>
		 						<th>${user.flag=='1'?"<font color='green'>启用</font>":"<font color='red'>禁用</font>" }</th>
		 						<th><a href="userEdit.do?uno=${user.uno}">编辑</a>|
		 							<a href="javaScript:toDelete(${user.uno})">删除</a>|
		 							<a href="setRole.jsp?uno=${user.uno }">设置角色</a>
		 						</th>
		 					</tr>
		 				</c:forEach>
		 			</c:otherwise>
		 		</c:choose>
		 	</tbody>
		 </table>
		</form>
		<form action="userUpload.do" method="post" enctype="multipart/form-data">
			<input type="file" name="files" />
			<input type="submit" value="导入excel">
			<a href="userExport.do">导出excel</a>
		</form>
	</body>
</html>
