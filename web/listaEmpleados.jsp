<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="logica.Empleado"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="es">
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

        <title>Lista de empleados</title>
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
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Direccion</th>
                    <th scope="col">DNI</th>
                    <th scope="col">Fecha de nacimiento</th>
                    <th scope="col">Nacionalidad</th>
                    <th scope="col">Celular</th>
                    <th scope="col">Email</th>
                    <th scope="col">Cargo</th>
                    <th scope="col">Sueldo</th>
                    <th scope="col">Usuario</th>
                    <th scope="col">Eliminar</th>
                    <th scope="col">Modificar</th>                    
                </tr>
            </thead>
            <tbody>
                
                <%   
                       List<Empleado> listaEmpleados = (List) miSession.getAttribute("listaEmpleados");
                       for (Empleado emple : listaEmpleados) { 
                %>  
                
                <tr>   
                    <%String nombre = emple.getNombre();%>
                    <td><%=nombre%> </td>
                    
                    <%String ape = emple.getApellido();%>
                    <td><%=ape%> </td>
                    
                    <%String direccion = emple.getDireccion();%>
                    <td><%=direccion%></td>
                    
                    <%int dni = emple.getDni();%>
                    <td><%=dni%></td>
                    
                    <%
                        DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                        String fecha = formato.format(emple.getFechaNacimiento());%>
                    <td><%=fecha%></td>
                    
                    <%String nacion = emple.getNacionalidad();%>
                    <td><%=nacion%></td>
                    
                     <%int celu = emple.getCelular();%>
                    <td><%=celu%></td>
                    
                     <%String email = emple.getEmail();%>
                    <td><%=email%></td>
                    
                     <%String cargo = emple.getCargo();%>
                    <td><%=cargo%></td>
                    
                     <%double sueldo = emple.getSueldo();%>
                    <td><%=sueldo%></td>
                    
                    <%int idUsuario = emple.getUsuario().getId();%>
                    <td>
                        <form name="frmUsuario"  action="SvConsultarUsuario" method="GET">
                            <input type="hidden" name="idUsuario" value="<%=idUsuario%>">
                            <button type="submit" class="btn btn-danger">Ver usuario</button>
                        </form>
                    </td>
                    
                    <%int id = emple.getId();%>
                    <td>
                        <form name="frmBorrarEmpleado"  action="SvEliminarEmpleado" method="POST">
                            <input type="hidden" name="id" value="<%=id%>">
                            <button type="submit" class="btn btn-danger">Borrar</button>
                        </form>
                    </td>
                    
                    <td>
                        <form name="frmModificarEmpleado"  action="SvModificarEmpleado" method="POST">
                            <input type="hidden" name="id" value="<%=id%>">
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
