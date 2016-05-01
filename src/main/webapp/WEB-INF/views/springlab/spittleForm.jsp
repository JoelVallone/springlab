<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false"%>
	<h1>New Spittle</h1>
	   <!--  spring framework forms automatically integrate csrf protection
	       token  -->
	   <sf:form    method="POST" 
                   commandName="spittle"   >
	        <sf:errors path="*" element="div" cssClass="errors" />
	        <br/>
			<sf:label path="message"   cssErrorClass="error"> 
			Message: 
			</sf:label>
			<sf:textarea path="message" rows="5" cols="30"  />
			<br/>
			  
            <sf:label path="latitude"   cssErrorClass="error"> 
			Latitude:  
            </sf:label> 
			<sf:input  path="latitude"  cssErrorClass="error"/>
            <br/>
                         
			<sf:label path="longitude"   cssErrorClass="error"> 
            Longitude:      
            </sf:label>
			<sf:input  path="longitude" cssErrorClass="error"/>
            <br/>
			<input type="submit" value="Register" />
	   </sf:form>