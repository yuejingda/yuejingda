<%@ page pageEncoding="utf-8"%>
<style>
    #spForm tr{
    	height:14px;
    	font-size:12px
    }
</style>
<script type="text/javascript">
		$(function(){
			$("#pmgg,#zjm,#xh,#dw,#sb,#cd").textbox({
				required:true,
				height:40
			});
			$("#kcsx,#kcxx,#lsj,#pfj1,#pfj2,#pfj3").numberbox({
				required:true,
				height:40
			});
		});
</script>

<div style="padding-top:15px">
<form action="go_saveSp_2.html" method="post" id="spForm">
<table id="spTable">
   <tr>
   		<td>品名规格:</td>
   		<td><input id="pmgg" name="sp.pmgg"/></td>
   		<td>助记码:</td>
   		<td><input id="zjm" name="sp.zjm"/></td>
   </tr>
    <tr>
   		<td>型号:</td>
   		<td><input id="xh" name="sp.xh"/></td>
   		<td>单位:</td>
   		<td><input id="dw" name="sp.dw"/></td>
   </tr>
    <tr>
   		<td>商标:</td>
   		<td><input id="sb" name="sp.sb"/></td>
   		<td>产地:</td>
   		<td><input id="cd" name="sp.cd"/></td>
   </tr>
    <tr>
   		<td>库存上线:</td>
   		<td><input id="kcsx" name="sp.kcsx"/></td>
   		<td>库存下限:</td>
   		<td><input id="kcxx" name="sp.kcxx"/></td>
   		
   </tr>
    <tr>
    	<td>零售价:</td>
   		<td><input id="lsj" name="sp.lsj"/></td>
   		<td>批发价1:</td>
   		<td><input id="pfj1" name="sp.pfj1"/></td>
   </tr>
   <tr>
   		<td>批发价2:</td>
   		<td><input id="pfj2" name="sp.pfj2"/></td>
   		<td>批发价3:</td>
   		<td><input id="pfj3" name="sp.pfj3"/></td>
   </tr>
</table>

</form>
</div>