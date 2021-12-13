<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="logica.ServicioTuristico"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

        <title>Lista de servicios</title>
    </head>
    <body>

        <table class="table table-striped">
            <thead>
                <!-- tr: table row, th: table header, td: table data-->
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Descripción</th>
                    <th scope="col">Destino</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Costo</th>
                    <th scope="col">Eliminar</th>
                    <th scope="col">Modificar</th>
                </tr>
            </thead>
            <tbody>
                
                <%     HttpSession miSession = request.getSession();
                       List<ServicioTuristico> listaServicios = (List) miSession.getAttribute("listaServicios");
                       for (ServicioTuristico serv : listaServicios) { 
                %>  
                
                <tr>   
                    <%String nombreServicio = serv.getNombre();%>
                    <td><%=nombreServicio%> </td>
                    
                    <%String descrip = serv.getDescripcion();%>
                    <td><%=descrip%></td>
                    
                    <%String destino = serv.getDestino();%>
                    <td><%=destino%></td>
                    
                    <%
                        DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                        String fecha = formato.format(serv.getFecha());%>
                    <td><%=fecha%></td>
                    
                    <%double costo = serv.getCosto();%>
                    <td><%=costo%></td>
                    
                    <%int codigoServicio = serv.getCodigo();%>
                    
                    <td>
                        <form name="frmBorrarServicio"  action="SvEliminarServicio" method="post">
                            <input type="hidden" name="codigoServicio" value="<%=codigoServicio%>">
                            <button type="submit" class="btn btn-danger">Borrar</button>
                        </form>
                    </td>
                    
                    <td>
                        <form name="frmModificarServicio"  action="SvModificarServicio" method="post">
                            <input type="hidden" name="codigoServicio" value="<%=codigoServicio%>">
                            <button type="submit" class="btn btn-primary">Modificar</button>
                        </form>
                    </td>                   
                </tr>
                <%}%>                
            </tbody>
        </table>

        <a class="btn btn-secondary" href="index.jsp" role="button" style = "margin: 10px">Volver</a>    
    </body>
</html>
