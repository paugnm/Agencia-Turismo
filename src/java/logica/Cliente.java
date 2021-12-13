package logica;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Cliente extends Persona{

    public Cliente() {
    }    

    public Cliente(int id, String nombre, String apellido, String direccion, int dni, Date fechaNacimiento, String nacionalidad, int celular, String email) {
        super(id, nombre, apellido, direccion, dni, fechaNacimiento, nacionalidad, celular, email);
    }    
    
    
}
