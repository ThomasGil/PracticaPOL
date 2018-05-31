<%-- 
    Document   : filas
    Created on : 30/05/2018, 06:45:34 PM
    Author     : Personal
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>          
            <div>
                <form:form modelAttribute="tarea" action="agregar">
                    
                    <form:label path="id"> Tareas </form:label>
                        <form:select path="id">                     
                            <c:forEach items="${tareas}" var="tarea">
                                    <option value="${tarea.id}">${tarea.nombre}</option>
                            </c:forEach>      
                        </form:select>
                                   
                    
                    <input type="submit" value="Agregar">
                </form:form>
            </div>
            <div>
                <p>${test}</p>
                <p style="visibility: hidden">${id}</p>
            </div>
    </body>
</html>
