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
    <h1>Modificar servicio</h1>
    <form class="row g-3" action="SvModificarServicio" method="get">
        
        <% 
           ServicioTuristico servi = (ServicioTuristico) miSession.getAttribute("servicio");
        {%>
        
        <div class="col-md-6">
          <label for="nombreServicio" class="form-label">Nombre</label>
          <input type="text" class="form-control" id="nombreServicio" name="nombreServicio" value="<%=servi.getNombre()%>">
        </div>
        <div class="col-md-6">
          <label for="destino" class="form-label">Destino</label>
          <input type="text" class="form-control" id="destino" name="destino" value="<%=servi.getDestino()%>">
        </div>
        <div class="col-6">
          <label for="descripcionServicio" class="form-label">Descripción</label>
          <input type="text" class="form-control" id="descripcionServicio" name="descripcion" value="<%=servi.getDescripcion()%>">
        </div>
        <div class="col-6">
          <label for="costo" class="form-label">Costo $</label>
          <input type="text" class="form-control" id="costo" name="costo" value="<%=servi.getCosto()%>">
        </div>
        <div class="col-12">
          <label for="fechaServicio" class="form-label">Fecha</label>
          
          <%
              Date fecha = servi.getFecha();
              DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
              String strFecha = formato.format(fecha);
          %>
          <input type="date" class="form-control" id="fechaServicio" name="fecha" value="<%=strFecha%>">
        </div>
        
        <input type="hidden" value="<%=servi.getCodigo()%>" name="codigo">
        
        <div class="col-12">
          <button type="submit" class="btn btn-primary">Enviar</button>
        </div>
        <%}%>      
      </form>
    
      <a class="btn btn-secondary" href="index.jsp" role="button" style = "margin: 10px">Volver</a>
      <%}%>
</body>
</html>
