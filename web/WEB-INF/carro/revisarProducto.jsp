<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Pagar Producto!</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"></jsp:include>
            <h1 class="text-center">Productos!</h1>
            <div class="container">
                <form action="CarroCtrl" method="POST">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Nombre</th>
                                <th scope="col">Precio</th>
                                <th scope="col">Cantidad</th>
                                <th scope="col">Total</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${productos}" var="producto">
                            <tr>
                                <th scope="row"><c:out value="${producto.nombre}"></c:out></th>
                                <td><c:out value="${producto.precio}"></c:out></td>
                                <td><c:out value="${producto.cantidad}"></c:out></td>
                                <td><c:out value="${(producto.precio) * producto.cantidad}"></c:out></td>
                                </tr>
                        </c:forEach>  

                    </tbody>
                </table>
                <h2>Datos del Destinatario:</h2>
                <input type="hidden" readonly="" class="form-control" name="idUsuario" value="<c:out value="${user.id}"></c:out>"/>
                <input type="text" readonly="" class="form-control" name="nombre" value="<c:out value="${user.nombre}"></c:out>"/>
                <input type="text" readonly="" class="form-control" name="correo" value="<c:out value="${user.correo}"></c:out>"/>
                <input type="text" readonly="" class="form-control" name="direccion" value="<c:out value="${user.direccion}"></c:out>"/>
                <input type="number" readonly="" class="form-control" name="total" value="<c:out value="${total}"></c:out>"/>
                    <input type="submit" class="btn btn-dark btn-block" name="accion" value="Volver" />
                </form>
            </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>
