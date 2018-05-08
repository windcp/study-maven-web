<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form:form id="save" action="${ctx}/role/save" method="post"> 
           <input name="id" value="${role.id }" type="hidden">     
         中文名称：<input name="name" value="${role.name }"><br>
         英文名称：<input name="enName" value="${role.enName }"/><br>
     <input type="submit" value="保存">      
   </form:form>
</body>
</html>