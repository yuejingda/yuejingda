<%@ page pageEncoding="utf-8"%>

<style>
    #gysEditForm tr{
    	height:14px;
    	font-size:12px
    }
</style>
<script type="text/javascript">
		$(function(){
			$("#lxdh,#yb,#cz,#sjhm,#yhzh,#sh").numberbox({
				required:true,
				height:40
			});
			
			$("#gysmc,#lxr,#frdb,#gsdz,#khyh,#bzxx").textbox({
				required:true,
				height:40
			});
		});
</script>


<div style="padding-top:15px">
<form action="go_updateGys_2.html" method="post" id="gysEditForm">
<input type="hidden" name="gysbh" id="gysbh">
<table id="gysTable" align="center">
   <tr>
		<td>供应商名称:</td>
		<td><input id="gysmc" name="gysmc"/></td>
		<td>联系人:</td> 
		<td><input id="lxr" name="lxr"/></td>	
 	</tr>
 	<tr>
 		<td>联系电话:</td>
 		<td><input id="lxdh" name="lxdh"/></td>
 		<td>法人代表:</td>
 		<td><input id="frdb" name="frdb"/></td>
 	</tr>
 	<tr>
 		<td>公司地址:</td>
 		<td><input id="gsdz" name="gsdz"/></td>
 		<td>邮编:</td>
 		<td><input id="yb" name="yb"/></td>
 	</tr>
 	<tr>
 		<td>传真:</td>
 		<td><input id="cz" name="cz"/></td>
 		<td>手机号码:</td>
 		<td><input id="sjhm" name="sjhm"/></td>
 	</tr>
 	<tr>
 		<td>银行账户:</td>
 		<td><input id="yhzh" name="yhzh"/></td>
 		<td>税号:</td>
 		<td><input id="sh" name="sh"/></td>
 	</tr>
 	<tr>
 		<td>开户银行:</td>
 		<td><input id="khyh" name="khyh"/></td>
 		<td>备注信息:</td>
 		<td><input id="bzxx" name="bzxx"/></td>
 	</tr>
</table>

</form>
</div>