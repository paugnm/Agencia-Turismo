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
        <title>Empleado</title>
    </head>

    <body>
        <%HttpSession miSession = request.getSession();
            String usu = (String) miSession.getAttribute("user");
            if (usu == null) {
                response.sendRedirect("login.jsp");
            } else {
        %>
        <h1>Nuevo cliente</h1>
        <form class="row g-3" action="SvCliente" method="POST">
            <div class="col-md-6">
                <label for="nombreCli" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombreCli" name="nombreCli">
            </div>
            <div class="col-md-6">
                <label for=apellidoCli"" class="form-label">Apellido</label>
                <input type="text" class="form-control" id="apellidoCli" name="apellidoCli">
            </div>
            <div class="col-md-6">
                <label for="direccion" class="form-label">Direccion</label>
                <input type="text" class="form-control" id="direccion" name="direccion">
            </div>
            <div class="col-md-6">
                <label for="dni" class="form-label">DNI</label>
                <input type="text" class="form-control" id="dni" name="dni">
            </div>
            <div class="col-md-6">
                <label for="fechaNac" class="form-label">Fecha de Nacimiento</label>
                <input type="Date" class="form-control" id="fechaNac" name="fechaNac">
            </div>
            <div class="col-md-6">
                <label for="nacionalidad" class="form-label">Nacionalidad</label>
                <input type="text" class="form-control" id="nacionalidad" name="nacionalidad">
            </div>
            <div class="col-md-6">
                <label for="celular" class="form-label">Celular</label>
                <input type="text" class="form-control" id="celular" name="celular">
            </div>
            <div class="col-md-6">
                <label for="email" class="form-label">Email</label>
                <input type="text" class="form-control" id="email" name="email">
            </div>
            <div class="col-6">
                <a href="index.jsp"  ><button type="button" class="btn btn-warning">Volver a inicio</button></a>
            </div>
            <div class="col-6">
                <button type="submit" class="btn btn-primary">Enviar</button>
            </div>

        </form>
        <%}%>
    </body>
</html>
