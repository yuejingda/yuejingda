<%@ page pageEncoding="utf-8" %>

<jsp:useBean id="role" class="com.domain.Role1" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="role"/>

<jsp:forward page="roleSave.do"></jsp:forward>