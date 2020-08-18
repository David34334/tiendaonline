<%@page import="java.util.List"%>
<%@page import="model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            List<Producto> productos = (List<Producto>) request.getAttribute("productos");
        %>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Tienda Online!</title>
    </head>
    <body>
        <!--Productos-->
        <form action="ProductoCtrl" method="GET">
            <div class="container">
                <div class="row">
                    <%for (Producto producto : productos) {%>
                    <div class="card mx-2 mb-4" style="width: 14rem;">
                        <img class="card-img-top" alt="..." src=<%=producto.getUrlPhotoProducto()%>>
                        <div class="card-body">
                            <h5 class="card-title"><%=producto.getNombreProducto()%></h5>
                            <p class="card-text"><%=producto.getDescripProducto()%></p>
                            <p class="card-text">$<%=producto.getPrecioProducto()%> COP</p>
                            <input type="submit" class="btn btn-dark" name="accion" value="Comprar" />
                        </div>
                    </div>
                    <%}%>
                </div>
            </div>
        </form>
    </body>
</html>
