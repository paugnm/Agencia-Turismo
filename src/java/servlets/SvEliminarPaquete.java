package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Venta;


@WebServlet(name = "SvEliminarPaquete", urlPatterns = {"/SvEliminarPaquete"})
public class SvEliminarPaquete extends HttpServlet {
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
        int codigo = Integer.valueOf(request.getParameter("codigo"));
        control.bajaPaquete(codigo);
        
        List<Venta> listaVentas = control.obtenerVentas();
        
        for (Venta venta : listaVentas) {
            if (venta.getServicio().getCodigo() == codigo) {
                control.bajaVenta(venta);
            }
        }
        
        //Actualizo la lista de paquetes
        request.getSession().setAttribute("listaPaquetes",control.obtenerPaquetes());
        
        //Actualizo la lista de ventas
        request.getSession().setAttribute("listaVentas",control.obtenerVentas());
        
        response.sendRedirect("listaPaquetes.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
