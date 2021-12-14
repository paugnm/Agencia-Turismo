package servlets;

import java.io.IOException;
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
import logica.Controladora;


@WebServlet(name = "SvCliente", urlPatterns = {"/SvCliente"})
public class SvCliente extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
            String nombre = request.getParameter("nombreCli");
            String apellido = request.getParameter("apellidoCli");
            String direccion = request.getParameter("direccion");
            int dni = Integer.parseInt(request.getParameter("dni"));
            String nacionalidad = request.getParameter("nacionalidad");
            int celular = Integer.parseInt(request.getParameter("celular"));
            String email = request.getParameter("email");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNac = formato.parse(request.getParameter("fechaNac"));
            
            request.getSession().setAttribute("nombreCli", nombre);
            request.getSession().setAttribute("apellidoCli", apellido);
            request.getSession().setAttribute("celular", celular);
            request.getSession().setAttribute("direccion", direccion);
            request.getSession().setAttribute("dni", dni);
            request.getSession().setAttribute("nacionalidad", nacionalidad);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("fechaNacimiento", fechaNac);
            
            control.crearCliente(nombre, apellido, dni, direccion, fechaNac, nacionalidad, email, celular);
            response.sendRedirect("formularioCliente.jsp");
            
        } catch (ParseException ex) {
            Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
