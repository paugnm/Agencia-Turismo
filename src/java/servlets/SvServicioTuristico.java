package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;


@WebServlet(name = "SvServicioTuristico", urlPatterns = {"/SvServicioTuristico"})
public class SvServicioTuristico extends HttpServlet {
    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String nombre = request.getParameter("nombreServicio");
            String destino = request.getParameter("destino");
            String descripcion = request.getParameter("descripcion");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(request.getParameter("fecha"));
            Double costo = Double.parseDouble(request.getParameter("costo"));
                        
            request.getSession().setAttribute("costo", costo);
            request.getSession().setAttribute("destino", destino);
            request.getSession().setAttribute("descripcion", descripcion);
            request.getSession().setAttribute("fechaServicio", fecha);
            request.getSession().setAttribute("nombreServicio", nombre);
            
            control.crearServicio(nombre, destino, descripcion, fecha, costo);
            response.sendRedirect("formularioServicio.jsp");
            
        } catch (Exception ex) {
           Logger.getLogger(SvServicioTuristico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
