package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Paquete;
import logica.ServicioTuristico;
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

        List<Venta> listaVentas = control.obtenerVentas();

        List<Paquete> listaPaquetes = control.obtenerPaquetes();

        //BORRO TODAS LAS VENTAS EN LAS QUE APAREZCA EL SERVICIO QUE QUIERO BORRAR
        for (Venta venta : listaVentas) {
            try {
                if (venta.getServicio().getCodigo() == codigo) {
                    control.bajaVenta(venta);
                }
            } catch (NullPointerException e) {
                System.out.println("Esta venta no incluye servicios");
            }

        }

        //BORRO TODOS LOS PAQUETES EN LAS QUE APAREZCA EL SERVICIO QUE QUIERO BORRAR
        for (Paquete paquete : listaPaquetes) {

            //POR CADA PAQUETE GUARDADO EN LA BD CHEQUEO SI INCLUYE EL SERVICIO QUE QUIERO BORRAR. SI LO INCLUYE, BORRO DICHO PAQUETE

            List<ServicioTuristico> serviciosIncluidosEnPaquete = paquete.getListaServiciosIncluidos();
            for (ServicioTuristico servi : serviciosIncluidosEnPaquete) {
                
                if (servi.getCodigo() == codigo) {
                    
                    //SI EL PAQUETE INCLUYE EL SERVICIO QUE QUIERO BORRAR, ANTES DE BORRARLO TENGO QUE BUSCAR EN LA LISTA DE VENTAS TODAS LAS VECES QUE FUE VENDIDO EL PAQUETE Y BORRARLAS
                    for (Venta venta : listaVentas) {
                        try {
                            if (venta.getPaquete().getCodigo() == paquete.getCodigo()) {
                                control.bajaVenta(venta);
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Esta venta no incluye paquetes");
                        }

                    }

                    control.bajaPaquete(paquete);
                    break;
                }
            }

        }

        control.bajaServicio(codigo);

        //Actualizo la lista de servicios
        request.getSession().setAttribute("listaServicios", control.obtenerServiciosTuristicos());

        //Actualizo la lista de ventas
        request.getSession().setAttribute("listaVentas", control.obtenerVentas());

        response.sendRedirect("listaServicios.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
