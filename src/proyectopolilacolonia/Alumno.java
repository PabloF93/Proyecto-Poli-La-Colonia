/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

import com.mysql.jdbc.SQLError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneOffset;

/**
 *
 * @author Moron
 */
public class Alumno extends Persona {
    
    private int id; //hasta resolver duda del tipo de dato en clase Entidad.
    //private String dni;
    //private String nombreCompleto;
    private int edad;
    private String sexo;
    private String observaciones;
    
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private boolean deleted = false;
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getEdad() {
        return edad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public boolean isDeleted() {
        return deleted;
    }

    
    //listar alumnos
    public ResultSet List() {
        
        try {
            conn = MySql.getConnection();
            ps = conn.prepareStatement("SELECT dni, nombreCompleto, edad, sexo, observaciones, created_at, updated_at FROM alumnos WHERE deleted=false");
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
        
        return rs;
    }
    
    //Buscar alumno por id
    public Alumno find(int id) {
        Alumno alumno = new Alumno();
        
        try {
            conn = MySql.getConnection();
            ps = conn.prepareStatement("SELECT dni, nombreCompleto, edad, sexo, observaciones, created_at, updated_at FROM alumnos WHERE id=? AND deleted=false");
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                
                alumno.setDni(rs.getString(1));
                alumno.setNombreCompleto(rs.getString(2));
                alumno.edad = rs.getInt(3);
                alumno.sexo = rs.getString(4);
                alumno.observaciones = rs.getString(5);
                alumno.created_at = LocalDateTime.ofInstant(rs.getTimestamp(6).toInstant(), ZoneOffset.ofHours(0));
                alumno.created_at = LocalDateTime.ofInstant(rs.getTimestamp(7).toInstant(), ZoneOffset.ofHours(0));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
        
        return alumno;
    }
    
    //Guardar alumno
    public void save(Alumno alumno) {
        
        try {
            conn = MySql.getConnection();
            ps = conn.prepareStatement("INSERT INTO alumnos(dni, nombreCompleto, edad, sexo, observaciones, created_at, updated_at, deleted) VALUES(?,?,?,?,?,?,?,?)");
            
            ps.setString(1, alumno.getDni());
            ps.setString(2, alumno.getNombreCompleto());
            ps.setInt(3, alumno.edad);
            ps.setString(4, alumno.sexo);
            ps.setString(5, alumno.observaciones);
            ps.setTimestamp(6, Timestamp.valueOf(alumno.created_at));
            ps.setTimestamp(7, Timestamp.valueOf(alumno.updated_at));
            ps.setBoolean(8, alumno.deleted);
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "¡Usuario registrado con éxito!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
        
    }
    
    //Actualizar alumno
    public void update(Alumno alumno) {
        
        try {
            conn = MySql.getConnection();
            ps = conn.prepareStatement("UPDATE alumnos SET nombreCompleto=?, edad=?, sexo=?, observaciones=?, updated_at=? WHERE id=?");
            
            ps.setString(1, alumno.getNombreCompleto());
            ps.setInt(2, alumno.edad);
            ps.setString(3, alumno.sexo);
            ps.setString(4, alumno.observaciones);
            ps.setTimestamp(5, Timestamp.valueOf(alumno.updated_at));
            ps.setInt(6, alumno.id);
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "¡Usuario actualizado con éxito!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
        
    }
    
    //Soft-delete de alumno mediante update deleted=true
    public void delete(int id) {
        
        try {
            conn = MySql.getConnection();
            ps = conn.prepareStatement("UPDATE alumnos SET deleted=true WHERE id=?");
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "¡Alumno eliminado con éxito!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
        
    }
    
   
}
    
