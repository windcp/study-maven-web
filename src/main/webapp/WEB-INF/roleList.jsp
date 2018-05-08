<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
<title>用户列表</title>
<script src="${ctx }/static/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
      function deleteUser(id){
    		var url = '${ctx}/role/delete?id='+ id;
    		$.ajax({
    			url:url,
    			type:'GET',
    			success:function(data){
    				window.location.reload(); 
    			}
    		});
    	}
    	
    	
    	function updateUser(id){
   		 var url = '${ctx}/role/form?id='+ id;
   		 window.location.href = url;
   	   }
</script>
</head>
<body>
  <div>
      <a href="${ctx }/role/form">添加权限</a><br>
  </div>
  <div>
      <table>
         <thead>
            <tr>
              <th>中文名称</th>
              <th>英文名称</th>
            </tr>
         </thead>
         <tbody>
           <c:forEach items="${roleList }" var="role">
            <tr>
              <td>${role.name }</td>
              <td>${role.enName }</td>
              <td>
                 <button onclick="updateUser('${role.id}')">修改</button>
                 <button onclick="deleteUser('${role.id}')">删除</button>
              </td>
            </tr>
           </c:forEach>
         </tbody>
      </table>
  </div>
</body>
</html>