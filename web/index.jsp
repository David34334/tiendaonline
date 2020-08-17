<%-- 
    Document   : index
    Created on : 16/08/2020, 11:14:50 PM
    Author     : Hardwell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tienda Online</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    </head>
    <body>
        <!--Navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">TiendaOnline</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Compras</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">IniciarSesión</a>
                    </li>
                </ul>
            </div>
        </nav>

        <!--IMG Banner-->
        <div class="img-banner">

        </div>

        <!--Productos-->
        <form action="ProductoCtrl" method="GET">
            <div class="container">
                <div class="card" style="width: 18rem;">
                    <img src="img/producto1.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Nombre Producto</h5>
                        <p class="card-text">Descripcion Producto.</p>
                        <input type="submit" class="btn btn-dark" name="accion" value="Comprar" />
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>