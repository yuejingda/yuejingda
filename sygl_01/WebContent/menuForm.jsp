<%@ page pageEncoding="utf-8"%>
<style>
	#menuForm li{margin:40px}
</style>


<script type="text/javascript">
		$(function(){
			$("#mname").textbox({
				prompt:"菜单名称",
				required:true,
				height:40
			});
			$("#href").textbox({
				prompt:"URL",
				required:true,
				height:40
			});
			$("#pname").textbox({
				height:40,
				editable:false
				
			});
		});


	
</script>

<form id="menuForm" action="saveMenu.do" mothed="post">
	<ul>
		<li><input id="mname" name="mname"/></li>
		<li><input id="href" name="href"/></li>
		<li><input id="pname" ><input type="hidden" id="pno" name="pno"/></li>
	</ul>
</form>