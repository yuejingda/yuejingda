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
					if(input.name == "rnos"){
						input.checked = all.checked;
					}
				}	
			}
		}
		function toDelete(rno){
			var f = confirm("是否确认删除");
			if(!f)return;
			location = "roleDelete.do?rno="+rno;
		}
		function roleBatchDelete(){
			var nos = document.getElementsByName("rnos");
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
		<h3 align="center">角色列表</h3>
		<p align="center">
			<a href="roleAdd.jsp">角色新建</a>
			<a href="javascript:roleBatchDelete()">批量删除</a>
		</p>
		<form id="deleteForm" action="roleBatchDelete.do" method="post">
		 <table align="center" border="2" cellspacing="0" width="80%">
		 	<thead>
		 		<tr>
		 			<th><input type="checkbox" id="all"/></th>
		 			<th>角色编号</th>
		 			<th>角色名称</th>
		 			<th>角色描述</th>
		 			<th>操作</th>
		 		</tr>
		 	</thead>
		 	<tbody>
		 		<c:choose>
		 			<c:when test="${roles==null or roles.size()==0 }">
		 				<tr align="center">
		 					<th colspan="5">没有任何记录</th>
		 				</tr>
		 			</c:when>
		 			<c:otherwise>
		 				<c:forEach items="${roles}" var="role">
		 					<tr>
		 						<th><input type="checkbox" name="rnos" value="${role.rno }"/></th>
		 						<th>${role.rno }</th>
		 						<th>${role.rname }</th>
		 						<th>${role.rms}</th>
		 						<th><a href="roleEdit.do?rno=${role.rno}">编辑</a>|
		 							<a href="javaScript:toDelete(${role.rno})">删除</a>|
		 							<a href="setMenus.jsp?rno=${role.rno }">设置权限</a>
		 						</th>
		 					</tr>
		 				</c:forEach>
		 			</c:otherwise>
		 		</c:choose>
		 	</tbody>
		 </table>
		</form>
		<!-- 
		<form action="roleUpload.do" method="post" enctype="multipart/form-data">
			<input type="file" name="file" />
			<input type="submit" value="导入excel">
			<a href="roleExport.do">导出excel</a>
		</form>
		 -->
	</body>
</html>