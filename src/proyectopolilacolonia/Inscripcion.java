/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

import java.time.LocalDate;


/**
 *
 * @author Moron
 */
public class Inscripcion extends Entidad {
    private LocalDate fechaInscripcion; //dia mes año minutos y segundos de la inscripcion
    private int numeroComprobante;
    private Clase inscripto;
    private Alumno alumno;

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }



    public int getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(int numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }


    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Clase getInscripto() {
        return inscripto;
    }

    public void setInscripto(Clase inscripto) {
        this.inscripto = inscripto;
    }    
    
}
