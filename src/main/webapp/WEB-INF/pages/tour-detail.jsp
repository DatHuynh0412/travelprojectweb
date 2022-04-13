<%-- 
    Document   : tour-detail
    Created on : 09-Apr-2022, 6:54:05 am
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info">TOUR DETAIL</h1>

<div class="row">
    <div class="col-md-5 col-sm-12">
        <img src="${tour.image}" 
             class="img-fluid"
             alt="${tour.name}" />
    </div>
    <div class="col-md-7 col-sm-12">
        <h1>${tour.name}</h1>
        <p>${tour.description}</p>
        <h4>${tour.price}$</h4>
    </div>
</div>
<div>
    <h2>Comment</h2>


</div>
<c:url value="/tours/${tour.id}/comment" var="cmt" />
<form:form action="${cmt}" method="POST" modelAttribute="comment">
    <div class="form-check" style=" ">
        <input value="1" type="radio" class="form-check-input" name="rate">1 Star 
        <input value="2" type="radio" class="form-check-input" name="rate">2 Star
        <input value="3" type="radio" class="form-check-input" name="rate">3 Star
        <input value="4" type="radio" class="form-check-input" name="rate">4 Star 
        <input value="5" type="radio" class="form-check-input" name="rate">5 Star 
    </div>
    <form:textarea path="comment"></form:textarea>
        <button type="submit">Comment</button>
</form:form>
</div>
<c:forEach items="${commentlist}" var="cmtlist">
    <p>${cmtlist.userId.username} <br>${cmtlist.comment}</p>      
</c:forEach>