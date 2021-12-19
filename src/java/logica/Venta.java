package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numVenta;
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
     
    @Basic 
    private String medioDePago;
    
    @ManyToOne
    private ServicioTuristico servicio;
    
    @ManyToOne
    private Paquete paquete;
    
    @ManyToOne
    private Empleado vendedor;
    
    @ManyToOne
    private Cliente comprador;

    public Venta() {
    }

    public ServicioTuristico getServicio() {
        return servicio;
    }

    public void setServicio(ServicioTuristico servicio) {
        this.servicio = servicio;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    
    public Venta(int numVenta, Date fechaVenta, String medioDePago, Empleado vendedor, Cliente comprador, ServicioTuristico servicio, Paquete paquete) {
        this.numVenta = numVenta;
        this.fechaVenta = fechaVenta;
        this.medioDePago = medioDePago;
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.servicio = servicio;
        this.paquete = paquete;
    }

    
    
    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }

    public Empleado getVendedor() {
        return vendedor;
    }

    public void setVendedor(Empleado vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }
            
     
    public boolean incluyeServicio() {
        if (getServicio()!=null) {
            return true;
        } else {
            return false;
        }
    }
    
     public boolean incluyePaquete() {
        if (getPaquete()!=null) {
            return true;
        } else {
            return false;
        }
    }
}
