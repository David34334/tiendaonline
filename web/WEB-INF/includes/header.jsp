<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    HttpSession objsesion = request.getSession(false);
    String usuario = (String) objsesion.getAttribute("usuario");
%>
<!--Navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">TiendaOnline</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Compras</a>
            </li>
        </ul>
        <form action="UsuarioCtrl" method="GET" class="form-inline my-2 my-lg-0">
            <%if(usuario != null) {%>
            <button class="btn btn-dark my-2 my-sm-0" type="submit" name="accion" value="Mis Compras">Mis Compras</button>
            <button class="btn btn-dark my-2 my-sm-0" type="submit" name="accion" value="Editar Datos">Editar Datos</button>
            <button class="btn btn-dark my-2 my-sm-0" type="submit" name="accion" value="Cerrar Sesion">Cerrar Sesion</button>
            <%} else {%>
            <button class="btn btn-dark my-2 my-sm-0" type="submit" name="accion" value="Registarse">Registrarse</button>
            <button class="btn btn-dark my-2 my-sm-0" type="submit" name="accion" value="Iniciar Sesion">Iniciar Sesion</button>
            <%}%>
        </form>
    </div>
</nav>