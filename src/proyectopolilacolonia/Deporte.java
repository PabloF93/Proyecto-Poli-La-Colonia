/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
    private Categoria categoria;

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
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
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                d1.setId(rs.getInt(1));
                d1.setNombreDeporte(rs.getString(2));
            }
            
            
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
    
    //Lista todas las categorias
    public ResultSet listCategories() {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("SELECT categorias_de_deportes.id, categorias_de_deportes.nombre, deportes.nombre, categorias_de_deportes.valorCuota, categorias_de_deportes.updated_at FROM categorias_de_deportes INNER JOIN deportes ON categorias_de_deportes.deporte_id=deportes.id WHERE deportes.deleted=false");
            rs = ps.executeQuery();
            
        } catch (Exception e) {
        }
        
        return rs;
    }
    
    //Guarda una categoria del deporte correspondiente
    public void saveCategory(int deporteId, Categoria categoria) {
        
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("INSERT INTO categorias_de_deportes(deporte_id, nombre, valorCuota, created_at, updated_at) VALUES(?,?,?,?,?)");
            ps.setInt(1, deporteId);
            ps.setString(2, categoria.getNombreCategoria());
            ps.setDouble(3, categoria.getValorCuota());
            ps.setTimestamp(4, Timestamp.valueOf(categoria.getCreated_at()));
            ps.setTimestamp(5, Timestamp.valueOf(categoria.getUpdated_at()));
            int resultado = ps.executeUpdate();
            if(resultado==1) {
                JOptionPane.showMessageDialog(null, "¡Categoría guardada con éxito!");
            }
            
        } catch (Exception e) {
            
        }
        
    }
    
    //Actualiza una categoria
    public void updateCategory(Categoria categoria) {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("UPDATE categorias_de_deportes SET nombre=?, valorCuota=?, updated_at=? WHERE id=?");
            ps.setString(1, categoria.getNombreCategoria());
            ps.setDouble(2, categoria.getValorCuota());
            ps.setTimestamp(3, Timestamp.valueOf(categoria.getUpdated_at()));
            ps.setInt(4, categoria.getId());
            int resultado = ps.executeUpdate();
            if(resultado==1) {
                JOptionPane.showMessageDialog(null, "¡Categoría actualizada con éxito!");
            }
            
            
        } catch (Exception e) {
        }
    }
    
    //Eliminar una categoria
    public void deleteCategory(int categoriaId) {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("DELETE FROM categorias_de_deportes WHERE id=?");
            ps.setInt(1, categoriaId);
            int resultado = ps.executeUpdate();
            if(resultado==1) {
                JOptionPane.showMessageDialog(null, "¡Categoría eliminada con éxito!");
            }
            
            
        } catch (Exception e) {
        }
        
    }
}
