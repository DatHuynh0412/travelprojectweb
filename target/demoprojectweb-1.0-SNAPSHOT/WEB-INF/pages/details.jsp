<%-- 
    Document   : details
    Created on : Apr 13, 2022, 4:50:46 PM
    Author     : huynh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div>
    <p>${news.name} <br> ${news.description}</p> 
</div>
<div>
    <h2>Comment</h2>
    <c:url value="/news/${news.id}/comment" var="cmt" />
    <form:form action="${cmt}" method="POST" modelAttribute="comment">
        <form:textarea path="comment"></form:textarea>
            <button type="submit">Comment</button>
    </form:form>
</div>
<c:forEach items="${commentlist}" var="cmtlist">
    <p>${cmtlist.userId.username} <br>${cmtlist.comment}</p>      
</c:forEach>
