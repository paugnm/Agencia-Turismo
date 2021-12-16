package logica;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Empleado extends Persona {
    @Basic
    private String cargo;
    private double sueldo;
    
    @OneToOne
    private Usuario usuario;

    public Empleado(String cargo, double sueldo, Usuario usu) {
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usuario = usu;
    }

    public Empleado(String cargo, double sueldo, int id, String nombre, String apellido, String direccion, int dni, Date fechaNacimiento, String nacionalidad, int celular, String email, Usuario usu) {
        super(id, nombre, apellido, direccion, dni, fechaNacimiento, nacionalidad, celular, email);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usuario = usu;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public Empleado() {
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
    
    
    
}
