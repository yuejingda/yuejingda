<%@ page pageEncoding="utf-8"%>

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
	window.onload = function(){
		var xhr = new XMLHttpRequest();
		xhr.open("post","menuShow.do",true);
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				handle(xhr.responseText);
			}
		}
		xhr.send();
		
		function handle(text){
			var menus = eval(text);
			var dl = document.getElementById("menuBox");
			showMenuForCurrentLevel(menus,-1,dl);
			
			
			//-------展开合并-----------------------------
			var dts = document.getElementsByTagName("dt");
			for(var i=0;i<dts.length;i++){
				var dt = dts[i];
				
				dt.onclick = function(){
					var next = this.nextElementSibling;
					if(next !=null && next.tagName == "DD"){
						if(next.style.display =="none"){
							next.style.display ="block";
						}else{
							next.style.display ="none";
						}
					}
				}
			}
		}
		
		function showMenuForCurrentLevel(source,pno,dl){
			for(var i=0;i<source.length;i++){
				var menu = source[i];
				if(menu.pno != pno) continue;
				var dt = document.createElement("dt");
				if(menu.href !="null"){
					dt.innerHTML = "<a href='"+menu.href+"' target='right'>"+menu.mname+"</a>";
				}else{
					dt.innerHTML = menu.mname;
				}
				var dd = document.createElement("dd");
				var childDl = document.createElement("dl");
				
				showMenuForCurrentLevel(source,menu.mno,childDl);
				
				dd.appendChild(childDl);
				dl.appendChild(dt);
				dl.appendChild(dd);
				
			}
		}
	}

</script>
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


























