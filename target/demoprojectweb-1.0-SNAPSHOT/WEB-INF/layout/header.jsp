<%-- 
    Document   : header
    Created on : 08-Apr-2022, 10:54:18 pm
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <a class="navbar-brand" href="<c:url value="/" />">Travel</a>
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="#">News <span class="sr-only">(current)</span></a>
            </li>
        </ul>

        <c:url value="/" var="homeAction" />
        <form class="form-inline my-2 my-lg-0" action="${homeAction}">
            <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search..." aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <a class="btn btn-outline-success my-2 my-sm-0" href="<c:url value="/register" />">Register</a> 
                <a class="btn btn-outline-success my-2 my-sm-0" href="<c:url value="/login" />">Login</a>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <a href="<c:url value = "/admin/add-tour"/>" class="btn btn-outline-success my-2 my-sm-0" >Add</a>
                <a class="btn btn-outline-success my-2 my-sm-0" href="<c:url value="/register" />">${pageContext.request.userPrincipal.name}</a> 
                <a class="btn btn-outline-success my-2 my-sm-0" href="<c:url value="/logout" />">Logout</a>
            </c:if>
        </form>
    </div>
</nav>