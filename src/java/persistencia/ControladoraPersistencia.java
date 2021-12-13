package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.ServicioTuristico;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    ServicioTuristicoJpaController servicioJPA = new ServicioTuristicoJpaController();
    
    public void crearServicioTuristico(ServicioTuristico servicio) {
        try {
            servicioJPA.create(servicio);
        } catch (Exception e) {
            System.out.println("No se pudo crear el servicio turístico");
        }                     
    }
    
    //Eliminar un servicio pasando el objeto como párametro
    public void eliminarServicioTuristico(ServicioTuristico servicio) {
        try {
            servicioJPA.destroy(servicio.getCodigo());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     //Eliminar un servicio pasando el codigo de dicho servicio como parámetro
    public void eliminarServicioTuristico(int codServicio) {
        try {
            servicioJPA.destroy(codServicio);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //Método para lectura
    public List<ServicioTuristico> obtenerServiciosTuristicos() {
        return servicioJPA.findServicioTuristicoEntities();
    }
    
    //Método para modificar 
    public void modificarServicioTuristico(ServicioTuristico servicio) {
        try {
            servicioJPA.edit(servicio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    //Método para búsqueda pasando el objeto completo
    public ServicioTuristico buscarServicioTurístico(ServicioTuristico servicio) {
        return servicioJPA.findServicioTuristico(servicio.getCodigo());
    }
    
    //Método para búsqueda pasando el codigo de servicio
    public ServicioTuristico buscarServicioTurístico(int codigo) {
        return servicioJPA.findServicioTuristico(codigo);
    }
}
