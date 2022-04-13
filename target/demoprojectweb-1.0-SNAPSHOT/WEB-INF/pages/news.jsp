<%-- 
    Document   : news
    Created on : Apr 13, 2022, 3:33:41 PM
    Author     : huynh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${News}" var="n">
    <a href="<c:url value="/news/${n.id}"/>">
        <div class="container">
            <p>${n.name} <br> ${n.description}</p> 
        </div>
    </a>
</c:forEach>