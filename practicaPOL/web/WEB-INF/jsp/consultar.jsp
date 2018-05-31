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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <p><h2> Ingrese la cedula del usaurio a consultar o eliminar </h2></p>
            </div>
            <div class="row">
                <p style="color: red">${mensajeError}</p>
                <p style="color: green">${mensajeBien}</p>
            </div>
            <div class="row">
                    <form:form modelAttribute="usuario" action="usuario.rd">
                        <div class="form-group">
                                <form:label path="id"> Id </form:label>
                                <form:input path="id" ytpe="number"/>
                        </div>
                        <div class="form-group">
                                <td colspan="2">
                                    <input type="submit" name="action" value="consultar" class="btn btn-primary">
                                    <input type="submit" name="action" value="eliminar" class="btn btn-primary">
                        </div>                      
                    </form:form>

            </div>
            <div class="row">
                <table class="table">
                  <caption>Info Usuario</caption>
                  <thead>
                    <tr>
                      <th scope="col">id</th>
                      <th scope="col">Fecha Nacimiento</th>
                      <th scope="col">Activo</th>
                      <th scope="col">Dependencia</th>
                      <th scope="col">Perfil</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">${usuarios.id}</th>
                      <td>${usuarios.fechaNacimiento}</td>
                      <td>${usuarios.activo}</td>
                      <td>${usuarios.dependencia}</td>
                      <td>
                        <c:forEach items="${usuarios.perfil}" var="perfil">
                          <p><c:out value="${perfil}"/></p>
                        </c:forEach> 
                      </td>
                    </tr>
                  </tbody>
                </table>
            </div>
            <div class="row">
                    <p>
                        <a href="/practicaPOL" class="btn btn-link"> Ir a inicio</a>
                    </p> 
            </div>
        </div>
    </body>
</html>