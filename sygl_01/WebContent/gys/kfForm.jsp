<%@ page pageEncoding="utf-8"%>
<style>
    #kfForm tr{
    	height:14px;
    	font-size:12px
    }
</style>
<script type="text/javascript">
		$(function(){
			$("#kfmc,#kfdz").textbox({
				required:true,
				height:40
			});
			
		});
</script>


<div style="padding-top:15px">
<form action="go_saveKf_2.html" method="post" id="kfForm">
<table id="kfTable">
    <tr>
   		<td>库房名称:</td>
   		<td><input id="kfmc" name="kf.kfmc"/></td>
   </tr>
    <tr>
   		<td>库房地址:</td>
   		<td><input id="kfdz" name="kf.kfdz"/></td>
   </tr>
</table>
</form>
</div>