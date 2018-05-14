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
    private String categoria;
    private Date diaHora; 
    private Deporte deporte;
    private Profesor entrenador;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(Date diaHora) {
        this.diaHora = diaHora;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public Profesor getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Profesor entrenador) {
        this.entrenador = entrenador;
    }
    
    
}
