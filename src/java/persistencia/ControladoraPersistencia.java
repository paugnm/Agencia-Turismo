package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import logica.Empleado;
import logica.Paquete;
import logica.ServicioTuristico;
import logica.Usuario;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    ServicioTuristicoJpaController servicioJPA = new ServicioTuristicoJpaController();
    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    ClienteJpaController clienteJPA = new ClienteJpaController();
    PaqueteJpaController paqueteJPA = new PaqueteJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();
    
    
    /*--------------------------------------Controladora de Servicios----------------------------------------*/
    
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
    
    
    /*--------------------------------------Controladora de Empleados----------------------------------------*/
    
    public void crearEmpleado(Empleado emple) {
        try {
            empleadoJPA.create(emple);
        } catch (Exception e) {
            System.out.println("No se pudo crear el empleado");
        }                     
    }
    
    //Eliminar un empledo pasando el objeto como párametro
    public void eliminarEmpleado(Empleado emple) {
        try {
            empleadoJPA.destroy(emple.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     //Eliminar un empledo pasando el id
    public void eliminarEmpleado(int id) {
        try {
            empleadoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    //Método para lectura
    public List<Empleado> obtenerEmpleados() {
        return empleadoJPA.findEmpleadoEntities();
    }
    
    //Método para modificar 
    public void modificarEmpleado(Empleado emple) {
        try {
           empleadoJPA.edit(emple);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    //Método para búsqueda pasando el objeto completo
    public Empleado buscarEmpleado(Empleado emple) {
        return empleadoJPA.findEmpleado(emple.getId());
    }
    
    //Método para búsqueda pasando el id de empleado
    public Empleado buscarEmpleado(int id) {
        return empleadoJPA.findEmpleado(id);
    }
    
    /*--------------------------------------Controladora de Clientes----------------------------------------*/
    
    public void crearCliente(Cliente cli) {
        try {
            clienteJPA.create(cli);
        } catch (Exception e) {
            System.out.println("No se pudo crear el cliente");
        }                     
    }
    
    //Eliminar un cliente pasando el objeto como párametro
    public void eliminarCliente(Cliente cli) {
        try {
            clienteJPA.destroy(cli.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     //Eliminar un cliente pasando el id
    public void eliminarCliente(int id) {
        try {
            clienteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //Método para lectura
    public List<Cliente> obtenerClientes() {
        return clienteJPA.findClienteEntities();
    }
    
    //Método para modificar 
    public void modificarCliente(Cliente cli) {
        try {
            clienteJPA.edit(cli);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    //Método para búsqueda pasando el objeto completo
    public Cliente buscarCliente(Cliente cli) {
        return clienteJPA.findCliente(cli.getId());
    }
    
    //Método para búsqueda pasando el id de cliente
    public Cliente buscarCliente(int id) {
        return clienteJPA.findCliente(id);
    }
    
    
    /*--------------------------------------Controladora de Paquetes----------------------------------------*/
    
    public void crearPaquete(Paquete paquete) {
        try {
            paqueteJPA.create(paquete);
        } catch (Exception e) {
            System.out.println("No se pudo crear el servicio turístico");
        }                     
    }
    
    //Eliminar un paquete pasando el objeto como párametro
    public void eliminarPaquete(Paquete paquete) {
        try {
            paqueteJPA.destroy(paquete.getCodigo());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     //Eliminar un paquete pasando el codigo de dicho paquete como parámetro
    public void eliminarPaquete(int cod) {
        try {
            paqueteJPA.destroy(cod);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //Método para lectura
    public List<Paquete> obtenerPaquetes() {
        return paqueteJPA.findPaqueteEntities();
    }
    
    //Método para modificar 
    public void modificarPaquete(Paquete paquete) {
        try {
            paqueteJPA.edit(paquete);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    //Método para búsqueda pasando el objeto completo
    public Paquete buscarPaquete(Paquete paquete) {
        return paqueteJPA.findPaquete(paquete.getCodigo());
    }
    
    //Método para búsqueda pasando el codigo de paquete
    public Paquete buscarPaquete(int codigo) {
        return paqueteJPA.findPaquete(codigo);
    }
    

    /*--------------------------------------Controladora de Usuario----------------------------------------*/
    
    public void crearUsuario(Usuario usu) {
        try {
            usuJPA.create(usu);
        } catch (Exception e) {
            System.out.println("No se pudo crear el usuario");
        }                     
    }
    
    //Eliminar un usuario pasando el objeto como párametro
    public void eliminarUsuario(Usuario usu) {
        try {
            usuJPA.destroy(usu.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     //Eliminar un usuario pasando el id
    public void eliminarUsuario(int id) {
        try {
            usuJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //Método para lectura
    public List<Usuario> obtenerUsuarios() {
        return usuJPA.findUsuarioEntities();
    }
    
    //Método para modificar 
    public void modificarUsuario(Usuario usu) {
        try {
            usuJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    //Método para búsqueda pasando el objeto completo
    public Usuario buscarUsuario(Usuario usu) {
        return usuJPA.findUsuario(usu.getId());
    }
    
    //Método para búsqueda pasando el codigo de servicio
    public Usuario buscarUsuario(int codigo) {
        return usuJPA.findUsuario(codigo);
    }
    
     /*--------------------------------------Controladora de Ventas----------------------------------------*/
    
    public void crearVenta(Venta venta) {
        try {
            ventaJPA.create(venta);
        } catch (Exception e) {
            System.out.println("No se pudo crear la venta");
        }                     
    }
    
    //Eliminar venta pasando el objeto como párametro
    public void eliminarVenta(Venta venta) {
        try {
            ventaJPA.destroy(venta.getNumVenta());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     //Eliminar una venta pasando el numero de venta como parámetro
    public void eliminarVenta(int num) {
        try {
            ventaJPA.destroy(num);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //Método para lectura
    public List<Venta> obtenerVentas() {
        return ventaJPA.findVentaEntities();
    }
    
    //Método para modificar 
    public void modificarVenta(Venta venta) {
        try {
            ventaJPA.edit(venta);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    //Método para búsqueda pasando el objeto completo
    public Venta buscarVenta(Venta venta) {
        return ventaJPA.findVenta(venta.getNumVenta());
    }
    
    //Método para búsqueda pasando el codigo de servicio
    public Venta buscarVenta(int venta) {
        return ventaJPA.findVenta(venta);
    }
    
     
}
