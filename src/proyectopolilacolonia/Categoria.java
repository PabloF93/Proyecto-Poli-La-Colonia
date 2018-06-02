/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

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
}
