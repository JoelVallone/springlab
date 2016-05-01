<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false"%>
	<h1>Register</h1>
	<!-- HTML form
	<form method="POST">
		First Name: <input type="text"     name="firstName" /><br /> 
		Last Name:  <input type="text"     name="lastName" /><br />
		Username:   <input type="text"     name="username" /><br /> 
	    Password:   <input type="password" name="password" /><br /> 
	                <input type="submit"   value="Register" />
	</form>
	
	error example 
	First Name: <input id="firstName" name="firstName" type="text" value="J"/>
                <span id="firstName.errors">size must be between 2 and 30</span>
	 -->
	 <!-- Spring tags form  -->
	   <sf:form    method="POST" 
	               commandName="spitter"  
	               enctype="multipart/form-data">
	        <sf:errors path="*" element="div" cssClass="errors" />
	        <br/>
			<sf:label path="firstName"   cssErrorClass="error"> 
			 First Name: 
			</sf:label>
			<sf:input  path="firstName"  cssErrorClass="error"/>
			<!-- <sf:errors path="firstName"  cssClass="error" /> -->
			<br/>
			  
            <sf:label path="lastName"   cssErrorClass="error"> 
			Last Name:  
            </sf:label> 
			<sf:input  path="lastName"  cssErrorClass="error"/>
            <!-- <sf:errors path="lastName"     cssClass="error" /> -->
            <br/>
                         
			<sf:label path="email"   cssErrorClass="error"> 
            Email:      
            </sf:label>
			<sf:input  path="email" cssErrorClass="error" type="email"/>
            <!-- <sf:errors path="email"        cssClass="error" /> -->
            <br/>
                         
			<sf:label path="username"   cssErrorClass="error"> 
            Username:    
            </sf:label>
			<sf:input  path="username"   cssErrorClass="error"/>
            <!-- <sf:errors path="username"   cssClass="error" /> -->
            <br/>
                         
			<sf:label path="password" cssErrorClass="error"> 
            Password:    
            </sf:label>
			<sf:password path="password" cssErrorClass="error"/>
            <!-- <sf:errors   path="password" cssClass="error" /> -->
            <br/>
            
            <sf:label path="profilePicture" cssErrorClass="error"> 
            Profile Picture
            </sf:label>
            <sf:input path="profilePicture" type="file" cssErrorClass="error"/>
            <br/>
            
			<input type="submit" value="Register" />
	   </sf:form>