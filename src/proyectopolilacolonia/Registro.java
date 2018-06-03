/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

//import java.util.Calendar;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Moron
 */
public class Registro extends Entidad {
    private LocalDateTime fechaHora;
    private Persona persona;
            
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
    public Registro(LocalDateTime fechaHora, Persona persona) {
        this.fechaHora = fechaHora;
        this.persona = persona;
    }
    
      
}
