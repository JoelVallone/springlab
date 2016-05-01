<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false"%>
	<h1>New Spittle</h1>
	   <!--  spring framework forms automatically integrate csrf protection
	       token  -->
	   <sf:form    method="POST" 
                   commandName="login"   >
	        <sf:errors path="*" element="div" cssClass="errors" />
	        <br/>
			<sf:label path="username"   cssErrorClass="error"> 
			User: 
			</sf:label>
			<sf:textarea path="username" rows="5" cols="30"  />
			<br/>
			  
            <sf:label path="password"   cssErrorClass="error"> 
			Password:  
            </sf:label> 
			<sf:input  path="password"  cssErrorClass="error"/>
            <br/>
			<input type="submit" value="Login" />
	   </sf:form>