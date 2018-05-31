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
                <p style="color: red">${mensajeError}</p>
                <p style="color: green">${mensajeBien}</p>
        </div>
        <div>
                <form:form modelAttribute="usuario" action="usuario.rd">
                    <table>
                        <tr>
                            <td><form:label path="id"> Id </form:label></td>
                            <td><form:input path="id" ytpe="number"/></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" name="action" value="consultar">
                                <input type="submit" name="action" value="eliminar">
                            </td>
                        </tr>
                    </table>
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
    </body>
</html>
