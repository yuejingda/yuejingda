<%@ page pageEncoding="utf-8"%>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script src="easyui/jquery.min.js"></script>
<script src="easyui/jquery.easyui.min.js"></script>
<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
<style>
	dl,dt,dd{
		margin-top:0;
		margin-bottom:0;
		padding-top:0;
		padding-bottom:0	
	}
	dt{
		margin-top:2px;
		margin-bottom:2px;	
		cursor:pointer;
	}
</style>


<script type="text/javascript">
		
		$(function(){
			initTree();
			$("#rootBtn").linkbutton({
				plain:true,
				iconCls:"icon-add",
				onClick:function(){
					openMenuDialog();	
				}
			});
			$("#childBtn").linkbutton({
				plain:true,
				iconCls:"icon-add",
				onClick:function(){
					var node = $("#menuBox").tree("getSelected");
					if(node==null){
						$.messager.alert("提示","请选择父级菜单","error");
						return;
					}
					openMenuDialog(node);	
				}
			});
			$("#editBtn").linkbutton({
				plain:true,
				iconCls:"icon-edit",
				onClick:function(){
					var row = $("#menuBox").tree("getSelected");
					if(row==null){
						$.messager.alert("提示","请选择菜单","error");
					}else{
						$.post("findMenu.do",{mno:row.mno},function(menu){
							$("#menuEditDialog").dialog({
								title:"修改菜单",
								width:420,
								height:400,
								modal:true,
								href:"menuEditForm.jsp",
								onLoad:function(){
									$("#menuEditForm").form("load",row);
									
								},
								buttons:[
								        	{
								        		text:"提交",
								        		iconCls:"icon-ok",
								        		onClick:function(){
								        			$("#menuEditForm").form("submit",{
								        					success:function(){
								        						$.messager.show({
								        							title:"提示",
								        							msg:"修改成功"
								        						});
								        						$("#menuEditDialog").dialog("close");
								        						initTree();
								        					}
								        				
								        			});
								        		}
								        	},
								        	{
								        		text:"取消",
								        		iconCls:"icon-no",
												onClick:function(){
													$("#menuEditDialog").dialog("close");	
								        		}
								        	}
									]
									
							});
						},"json");
					}
				}
				
			});
			$("#deleteBtn").linkbutton({
				plain:true,
				iconCls:"icon-cancel",
				onClick:function(){
					var row = $("#menuBox").tree("getSelected");
					if(row==null ){
						$.messager.alert("提示","请选择菜单","error");
					}else{
						$.post("deleteMenu.do",{mno:row.mno},function(){
							initTree();
						});
					}
				}
				
			});
			
			
			
			
			function openMenuDialog(node){
				$("#menuDialog").dialog({
					title:"新建菜单",
					width:420,
					height:400,
					modal:true,
					href:"menuForm.jsp",
					buttons:[
					        	{
					        		text:"提交",
					        		iconCls:"icon-ok",
					        		onClick:function(){
					        			$("#menuForm").form("submit",{
					        					success:function(){
					        						$.messager.show({
					        							title:"提示",
					        							msg:"保存成功"
					        						});
					        						$("#menuDialog").dialog("close");
					        						initTree();
					        					}
					        				
					        			});
					        		}
					        	},
					        	{
					        		text:"取消",
					        		iconCls:"icon-no",
									onClick:function(){
										$("#menuDialog").dialog("close");	
					        		}
					        	}
					        ],
					onLoad:function(){
						if(node==null){
							$("#pname").textbox("setValue","主菜单");
							$("#pno").val(-1);
						}else{
							$("#pname").textbox("setValue",node.text);
							$("#pno").val(node.mno);
						}
						
					}
				});
			};
			
		});
		function initTree(){
			$.post("menuShow.do",function(menus){
				//转换成tree识别的text
				for(var i=0;i<menus.length;i++){
					menus[i].text = menus[i].mname;
				}
				menus = resetData(menus,-1);
				
				$("#menuBox").tree({
					data:menus,
					lines:true,
					animate:true
				});
			},"json");
			
			//找到tree识别的children，写一个函数来找到children
			function resetData(array,pno){
				var menus = [];
				for(var i=0;i<array.length;i++){
					var menu = array[i];
					if(menu.pno == pno){
						menus.push(menu);
						var children = resetData(array,menu.mno);
						if(children!=null && children.length>0){
							menu.children = children;
						}
					}
					
				}
				return menus;
			}
		};
		

</script>
<a id="rootBtn">增加根目录</a>|
<a id="childBtn">增加子目录</a>|
<a id="editBtn">编辑菜单</a>|
<a id="deleteBtn">删除菜单</a>
<div id="menuDialog"></div>
<div id="menuEditDialog"></div>
<dl id="menuBox">
<!--  
	<dt>权限管理</dt>
	<dd>
		<dl>
			<dt>用户管理</dt>
			<dd>
				<dl>
					<dt>普通用户</dt>
					<dt>会员用户</dt>
					<dd>
						<dl>
							<dt>黄金会员</dt>
							<dt>铂金会员</dt>
							<dt>钻石会员</dt>
						</dl>
					</dd>
					<dt>员工用户</dt>
				</dl>
			</dd>
			<dt>角色管理</dt>
			<dt>权限管理</dt>
		</dl>
	</dd>
	-->
</dl>


























