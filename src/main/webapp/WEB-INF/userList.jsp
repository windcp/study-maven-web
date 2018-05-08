<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
<title>用户列表</title>
<script src="${ctx }/static/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
      function deleteUser(id){
    		var url = '${ctx}/user/delete?id='+ id;
    		$.ajax({
    			url:url,
    			type:'GET',
    			success:function(data){
    				window.location.reload(); 
    			}
    		});
    	}
    	
    	function viewUser(id){
    		 var url = '${ctx}/user/view?id='+ id;
    		 window.location.href = url;
    	}
    	
    	function updateUser(id){
   		 var url = '${ctx}/user/form?id='+ id;
   		 window.location.href = url;
   	   }
</script>
</head>
<body>
  <div>
   <shiro:hasAnyRoles name="admin,test">
      <a href="${ctx }/user/form">添加用户</a><br>
      <a href="${ctx }/role/list">跳转到角色页面</a>
      <a href="${ctx }/role/roleMenuForm">跳转到角色权限页面</a>
   </shiro:hasAnyRoles>
   <a href="${ctx }/login/loginOut">退出</a>
  </div>
  <div>
      <table>
         <thead>
            <tr>
              <th>姓名</th>
              <th>账号</th>
              <th>操作</th>
            </tr>
         </thead>
         <tbody>
           <c:forEach items="${userList }" var="user">
            <tr>
              <td>${user.name }</td>
              <td>${user.account }</td>
              <td>
                 <button onclick="viewUser('${user.id}')">查看</button>
                 <shiro:hasAnyRoles  name="admin,test">
                   <button onclick="updateUser('${user.id}')">修改</button>
                 </shiro:hasAnyRoles >
                 <shiro:hasRole name="admin">
                   <button onclick="deleteUser('${user.id}')">删除</button>
                 </shiro:hasRole>
              </td>
            </tr>
           </c:forEach>
         </tbody>
      </table>
  </div>
</body>
</html>