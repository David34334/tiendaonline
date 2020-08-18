<%-- 
    Document   : index
    Created on : 16/08/2020, 11:14:50 PM
    Author     : Hardwell
--%>

<%@page import="java.util.List"%>
<%@page import="model.Producto"%>
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
            <h2>sdsdsd</h2>
        </div>
        
        <!--BTN COMPRAR-->
        <form action="ProductoCtrl" method="GET">
            <input type="submit" class="btn btn-dark" name="accion" value="Comprar" />
            <input type="submit" class="btn btn-warning" name="accion" value="VerCatalogo" />
        </form>
        
    </body>
</html>