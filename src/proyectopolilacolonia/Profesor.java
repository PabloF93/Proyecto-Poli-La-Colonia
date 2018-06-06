/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.swing.JOptionPane;

/**
 *
 * @author Moron
 */
public class Profesor extends Persona{

    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Profesor() {
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
    
    
    //Lista todos los profesores en los que deleted sea false
    public ResultSet list() {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("SELECT * FROM profesores WHERE deleted = false ORDER BY nombreCompleto");
            rs = ps.executeQuery();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return rs;
    }
    
    //Devuelve un profesor en particular.
    public Profesor find(String dni) {
        Profesor p1 = new Profesor();
        conn = MySql.getConnection();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM profesores WHERE dni=? AND deleted=false");
            ps.setString(1, dni);
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                p1.setId(rs.getInt(1));
                p1.setDni(rs.getString(2));
                p1.setCodTarjeta(rs.getString(3));
                p1.setNombreCompleto(rs.getString(4));
                p1.setFechaNacimiento(rs.getDate(5).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                p1.setSexo(rs.getString(6));
                p1.setCreated_at(LocalDateTime.ofInstant(rs.getTimestamp(7).toInstant(), ZoneId.systemDefault()));
                p1.setUpdated_at(LocalDateTime.ofInstant(rs.getTimestamp(8).toInstant(), ZoneId.systemDefault()));
    
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
        return p1;
    }
    
    //Guarda un profesor
    public void save(Profesor p) {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("INSERT INTO profesores(dni, codTarjeta, nombreCompleto, fechaNacimiento, sexo, created_at, updated_at, deleted) VALUES(?,?,?,?,?,?,?,?)");
            ps.setString(1, p.getDni());
            ps.setString(2, p.getCodTarjeta());
            ps.setString(3, p.getNombreCompleto());
            ps.setDate(4, Date.valueOf(p.getFechaNacimiento()));
            ps.setString(5, p.getSexo());
            ps.setTimestamp(6, Timestamp.valueOf(p.getCreated_at()));
            ps.setTimestamp(7, Timestamp.valueOf(p.getUpdated_at()));
            ps.setBoolean(8, p.isDeleted());
            
            int resultado = ps.executeUpdate();
            if(resultado == 1) {
                JOptionPane.showMessageDialog(null, "¡Profesor registrado con éxito!");
            }
            
        } catch (Exception e) {
            
        }
        
        
    }
    
    //Actualiza la informacion de u
    public void update(Profesor p) {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("UPDATE profesores SET nombreCompleto=?, fechaNacimiento=?, sexo=?, updated_at=? WHERE deleted=false AND DNI=?");
            ps.setString(1, p.getNombreCompleto());
            ps.setDate(2, Date.valueOf(p.getFechaNacimiento()));
            ps.setString(3, p.getSexo());
            ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            ps.setString(5, p.getDni());
            
            int resultado = ps.executeUpdate();
            if(resultado==1) {
                JOptionPane.showMessageDialog(null, "¡Profesor modificado con éxito!");
            }
            
        } catch (Exception e) {
        }
    }
    
    public void delete(int id) {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("UPDATE profesores SET deleted=true WHERE id=?");
            ps.setInt(1, id);
            
            int resultado = ps.executeUpdate();
            if(resultado==1) {
                JOptionPane.showMessageDialog(null, "¡Profesor borrado con éxito!");
            }
            
        } catch (Exception e) {
        }
    }
}
