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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class = "container">
            <div class="row">
                <p>
                    <h2>Realizar o actualizar registro</h2>
                </p>
            </div>
            <div class="row">
                <p>Para realizar o actualizar su registro porfavor llene los siguientes campos </p>
            </div>
            <div class="row">
                <p style="color: red">${mensajeError}</p>
                <p style="color: green">${mensajeBien}</p>
            </div>
            <div class="row">
                <form:form modelAttribute="usuario" action="usuario.cu">
                    <div class="form-group">
                        <form:label path="id"> id </form:label>
                        <form:input path="id" type = "number" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <form:label path="fechaNacimiento"> Fecha de Nacimiento </form:label>
                        <form:input path="fechaNacimiento" type="Date" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <form:label path="activo"> Activo </form:label>          
                        <form:select path="activo" type = "bool" cssClass="form-control">
                            <option value="true"> activo </option>
                            <option value="false"> NO activo </option>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <form:label path="dependencia"> Dependencia </form:label>
                        <form:select path="dependencia" cssClass="form-control">                     
                                <c:forEach items="${dependencias}" var="dependencia">
                                    <option value="${dependencia}">${dependencia}</option>
                            </c:forEach>      
                            </form:select>
                    </div>
                    <div class="form-group">
                        <form:label path="perfil"> Perfil </form:label>
                        <form:select multiple="multiple" path="perfil" cssClass="form-control">                     
                                <c:forEach items="${Perfiles}" var="perfil">
                                <option value="${perfil}">${perfil}</option>
                                </c:forEach>      
                            </form:select>  
                    </div>
                    <div class="form-group">
                                <td colspan="2">
                                <input type="submit" name="action" value="registrar" class="btn btn-primary">
                                <input type="submit" name="action" value="actualizar" class="btn btn-primary">
                    </div>
                </form:form>
            </div>
            <div class="row">
                <p>
                    <a href="consultar" class="btn btn-link"> Ir a consultas</a>
                </p> 
            </div>
        </div>    
    </body>
</html>