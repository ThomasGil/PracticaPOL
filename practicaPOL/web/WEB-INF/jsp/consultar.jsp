<%-- 
    Document   : consultar
    Created on : 30/05/2018, 06:49:30 PM
    Author     : Personal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <form:form modelAttribute="usuario" action="consulta">
                <form:label path="id"> origen </form:label>
                <form:input path="id" ytpe="number"/>
                
                <input type="submit" value="Consultar">
                </form:form>
        </div>
        <div>
            <table>
                <thead>
                    <tr>
                        <th> id </th>
                        <th> Fecha Nacimiento </th>
                        <th> Activo </th>
                        <th> Dependencia </th>
                        <th> Perfil </th>
                </thead>
                <tr>
                    <td>${usuarios.id}</td>
                    <td>${usuarios.fechaNacimiento}</td>
                    <td>${usuarios.activo}</td>
                    <td>${usuarios.dependencia}</td>
                    <td>
                        <c:forEach items="${usuarios.perfil}" var="perfil">
                            <p><c:out value="${perfil}"/></p>
                        </c:forEach> 
                    </td>

                </tr>
            </table>
        </div>
                    
                    <p> ${test} </p>
                    <p> ${test0} </p>
                    <p> ${test1} </p>
                    <p> ${test2} </p>
    </body>
</html>
