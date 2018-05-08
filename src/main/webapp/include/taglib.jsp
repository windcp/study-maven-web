<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="command2"  class="com.lk.play.user.entity.Role" scope="request" ></jsp:useBean>
<jsp:useBean id="command"  class="com.lk.play.user.entity.User" scope="request" ></jsp:useBean>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>