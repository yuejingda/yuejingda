<%@ page pageEncoding="utf-8"%>
<%@ include file="common.jsp"%>

<script type="text/javascript">
		$(function(){
			initTree();
			
			function initTree(){
				$.post("menuShow.do",{},function(menus){
					//转换成tree识别的text
					for(var i=0;i<menus.length;i++){
						menus[i].text = menus[i].mname;
					}
					menus = resetData(menus,-1);
					
					$("#menuBox").tree({
						data:menus,
						lines:true,
						checkbox:true,
						animate:true
					});
					
					$.post("setMenus.do",{rno:$("#rno").val()},function(currentMenus){
						checkedDefaultMenus(currentMenus);
					},"json");
					
				},"json");
				
				function checkedDefaultMenus(currentMenus){
					var roots = $("#menuBox").tree("getRoots");
					checkedCurrentLevel(roots);
					
					function checkedCurrentLevel(roots){
						for(var i=0;i<roots.length;i++){
							var menu = roots[i];
							var children = $("#menuBox").tree("getChildren",menu.target);
							if(children != null && children.length>0){
								checkedCurrentLevel(children);
							}else{
								for(var j=0;j<currentMenus.length;j++){
									var m = currentMenus[j];
									if(menu.mno==m.mno){
										$("#menuBox").tree("check",menu.target);
										break;
									}
								}
							}
						}
					};
				};
				
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
		});
		$(function(){
			$("#setMenuBtn").linkbutton({
				iconCls:"icon-ok",
				onClick:function(){
					var cs = $("#menuBox").tree("getChecked",["checked","indeterminate"]);
					var url = "saveRoleMenus.do?rno="+$("#rno").val();
					for(var i=0;i<cs.length;i++){
						var c = cs[i];
						url += "&mnos="+c.mno;
					}
					$.post(url,{},function(){
							$.messager.show({
								title:"提示",
								msg:"保存成功"
							});
						});
				}
			});
		});
	
</script>


<a id="setMenuBtn">设置权限</a>
<dl id="menuBox"></dl>
<input type="hidden" id="rno"  name="rno" value="${param.rno }"/>













