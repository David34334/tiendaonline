<%-- 
    Document   : carroIndex
    Created on : 1/09/2020, 05:43:41 PM
    Author     : b_urb
--%>
<%@page import="java.util.List"%>
<%@page import="model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Confirmar Compra!</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"></jsp:include>
            <div class="container mt-3">
                <div class="card text-center">
                    <div class="card-header">
                        <h4>Resumen del Pedido!</h4>
                    </div>
                    <div class="card-body">
                        <form action="CarroCtrl" method="POST">
                        <input type="hidden" readonly="" class="form-control" name="idProducto" value="<c:out value="${producto.id}"></c:out>"/>
                        <input type="text" readonly="" class="form-control" name="nombreproducto" value="<c:out value="${producto.nombre}"></c:out>"/>
                        <img style="width:350px; height:250px;" class="card-img-top" alt="..." src="img/<c:out value="${producto.imagen}"></c:out>">
                        <input type="text" readonly="" class="form-control" name="descripproducto" value="<c:out value="${producto.descripcion}"></c:out>"/>
                        <input type="text" readonly="" class="form-control" name="precioproducto" value="<c:out value="${producto.precio}"></c:out>"/>
                        <label>Cantidad</label>
                        <input type="text" class="form-control" name="cantidad" value="1" />
                        <input type="hidden" readonly="" class="form-control" name="idUsuario" value="<c:out value="${user.id}"></c:out>"/>
                        <input type="submit" class="btn btn-dark btn-block" name="accion" value="Anadir"/>
                        </form>
                    </div>
                    <div class="card-footer text-muted">
                        Now
                    </div>
                </div>
            </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>