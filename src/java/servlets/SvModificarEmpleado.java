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


@WebServlet(name = "SvModificarEmpleado", urlPatterns = {"/SvModificarEmpleado"})
public class SvModificarEmpleado extends HttpServlet {
    Controladora control = new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String nombre = request.getParameter("nombreEmple");
            String apellido = request.getParameter("apellidoEmple");
            String direccion = request.getParameter("direccion");
            int dni = Integer.parseInt(request.getParameter("dni"));
            String nacionalidad = request.getParameter("nacionalidad");
            int celular = Integer.parseInt(request.getParameter("celular"));
            String email = request.getParameter("email");
            String cargo = request.getParameter("cargo");
            double sueldo = Double.parseDouble(request.getParameter("sueldo"));
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNac = formato.parse(request.getParameter("fechaNac"));
            
            Empleado emp = control.buscarEmpleado(Integer.parseInt(request.getParameter("id")));
            emp.setNombre(nombre);
            emp.setApellido(apellido);
            emp.setCargo(cargo);
            emp.setCelular(celular);
            emp.setDireccion(direccion);
            emp.setFechaNacimiento(fechaNac);
            emp.setDni(dni);
            emp.setNacionalidad(nacionalidad);
            emp.setEmail(email);
            emp.setSueldo(sueldo);
            
            control.modificarEmpleado(emp);
            
            request.getSession().setAttribute("listaEmpleados", control.obtenerEmpleados());
            
            response.sendRedirect("listaEmpleados.jsp");
            
        } catch (ParseException ex) {
            Logger.getLogger(SvModificarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Empleado emple = control.buscarEmpleado(id);
        
        HttpSession miSession = request.getSession();
        
        miSession.setAttribute("emple", emple);
        response.sendRedirect("modificarEmpleado.jsp");
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
