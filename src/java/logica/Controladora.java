package logica;

import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void altaServicio(ServicioTuristico servicio) {
        controlPersis.crearServicioTuristico(servicio);
    }
    
    public void bajaServicio(ServicioTuristico servicio) {
        controlPersis.eliminarServicioTuristico(servicio);
    }
    
    public void bajaServicio(int codigo) {
        controlPersis.eliminarServicioTuristico(codigo);        
    }
    
    public List<ServicioTuristico> obtenerServiciosTuristicos() {
       return controlPersis.obtenerServiciosTuristicos();
    }
    
    public void modificarServicio(ServicioTuristico servicio) {
        controlPersis.modificarServicioTuristico(servicio);
    } 
    
    public ServicioTuristico buscarServicio(ServicioTuristico servicio) {
        return controlPersis.buscarServicioTurístico(servicio);
    }
    
    public ServicioTuristico buscarServicio(int codigo) {
        return controlPersis.buscarServicioTurístico(codigo); 
    }

    public void crearServicio(String nombre, String destino, String descripcion, Date fecha, double costo) {
        ServicioTuristico servicio = new ServicioTuristico();
        servicio.setNombre(nombre);
        servicio.setDescripcion(descripcion);
        servicio.setDestino(destino);
        servicio.setFecha(fecha);
        servicio.setCosto(costo);
        
        this.altaServicio(servicio);
    }    
}
