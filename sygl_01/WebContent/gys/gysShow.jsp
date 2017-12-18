<%@ page pageEncoding="utf-8"%>
<html>
	<head>
		<base href="<%=request.getContextPath()+"/" %>"/>
		<%@ include file="/common.jsp" %>
		<script>
			$(function(){
				$("#gysDatagrid").datagrid({
					fit:true,
					rownumbers:true,
					title:"供应商列表",
					pagination:true,
					striped:true,
					url:"gysShow.do",
					checkOnSelect:true,
					columns:[[
					         {field:"gysbh",title:"供应商编号",width:80,align:"center",hidden:true},
					         {field:"gysmc",title:"供应商名称",width:120,align:"center"},
					         {field:"lxr",title:"联系人",width:80,align:"center"},
					         {field:"lxdh",title:"联系电话",width:120,align:"center"},
					         {field:"frdb",title:"法人代表",width:80,align:"center"},
					         {field:"gsdz",title:"公司地址",width:120,align:"center"},
					         {field:"yb",title:"邮编",width:80,align:"center"},
					         {field:"cz",title:"传真",width:120,align:"center"},
					         {field:"sjhm",title:"手机号码",width:120,align:"center"},
					         {field:"yhzh",title:"银行账户",width:120,align:"center"},
					         {field:"sh",title:"税号",width:120,align:"center"},
					         {field:"khyh",title:"开户银行",width:120,align:"center"},
					         {field:"bzxx",title:"备注信息",width:80,align:"center"},
					 ]],
					toolbar:[
					         {
					        	 text:"添加",
					        		iconCls:"icon-add",
					        		onClick:function(){
					        			$("#gysDialog").dialog({
					        				title:"新建供应商",
					    					width:600,
					    					height:400,
					    					modal:true,
					    					href:"go_gysForm_1.html",
					    					buttons:[
								        				{
											        		text:"提交",
											        		iconCls:"icon-ok",
											        		onClick:function(){
											        			$("#gysForm").form("submit",{
											        					success:function(){
											        						$.messager.show({
											        							title:"提示",
											        							msg:"保存成功"
											        						});
											        						$("#gysDialog").dialog("close");
											        						$("#gysDatagrid").datagrid("load");
											        					}
											        			});
											        		}
											        	},
											        	{
											        		text:"取消",
											        		iconCls:"icon-no",
															onClick:function(){
																$("#gysDialog").dialog("close");	
											        		}
											        	}
											        ]
								        				
								        		});
								        	} 
								},
								{
									text:"编辑",
									iconCls:"icon-edit",
									onClick:function(){
										var row = $("#gysDatagrid").datagrid("getSelected");
										if(row == null){
											$.messager.alert({
			        							title:"提示",
			        							msg:"没有选中的记录",
			        							icon:"question"
			        						});
										}
										$.post("go_findGys_2.html",{gysbh:row.gysbh},function(obj){
											$("#gysEdit").dialog({
												title:"库房信息修改",
												width:600,
						    					height:400,
												modal:true,
												href:"go_gysEditForm_1.html",
												onLoad:function(){
													$("#gysEditForm").form("load",obj.gys);
												},
												buttons:[
							    					      {
							    					    	  text:"提交",
							    					    	  iconCls:"icon-ok",
							    					    	  onClick:function(){
							    					    		  $("#gysEditForm").form("submit",{
							    					    			  success:function(){
											        						$.messager.show({
											        							title:"提示",
											        							msg:"修改成功"
											        						});
											        						$("#gysEdit").dialog("close");
											        						$("#gysDatagrid").datagrid("load");
											        					}
							    					    		  });
							    					    	  }
							    					      },
							    					      {
							  								text:"取消",
							  				        		iconCls:"icon-no",
							  								onClick:function(){
							  									$("#gysEdit").dialog("close");	
							  								}
							  								
							  							}
							    					   ]
											});
										},"json");
									}
								},
								{
									text:"删除",
									iconCls:"icon-cancel",
									onClick:function(){
										var rows = $("#gysDatagrid").datagrid("getSelections");
										if(rows == null || rows.length == 0){
											$.messager.alert({
			        							title:"提示",
			        							msg:"没有选中的记录",
			        							icon:"question"
			        						});
										}else{
											$.messager.confirm("提示","是否确认删除",function(f){
											if(f){
												var url = "deleteGys.active?";
												for(var i=0;i<rows.length;i++){
													var row = rows[i];
													url += "gysbhs="+row.gysbh+"&"; 
												}
												$.post(url,{},function(){
													$.messager.show({
														title:"提示",
														msg:"删除成功"
													});
													$("#gysDatagrid").datagrid("reload");
												})															
											}
										});
									}
								}
							}
											         
							]
				});
			});
		</script>
	</head>
	
	<body>
	<table id="gysDatagrid"></table>
	<div id="gysDialog"></div>
	<div id="gysEdit"></div>
	</body>
</html>