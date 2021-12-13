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
import logica.ServicioTuristico;

@WebServlet(name = "SvModificarServicio", urlPatterns = {"/SvModificarServicio"})
public class SvModificarServicio extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String nombre = request.getParameter("nombreServicio");
            String destino = request.getParameter("destino");
            String descripcion = request.getParameter("descripcion");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(request.getParameter("fecha"));
            Double costo = Double.parseDouble(request.getParameter("costo"));
            
            ServicioTuristico ser = control.buscarServicio(Integer.parseInt(request.getParameter("codigo")));
            ser.setCosto(costo);
            ser.setDescripcion(descripcion);
            ser.setFecha(fecha);
            ser.setDestino(destino);
            ser.setNombre(nombre);
            
            control.modificarServicio(ser);
            
            //Actualizo mi lista de servicios
            request.getSession().setAttribute("listaServicios", control.obtenerServiciosTuristicos());
            
            response.sendRedirect("listaServicios.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(SvModificarServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codigoServicio = Integer.valueOf(request.getParameter("codigoServicio"));
        ServicioTuristico serv = control.buscarServicio(codigoServicio);
        
        HttpSession miSession = request.getSession();
        miSession.setAttribute("servicio", serv);
        response.sendRedirect("modificarServicio.jsp");
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
