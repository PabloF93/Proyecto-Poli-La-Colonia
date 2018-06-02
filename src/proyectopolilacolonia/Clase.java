/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

import java.util.Date;

/**
 *
 * @author Moron
 */
public class Clase extends Entidad{
    private Date diaHora; 
    private Profesor entrenador;


    public Date getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(Date diaHora) {
        this.diaHora = diaHora;
    }

    public Profesor getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Profesor entrenador) {
        this.entrenador = entrenador;
    }
    
    
}
