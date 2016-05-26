<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false"%>


<div style="float:left; width:20%; text-align:left">
	<a href="<s:url value="/" />">
	    <img src="<s:url value="/resources" />
	    /img/panda-logo.png" border="0" />
	</a>
</div>

<!--  
<div style="float:center; width:60%; text-align:center">
    digitalpanda.org
</div> -->

<div style="float:right; width:20%; text-align:left">
	<security:authorize access="isAuthenticated()" >
	   Logged in as  <security:authentication property="principal.username" /><br>
	   <a href="<c:url value="/logout" />">Logout</a>
	</security:authorize>
</div>
<BR>