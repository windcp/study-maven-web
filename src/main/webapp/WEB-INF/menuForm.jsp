<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加/修改菜单</title>
</head>
<body>
  <form id="save" action="${ctx }/menu/save"  method="post">
           <input name="id" value="${menu.id}" type="hidden">
           中文名称：<input id="chName" name="name" type="text" value="${menu.name }"><br>
           英文名称：<input id="enName" name="permission" type="text" value="${menu.permission }"><br>
           <input type="submit" value="保存">      
  </form>
</body>
</html>