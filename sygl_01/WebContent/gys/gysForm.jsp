<%@  page pageEncoding="utf-8"%>
<style>
	#gysForm tr{
		height:16px;
		font-size:14px
		}
	
</style>
<script>
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

<div style="padding-top:20px">
<form action="go_saveGys_2.html" method="post" id="gysForm">
 <table id="gysTable">
 	<tr>
		<td>供应商名称:</td>
		<td><input id="gysmc" name="gys.gysmc"/></td>
		<td>联系人:</td> 
		<td><input id="lxr" name="gys.lxr"/></td>	
 	</tr>
 	<tr>
 		<td>联系电话:</td>
 		<td><input id="lxdh" name="gys.lxdh"/></td>
 		<td>法人代表:</td>
 		<td><input id="frdb" name="gys.frdb"/></td>
 	</tr>
 	<tr>
 		<td>公司地址:</td>
 		<td><input id="gsdz" name="gys.gsdz"/></td>
 		<td>邮编:</td>
 		<td><input id="yb" name="gys.yb"/></td>
 	</tr>
 	<tr>
 		<td>传真:</td>
 		<td><input id="cz" name="gys.cz"/></td>
 		<td>手机号码:</td>
 		<td><input id="sjhm" name="gys.sjhm"/></td>
 	</tr>
 	<tr>
 		<td>银行账户:</td>
 		<td><input id="yhzh" name="gys.yhzh"/></td>
 		<td>税号:</td>
 		<td><input id="sh" name="gys.sh"/></td>
 	</tr>
 	<tr>
 		<td>开户银行:</td>
 		<td><input id="khyh" name="gys.khyh"/></td>
 		<td>备注信息:</td>
 		<td><input id="bzxx" name="gys.bzxx"/></td>
 	</tr>
 	
 	
 </table>

</form>
</div>