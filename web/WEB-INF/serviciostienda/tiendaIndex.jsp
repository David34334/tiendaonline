<%@page import="java.util.List"%>
<%@page import="model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            HttpSession objsesion = request.getSession(false);
            String usuario = (String)objsesion.getAttribute("usuario");
        %>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Tienda Online!</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"></jsp:include>
            <!--Productos-->
            <h4>Bienvenido <c:out value="${usuario}"></c:out> !</h4>
            <h2 class="text-center text-dark">Nuestros Productos!</h2>
            <form action="ProductoCtrl" method="GET">
                <div class="container">
                    <div class="row">
                    <c:forEach items="${productos}" var="producto">
                    <div class="card mx-2 mb-4" style="width: 13rem;">
                        <img class="card-img-top" alt="..." src="img/<c:out value="${producto.imagen}"></c:out>">
                        <hr/>
                        <div class="card-body">
                            <h5 class="card-title"><c:out value="${producto.nombre}"></c:out></h5>
                            <p class="card-text"><c:out value="${producto.descripcion}"></c:out></p>
                            <p class="card-text"><c:out value="${producto.precio}"></c:out> COP</p>
                            <input type="submit" class="btn btn-dark" name="accion" value="Comprar" />
                        </div>
                    </div>
                    </c:forEach>        
                </div>
            </div>
        </form>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>
