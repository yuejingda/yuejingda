<%@ page pageEncoding="utf-8"%>
<%@ include file="common.jsp"%>
<script>
	$(function(){
		$("#updateDialog").dialog({
			title:"修改密码",
			width:420,
			height:400,
			modle:true,
			href:"pwdForm.jsp",
			buttons:[
			        	{
			        		text:"提交",
			        		iconCls:"icon-ok",
			        		onClick:function(){
			        			$("#pwdForm").form("submit",{
			        					success:function(){
			        						$.messager.show({
			        							title:"提示",
			        							msg:"修改成功"
			        						});
			        						$("#updateDialog").dialog('close');
			        						window.open("login.jsp","_parent");
			        					}
			        			
			        				
			        			});
			        		}
			        	},
			        	{
			        		text:"取消",
			        		iconCls:"icon-no",
							onClick:function(){
								$('#updateDialog').dialog('close');	
			        		}
			        	}
			        ],
		});
	});
	
</script>

<div id="updateDialog"></div>