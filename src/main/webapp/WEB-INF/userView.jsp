<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
<title>login</title>
</head>
<body>  
         姓名：${user.name }<br>
         账号：${user.account }<br>
         密码：${user.password }<br>
         角色：${roleName }    
</body>
</html>
