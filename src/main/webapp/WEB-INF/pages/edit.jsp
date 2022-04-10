<%-- 
    Document   : edit
    Created on : Apr 7, 2022, 6:52:49 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
        <link href="<c:url value="/css/style.css" />" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="controller">
            <h1>Edit</h1>
            <c:if test="${errMsg != null}">
                <div class="alert alert-danger">
                    ${errMsg}
                </div>
            </c:if>

            <c:url value="/admin/${tour.id}/edit" var="edit" />
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
                <input type="submit" value="Edit" class="btn btn-success" />
            </form:form>
        </div> 
        <br><br>
    </body>
</html>



