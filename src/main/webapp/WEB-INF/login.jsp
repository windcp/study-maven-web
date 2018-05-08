<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
<title>login</title>
</head>
<body>
   <form:form id="login" action="${ctx}/login/loginOn" method="post">
         账号：<form:input path="account"/><br>
         密码：<form:password path="password"/><br>
         <input type="submit" value="登陆">      
   </form:form>
</body>
</html>
