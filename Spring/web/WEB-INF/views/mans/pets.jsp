

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <title>JSP Page</title>
    </head>
    <body>
        <div class="main">
            <h1 class="title">Список </h1>
            <table class="data_table">
                <tr>
                    <th>Name</th>
                
                    <th>Date Birth</th>
                   
                    
                </tr>
                <c:forEach var="man" items="${mans}">
                    <tr>
                        <td>${man.name}</td>
                     
                        <td>${man.birth}</td>
                       
                        <td><a href="<c:url value="${man.id}"/>">View all</a></td>
                        <td><a href="<c:url value="${man.id}/edit"/>">Edit</a></td>
                        <td><a href="<c:url value="${man.id}/delete"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
            <a class="button" href="<c:url value="/add"/>">Add new man</a>
        </div>
    </body>
</html>
