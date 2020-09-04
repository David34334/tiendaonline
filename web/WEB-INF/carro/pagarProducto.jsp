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
        <h1 class="text-center">Paga tu(s) Productos!</h1>
        <div class="container">
            <form>
            <ul class="list-group">
                <li class="list-group-item disabled" aria-disabled="true"><c:out value="${producto.nombre}"></c:out></li>
                <li class="list-group-item"><c:out value="${producto.descripcion}"></c:out></li>
                <li class="list-group-item"><c:out value="${cantidad}"></c:out></li>
                <li class="list-group-item"><c:out value="${producto.precio}"></c:out></li>
                <li class="list-group-item"><c:out value="${(producto.precio) * cantidad}"></c:out></li>
                <input type="submit" class="btn btn-dark btn-block" name="accion" value="Pagar" />
            </ul>
            </form>
        </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>
