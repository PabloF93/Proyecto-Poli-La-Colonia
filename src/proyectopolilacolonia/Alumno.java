/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

//import com.mysql.jdbc.SQLError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneOffset;

/**
 *
 * @author Moron
 */
public class Alumno extends Persona {
        
    private LocalDateTime created_at;
    private LocalDateTime updated_at;    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
        
        conn = MySql.getConnection();
        
        try {
            
            ps = conn.prepareStatement("SELECT id, dni,codTarjeta, nombreCompleto, fechaNacimiento, sexo, created_at, updated_at FROM alumnos WHERE deleted=false");
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString(), "Error", JOptionPane.ERROR);
        }
        
        return rs;
    }
    
    //Buscar alumno por dni
    public Alumno find(String dni) {
        Alumno alumno = new Alumno();
        conn = MySql.getConnection();
        try {
            
            ps = conn.prepareStatement("SELECT id, dni, codTarjeta, nombreCompleto, fechaNacimiento, sexo, created_at, updated_at FROM alumnos WHERE dni=? AND deleted=false");
            
            ps.setString(1, dni);
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                
                alumno.setId(rs.getInt(1));
                alumno.setDni(rs.getString(2));
                alumno.setCodTarjeta(rs.getString(3));
                alumno.setNombreCompleto(rs.getString(4));
                alumno.setFechaNacimiento(rs.getDate(5).toLocalDate());
                alumno.setSexo(rs.getString(6));
                alumno.created_at = LocalDateTime.ofInstant(rs.getTimestamp(7).toInstant(), ZoneOffset.ofHours(0));
                alumno.created_at = LocalDateTime.ofInstant(rs.getTimestamp(8).toInstant(), ZoneOffset.ofHours(0));
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error: No se encuentra el alumno con ese DNI. "+e.toString(), "¡Error!", JOptionPane.ERROR);
        }
        
        return alumno;
    }
    
    //Guardar alumno
    public void save(Alumno alumno) {
        
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("INSERT INTO alumnos (dni,codTarjeta,nombreCompleto,fechaNacimiento,sexo,created_at,updated_at,deleted) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, alumno.getDni());
            ps.setString(2, alumno.getCodTarjeta());
            ps.setString(3, alumno.getNombreCompleto());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setString(5, alumno.getSexo());
            ps.setTimestamp(6, Timestamp.valueOf(alumno.getCreated_at()));
            ps.setTimestamp(7, Timestamp.valueOf(alumno.getUpdated_at()));
            ps.setBoolean(8, alumno.isDeleted());
            
            int resultado = ps.executeUpdate();
           
            if(resultado == 1) {
                JOptionPane.showMessageDialog(null, "¡Usuario registrado!", "¡Éxito!", JOptionPane.INFORMATION_MESSAGE);
            } 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
        
    }
    
    //Actualizar alumno
    public void update(Alumno alumno) {
        conn = MySql.getConnection();
        try {
            
            ps = conn.prepareStatement("UPDATE alumnos SET nombreCompleto=?, fechaNacimiento=?, sexo=?, updated_at=? WHERE dni=?");
            
            ps.setString(1, alumno.getNombreCompleto());
            ps.setDate(2, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setString(3, alumno.getSexo());
            ps.setTimestamp(4, Timestamp.valueOf(alumno.updated_at));
            ps.setString(5, alumno.getDni());
            
            int resultado = ps.executeUpdate();
            
            if(resultado == 1) {
                JOptionPane.showMessageDialog(null, "¡Usuario actualizado con éxito!");
            }
            
            
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error: No se pudo actualizar el alumno. Compruebe el DNI ingresado."+e.toString(), "¡Error!", JOptionPane.ERROR);
        }
        
    }
    
    //Soft-delete de alumno mediante update deleted=true
    public void delete(String dni) {
        conn = MySql.getConnection();
        try {
            
            ps = conn.prepareStatement("UPDATE alumnos SET deleted=true WHERE dni=?");
            ps.setString(1, dni);
            
            int resultado = ps.executeUpdate();
            
            if(resultado == 1) {
               JOptionPane.showMessageDialog(null, "¡Alumno eliminado con éxito!"); 
            }
            
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error: No se puedo eliminar el alumno. Compruebe el DNI ingresado."+e.toString(), "¡Error!", JOptionPane.ERROR);
        }
        
    }
    
    //Listar observaciones de un alumno.
    public ResultSet listObservations(String alumnoDni) {
        conn = MySql.getConnection();
        
        try {
            ps = conn.prepareStatement("SELECT observaciones_de_alumnos.id ,alumnos.nombreCompleto, observaciones_de_alumnos.contenido, observaciones_de_alumnos.created_at, observaciones_de_alumnos.updated_at FROM observaciones_de_alumnos INNER JOIN alumnos WHERE alumnos.id = observaciones_de_alumnos.alumno_id AND alumnos.dni = ?");
            ps.setString(1, alumnoDni);
            rs = ps.executeQuery();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return rs;
    }
    
    //Guardar observación de un alumno.
    public void saveObservation(int alumnoId, Observacion observacion) {
        conn = MySql.getConnection();
        
        try {
            ps = conn.prepareStatement("INSERT INTO observaciones_de_alumnos (alumno_id, contenido, created_at, updated_at) VALUES (?,?,?,?)");
            
            ps.setInt(1, alumnoId);
            ps.setString(2, observacion.getObservacion());
            ps.setTimestamp(3, Timestamp.valueOf(observacion.getCreated_at()));
            ps.setTimestamp(4, Timestamp.valueOf(observacion.getUpdated_at()));
            
            int resultado = ps.executeUpdate();
            
            if(resultado == 1) {
                JOptionPane.showMessageDialog(null, "¡Observación registrada con éxito!", "¡Éxito!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: "+e.toString(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    //Actualizar la observacion de un alumno.
    public void updateObservation(Observacion observacion) {
        conn = MySql.getConnection();
        
        try {
            ps = conn.prepareStatement("UPDATE observaciones_de_alumnos SET contenido=?, updated_at=? WHERE id=?");
            ps.setString(1, observacion.getObservacion());
            ps.setTimestamp(2, Timestamp.valueOf(observacion.getUpdated_at()));
            ps.setInt(3, observacion.getId());
            
            int resultado = ps.executeUpdate();
            
            if(resultado == 1) {
                JOptionPane.showMessageDialog(null, "¡Observación actualizada!", "¡Éxito!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    //Elimina la observación de un alumno.
    public void deleteObservation(int observacionId) {
        conn = MySql.getConnection();
        try {
            ps = conn.prepareStatement("DELETE FROM observaciones_de_alumnos WHERE id=?");
            ps.setInt(1, observacionId);
            
            int resultado = ps.executeUpdate();
            if(resultado == 1) {
                JOptionPane.showMessageDialog(null, "¡Observación eliminada!", "'Éxito!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
    
