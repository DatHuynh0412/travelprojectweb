<%-- 
    Document   : login
    Created on : Mar 22, 2022, 10:14:28 PM
    Author     : huynh
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<body>
    <br><br><br><br>
    <div class="controller">
        <h1>Login</h1>
        <c:if test="${msg.equals('SUCCESSFUL')==true}">
            <h1 style="color: darkblue;">${msg}</h1>
        </c:if>
        <c:if test="${msg.equals('FAIL')==true}">
            <h1 style="color: red;">${msg}</h1>
        </c:if>
        <c:url value="/login" var="action" />    
        <form:form method="post" action="${action}" modelAttribute="User" >
            <div class="form-group">
                Username: <form:input path="username" class="form-control" />
            </div>
            <div class="form-group">
                Password: <form:password path="password" class="form-control" />
            </div>
            <input type="submit" value="Login" class="btn btn-success" />
        </form:form>
    </div>
    <br><br><br><br><br>
</body>

