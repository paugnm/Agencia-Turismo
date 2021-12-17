<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </head>
    <body>
        <%HttpSession miSession = request.getSession();
          String usua = (String) miSession.getAttribute("user");
          if (usua==null) {
              response.sendRedirect("login.jsp");
          } else {
        %>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Nombre usuario</th>
                    <th scope="col">Contraseña</th>
                    <th scope="col">Eliminar</th>
                    <th scope="col">Modificar</th>
                </tr>
            </thead>
            <tbody>

                <%  
                    Usuario usu = (Usuario) miSession.getAttribute("usuario");
                %>  

                <tr>   
                    <%String nombre = usu.getNombreUsu();%>
                    <td><%=nombre%> </td>

                    <%String contra = usu.getContrasenia();%>
                    <td><%=contra%> </td>

                    <%int id = usu.getId();%>
                    <td>
                        <form name="frmBorrarUsuario"  action="SvEliminarUsuario" method="POST">
                            <input type="hidden" name="id" value="<%=id%>">
                            <button type="submit" class="btn btn-danger">Borrar</button>
                        </form>
                    </td>

                    <td>
                        <form name="frmModificarUsuario"  action="SvModificarUsuario" method="POST">
                            <input type="hidden" name="id" value="<%=id%>">
                            <button type="submit" class="btn btn-primary">Modificar</button>
                        </form>
                    </td>                   
                </tr>        
            </tbody>
        </table>

        <a class="btn btn-secondary" href="index.jsp" role="button" style = "margin: 10px">Volver</a>
        <%}%>
    </body>
</html>
