<%@ page pageEncoding="utf-8"%>
<html>
	<head>
	<style type="text/css">
		span{
		position:absolute;
				padding-left:8px;
				color:red;
				font-size:14px;
		}
	</style>
	<script type="text/javascript">
		window.onload = function(){
			var form = document.getElementById("roleForm");
			var f = true;
			var rname = document.getElementById("rname");
			var rms = document.getElementById("rms");
			form.onsubmit = function(){
				
				if(rname.value==""){
					rname.nextElementSibling.innerHTML = "角色名称不能为空";
					f = false;
				}else{
					rname.nextElementSibling.innerHTML = "";
				}
				
				var reg = /.+/ig;
				if(!reg.test(rms.value)){
					rms.nextElementSibling.innerHTML = "角色数量不能为空";
				}else{
					rms.nextElementSibling.innerHTML ="";
				}
			}
		}
	</script>
	</head>
	<body>
		<h3 align="center">新建角色</h3>
		<form action="roleRequestSave.jsp" method="post" id="roleForm">
			<table  align="center"  >
				<tr align="center">
					<td>角色名称</td>
					<td><input type="text" name="rname" id="rname" /><span></span></td>
				</tr>
				<tr align="center">
					<td>角色描述</td>
					<td><input type="text" name="rms" id="rms" /><span></span></td>
				</tr>
				<tr align="center">
					<th colspan="2"><input type="submit"/></th>
				</tr>
			</table>
		</form>
	</body>
</html>