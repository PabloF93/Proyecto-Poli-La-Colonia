/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 *
 * @author Moron
 */
public class Inscripcion extends Entidad {
    private LocalDateTime fechaInscripcion; //dia mes año minutos y segundos de la inscripcion
    private int numeroComprobante;
    private Alumno alumno;
    private Clase clase;
    //private Deporte deporte;
    //private Categoria categoria;

//    public Deporte getDeporte() {
//        return deporte;
//    }
//
//    public void setDeporte(Deporte deporte) {
//        this.deporte = deporte;
//    }
//
//    public Categoria getCategoria() {
//        return categoria;
//    }
//
//    public void setCategoria(Categoria categoria) {
//        this.categoria = categoria;
//    }
        
    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDateTime fechaInscripcion) {
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

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
    
    
 
    
}