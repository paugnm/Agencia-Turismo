<%@page import="logica.Usuario"%>
<%@page import="logica.Empleado"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>        
        <style>
            body {
                margin-top: 5%;
                margin-left:20%;
                margin-right: 20%;
            }
            h1 {
                padding-bottom: 20px;
            }
        </style>
        <title>Modificar usuario</title>
    </head>

    <body>
        <%HttpSession miSession = request.getSession();
            String usu = (String) miSession.getAttribute("user");
            if (usu == null) {
                response.sendRedirect("login.jsp");
            } else {
        %>
        <h1>Modificar usuario</h1>
        <%
            Usuario usuario = (Usuario) miSession.getAttribute("usuario");%>
        <form class="row g-3" action="SvModificarUsuario" method="GET">
            <div class="col-md-6">
                <label for=nombre"" class="form-label">Usuario</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="<%=usuario.getNombreUsu()%>">
            </div>
            <div class="col-md-6">
                <label for=contrasenia"" class="form-label">Contraseña</label>
                <input type="password" class="form-control" id="contrasenia" name="contrasenia" value="<%=usuario.getContrasenia()%>">
            </div> 
            <input style="display: none"; value="<%=usuario.getId()%>" name="id">


            <div class="col-6">
                <a class="btn btn-warning" href="listaEmpleados.jsp" role="button">Volver</a>
            </div>
            <div class="col-6">
                <button type="submit" class="btn btn-primary">Enviar</button>
            </div>

        </form>
        <%}%>    
    </body>
</html>
