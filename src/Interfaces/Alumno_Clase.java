/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectopolilacolonia.Alumno;
import proyectopolilacolonia.Clase;
import proyectopolilacolonia.Inscripcion;

/**
 *
 * @author Pablo2
 */
public class Alumno_Clase extends javax.swing.JFrame {

    private ResultSet rs = null;
    
    public Alumno_Clase() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.refrescarAlumnos();
        this.refrescarClases();
    }

    private void refrescarAlumnos() {
        DefaultTableModel modelo = (DefaultTableModel) this.JTable_alumnos.getModel();
        modelo.setRowCount(0);
        int cantCols = modelo.getColumnCount();
        
        rs = new Alumno().List();
        
        try {
            while(rs.next()) {
                Object[] fila = new Object[cantCols];
                fila[0] = rs.getObject(2);
                fila[1] = rs.getObject(4);
                
                modelo.addRow(fila);
            }
            
        } catch (Exception e) {
        }
        
    }
    
    private void refrescarClases() {
        DefaultTableModel modelo = (DefaultTableModel) this.JTable_clases.getModel();
        modelo.setRowCount(0);
        int cantCols = modelo.getColumnCount();
        
        rs = new Clase().list();
        
        try {
            while(rs.next()) {
                Object[] fila = new Object[cantCols];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                modelo.addRow(fila);
            }
        } catch (Exception e) {
        }
    }
    
    private void refrescarInscripciones() {
        int fila = this.JTable_alumnos.getSelectedRow();
        String dni = this.JTable_alumnos.getValueAt(fila, 0).toString();
        Alumno a1 = new Alumno().find(dni);
        
        
        DefaultTableModel modelo = (DefaultTableModel) this.JTable_inscripcionesDeAlumno.getModel();
        int cantCols = modelo.getColumnCount();
        modelo.setRowCount(0);
        
        rs = a1.listClases(a1.getId());
        
        try {
            while(rs.next()) {
                Object[] elemento = new Object[cantCols];
                for (int i = 0; i < elemento.length; i++) {
                    elemento[i] = rs.getObject(i+1);
                }
                modelo.addRow(elemento);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtField_buscarDniAlumno = new javax.swing.JTextField();
        Btn_buscarDniAlumno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_alumnos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTable_clases = new javax.swing.JTable();
        Btn_inscribir = new javax.swing.JButton();
        Btn_borrar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTable_inscripcionesDeAlumno = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Listado de alumnos:");

        jLabel2.setText("Buscar por DNI:");

        Btn_buscarDniAlumno.setText("Buscar");
        Btn_buscarDniAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_buscarDniAlumnoActionPerformed(evt);
            }
        });

        JTable_alumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "DNI", "Nombre y apellido"
            }
        ));
        JTable_alumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_alumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_alumnos);

        jLabel3.setText("Listado de clases:");

        JTable_clases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nº", "Profesor", "Deporte", "Categoría", "Día y hora", "Cuota mensual"
            }
        ));
        jScrollPane2.setViewportView(JTable_clases);

        Btn_inscribir.setText("Inscribir alumno a la clase");
        Btn_inscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_inscribirActionPerformed(evt);
            }
        });

        Btn_borrar.setText("Borrar alumno de la clase");
        Btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_borrarActionPerformed(evt);
            }
        });

        JTable_inscripcionesDeAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nº inscripción", "Nombre del alumno", "Nº de la clase", "Fecha de inscripción"
            }
        ));
        jScrollPane3.setViewportView(JTable_inscripcionesDeAlumno);

        jLabel4.setText("Actualmente inscripto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtField_buscarDniAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_buscarDniAlumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel3)
                            .addComponent(Btn_inscribir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtField_buscarDniAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_buscarDniAlumno)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_inscribir)
                    .addComponent(Btn_borrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_buscarDniAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_buscarDniAlumnoActionPerformed

        String dni = this.TxtField_buscarDniAlumno.getText().trim();
        if(dni.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "¡El campo no puede estar vacio!", "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        for (int i = 0; i < this.JTable_alumnos.getModel().getRowCount(); i++) {
            for (int j = 0; j < this.JTable_alumnos.getModel().getColumnCount(); j++) {
                if(this.JTable_alumnos.getValueAt(i, 0).toString().equalsIgnoreCase(dni)) {
                    this.JTable_alumnos.setRowSelectionInterval(i, i);
                }
            }
        }
    }//GEN-LAST:event_Btn_buscarDniAlumnoActionPerformed

    private void Btn_inscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_inscribirActionPerformed
        int filaAlumno = this.JTable_alumnos.getSelectedRow();
        String dniAlumno = this.JTable_alumnos.getValueAt(filaAlumno, 0).toString();
        
        Alumno a1 = new Alumno().find(dniAlumno);
        
        int filaClase = this.JTable_clases.getSelectedRow();
        int idClase = Integer.valueOf(this.JTable_clases.getValueAt(filaClase, 0).toString());
        
        Clase c1 = new Clase();
        c1.setId(idClase);
        
        Inscripcion i1 = new Inscripcion();
        i1.setAlumno(a1);
        i1.setClase(c1);
        i1.setFechaInscripcion(LocalDateTime.now());
        
        a1.addToClase(i1);
        
    }//GEN-LAST:event_Btn_inscribirActionPerformed

    private void Btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_borrarActionPerformed
        int fila = this.JTable_inscripcionesDeAlumno.getSelectedRow();
        int idInscripcion = Integer.valueOf(this.JTable_inscripcionesDeAlumno.getValueAt(fila, 0).toString());
        
        Inscripcion i1 = new Inscripcion();
        i1.setNumeroComprobante(idInscripcion);
        
        new Alumno().deleteFromClase(idInscripcion);
        this.refrescarInscripciones();
    }//GEN-LAST:event_Btn_borrarActionPerformed

    private void JTable_alumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_alumnosMouseClicked
        this.refrescarInscripciones();
    }//GEN-LAST:event_JTable_alumnosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Alumno_Clase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alumno_Clase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alumno_Clase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alumno_Clase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alumno_Clase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_borrar;
    private javax.swing.JButton Btn_buscarDniAlumno;
    private javax.swing.JButton Btn_inscribir;
    private javax.swing.JTable JTable_alumnos;
    private javax.swing.JTable JTable_clases;
    private javax.swing.JTable JTable_inscripcionesDeAlumno;
    private javax.swing.JTextField TxtField_buscarDniAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}