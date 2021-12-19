package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Cliente;
import logica.Controladora;
import logica.Empleado;
import logica.Paquete;
import logica.ServicioTuristico;
import logica.Venta;
import servlets.SvModificarServicio;

@WebServlet(urlPatterns = {"/SvModificarVenta"})
public class SvModificarVenta extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int empleId = Integer.parseInt(request.getParameter("empleado"));
            String medioPago = request.getParameter("medioDePago");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(request.getParameter("fecha"));
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            Cliente cliente = control.buscarCliente(idCliente);

            ServicioTuristico servicio;
            try {
                servicio = control.buscarServicio(Integer.valueOf(request.getParameter("servicio")));
            } catch (Exception e) {
                servicio = null;
            }

            Paquete paquete;
            try {
                paquete = control.buscarPaquete(Integer.valueOf(request.getParameter("paquete")));
            } catch (Exception e) {
                paquete = null;
            }

            //SI SERVICIO O PAQUETE TIENEN DATOS (NO PUEDO TENER AMBOS EN NULL) CREO LA VENTA  
            if (servicio != null || paquete != null) {
                Venta venta = control.buscarVenta(Integer.parseInt(request.getParameter("codigo")));
                venta.setFechaVenta(fecha);
                venta.setServicio(servicio);
                venta.setMedioDePago(medioPago);
                venta.setPaquete(paquete);
                venta.setVendedor(control.buscarEmpleado(empleId));
                venta.setComprador(cliente);
                control.modificarVenta(venta);
                //Actualizo mi lista de ventas
                request.getSession().setAttribute("listaVentas", control.obtenerVentas());
            }
            response.sendRedirect("listaVentas.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(SvModificarServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int codigo = Integer.parseInt(request.getParameter("codigo"));
        Venta venta = control.buscarVenta(codigo);

        HttpSession miSession = request.getSession();
        miSession.setAttribute("venta", venta);
        miSession.setAttribute("listaEmpleados", control.obtenerEmpleados());
        miSession.setAttribute("listaServicios", control.obtenerServiciosTuristicos());
        miSession.setAttribute("listaPaquetes", control.obtenerPaquetes());
        miSession.setAttribute("listaClientes", control.obtenerClientes());
        response.sendRedirect("modificarVenta.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
