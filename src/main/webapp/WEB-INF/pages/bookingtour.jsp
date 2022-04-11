<%-- 
    Document   : bookingtour
    Created on : Apr 9, 2022, 8:05:36 PM
    Author     : huynh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
<c:url value="/tours/${tour.id}/booking" var="booking" />
<form:form method="post" action="${booking}" modelAttribute="booking" >
    <br> 
    <div class="form-group">Adult: <form:input path="adultTicket" /></div>

    <div class="form-group">Children: <form:input path="childTicket"/></div>



    <input type="submit" value="Book" />

</form:form>   
<br> 