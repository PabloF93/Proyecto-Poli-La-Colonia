/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Moron
 */
public class Deporte extends Entidad{

    private String nombreDeporte;
    private List<Categoria> categoriaList = new ArrayList();
    private Boolean deleted = false;

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getDeleted() {
        return deleted;
    }
    
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    

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
    
    //Listar todos los deportes no eliminados.
    public ResultSet list() {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("SELECT * FROM deportes WHERE deleted=false");
            rs = ps.executeQuery();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
        
        return rs;
    }
    
    //Retorna un deporte mediante el nombre.
    public Deporte find(String nombre) {
        Deporte d1 = new Deporte();
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("SELECT * FROM deportes WHERE nombre=? AND deleted=false");
            ps.setString(1, nombre);
            
            d1.setId(rs.getInt(1));
            d1.setNombreDeporte(rs.getString(2));
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
        
        return d1;
    }
    
    //Guarda el deporte.
    public void save(Deporte deporte) {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("INSERT INTO deportes(nombre, deleted) VALUES(?,?)");
            ps.setString(1, deporte.getNombreDeporte());
            ps.setBoolean(2, deporte.getDeleted());
            
            int resultado = ps.executeUpdate();
            if(resultado==1) {
                JOptionPane.showMessageDialog(null, "¡Deporte guardado con éxito!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
        
        
    }
    
    //Realiza un soft-delete del deporte.
    public void delete(int id) {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("UPDATE deportes SET deleted=true WHERE id=?");
            ps.setInt(1, id);
            
            int resultado = ps.executeUpdate();
            if(resultado==1) {
                JOptionPane.showMessageDialog(null, "¡Deporte eliminado con éxito!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
    }
}
