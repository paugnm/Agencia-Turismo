<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@page import="logica.Venta"%>
<%@page import="logica.Paquete"%>
<%@page import="logica.ServicioTuristico"%>
<%@page import="logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <title>Modificar venta</title>
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
        <h1>Modificar venta</h1>

        <% 
            Venta venta = (Venta) miSession.getAttribute("venta");
            List<Empleado> listaEmpleados = (List) miSession.getAttribute("listaEmpleados");
            List<ServicioTuristico> listaServicios = (List) miSession.getAttribute("listaServicios");
            List<Paquete> listaPaquetes = (List) miSession.getAttribute("listaPaquetes");
        %>

        <form class="row g-3" action="SvModificarVenta" method="get">
            <div class="col-12">
                <label for="fechaVenta" class="form-label">Fecha</label>
                <%
                    Date fecha = venta.getFechaVenta();
                    DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    String strFecha = formato.format(fecha);
                %>
                <input type="date" class="form-control" id="fechaServicio" name="fecha" value="<%=strFecha%>">


            </div>
            <div class="col-md-6">
                <select class="form-select" aria-label="Default select example" name="medioDePago">
                    <option selected><%=venta.getMedioDePago()%></option>
                    <option value="Efectivo">Efectivo</option>
                    <option value="Tarjeta de débito">Tarjeta de débito</option>
                    <option value="Tarjeta de crédito">Tarjeta de crédito</option>
                </select>
            </div>
            <div class="col-md-6">

                <input type="text" class="form-control" placeholder=<%=venta.getComprador().getDni()%> name="dniCliente">
            </div>


            <div class="col-6">
                <select class="form-select" aria-label="Default select example" name="empleado">
                    <option value="<%=venta.getVendedor().getId()%>"><%=venta.getVendedor().getNombre()%> <%=venta.getVendedor().getApellido()%></option>
                    <%for (Empleado emple : listaEmpleados) {%>
                    <option value="<%=emple.getId()%>"><%=emple.getNombre()%> <%=emple.getApellido()%></option>
                    <%}%>
                </select>
            </div>     

            <div class="col-6">
                <select class="form-select" aria-label="Default select example" name="paquete">
                    <option selected><%=venta.getPaquete().getCodigo()%></option>
                    <%for (Paquete paque : listaPaquetes) {%>
                    <option value="<%=paque.getCodigo()%>"><%=paque.getCodigo()%> - <%=paque.getCosto()%></option>
                    <%}%>
                </select>
            </div>       

            <div class="col-6">
                <select class="form-select" aria-label="Default select example" name="servicio">
                    <option selected><%=venta.getServicio().getCodigo()%></option>
                    <%for (ServicioTuristico ser : listaServicios) {%>
                    <option value="<%=ser.getCodigo()%>"><%=ser.getCodigo()%></option>
                    <%}%>
                </select>
            </div>

           <input type="hidden" value="<%=venta.getNumVenta()%>" name="codigo">
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
        </form>
        <%}%>    
    </body>
</html>

