<%@ page pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
		<script type="text/javascript">
			$(function(){
				
				$.post("setRole.do",function(json){
					//var data = eval(roles);
					for(var i=0;i<json.length;i++){
						var role = json[i];
						var tbody = $("#tbody");
						if(json==null || json.length==0){
							var tr0 = $("<tr>");
							var th0 = $("<th colspan='5'></th>");
							//th0.attr("colspan","5");
							th0.html("没有任何记录");
							tr0.append(th0);
							tbody.append(tr0);
						}else{
							var tr1 = $("<tr>");
							var th1 = $("<th></th>");
							var th2 = $("<th>"+role.rno+"</th>");
							var th3 = $("<th>"+role.rname+"</th>");
							var th4 = $("<th>"+role.rms+"</th>");
							var input = $("<input type='checkbox' name='rnos' value='"+role.rno+"' id='in'/>");
							tbody.append(tr1);
							th1.append(input);
							tr1.append(th1);
							tr1.append(th2);
							tr1.append(th3);
							tr1.append(th4);
						}
					}
					
					$("#all").click(function(){
						var inputs = $("in");
						for(var i=0;i<inputs.length;i++){
							var input = inputs[i];
							if(input.name=="rnames"){
								input.checked = $("#all").checked;
							}
						}
					});
					
					$.post("setUserRole.do",{uno:$("#in").val()},function(roles){
						for(var i=0;i<roles.length;i++){
							var role = roles[i] ;
							$('input[value="'+role.rno+'"]').attr('checked',true);
						}
					},'json');
					
				},"json");
				
				
				
			
				
			});
		</script>
	</head>
	<body>
		<form id="setRoleForm" action="toSetRoles.do" method="post">
		<h3 align="center">设置用户角色</h3>
			<p align="center">
				<input type="submit" value="确定"/>
				<input type="hidden" name="uno" value="${param.uno }" id="in"/>
			</p>
			 <table align="center" border="2" cellspacing="0" width="80%">
			 	<thead>
			 		<tr>
			 			<th><input type="checkbox" id="all"/></th>
			 			<th>角色编号</th>
			 			<th>角色名称</th>
			 			<th>角色描述</th>
			 		</tr>
			 	</thead>
			 	<tbody id="tbody">
			 	<!-- 
			 		<c:choose>
			 			<c:when test="${roles==null or roles.size()==0 }">
			 				<tr align="center">
			 					<th colspan="5">没有任何记录</th>
			 				</tr>
			 			</c:when>
			 			<c:otherwise>
			 				<c:forEach items="${roles}" var="role">
			 					<tr>
			 						<th><input type="checkbox" name="rnos" value="${role.rno }" id="in"/></th>
			 						<th>${role.rno }</th>
			 						<th>${role.rname }</th>
			 						<th>${role.rms}</th>
			 					</tr>
			 				</c:forEach>
			 			</c:otherwise>
			 		</c:choose>
			 		 -->
			 	</tbody>
			 </table>
		</form>
	</body>
</html>