
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Delete man</title>
    </head>
    <body>
        <div class="main">
            <h1 class="title">Delete the choosen man</h1>
            <form action="<c:url value="/man/deleteConfirm"/>" method="POST">
                <p>You really want to delete the man?</p>
                <input type="hidden" name="id" value="${man.id}"/>
                <input type="submit" value="Delete"/>
            </form>
            <a class="button" href="<c:url value="/man/mans"/>">Return to main page</a>
        </div>
    </body>
</html>
