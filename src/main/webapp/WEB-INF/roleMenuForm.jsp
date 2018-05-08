<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="${ctx }/menu/list">跳转到权限页面</a>
	<form action="${ctx }/role/roleMenuSave" method="post">
		<table>
			<thead>
				<tr>
					<th>角色</th>
					<th>权限</th>
				</tr>
			</thead>
			<tbody>

				<%-- 
				<c:choose>
					<c:when test="${role.enName == 'admin'}">
						<c:forEach items="${roleList }" var="role2">
							<tr>
								<td>${role2.name }</td>
								<c:forEach items="${menuList }" var="menu">
									<td><input type="checkbox" name="name"
										value="${menu.name }">${menu.name }</td>
								</c:forEach>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<shiro:hasRole name="${role.enName }">
								<td>${role.name }</td>
								<c:forEach items="${menuList }" var="menu">
									<td><input type="checkbox" name="name"
										value="${menu.name }">${menu.name }</td>
								</c:forEach>
							</shiro:hasRole>
						</tr>
					</c:otherwise>
				</c:choose>
 --%>
				<c:forEach items="${roleList }" var="role">
					<shiro:hasRole name="admin">
						<tr>
							<td>${role.name }<input type="hidden" name="role.id"></td>
							<c:forEach items="${menuList }" var="menu">
								<td><input type="checkbox" name="name"
									value="${menu.name }">${menu.name }</td>
							</c:forEach>
						</tr>
					</shiro:hasRole>
					<shiro:lacksRole name="admin">
						<tr>
							<shiro:hasRole name="${role.enName }">
								<td>${role.name }<input type="hidden" name="role.id"></td>
								<c:forEach items="${menuList }" var="menu">
									<td><input type="checkbox" name="menu.id"
										value="${menu.name }">${menu.name }</td>
								</c:forEach>
							</shiro:hasRole>
						</tr>
					</shiro:lacksRole>
				</c:forEach>
			</tbody>
		</table>
		<input type="submit" value="提交">
	</form>
</body>
</html>