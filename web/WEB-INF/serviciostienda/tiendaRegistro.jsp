<%-- 
    Document   : tiendaRegistro
    Created on : 16/08/2020, 10:25:13 PM
    Author     : Hardwell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">        
        <title>Registrarse</title>
    </head>
    <body>
        <div class="container">
            <form action="ProductoCtrl" method="POST">
                <h2 class="text-center">Registrate!</h2>
                <input class="form-control mb-2" type="text" placeholder="Ingresa tu nombre de usuario..." />
                <input class="form-control mb-2" type="text" placeholder="Ingresa tu correo..." />
                <input class="form-control mb-2" type="text" placeholder="Ingresa tu contraseña..." />
                <input type="submit" class="btn btn-dark btn-block mb-2" name="accion" value="SignIn">
                <input type="submit" class="btn btn-warning btn-sm btn-block mb-2" name="accion" value="LogIn">
            </form>
        </div>
    </body>
</html>
