<%@page import="logica.ServicioTuristico"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="logica.Paquete"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

        <title>Lista de paquetes</title>
    </head>
    <body>
        <%HttpSession miSession = request.getSession();
          String usu = (String) miSession.getAttribute("user");
          if (usu==null) {
              response.sendRedirect("login.jsp");
          } else {
        %>
        <table class="table table-striped">
            <thead>
                <!-- tr: table row, th: table header, td: table data-->
                <tr>
                    <th scope="col">Codigo de paquete</th>
                    <th scope="col">Servicios inclu?dos en el paquete</th>
                    <th scope="col">Costo</th>
                    <th scope="col">Borrar</th>
                    <th scope="col">Modificar</th>
                </tr>
            </thead>

            <tbody>                
                <% 
                    List<Paquete> listaPaquetes = (List) miSession.getAttribute("listaPaquetes");
                    for (Paquete paquete : listaPaquetes) {
                %>  

                <tr>   
                    <%int codigo = paquete.getCodigo();%>
                    <td><%=codigo%> </td>      
                    <td>
                        <table>
                            <%List<ServicioTuristico> servicios = paquete.getListaServiciosIncluidos();
                             for (ServicioTuristico ser : servicios) {
                            %>
                            <tr>
                                <td>
                                    <b>Servicio:</b> <%=ser.getNombre()%>   -   <b>Detalle:</b> <%=ser.getDescripcion()%>                                     
                                <%}%>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td>$<%=paquete.getCosto()%></td>


                    <td>
                        <form name="frmBorrarPaquete"  action="SvEliminarPaquete" method="post">
                            <input type="hidden" name="codigo" value="<%=codigo%>">
                            <button type="submit" class="btn btn-danger">Borrar</button>
                        </form>
                    </td>

                    <td>
                        <form name="frmModificarPaquete"  action="SvModificarPaquete" method="post">
                            <input type="hidden" name="codigo" value="<%=codigo%>">
                            <button type="submit" class="btn btn-primary">Modificar</button>
                        </form>
                    </td>                   
                </tr>  
                <%}%>                
            </tbody>
        </table>

        <div class="col-6">
            <a href="index.jsp"  ><button type="button" class="btn btn-warning">Volver a inicio</button></a>
        </div>
        <%}%>
    </body>
</html>
