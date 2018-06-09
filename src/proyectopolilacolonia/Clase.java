/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Moron
 */
public class Clase extends Entidad{
    private String diaHora; 
    private Profesor entrenador;
    private Categoria categoria;
    private Deporte deporte;

    private ResultSet rs = null;
    private Connection conn = null;
    private PreparedStatement ps = null;
    
    public Clase() {
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public String getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(String diaHora) {
        this.diaHora = diaHora;
    }

    public Profesor getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Profesor entrenador) {
        this.entrenador = entrenador;
    }
    
    //Listar todas las clases
    public ResultSet list() {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("SELECT clases.id, profesores.nombreCompleto, deportes.nombre,categorias_de_deportes.nombre, clases.dia_hora FROM clases INNER JOIN profesores ON clases.profesor_id=profesores.id INNER JOIN deportes ON clases.deporte_id=deportes.id INNER JOIN categorias_de_deportes ON clases.categoria_id=categorias_de_deportes.id");
            rs = ps.executeQuery();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
        return rs;
    }
    
    //Guardar una clase
    public void save(Clase clase) {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("INSERT INTO clases(profesor_id, deporte_id, categoria_id, dia_hora) VALUES(?,?,?)");
            ps.setInt(1, clase.getEntrenador().getId());
            ps.setInt(2, clase.getDeporte().getId());
            ps.setInt(3, clase.getCategoria().getId());
            ps.setString(4, clase.getDiaHora());
            int resultado = ps.executeUpdate();
            if(resultado==1) {
                JOptionPane.showMessageDialog(null, "¡Clase creada con éxito!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Actualiza una clase, suponiendo que los valores que se pueden actualizar son el profesor y dia_hora
    public void update(Clase clase) {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("UPDATE clases SET profesor_id=?, dia_hora=? WHERE id=?");
            ps.setInt(1, clase.getEntrenador().getId());
            ps.setString(2, clase.getDiaHora());
            ps.setInt(3, clase.getId());
            int resultado = ps.executeUpdate();
            if(resultado==1) {
                JOptionPane.showMessageDialog(null, "¡Clase actualizada con éxito!");
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Eliminar una clase por el id
    public void delete(int claseId) {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("DELETE FROM clases WHERE id=?");
            ps.setInt(1, claseId);
            int resultado = ps.executeUpdate();
            if(resultado==1) {
                JOptionPane.showMessageDialog(null, "¡Clase eliminada con éxito!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
