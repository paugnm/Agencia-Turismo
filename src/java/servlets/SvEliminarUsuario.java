package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Empleado;
import logica.Venta;


@WebServlet(name = "SvEliminarUsuario", urlPatterns = {"/SvEliminarUsuario"})
public class SvEliminarUsuario extends HttpServlet {
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
       
        int id = Integer.parseInt(request.getParameter("id"));
        
        List<Empleado> listaEmpleados = control.obtenerEmpleados();
        
        List<Venta> listaVentas = control.obtenerVentas();
        
        int empleId=-1;
        
        //BUSCO EL ID DEL EMPLEADO RELACIONADO CON EL USUARIO QUE QUIERO BORRAR
        for(Empleado emple : listaEmpleados) {
            if (emple.getUsuario().getId()==id) {
                empleId =  emple.getId();
            } 
        }    
        
        for (Venta venta : listaVentas) {
            if (venta.getVendedor().getId() == empleId) {
                control.bajaVenta(venta);
            }
        }
     
        
        control.bajaEmpleado(empleId);  

        control.bajaUsuario(id);
        HttpSession miSession = request.getSession();        
        miSession.setAttribute("listaUsuarios", control.obtenerUsuarios()); 
        miSession.setAttribute("listaEmpleados", control.obtenerEmpleados()); 
        response.sendRedirect("listaEmpleados.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
