<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Editar Producto!</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"></jsp:include>
            <h1 class="text-center text-dark">Editar Producto!</h1>
            <form action="ProductoCtrl" method="POST">
                <table class="table table-striped table-bordered table-hover">

                <tr>
                    <td>ID</td>
                    <td><input class="form-control" type="number" name="id" value="<c:out value="${producto.id}"></c:out>" readonly=""/></td>
                </tr>
                <tr>
                    <td>NOMBRE</td>
                    <td><input class="form-control" type="text" name="nombre" value="<c:out value="${producto.nombre}"></c:out>"/></td>
                </tr>
                <tr>
                    <td>APELLIDO</td>
                    <td><input class="form-control" type="text" name="descripcion" value="<c:out value="${producto.descripcion}"></c:out>"/></td>
                </tr>
                <tr>
                    <td>Descripcion</td>
                    <td><input class="form-control" type="text" name="precio" value="<c:out value="${producto.precio}"></c:out>"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="accion" value="Editar" class="btn btn-warning btn-block" /></td>
                </tr>

            </table>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
        </form>
    </body>
</html>
