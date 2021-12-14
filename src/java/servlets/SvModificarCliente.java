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
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Cliente;
import logica.Empleado;

@WebServlet(name = "SvModificarCliente", urlPatterns = {"/SvModificarCliente"})
public class SvModificarCliente extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
            
            Cliente cli = control.buscarCliente(Integer.parseInt(request.getParameter("id")));
            cli.setNombre(nombre);
            cli.setApellido(apellido);
            cli.setCelular(celular);
            cli.setDireccion(direccion);
            cli.setFechaNacimiento(fechaNac);
            cli.setDni(dni);
            cli.setNacionalidad(nacionalidad);
            cli.setEmail(email);
            
            control.modificarCliente(cli);
            
            request.getSession().setAttribute("listaClientes", control.obtenerClientes());
            
            response.sendRedirect("listaClientes.jsp");
            
        } catch (ParseException ex) {
            Logger.getLogger(SvModificarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        int id = Integer.parseInt(request.getParameter("id"));
        
        Cliente cli = control.buscarCliente(id);
        
        HttpSession miSession = request.getSession();
        
        miSession.setAttribute("cliente", cli);
        response.sendRedirect("modificarCliente.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
