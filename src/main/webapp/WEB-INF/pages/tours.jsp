<%-- 
    Document   : tour
    Created on : 09-Apr-2022, 12:00:46 am
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="controller">
    <h1 class="text-center text-danger">TOUR MANAGEMENT</h1>

    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>
    <form:form method="post" action="" modelAttribute="Tour" enctype="multipart/form-data" >
        <div class="form-group">
            Name: <form:input path="name" class="form-control" />
        </div>
        <div class="form-group">
            Price: <form:input path="price" class="form-control" />
        </div>
        <div class="form-group">
            Description: <form:textarea path="description" class="form-control" />
        </div>
        <div class="form-group">
            Image: <form:input type="file" path="multipartFile" class="form-control" id="img" name="img" accept="image/*" />
        </div>
        <input type="submit" value="Add Tour" class="btn btn-success" />
    </form:form>
</div>
<br><br>


