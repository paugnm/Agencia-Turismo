<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="logica.Cliente"%>
<%@page import="java.util.List"%>
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
                    <th scope="col">Eliminar</th>
                    <th scope="col">Modificar</th>
                </tr>
            </thead>
            <tbody>

                <%     HttpSession miSession = request.getSession();
                    List<Cliente> listaClientes = (List) miSession.getAttribute("listaClientes");
                    for (Cliente cli : listaClientes) {
                %>  

                <tr>   
                    <%String nombre = cli.getNombre();%>
                    <td><%=nombre%> </td>

                    <%String ape = cli.getApellido();%>
                    <td><%=ape%> </td>

                    <%String direccion = cli.getDireccion();%>
                    <td><%=direccion%></td>

                    <%int dni = cli.getDni();%>
                    <td><%=dni%></td>

                    <%
                        DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                        String fecha = formato.format(cli.getFechaNacimiento());%>
                    <td><%=fecha%></td>

                    <%String nacion = cli.getNacionalidad();%>
                    <td><%=nacion%></td>

                    <%int celu = cli.getCelular();%>
                    <td><%=celu%></td>

                    <%String email = cli.getEmail();%>
                    <td><%=email%></td>

                    <%int id = cli.getId();%>
                    <td>
                        <form name="frmBorrarCliente"  action="SvEliminarCliente" method="POST">
                            <input type="hidden" name="id" value="<%=id%>">
                            <button type="submit" class="btn btn-danger">Borrar</button>
                        </form>
                    </td>

                    <td>
                        <form name="frmModificarCliente"  action="SvModificarCliente" method="POST">
                            <input type="hidden" name="id" value="<%=id%>">
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
