<%@page import="java.util.List"%>
<%@page import="logica.ServicioTuristico"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>        

        <title>Paquete</title>
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
    </head>
    <body>
        <%HttpSession miSession = request.getSession();
            String usu = (String) miSession.getAttribute("user");
            if (usu == null) {
                response.sendRedirect("login.jsp");
            } else {
        %>
        <h1>Nuevo paquete</h1>
        <p>Seleccione los serviocios que desea incluir en el nuevo paquete.</p>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">Nombre del servicio</th>
                    <th scope="col">Descripción del servicio</th>
                </tr>
            </thead>
            <tbody>
                <%     List<ServicioTuristico> listaServicios = (List) miSession.getAttribute("listaServicios");
                    for (ServicioTuristico serv : listaServicios) {
                %> 

            <form class="row g-3" action="SvPaquete" method="POST">
                <tr>
                    <td>   
                        <div class="col-md-12 form-check">
                            <input type="checkbox" class="form-check-input" id="servicio" value="<%=serv.getCodigo()%>" name="selected">
                        </div>
                    </td> 
                    <td><%=serv.getNombre()%></td>
                    <td><%=serv.getDescripcion()%></td>
                </tr>
                <%}%> 
                </tbody>
        </table>
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
