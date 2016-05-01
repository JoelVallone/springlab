<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false"%>

    <h1> 
        Welcome to digital panda - spring laboratory
        <BR>
        <img width="250" height="186" 
             src="<c:url value="/resources/img/panda.jpg" />"> 
    </h1>
    
    <br>
    <h2>Home made functionalities</h2> 
    <a href="<c:url value="/presentation/" />">Presentation</a>
    
    
    <br>
    <h2><s:message code="spittr.welcome" /></h2>
    <a href="<c:url value="/springlab/spittles" />">
        Spittles</a> |
    <a href="<c:url value="/springlab/spittles/register" />">
        New spittle</a> |
    <a href="<c:url value="/springlab/spittles?max=238900&count=6" />">
        Spittles query param</a> |
    <a href="<c:url value="/springlab/spittles/42" />">
        Spittle path param 42</a> |     
    <a href="<c:url value="/springlab/spittles/-1" />">
        Wrong spittle</a> |
    <br>
    <a href="<c:url value="/springlab/spitter/register" />">
        Register spitter</a> |