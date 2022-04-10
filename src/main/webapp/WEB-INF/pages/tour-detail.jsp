<%-- 
    Document   : tour-detail
    Created on : 09-Apr-2022, 6:54:05 am
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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