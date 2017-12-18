<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>
<%@ include file="common.jsp" %>
<style>
	#logoutBtn{
		position:absolute;
		right:10px;
	}
</style>
<script type="text/javascript">

	$(function(){
		$("#logoutBtn").linkbutton({
			width:40,
			height:30,
			onClick:function(){
				$.messager.confirm("提示","是否确认注销",function(f){
					if(f){
						window.open("logout.do","_parent");
						return;
					}
				});
			}
		});
		
		$("#updateBtn").linkbutton({
			width:60,
			height:20,
			onClick:function(){
				window.open("updatePassword.jsp","right")
			}
		});
	})

</script>


<div style='margin-top:60px;margin-left:30px'>
       <p>欢迎【${sessionScope.user.truename }】 <a id="logoutBtn">注销</a><a id="updateBtn">修改密码</a></p>
</div>
<div id="updateWindow"></div>
