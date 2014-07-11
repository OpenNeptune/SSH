<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<s:debug></s:debug>
	<s:form action="/user_register" method="post">
		<s:textfield name="username" label="userName"></s:textfield>
		<s:textfield name="email" label="email"></s:textfield>
		<s:password name="password" label="Password"></s:password>
		<s:password name="confirPassword" label="Re-Password"></s:password>
		<s:submit value="JOIN-IN"></s:submit>
	</s:form>
</body>
</html>