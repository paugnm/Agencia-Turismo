<%@page import="logica.Cliente"%>
<%@page import="logica.Paquete"%>
<%@page import="logica.ServicioTuristico"%>
<%@page import="logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>

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

        <title>Ventas</title>
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
        <h1>Nueva venta</h1>
        <%
            List<Empleado> listaEmpleados = (List) miSession.getAttribute("empleados");
            List<Cliente> listaClientes = (List) miSession.getAttribute("clientes");
            List<ServicioTuristico> listaServicios = (List) miSession.getAttribute("servicios");
            List<Paquete> listaPaquetes = (List) miSession.getAttribute("paquetes");
            System.out.println(listaServicios.size());
        %>

        <form class="row g-3" action="SvVenta" method="POST">
            <div class="col-12">
                <label for="fechaVenta" class="form-label">Fecha</label>
                <input type="date" class="form-control" id="fechaVenta" name="fecha">
            </div>
            <div class="col-md-12">
                <select class="form-select" aria-label="Default select example" name="medioDePago">
                    <option selected>Seleccione una forma de pago</option>
                    <option value="Efectivo">Efectivo</option>
                    <option value="Tarjeta de débito">Tarjeta de débito</option>
                    <option value="Tarjeta de crédito">Tarjeta de crédito</option>
                </select>
            </div>

            <div class="col-6">
                <label for="cli">Cliente</label>
                <select id="cli" class="form-select" aria-label="Default select example" name="idCliente">
                    <option selected>Cliente</option>
                    <%for (Cliente cli : listaClientes) {%>
                    <option value="<%=cli.getId()%>"><%=cli.getNombre()%> <%=cli.getApellido()%></option>
                    <%}%>
                </select>
            </div>

            <div class="col-6">
                <label for="emple">Empleado</label>
                <select id="emple" class="form-select" aria-label="Default select example" name="empleado">
                    <option selected>Empleado a cargo de la venta</option>
                    <%for (Empleado emple : listaEmpleados) {%>
                    <option value="<%=emple.getId()%>"><%=emple.getNombre()%> <%=emple.getApellido()%></option>
                    <%}%>
                </select>
            </div>



            <div class="col-12">
                <input class="form-check-input" type="radio" name="tipoDeCompra" id="btnPaquete" onclick="display()">
                <label class="form-check-label" for="btnPaquete">
                    Paquete
                </label>
                <input class="form-check-input" type="radio" name="tipoDeCompra" id="btnServicio" onclick="display()">
                <label class="form-check-label" for="btnServicio">
                    Servicio
                </label>
            </div>



            <div class="col-6">
                <select class="form-select" aria-label="Default select example" name="paquete" id="selectPaquete" disabled="disabled">
                    <option selected>Paquetes disponibles</option>
                    <%for (Paquete paque : listaPaquetes) {%>
                    <option value="<%=paque.getCodigo()%>" >Cod. paquete: <%=paque.getCodigo()%> - Costo: $<%=paque.getCosto()%></option>
                    <%}%>                   
                </select>              
            </div>   


            <div class="col-6">
                <select class="form-select" aria-label="Default select example" name="servicio" id="selectServicio" disabled="disabled">
                    <option selected>Servicios disponibles</option>
                    <%for (ServicioTuristico ser : listaServicios) {%>
                    <option value="<%=ser.getCodigo()%>" > Cod. servicio: <%=ser.getCodigo()%> - Tipo: <%=ser.getNombre()%> - Costo: $<%=ser.getCosto()%> </option>
                    <%}%>
                </select>
            </div>         

            <script>
                function display() {
                    if (document.getElementById("btnPaquete").checked) {
                        document.getElementById("selectPaquete").disabled = false;
                        document.getElementById("selectServicio").disabled = true;
                        document.getElementById("selectServicio").selectedIndex = 0;
                        document.getElementById("selectSercicio").value = null;
                    } else {
                        document.getElementById("selectServicio").disabled = false;
                        document.getElementById("selectPaquete").disabled = true;
                        document.getElementById("selectPaquete").value = null;
                        document.getElementById("selectPaquete").selectedIndex = 0;
                    }
                }
            </script>   

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
