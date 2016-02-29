

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <title>${title}</title>
    </head>
    <body>
        <div class="main">
            <h1 class="title">${title}</h1> 
            <form action="<c:url value="${sendURL}"/>" method="POST">
                <c:if test="${man.id != null}">
                    <input type="hidden" name="id" value="${man.id}"/>
                </c:if>
                <table class="table_form"> 
                    <tr>
                        <td><label for="temp">Name</label></td>
                        <td><input id="name" name="name" type="text" value="${man.name}"/></td>
                    </tr>                  
                    <tr>
                        <td><label for="birth">Date Birth</label></td>
                        <td><input id="birth" name="birth" type="text" value="${man.birth}"/></td>
                    </tr>              
                    <tr>
                        <td colspan="2"><input type="submit" value="Save"/></td>
                    </tr>
                </table>
            </form>
            <a class="button" href="<c:url value="/man/mans"/>">Return to main page</a>
        </div>
    </body>
</html>
