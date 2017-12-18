<%@ page pageEncoding="utf-8"%>
<%@ include file="common.jsp"  %>
<html>
	<head>
	<script type="text/javascript">
			$(function(){
				initTree();
				//-------查找所有menu数据------------------------
				function initTree(){
					$.post("loginMenus.do",{},function(menus){
						//转换成tree识别的text
						for(var i=0;i<menus.length;i++){
							menus[i].text = menus[i].mname;
						}
						menus = resetData(menus,-1);
						
						$("#menuBox").tree({
							data:menus,
							lines:true,
							animate:true,
							onClick:function(node){
								if(node.children !=null && node.children.length >0){
									$("#menuBox").tree("toggle",node.target);
									return;
								}
								window.open(node.href,"right");
							}
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
			});	
	</script>
	
	</head>
	<body>
		<dl id="menuBox"></dl>
	</body>
</html>
