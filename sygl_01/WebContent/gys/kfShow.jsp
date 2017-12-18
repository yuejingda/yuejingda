<%@page pageEncoding="utf-8"%>
<html>
	<head>
		<base href="<%=request.getContextPath()+"/" %>"/>
		<%@ include file="/common.jsp" %>
		<script type="text/javascript">
			$(function(){
				$("#kfDatagrid").datagrid({
					fit:true,
					rownumbers:true,
					title:"库房列表",
					pagination:true,
					striped:true,
					url:"go_kfShow_2.html",
					checkOnSelect:true,
					columns:[[
							{field:"kfbh",title:"库房编号",wieth:80,align:"center"},
							{field:"kfmc",title:"库房名称",wieth:120,align:"center"},
							{field:"kfdz",title:"库房地址",wieth:180,align:"center"},          
					]],
					toolbar:[
								{
									text:"添加",
									iconCls:"icon-add",
									onClick:function(){
										$("#kfDialog").dialog({
											title:"新建库房",
											height:400,
											width:300,
											modal:true,
					    					href:"go_kfForm_1.html",
					    					buttons:[
					    					      {
					    					    	  text:"提交",
					    					    	  iconCls:"icon-ok",
					    					    	  onClick:function(){
					    					    		  $("#kfForm").form("submit",{
					    					    			  success:function(){
									        						$.messager.show({
									        							title:"提示",
									        							msg:"保存成功"
									        						});
									        						$("#kfDialog").dialog("close");
									        						$("#kfDatagrid").datagrid("load");
									        					}
					    					    		  });
					    					    	  }
					    					      },
					    					      {
					  								text:"取消",
					  				        		iconCls:"icon-no",
					  								onClick:function(){
					  									$("#kfDialog").dialog("close");	
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
										var row = $("#kfDatagrid").datagrid("getSelected");
										if(row == null){
											$.messager.alert({
			        							title:"提示",
			        							msg:"没有选中的记录",
			        							icon:"question"
			        						});
										}
										$.post("go_findKf_2.html",{kfbh:row.kfbh},function(obj){
											$("#kfEdit").dialog({
												title:"库房信息修改",
												height:400,
												width:300,
												modal:true,
												href:"go_kfEditForm_1.html",
												onLoad:function(){
													$("#kfEditForm").form("load",obj.kf);
												},
												buttons:[
							    					      {
							    					    	  text:"提交",
							    					    	  iconCls:"icon-ok",
							    					    	  onClick:function(){
							    					    		  $("#kfEditForm").form("submit",{
							    					    			  success:function(){
											        						$.messager.show({
											        							title:"提示",
											        							msg:"修改成功"
											        						});
											        						$("#kfEdit").dialog("close");
											        						$("#kfDatagrid").datagrid("load");
											        					}
							    					    		  });
							    					    	  }
							    					      },
							    					      {
							  								text:"取消",
							  				        		iconCls:"icon-no",
							  								onClick:function(){
							  									$("#kfEdit").dialog("close");	
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
										var rows = $("#kfDatagrid").datagrid("getSelections");
										if(rows == null || rows.length == 0){
											$.messager.alert({
			        							title:"提示",
			        							msg:"没有选中的记录",
			        							icon:"question"
			        						});
										}else{
											$.messager.confirm("提示","是否确认删除",function(f){
											if(f){
												var url = "deleteKf.active?";
												for(var i=0;i<rows.length;i++){
													var row = rows[i];
													url += "kfbhs="+row.kfbh+"&"; 
												}
												$.post(url,{},function(){
													$.messager.show({
														title:"提示",
														msg:"删除成功"
													});
													$("#kfDatagrid").datagrid("reload");
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
		<table id="kfDatagrid"></table>
		<div id="kfDialog"></div>
		<div id="kfEdit"></div>
	</body>






</html>



