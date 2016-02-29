
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>View the pet</title>
    </head>
    <body>
        <div class="main">
            <h1 class="title">About the man</h1>
            <p>The man <b>${man.name}</b> is a man and this man was born in <b>${man.birth}</b> </p>
            <a class="button" href="<c:url value="/man/mans"/>">Return to main page</a>
        </div>
    </body>
</html>
