<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false"%>
    <a href="<c:url value="/springlab/" />">Springlab</a>
    <a href="<c:url value="/presentation/" />">Presentation</a>  
    <security:authorize access="hasRole('ROLE_SPITTER')">  
        <a href="<c:url value="/admin/" />">Admin</a>
    </security:authorize>
    