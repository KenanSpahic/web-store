<%-- 
    Document   : products
    Created on : May 28, 2018, 11:28:40 AM
    Author     : Kenan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>

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
        <h1>Products</h1>
        <form:form action="products.htm" method="post" commandName="product">
            <div class="field">
                <form:label path="name">Enter product name:</form:label><br/>
                <form:input id="name" type = "text" path="name" placeholder = "Enter product name..."></form:input><br/>
                </div>
                <div class="field">
                <form:label path="price">Enter product price:</form:label><br/>
                <form:input id="price" type = "text" path="price" placeholder = "Enter product price..."></form:input><br/>
                </div>                
                <input type="submit" value="Add"/>
        </form:form>
<!--        <table class="custable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="prod" items="${products1}">
                <tr>
                    <td>${products1}</td>
                </tr>       
            </c:forEach>
        </tbody>
    </table>-->
            <table class="custable">
                <tr>
                    <th>All products:</th>
                </tr>
                <tr>
                    <td>${products1}</td>
                </tr>
            </table>
</body>
</html>
