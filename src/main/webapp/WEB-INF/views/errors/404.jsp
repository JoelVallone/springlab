<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false"%>
<html>
<head>
<title>lab home</title>
<link rel="stylesheet" type="text/css"
    href="<c:url value="/resources/css/style.css" />">
</head>
<body>
    <div align="center">
	    <BR>
	    <h2>Oups... the resource you are requesting does not exist !
	    <BR><BR>
	    <img height="247" width="368" src="<s:url value="/resources" />/img/panda-404.jpg" border="0"/>
	    </h2>
    </div>
</body>
</html>