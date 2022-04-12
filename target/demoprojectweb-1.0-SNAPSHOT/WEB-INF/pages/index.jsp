<%-- 
    Document   : index
    Created on : Mar 20, 2022, 10:06:22 PM
    Author     : huynh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">TOUR LIST</h1>
<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(tourCounter/6)}" var="i">
        <c:url value="/" var="myAction">
            <c:param name="page" value="${i}" />
        </c:url>
        <li class="page-item"><a class="page-link" href="${myAction}">${i}</a></li>
        </c:forEach>
</ul>
<div class="row">

    <c:forEach items="${Tour}" var = "tour">
        <div class="col-md-4 col-sm-12" style="padding: 10px;">
            <div class="card">
                <img class="card-img-top" src="${tour.image}" alt="Card image" width="250" height="300">
                <div class="card-body">
                    <h4 class="card-title">${tour.name}</h4>
                    <p class="card-text">${tour.price}$</p>
                    <a href="<c:url value="/tours/${tour.id}" />" class="btn btn-primary">See Detail</a>
                    <a href="<c:url value="/tours/${tour.id}/booking" />" class="btn btn-danger">Booking Tour</a>
                    <br>                
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <a href="<c:url value = "/admin/${tour.id}/edit"/>" class="btn btn-danger" style="margin-top: 5px">Edit</a>
                        <a href="<c:url value = "/admin/${tour.id}/delete"/>" class="btn btn-danger" style="margin-top: 5px">Delete</a>
                    </c:if>
                </div>
            </div>
            <br>        
        </div>

    </c:forEach>
</div>
