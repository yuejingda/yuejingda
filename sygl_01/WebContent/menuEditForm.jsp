<%@ page pageEncoding="utf-8"%>
<style>
	#menuEditForm li{margin:40px}
</style>

<script type="text/javascript">
		$(function(){
			$("#mname").textbox({
				required:true,
				height:40
			});
			$("#href").textbox({
				required:true,
				height:40
			});
			$("#pname").textbox({
				height:40,
				editable:false
				
			});
		});


	
</script>

<form id="menuEditForm" action="updateMenu.do" mothed="post">
	<ul>
		<li><input id="mname" name="mname"/><input id="mno" name="mno" type="hidden"/></li>
		<li><input id="href" name="href"/><input type="hidden" id="pno" name="pno"/></li>
	</ul>
</form>