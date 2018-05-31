<%-- 
    Document   : inicio
    Created on : 29/05/2018, 05:36:40 PM
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
        <div class = "contenedor">
            <div>
                <h2>Realizar o actualizar registro</h2>
                <p>Para realizar o actualizar su registro porfavor llene los siguientes campos </p>
                <p style="color: red">${mensajeError}</p>
                <p style="color: green">${mensajeBien}</p>
            </div>
            <div>
                <form:form modelAttribute="usuario" action="usuario.cu">
                <table>
                    <tr>
                        <td><form:label path="id"> id </form:label></td>
                        <td><form:input path="id" type = "number"/></td>
                    </tr>
                        <td><form:label path="fechaNacimiento"> Fecha de Nacimiento </form:label></td>
                        <td><form:input path="fechaNacimiento" type="Date"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="activo"> Activo </form:label></td>
                        <td>
                            <form:select path="activo" type = "bool">
                            <option value="true"> activo </option>
                            <option value="false"> NO activo </option>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="dependencia"> Dependencia </form:label></td>
                        <td><form:select path="dependencia">                     
                                <c:forEach items="${dependencias}" var="dependencia">
                                    <option value="${dependencia}">${dependencia}</option>
                            </c:forEach>      
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="perfil"> Perfil </form:label></td>
                        <td><form:select multiple="multiple" path="perfil">                     
                                <c:forEach items="${Perfiles}" var="perfil">
                                <option value="${perfil}">${perfil}</option>
                                </c:forEach>      
                            </form:select>  
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                                <input type="submit" name="action" value="registrar">
                                <input type="submit" name="action" value="actualizar">
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </body>
</html>
