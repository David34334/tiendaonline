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
            String usuario = (String) objsesion.getAttribute("usuario");
        %>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Tienda Online!</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"></jsp:include>
            <!--Productos-->
        <%if (usuario != null) {%>
        <h4>Historial de tus compras <c:out value="${usuario.nombre}"></c:out> !</h4>
        <%}%>
        <h2 class="text-center text-dark">Artículos que Compraste!</h2>
        <div class="container">
            <div class="row">

                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">id</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Accion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${carros}" var="carro">
                            <tr>
                                <th scope="row"><c:out value="${carro.id}"></c:out></th>
                                    <td><c:out value="${carro.precio}"></c:out></td>
                                    <td><c:out value="${carro.estado}"></c:out></td>
                                    <td>
                                        <form action="UsuarioCtrl" method="POST">
                                            <input hidden class="btn btn-dark btn-block"  name="id_carro" value="<c:out value="${carro.id}"></c:out>"/>
                                            <input class="btn btn-dark btn-block" type="submit" name="accion" value="Ver"/>
                                        </form>
                                    </td>
                                </tr>
                        </c:forEach>  
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>
