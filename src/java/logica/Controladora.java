package logica;

import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    
    /*----------------------Control Servicios-----------------------------------*/
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
    
    /*----------------------Control Clientes-----------------------------------*/
    public void altaCliente(Cliente cli) {
        controlPersis.crearCliente(cli);
    }
    
    public void bajaCliente(Cliente cli) {
        controlPersis.eliminarCliente(cli);
    }
    
    public void bajaCliente(int id) {
        controlPersis.eliminarCliente(id);        
    }
    
    public List<Cliente> obtenerClientes() {
       return controlPersis.obtenerClientes();
    }
    
    public void modificarCliente(Cliente cli) {
        controlPersis.modificarCliente(cli);
    } 
    
    public Cliente buscarCliente(Cliente cli) {
        return controlPersis.buscarCliente(cli);
    }
    
    public Cliente buscarCliente(int id) {
        return controlPersis.buscarCliente(id); 
    }

    public void crearCliente(String nombre, String apellido, int dni, String direccion, Date fNac, String nacionalidad, String email, int celular) {
        Cliente cli = new Cliente();        
        cli.setApellido(apellido);
        cli.setCelular(celular);
        cli.setDireccion(direccion);
        cli.setNombre(nombre);
        cli.setEmail(email);
        cli.setDni(dni);
        cli.setFechaNacimiento(fNac);
        cli.setNacionalidad(nacionalidad);
        this.altaCliente(cli);
    }

 /*----------------------Control Empleados-----------------------------------*/
    public void altaEmpleado(Empleado emple) {
        controlPersis.crearEmpleado(emple);
    }
    
    public void bajaEmpleado(Empleado emple) {
        controlPersis.eliminarEmpleado(emple);
    }
    
    public void bajaEmpleado(int id) {
        controlPersis.eliminarEmpleado(id);        
    }
    
    public List<Empleado> obtenerEmpleados() {
       return controlPersis.obtenerEmpleados();
    }
    
    public void modificarEmpleado(Empleado emple) {
        controlPersis.modificarEmpleado(emple);
    } 
    
    public Empleado buscarEmpleado(Empleado emple) {
        return controlPersis.buscarEmpleado(emple);
    }
    
    public Empleado buscarEmpleado(int id) {
        return controlPersis.buscarEmpleado(id); 
    }

    public void crearEmpleado(String cargo, double sueldo, String nombre, String apellido, int dni, String direccion, Date fNac, String nacionalidad, String email, int celular) {
        Empleado emple = new Empleado();        
        emple.setApellido(apellido);
        emple.setCelular(celular);
        emple.setDireccion(direccion);
        emple.setNombre(nombre);
        emple.setEmail(email);
        emple.setDni(dni);
        emple.setFechaNacimiento(fNac);
        emple.setNacionalidad(nacionalidad);
        emple.setSueldo(sueldo);
        emple.setCargo(cargo);
        this.altaEmpleado(emple);
    }    

    public Empleado buscarEmpleado(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*----------------------Control Paquetes-----------------------------------*/
    public void altaPaquete(Paquete paquete) {
        controlPersis.crearPaquete(paquete);
    }
    
    public void bajaPaquete(Paquete paquete) {
        controlPersis.eliminarPaquete(paquete);
    }
    
    public void bajaPaquete(int codigo) {
        controlPersis.eliminarPaquete(codigo);        
    }
    
    public List<Paquete> obtenerPaquetes() {
       return controlPersis.obtenerPaquetes();
    }
    
    public void modificarPaquete(Paquete paquete) {
        controlPersis.modificarPaquete(paquete);
    } 
    
    public Paquete buscarPaquete(Paquete paquete) {
        return controlPersis.buscarPaquete(paquete);
    }
    
    public Paquete buscarPaquete(int codigo) {
        return controlPersis.buscarPaquete(codigo); 
    }

    public void crearPaquete(List<ServicioTuristico> listaServiciosIncluidos) {
        Paquete paquete = new Paquete();
        paquete.setListaServiciosIncluidos(listaServiciosIncluidos);
        paquete.setCosto(paquete.calcularCosto());
        this.altaPaquete(paquete);
    }   
    
}
