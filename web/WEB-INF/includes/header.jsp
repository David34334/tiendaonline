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
          <button class="btn btn-dark my-2 my-sm-0" type="submit" name="accion" value="Registarse">Registrarse</button>
          <button class="btn btn-dark my-2 my-sm-0" type="submit" name="accion" value="Iniciar Sesion">Iniciar Sesion</button>
    </form>
  </div>
</nav>