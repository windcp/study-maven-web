<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
<title>login</title>
</head>
<body>
   <form:form id="save" action="${ctx}/user/save" method="post"> 
   <input type="hidden" name="id" value="${user.id}"/>
         姓名：<input name="name" value="${user.name}"/><br>
         账号：<input name="account" value="${user.account}"/><br>
         密码：<input name="password" value="${user.password}"/><br>
         角色：<c:forEach items="${roleList }" var="roleObj">
           <input type="radio" name="role.id" value="${roleObj.id }" <c:if test="${user.role.id == roleObj.id }">checked='checked'</c:if>>${roleObj.name }
        </c:forEach><br>
     <input type="submit" value="保存">      
   </form:form>    
</body>
</html>
