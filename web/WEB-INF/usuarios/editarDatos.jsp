<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <%
            HttpSession objsesion = request.getSession(false);
            String usuario = (String) objsesion.getAttribute("usuario");
        %>
        <title>Editar Datos</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"></jsp:include>
            <h1 class="text-center text-dark">Edita tus Datos!</h1>
            <form action="UsuarioCtrl" method="POST">
                <table class="table table-striped table-bordered table-hover">

                <tr>
                    <td>ID</td>
                    <td><input class="form-control" type="number" name="id" value="<c:out value="${id}"></c:out>" readonly=""/></td>
                </tr>
                <tr>
                    <td>NOMBRE</td>
                    <td><input class="form-control" type="text" name="nombre" value="<c:out value="${usuario.nombre}"></c:out>"/></td>
                </tr>
                <tr>
                    <td>APELLIDO</td>
                    <td><input class="form-control" type="text" name="apellido" value="<c:out value="${usuario.apellido}"></c:out>"/></td>
                </tr>
                <tr>
                    <td>DIRECCION</td>
                    <td><input class="form-control" type="text" name="direccion" value="<c:out value="${usuario.direccion}"></c:out>"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="accion" value="Editar" class="btn btn-warning btn-block" /></td>
                </tr>

            </table>
            <jsp:include page="../includes/footer.jsp"></jsp:include>
        </form>
    </body>
</html>
