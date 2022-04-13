<%-- 
    Document   : userprofile
    Created on : Apr 13, 2022, 8:26:45 PM
    Author     : huynh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>User</h1>
<p>${user.username}</p>
<c:forEach items="${booklist}" var="bklist">
    <p>${bklist.tourId.name} - ${bklist.adultTicket} - ${bklist.childTicket}</p>
</c:forEach>