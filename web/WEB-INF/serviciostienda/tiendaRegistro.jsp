<%-- 
    Document   : tiendaRegistro
    Created on : 16/08/2020, 10:25:13 PM
    Author     : Hardwell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">        
        <title>Registrarse</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"></jsp:include>
        <div class="container">
            <form action="ProductoCtrl" method="POST">
                <h2 class="text-center">Regístrate!</h2>
                <input class="form-control mb-2" type="text" name="nombre" placeholder="Ingresa tu nombre..." required=""/>
                <input class="form-control mb-2" type="text" name="apellido" placeholder="Ingresa tu apellido..." required=""/>
                <input class="form-control mb-2" type="email" name="correo" placeholder="Ingresa tu correo..." required=""/>
                <input class="form-control mb-2" type="password" name="clave" placeholder="Ingresa tu contraseña..." required=""/>
                <input class="form-control mb-2" type="text" name="cedula" placeholder="Ingresa tu cédula..." required=""/>
                <input class="form-control mb-2" type="text" name="direccion" placeholder="Ingresa tu dirección..." required=""/>
                <input type="submit" class="btn btn-dark btn-block mb-2" name="accion" value="SignIn">
                <input type="submit" class="btn btn-warning btn-sm btn-block mb-2" name="accion" value="LogIn">
            </form>
        </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>
