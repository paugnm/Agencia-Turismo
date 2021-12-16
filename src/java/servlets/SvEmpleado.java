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

@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {
    
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
            String nombre = request.getParameter("nombreEmple");
            String apellido = request.getParameter("apellidoEmple");
            String direccion = request.getParameter("direccion");
            int dni = Integer.parseInt(request.getParameter("dni"));
            String nacionalidad = request.getParameter("nacionalidad");
            int celular = Integer.valueOf(request.getParameter("celular"));
            String email = request.getParameter("email");
            String cargo = request.getParameter("cargo");
            double sueldo = Double.parseDouble(request.getParameter("sueldo"));
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNac = formato.parse(request.getParameter("fechaNac"));
            String nombreUsu = request.getParameter("usuario");
            String pass = request.getParameter("contrasenia");
            
            request.getSession().setAttribute("nombreEmple", nombre);
            request.getSession().setAttribute("apellidoEmple", apellido);
            request.getSession().setAttribute("celular", celular);
            request.getSession().setAttribute("direccion", direccion);
            request.getSession().setAttribute("dni", dni);
            request.getSession().setAttribute("nacionalidad", nacionalidad);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("cargo", cargo);
            request.getSession().setAttribute("fechaNacimiento", fechaNac);
            request.getSession().setAttribute("sueldo", sueldo);
            request.getSession().setAttribute("usuario", nombreUsu);
            request.getSession().setAttribute("pass", pass);
            
            control.crearEmpleado(cargo, sueldo, nombre, apellido, dni, direccion, fechaNac, nacionalidad, email, celular, nombreUsu, pass);
            response.sendRedirect("formularioEmpleado.jsp");
            
        } catch (ParseException ex) {
            Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
