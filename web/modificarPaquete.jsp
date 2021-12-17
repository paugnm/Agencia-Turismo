<%@page import="java.util.List"%>
<%@page import="logica.Paquete"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="logica.ServicioTuristico"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Modificar servicio</title>
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
          if (usu==null) {
              response.sendRedirect("login.jsp");
          } else {
        %>
        <h1>Modificar paquete</h1>

        <%   
               Paquete paquete = (Paquete) miSession.getAttribute("paquete");
               List<ServicioTuristico> listaServicios = (List) miSession.getAttribute("listaServicios");
               for (ServicioTuristico serv : listaServicios) {
        %> 
        <form class="row g-3" action="SvModificarPaquete" method="get">       

            <div class="col-md-12 form-check">                        
                
                <input type="checkbox" class="form-check-input" id="servicio" value="<%=serv.getCodigo()%>" name="selected"  <%=paquete.isChecked(serv.getCodigo())%>>
                <label class="form-check-label" for="servicio"><%=serv.getNombre()%> - <%=serv.getDescripcion()%></label>
            </div>
            <%}%>     
            <input type="hidden" name="codigo" value="<%=paquete.getCodigo()%>">
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
            
        </form>
        <%}%>    
    </body>
</html>
