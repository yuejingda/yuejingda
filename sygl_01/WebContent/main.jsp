<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>



<html>
	<head>
		<title>主界面</title>
		<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
	</head>
	<frameset rows="110,*">
		<frame src="top.jsp"/>
		<frameset cols="220,*">
			<frame src="left.jsp"/>
			<frame name="right"/>
		</frameset>
	</frameset>
</html>