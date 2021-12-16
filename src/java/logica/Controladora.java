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

    public void crearEmpleado(String cargo, double sueldo, String nombre, String apellido, int dni, String direccion, Date fNac, String nacionalidad, String email, int celular, String nombreUsu, String contra) {
        Usuario usu = new Usuario();
        usu.setNombreUsu(nombreUsu);
        usu.setContrasenia(contra);
        this.altaUsuario(usu);
        
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
        emple.setUsuario(usu);
        this.altaEmpleado(emple);
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
    
    /*----------------------Control Servicios-----------------------------------*/
    public void altaUsuario(Usuario usu) {
        controlPersis.crearUsuario(usu);
    }
    
    public void bajaUsuario(Usuario usu) {
        controlPersis.eliminarUsuario(usu);
    }
    
    public void bajaUsuario(int id) {
        controlPersis.eliminarUsuario(id);        
    }
    
    public List<Usuario> obtenerUsuarios() {
       return controlPersis.obtenerUsuarios();
    }
    
    public void modificarUsuario(Usuario usu) {
        controlPersis.modificarUsuario(usu);
    } 
    
    public Usuario buscarUsuario(Usuario usu) {
        return controlPersis.buscarUsuario(usu);
    }
    
    public Usuario buscarUsuario(int id) {
        return controlPersis.buscarUsuario(id); 
    }

   
// ---------------------------Verificación de usuario--------------------------------------------------

    public boolean verificarUsuario(String usuario, String contra) {
        List<Usuario> listaUsuarios = controlPersis.obtenerUsuarios();
        
        if(listaUsuarios != null) {
            for(Usuario usu : listaUsuarios) {
                if(usu.getNombreUsu().equals(usuario) && usu.getContrasenia().equals(contra)){
                    return true;
                }
            }
            
        }
        
        return false; 
    }
    
    /*----------------------Control Ventas-----------------------------------*/
    public void altaVenta(Venta venta) {
        controlPersis.crearVenta(venta);
    }
    
    public void bajaVenta(Venta venta) {
        controlPersis.eliminarVenta(venta);
    }
    
    public void bajaVenta(int num) {
        controlPersis.eliminarVenta(num);        
    }
    
    public List<Venta> obtenerVentas() {
       return controlPersis.obtenerVentas();
    }
    
    public void modificarVenta(Venta venta) {
        controlPersis.modificarVenta(venta);
    } 
    
    public Venta buscarVenta(Venta venta) {
        return controlPersis.buscarVenta(venta.getNumVenta());
    }
    
    public Venta buscarVenta(int num) {
        return controlPersis.buscarVenta(num); 
    }

    public void crearServicio(Date fechaVenta, String medioDePago, Empleado vendedor, Cliente comprador) {
        Venta venta = new Venta();
        venta.setFechaVenta(fechaVenta);
        venta.setMedioDePago(medioDePago);
        venta.setComprador(comprador);
        venta.setVendedor(vendedor);        
        this.altaVenta(venta);
    }    

    public Cliente buscarClientePorDni(int dniCliente) {
        //SUPUESTO: el cliente ya se encuentra registrado al momento de realizar la compra, por lo tanto este método no devuleve null
        List<Cliente> listaClientes = this.obtenerClientes();
        Cliente clienteBuscado=null;
        for (Cliente cli : listaClientes) {
            if(cli.getDni()==dniCliente) {
                return clienteBuscado = cli;
            }
        }
        return clienteBuscado;        
    }

    public void crearVenta(String medioPago, Date fecha, Cliente cliente, ServicioTuristico servi, Paquete paquete, Empleado vendedor) {
        Venta venta = new Venta();
        venta.setComprador(cliente);
        venta.setMedioDePago(medioPago);
        venta.setPaquete(paquete);
        venta.setServicio(servi);
        venta.setFechaVenta(fecha);
        venta.setVendedor(vendedor);
        
        this.altaVenta(venta);

    }

    
}
