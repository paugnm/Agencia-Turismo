package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Venta;


@WebServlet(name = "SvEliminarServicio", urlPatterns = {"/SvEliminarServicio"})
public class SvEliminarServicio extends HttpServlet {
    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.valueOf(request.getParameter("codigoServicio"));
        control.bajaServicio(codigo);
        
        List<Venta> listaVentas = control.obtenerVentas();
        
        for (Venta venta : listaVentas) {
            if (venta.getServicio().getCodigo() == codigo) {
                control.bajaVenta(venta);
            }
        }
        
        //Actualizo la lista de servicios
        request.getSession().setAttribute("listaServicios",control.obtenerServiciosTuristicos());
        
        //Actualizo la lista de ventas
        request.getSession().setAttribute("listaVentas",control.obtenerVentas());
        
        response.sendRedirect("listaServicios.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
