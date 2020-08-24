<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Login Usuario</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"></jsp:include>
        <div class="container">
            <form action="ProductoCtrl" method="POST">
                <h2 class="text-center">Iniciar Sesión!</h2>
                <input class="form-control mb-2" type="text" placeholder="Ingresa tu correo..." />
                <input class="form-control mb-2" type="text" placeholder="Ingresa tu contraseña..." />
                <input type="submit" class="btn btn-dark btn-block mb-2" name="accion" value="LogIn">
                <input type="submit" class="btn btn-warning btn-sm btn-block mb-2" name="accion" value="SignIn">
            </form>
        </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>
