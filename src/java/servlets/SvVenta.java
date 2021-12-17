package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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


@WebServlet(name = "SvVenta", urlPatterns = {"/SvVenta"})
public class SvVenta extends HttpServlet {
    Controladora control = new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Empleado> empleados = control.obtenerEmpleados();   
        List<Cliente> clientes = control.obtenerClientes();
        List<ServicioTuristico> servicios = control.obtenerServiciosTuristicos(); 
        List<Paquete> paquetes = control.obtenerPaquetes(); 
        HttpSession miSession = request.getSession();
        miSession.setAttribute("empleados", empleados);
        miSession.setAttribute("servicios", servicios);
        miSession.setAttribute("paquetes", paquetes);
        miSession.setAttribute("clientes", clientes);
        response.sendRedirect("formularioVentas.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String medioPago = request.getParameter("medioDePago");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(request.getParameter("fecha"));
            int id = Integer.parseInt(request.getParameter("idCliente"));
    
            
            Cliente cliente = control.buscarCliente(id);
            Empleado emple = control.buscarEmpleado(Integer.valueOf(request.getParameter("empleado")));
            
            ServicioTuristico servi; 
            try{
                servi = control.buscarServicio(Integer.valueOf(request.getParameter("servicio")));
            } catch (Exception e){
                servi = null;
            }
            
            Paquete paquete; 
             try{
                paquete = control.buscarPaquete(Integer.valueOf(request.getParameter("paquete")));
            } catch (Exception e){
                paquete = null;
            }         
            
            
            control.crearVenta(medioPago, fecha, cliente, servi, paquete, emple);
            response.sendRedirect("formularioVentas.jsp");
            
        } catch (Exception ex) {
           Logger.getLogger(SvServicioTuristico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }    

}
