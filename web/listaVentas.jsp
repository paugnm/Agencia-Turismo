<%@page import="logica.Venta"%>
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
                <tr>
                    <th scope="col">Número</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Medio de pago</th>
                    <th scope="col">Empleado</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">Código servicio</th>
                    <th scope="col">Código de paquete</th>
                    <th scope="col">Eliminar</th>
                    <th scope="col">Modificar</th>
                </tr>
            </thead>

            <tbody>                
                <%  
                    List<Venta> listaVentas = (List) miSession.getAttribute("listaVentas");
                    for (Venta vent : listaVentas) {
                %>  

                <tr>   
                    <%int codigo = vent.getNumVenta();%>
                    <td><%=codigo%> </td>   
                    
                     <%
                        DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                        String fecha = formato.format(vent.getFechaVenta());%>
                    <td><%=fecha%></td>
          
                    <%String medioPago = vent.getMedioDePago();%>
                    <td><%=medioPago%> </td> 

                    <%String apeEmple = vent.getVendedor().getApellido();%>
                    <%String nombreEmple = vent.getVendedor().getNombre();%>
                    <td><%=nombreEmple%> <%=apeEmple%></td> 

                    <%String nombreCliente = vent.getComprador().getNombre(); String apeCliente = vent.getComprador().getApellido();%>
                    <td><%=nombreCliente%> <%=apeCliente%></td> 
                    
                    <%if (vent.getServicio()!= null) {%>
                        <td><%=vent.getServicio().getCodigo()%></td> 
                    <%} else {%>
                    <td>-</td>
                    <%}%>
                    <%if (vent.getPaquete()!= null) {%>
                    <td><%=vent.getPaquete().getCodigo()%></td> 
                    <%} else {%>
                    <td>-</td>
                    <%}%>
                    
                    <td>
                        <form name="frmBorrarVenta"  action="SvEliminarVenta" method="post">
                            <input type="hidden" name="codigo" value="<%=codigo%>">
                            <button type="submit" class="btn btn-danger">Borrar</button>
                        </form>
                    </td>

                    <td>
                        <form name="frmModificarVenta"  action="SvModificarVenta" method="post">
                            <input type="hidden" name="codigo" value="<%=codigo%>">
                            <button type="submit" class="btn btn-primary">Modificar</button>
                        </form>
                    </td>                   
                </tr>  
                <%}%>                
            </tbody>
        </table>

        <a class="btn btn-secondary" href="index.jsp" role="button" style = "margin: 10px">Volver</a>    
        <%}%>
    </body>
</html>

