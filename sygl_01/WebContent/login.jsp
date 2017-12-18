<%@ page pageEncoding="utf-8" %>
<html>
	<head>
		<title>登录界面</title>
		<style type="text/css">
	#loginBox{
				width:300px;
				height:220px;
				broder:2px solid #ccc;
				background:#cfc;
				margin:0 auto;
				margin-top:100px;
			}
			#btn{
				height:30px;
			}
			#loginBox tr{
				height:40px;
				line-heigt:40px;
			}
		</style>
	</head>
	<body>
		<div align="center" id="loginBox">
			<h2 align="center">用户登录</h2>
			<form action="login.do" method="post" id="form">
				<table align="center">
					<tr>
						<td>用户名:</td>
						<td><input type="text" name="uname"/></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type="password" name="upass"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center" id="btn"><input type="submit"/></td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>