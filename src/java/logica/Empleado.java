package logica;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class Empleado extends Persona {
    @Basic
    private String cargo;
    private double sueldo;

    public Empleado(String cargo, double sueldo) {
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public Empleado(String cargo, double sueldo, int id, String nombre, String apellido, String direccion, int dni, Date fechaNacimiento, String nacionalidad, int celular, String email) {
        super(id, nombre, apellido, direccion, dni, fechaNacimiento, nacionalidad, celular, email);
        this.cargo = cargo;
        this.sueldo = sueldo;
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
