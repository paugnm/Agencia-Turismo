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
            int paqueId = Integer.parseInt(request.getParameter("paquete"));
            int servicio = Integer.parseInt(request.getParameter("servicio"));
            String medioPago = request.getParameter("medioDePago");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(request.getParameter("fecha"));
            String dni = request.getParameter("dniCliente");
            
            Venta venta = control.buscarVenta(Integer.parseInt(request.getParameter("codigo")));
            if(dni!=""){
                
                venta.setComprador(control.buscarClientePorDni(Integer.parseInt(dni)));
            }
  
            venta.setFechaVenta(fecha);
            venta.setServicio(control.buscarServicio(servicio));
            venta.setMedioDePago(medioPago);
            venta.setPaquete(control.buscarPaquete(paqueId));
            venta.setVendedor(control.buscarEmpleado(empleId));
            
            control.modificarVenta(venta);
            
            //Actualizo mi lista de ventas
            request.getSession().setAttribute("listaVentas", control.obtenerVentas());
            
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
        response.sendRedirect("modificarVenta.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
