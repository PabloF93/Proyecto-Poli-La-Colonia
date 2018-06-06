/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Moron
 */
public class Categoria extends Entidad{
    private String nombreCategoria;
    private float valorCuota;
    private List<Clase> clasesList = new ArrayList();
    private Deporte deporte;
    
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Connection conn = null;
    
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public float getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(float valorCuota) {
        this.valorCuota = valorCuota;
    }

    public List<Clase> getClasesList() {
        return clasesList;
    }

    public void setClasesList(List<Clase> clasesList) {
        this.clasesList = clasesList;
    }
    
    public void agregarClase (Clase cla){
    this.clasesList.add(cla);
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    
    
    public Categoria() {
    }
    
    
    
   
}
