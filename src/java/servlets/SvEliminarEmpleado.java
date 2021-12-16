package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Venta;


@WebServlet(name = "SvEliminarEmpleado", urlPatterns = {"/SvEliminarEmpleado"})
public class SvEliminarEmpleado extends HttpServlet {
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
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        List<Venta> listaVentas = control.obtenerVentas();
        
        for(Venta venta : listaVentas) {
            if (venta.getVendedor().getId()==id) {
                control.bajaVenta(venta);
            }
        }
        control.bajaEmpleado(id);
        HttpSession miSession = request.getSession();        
        miSession.setAttribute("listaEmpleados", control.obtenerEmpleados()); 
        response.sendRedirect("listaEmpleados.jsp");
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
