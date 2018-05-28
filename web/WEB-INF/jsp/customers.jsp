<%-- 
    Document   : customers
    Created on : May 28, 2018, 11:28:19 AM
    Author     : Kenan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers</title>
    </head>
    <body>
        <h1>Customers</h1>
        <form:form action="customers.htm" method="post" commandName="customer">
            <form:label path="first_name">Enter your first name:</form:label><br/>
            <form:input id="first_name" type = "text" path="first_name" placeholder = "Enter your first name..."></form:input><br/>
            
        </form:form>
    </body>
</html>
