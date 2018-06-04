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

        <style>
            .field
            {
                clear:both;
                padding:5px;
            }

            .field label
            {
                text-align: left;
                width:100px;
                float:left;
            }

            .error
            {
                color: red;
            }

            .custable
            {
                border: solid black;
                border-width: thin;
            }


        </style>

    </head>
    <body>
        <h1>Customers</h1>
        <form:form action="customers.htm" method="post" commandName="customer">
            <div class="field">
                <form:label path="first_name">Enter your first name:</form:label><br/>
                <form:input id="first_name" type = "text" path="first_name" placeholder = "Enter your first name..."></form:input><br/>
                </div>
                <div class="field">
                <form:label path="last_name">Enter your last name:</form:label><br/>
                <form:input id="last_name" type = "text" path="last_name" placeholder = "Enter your last name..."></form:input><br/>
                </div>
                <div class="field">
                <form:label path="username">Enter your username:</form:label><br/>
                <form:input id="username" type = "text" path="username" placeholder = "Enter your username..."></form:input><br/>
                </div>
                <div class="field">
                <form:label path="email">Enter your email address:</form:label><br/>
                <form:input id="email" type = "text" path="email" placeholder = "Enter your email..."></form:input><br/>
                </div>
                <div class="field">
                <form:label path="id">Enter id for change or delete:</form:label><br/>
                <form:input id="id" type = "text" path="id" placeholder = "Enter id..."></form:input><br/>
                </div>                
                <input type="submit"  name="addBtn" value="Add"/>
                <input type="submit"  name="deleteBtn" value="Delete" >
        </form:form>
        <table class="custable">
            <tr>
                <td>All customers:</td>
            </tr>
            <tr>
                <td>${customers1}</td>
            </tr>
        </table>
    </body>
</html>
