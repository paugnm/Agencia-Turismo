/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.ServicioTuristico;

@WebServlet(name = "SvPaquete", urlPatterns = {"/SvPaquete"})
public class SvPaquete extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ServicioTuristico> listaServicios = control.obtenerServiciosTuristicos();
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaServicios", listaServicios);
        response.sendRedirect("formularioPaquete.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        List<ServicioTuristico> serviciosIncluidosPaquete = new ArrayList();
        
        String[] checked = request.getParameterValues("selected");
       
        //SOLO LE DOY ALTA AL PAQUETE SI INCLUYE AL MENOS DOS SERVICIOS
        if (checked.length>=2) {
             for (int i=0; i<checked.length; i++)
             {
                serviciosIncluidosPaquete.add(control.buscarServicio(Integer.parseInt(checked[i])));
             }
        
            control.crearPaquete(serviciosIncluidosPaquete);
        }
        response.sendRedirect("formularioPaquete.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
