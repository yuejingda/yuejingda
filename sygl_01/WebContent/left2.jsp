<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
	<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
		<style>
			dl,dt,dd{
				margin:0;
				padding:0;
			}
			#menu{
				width:200px;
				border:1px solid #ccc ;
				text-align:center ;
			}
			
			dd{
				overflow:hidden;
			}
			dt{
				height:40px;
				line-height:40px;
			}
			
			#menu > dt{
				border:1px solid #ccc ;
				background:#cfc ;
				cursor:pointer;
			}
		</style>
		<script>
			window.onload = function(){
				
				var menu = document.getElementById('menu') ;
				var cs = menu.children ;

				/*计算每一个子菜单区域的高度。*/
				for(var i=0;i<cs.length;i++){
					if(cs[i].tagName == 'DD'){
						var dts = cs[i].getElementsByTagName('dt') ;
						var count = dts.length ;
						var style = getComputedStyle(dts[0],false) ;
						var h = style.height ;
						h = parseInt(h); 
						h*=count ;
						cs[i].setAttribute('h',h) ;	
					}
				}


				//-------------------------------------------------------
				for(var i=0;i<cs.length;i++ ){
					if(cs[i].tagName == 'DT'){
						cs[i].onclick = function(){
							var next = this.nextElementSibling ;
							var f = next.getAttribute('f') ;
							if(f == 'on'){
							
								var t1 = setInterval(function(){
									var style = getComputedStyle(next,false) ;
									var h = style.height ;
									h = parseInt(h) ;
									h -= 5 ;
									
									if(h <= 0){
										next.style.height = 0 ;
										clearInterval(t1);
										
									}else{
										next.style.height = h + 'px' ;
									}
									
								},50);
							
								next.setAttribute('f','off') ;	
							}else{
								
								var t2 = setInterval(function(){
									var style = getComputedStyle(next,false) ;
									var h = style.height ;
									h = parseInt(h) ;
									h += 5 ;
									
									var target = next.getAttribute('h') ;
									if(h >= target){
										next.style.height = target + 'px' ;
										clearInterval(t2);
									}else{
										next.style.height = h + 'px' ;
									}
									
								},50);
								
								
								next.setAttribute('f','on') ;	
							}
						}	
					}
				}
			}
		</script>
	</head>
	<body>
		<dl id="menu">
			<dt>权限管理</dt>
			<dd f="on" >
				<dl>
					<dt><a href="userShow.do" target="right">用户管理</a></dt>					
					<dt><a href="roleShow.do" target="right">角色管理</a></dt>
					<dt><a href="menuShow.jsp" target="right">菜单管理</a></dt>					
				</dl>
			</dd>
			<dt>基本信息管理</dt>
			<dd  f="on" >
				<dl>
					<dt>商品管理</dt>					
					<dt>供应商管理</dt>					
					<dt>库房管理</dt>					
				</dl>
			</dd>
			<dt>系统管理</dt>
			<dd  f="on" >
				<dl>
					<dt>修改密码</dt>					
					<dt>注销</dt>					
				</dl>
			</dd>
		</dl>
	</body>
</html>
