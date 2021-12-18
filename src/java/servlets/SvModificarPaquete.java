package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Paquete;
import logica.ServicioTuristico;

@WebServlet(name = "SvModificarPaquete", urlPatterns = {"/SvModificarPaquete"})
public class SvModificarPaquete extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ServicioTuristico> serviciosIncluidosPaquete = new ArrayList();
        String[] checked = request.getParameterValues("selected");

        //USO EL TRY-CATCH PORQUE SI NO SELECCIONO NINGÚN PAQUETE SALE UNA NULL POINTER EXCEPTION
        try {
             //SOLO LE DOY ALTA AL PAQUETE SI INCLUYE AL MENOS DOS SERVICIOS
            if (checked.length >= 2) {

                for (int i = 0; i < checked.length; i++) {
                    serviciosIncluidosPaquete.add(control.buscarServicio(Integer.parseInt(checked[i])));
                }

                int codigo = Integer.parseInt(request.getParameter("codigo"));
                Paquete paqueteModifi = control.buscarPaquete(codigo);
                paqueteModifi.setListaServiciosIncluidos(serviciosIncluidosPaquete);
                control.modificarPaquete(paqueteModifi);

                request.getSession().setAttribute("listaPaquetes", control.obtenerPaquetes());
            }
        } catch (NullPointerException e) {
            System.out.println("No se seleccionó ningún paquete");
        }
        response.sendRedirect("listaPaquetes.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.valueOf(request.getParameter("codigo"));
        Paquete paquete = control.buscarPaquete(codigo);
        HttpSession miSession = request.getSession();
        miSession.setAttribute("paquete", paquete);
        miSession.setAttribute("listaServicios", control.obtenerServiciosTuristicos());
        response.sendRedirect("modificarPaquete.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
