<%@ page pageEncoding="utf-8"%>
<style>
	li{margin:40px};
	span{
		position:absolute;
		padding-left:8px;
		color:red;
		font-size:14px;
	}
		
</style>

<script type="text/javascript">
	$(function(){
		$.post("obtainUpss.do",{},function(upass){
			var form = document.getElemenById("pwdForm");
			var f = true;
			var oldPass = document.getElementById("oldPass");
			var newPass = document.getElementById("newPass");
			var reNewPass = document.getElemengtById("reNewPass");
			form.onsubmit(){
				if(oldPass.value != upass){
					 oldPass.nextElementSibling.innerHTML = "输入密码与原密码不相等";
					f = false;
				}else{
					oldPass.nextElementSibling.innerHTML = "";
				}
				if(newPass.value != reNewPass.value){
					 reNewPass.nextElementSibling.innerHTML = "输入密码与原密码不相等";
				}else{
					reNewPass.nextElementSibling.innerHTML = "";
				}
				return f;
			}
			
			
		});
		$("#oldPass").passwordbox({
			required:true,
			height:40,
			showEye:true,
			prompt:"原密码"
		});
		$("#newPass").passwordbox({
			required:true,
			height:40,
			showEye:true,
			prompt:"新密码"
		});
		$("#reNewPass").passwordbox({
			required:true,
			height:40,
			showEye:true,
			prompt:"确认密码"
		});
	});
</script>
<form id="pwdForm" action="updatePass.do" method="post">
	<ul>
		<li><input id="oldPass"/><span></span></li>
		<li><input id="newPass" name="newPass"/></li>
		<li><input id="reNewPass" /><span></span></li>
	</ul>
</form>