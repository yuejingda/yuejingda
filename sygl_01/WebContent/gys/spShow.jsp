<%@ page pageEncoding="utf-8"%>
<html>
	<head>
		<base  href="<%=request.getContextPath()+'/' %>"/>
		<%@ include file="/common.jsp" %>
		<script type="text/javascript">
			$(function(){
				$("#spDataGrid").datagrid({
					fit:true,
					rownumbers:true,
					title:"商品列表",
					pagination:true,
					striped:true,
					checkOnSelect:true,
					url:"go_spShow_2.html",
					columns:[[
					          {field:"spbh",title:"商品编号",wieth:80,align:"center"},
					          {field:"pmgg",title:"品名规格",wieth:80,align:"center"},
					          {field:"zjm",title:"助记码",wieth:80,align:"center"},
					          {field:"xh",title:"型号",wieth:80,align:"center"},
					          {field:"dw",title:"单位",wieth:80,align:"center"},
					          {field:"sb",title:"商标",wieth:80,align:"center"},
					          {field:"cd",title:"产地",wieth:80,align:"center"},
					          {field:"kcsx",title:"库存上限",wieth:80,align:"center"},
					          {field:"kcxx",title:"库存下限",wieth:80,align:"center"},
					          {field:"lsj",title:"零售价",wieth:80,align:"center"},
					          {field:"pfj1",title:"批发价1",wieth:80,align:"center"},
					          {field:"pfj2",title:"批发价2",wieth:80,align:"center"},
					          {field:"pfj3",title:"批发价3",wieth:80,align:"center"},
					]],
					toolbar:[
							{
								text:"添加",
								iconCls:"icon-add",
								onClick:function(){
									$("#spDialog").dialog({
										title:"新建商品",
										height:380,
										width:600,
										modal:true,
				    					href:"go_spForm_1.html",
				    					buttons:[
				    					      {
				    					    	  text:"提交",
				    					    	  iconCls:"icon-ok",
				    					    	  onClick:function(){
				    					    		  $("#spForm").form("submit",{
				    					    			  success:function(){
								        						$.messager.show({
								        							title:"提示",
								        							msg:"保存成功"
								        						});
								        						$("#spDialog").dialog("close");
								        						$("#spDataGrid").datagrid("load");
								        					}
				    					    		  });
				    					    	  }
				    					      },
				    					      {
				  								text:"取消",
				  				        		iconCls:"icon-no",
				  								onClick:function(){
				  									$("#spDialog").dialog("close");	
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
									var row = $("#spDataGrid").datagrid("getSelected");
									if(row == null){
										$.messager.alert({
		        							title:"提示",
		        							msg:"没有选中的记录",
		        							icon:"question"
		        						});
									}
									$.post("go_findSp_2.html",{spbh:row.spbh},function(obj){
										$("#spEditDialog").dialog({
											title:"商品信息修改",
											height:380,
											width:600,
											modal:true,
											href:"go_spEditForm_1.html",
											onLoad:function(){
												$("#spEditForm").form("load",obj.sp);
											},
											buttons:[
						    					      {
						    					    	  text:"提交",
						    					    	  iconCls:"icon-ok",
						    					    	  onClick:function(){
						    					    		  $("#spEditForm").form("submit",{
						    					    			  success:function(){
										        						$.messager.show({
										        							title:"提示",
										        							msg:"修改成功"
										        						});
										        						$("#spEditDialog").dialog("close");
										        						$("#spDataGrid").datagrid("load");
										        					}
						    					    		  });
						    					    	  }
						    					      },
						    					      {
						  								text:"取消",
						  				        		iconCls:"icon-no",
						  								onClick:function(){
						  									$("#spEditDialog").dialog("close");	
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
									var rows = $("#spDataGrid").datagrid("getSelections");
									if(rows == null || rows.length == 0){
										$.messager.alert({
		        							title:"提示",
		        							msg:"没有选中的记录",
		        							icon:"question"
		        						});
									}else{
										$.messager.confirm("提示","是否确认删除",function(f){
										if(f){
											var url = "deleteSp.active?";
											for(var i=0;i<rows.length;i++){
												var row = rows[i];
												url += "spbhs="+row.spbh+"&"; 
											}
											$.post(url,{},function(){
												$.messager.show({
													title:"提示",
													msg:"删除成功"
												});
												$("#spDataGrid").datagrid("reload");
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
		<table id="spDataGrid"></table>
		<div id="spDialog"></div>
		<div id="spEditDialog"></div>
	</body>

</html>