<%-- 
    Document   : index
    Created on : 16/08/2020, 11:14:50 PM
    Author     : Hardwell
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <jsp:include page="WEB-INF/includes/header.jsp"></jsp:include>
        <!--IMG Banner-->
        <div class="img-banner">
            <h2>Tienda Online!</h2>
        </div>

        <!--BTN COMPRAR-->
        <div class="">
        <form action="ProductoCtrl" method="GET">
            <input type="submit" class="btn btn-dark btn-block" name="accion" value="Comprar" />                
            <input type="submit" class="btn btn-warning btn-block" name="accion" value="VerCatalogo" />
        </form>            
        </div>
    </body>
</html>