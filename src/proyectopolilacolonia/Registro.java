/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

//import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Moron
 */
public class Registro extends Entidad {
    private Date fechaHora;
    private Persona persona;
            
    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
    public Registro(Date fechaHora, Persona persona) {
        this.fechaHora = fechaHora;
        this.persona = persona;
    }
    
      
}
