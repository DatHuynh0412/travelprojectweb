<%-- 
    Document   : register
    Created on : Apr 9, 2022, 11:31:42 PM
    Author     : huynh
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<body>
    <br><br><br><br>
    <div class="controller">
        <h1>Register</h1>
        <c:if test="${errMsg != null}">
            <div class="alert alert-danger">
                ${errMsg}
            </div>
        </c:if>

        <c:url value="/register" var="action" />
        <form:form method="post" action="${action}" modelAttribute="user" enctype="multipart/form-data" >
            <div class="form-group">
                Username: <form:input path="username" class="form-control" />
                <form:errors path="username" cssClass="text-danger" />
            </div>
            <div class="form-group">
                Password: <form:password path="password" class="form-control" />
                <form:errors path="password" cssClass="text-danger" />
            </div>
            <div class="form-group">
                Confirm Password: <form:password path="confirmPassword" class="form-control" />
            </div>
            <input type="submit" value="Register" class="btn btn-success" />
        </form:form>
    </div>
    <br><br><br><br><br>
</body>