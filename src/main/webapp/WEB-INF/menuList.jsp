<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>菜单列表</title>
<script src="${ctx }/static/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function deleteMenu(id) {
		var url = '${ctx}/menu/delete?id=' + id;
		$.ajax({
			url : url,
			type : 'GET',
			success : function(data) {
				window.location.reload();
			}
		});
	}

	function updateMenu(id) {
		var url = '${ctx}/menu/form?id=' + id;
		window.location.href = url;
	}
</script>
</head>
<body>
    <div>
      <a href="${ctx }/menu/form">添加权限</a>
    </div>
	<div>
		<table>
			<thead>
				<tr>
					<th>中文名称</th>
					<th>英文名称</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${menuList }" var="menu">
					<tr>
						<td>${menu.name }</td>
						<td>${menu.permission }</td>
						<td>
							<button onclick="updateMenu('${menu.id}')">修改</button>
							<button onclick="deleteMenu('${menu.id}')">删除</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>