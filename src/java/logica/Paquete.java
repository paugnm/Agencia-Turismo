package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Paquete implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    
    @Basic
    private double costo;
    
    @ManyToMany
    private List<ServicioTuristico> listaServiciosIncluidos;

    public Paquete() {
    }

    public Paquete(int codigo, double costo, List<ServicioTuristico> listaServiciosIncluidos) {
        this.codigo = codigo;
        this.costo = costo;
        this.listaServiciosIncluidos = listaServiciosIncluidos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public List<ServicioTuristico> getListaServiciosIncluidos() {
        return listaServiciosIncluidos;
    }

    public void setListaServiciosIncluidos(List<ServicioTuristico> listaServiciosIncluidos) {
        this.listaServiciosIncluidos = listaServiciosIncluidos;
        
        //Cada vez que seteo una lista calculo nuevamente el costo
        this.costo = this.calcularCosto();
    }
    
    public double calcularCosto() {
        this.costo = 0;
        for(ServicioTuristico serv : listaServiciosIncluidos){
            costo += serv.getCosto();
        }        
        return costo -= costo*0.1;
    }
    
    public boolean isChecked(int codServicio){
        boolean checked=false;
        
        for (ServicioTuristico serv : listaServiciosIncluidos){
            if(serv.getCodigo() == codServicio) {
                checked = true;
                return checked;
            }        
        }
        
        return checked;
        
    }
    
    
}
