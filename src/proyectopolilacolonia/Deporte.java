/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Moron
 */
public class Deporte extends Entidad{

    private String nombreDeporte;
    private List<Categoria> categoriaList = new ArrayList();

    public List<Categoria> getA() {
        return categoriaList;
    }

    public void setA(List<Categoria> categoriasList) {
        this.categoriaList = categoriaList;
    }
    
    public void agregarCategoria(Categoria cat){
    this.categoriaList.add(cat);
    }
    
    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }       
}
