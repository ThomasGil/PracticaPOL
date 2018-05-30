<%-- 
    Document   : inicio
    Created on : 29/05/2018, 05:36:40 PM
    Author     : Personal
--%>
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
                <h2>Realizar registro</h2>
                <p>Para realizar su registro porfavor llene los siguientes campos </p>
                <p style="color: red">${mensajeError}</p>
                <p style="color: green">${mensajeBien}</p>
            </div>
            <div>
                <form:form modelAttribute="usuarios" action="registrar">
                <form:label path="id"> id </form:label>
                <form:input path="id" />
                <form:label path="fechaNacimiento"> Fecha de Nacimiento </form:label>
                <form:input path="fechaNacimiento" type="Date"/>

                <input type="submit" value="Registrar">
                </form:form>
            </div>
            <div>                       
				<input type="submit" name="action" value="Add" />
				<input type="submit" name="action" value="Edit" />
				<input type="submit" name="action" value="Delete" />
				<input type="submit" name="action" value="Search" />
            </div>
        </div>
    </body>
</html>
