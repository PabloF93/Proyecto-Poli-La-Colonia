/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectopolilacolonia.Deporte;

/**
 *
 * @author Pablo2
 */
public class Deporte_CRUD extends javax.swing.JFrame {

    private ResultSet rs = null;
    
    public Deporte_CRUD() {
        initComponents();
        
        this.refrescarDeportes();
    }
    
    private void refrescarDeportes() {
        DefaultTableModel modelo = (DefaultTableModel) this.JTable_deportes.getModel();
        int cantCols = modelo.getColumnCount();
        modelo.setRowCount(0);
        
        rs = new Deporte().list();
        
        try {
            while(rs.next()) {
                Object[] fila = new Object[cantCols];
                
                for (int i = 0; i < cantCols; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                
                modelo.addRow(fila);
            }
        } catch (Exception e) {
        }
    }
    
    private void limpiar() {
        this.TxtField_nombre.setText("");
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
        TxtField_nombre = new javax.swing.JTextField();
        Btn_registrar = new javax.swing.JButton();
        Btn_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_deportes = new javax.swing.JTable();
        Btn_cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre del deporte:");

        Btn_registrar.setText("Registrar");
        Btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_registrarActionPerformed(evt);
            }
        });

        Btn_eliminar.setText("Eliminar");
        Btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_eliminarActionPerformed(evt);
            }
        });

        JTable_deportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nº", "Deporte"
            }
        ));
        jScrollPane1.setViewportView(JTable_deportes);

        Btn_cerrar.setText("Cerrar");
        Btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TxtField_nombre))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Btn_cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_registrar)
                    .addComponent(Btn_eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_registrarActionPerformed
        if(this.TxtField_nombre.getText()=="") {
            JOptionPane.showMessageDialog(this, "¡El campo no puede estar vacio!");
        } else {
            Deporte d1 = new Deporte();
            d1.setNombreDeporte(this.TxtField_nombre.getText().trim());
            d1.save(d1);
            
            this.refrescarDeportes();
            this.limpiar();
            
        }
    }//GEN-LAST:event_Btn_registrarActionPerformed

    private void Btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_eliminarActionPerformed
        int resultado=JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quiere eliminar este deporte?", "Eliminar",JOptionPane.YES_NO_OPTION);
        if(resultado==JOptionPane.YES_NO_OPTION) {
            int fila = this.JTable_deportes.getSelectedRow();
            int id = Integer.valueOf(this.JTable_deportes.getValueAt(fila, 0).toString());
            
            new Deporte().delete(id);
            
            this.refrescarDeportes();
            this.limpiar();
        }
        
        
        
    }//GEN-LAST:event_Btn_eliminarActionPerformed

    private void Btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cerrarActionPerformed
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_Btn_cerrarActionPerformed

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
            java.util.logging.Logger.getLogger(Deporte_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Deporte_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Deporte_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Deporte_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Deporte_CRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_cerrar;
    private javax.swing.JButton Btn_eliminar;
    private javax.swing.JButton Btn_registrar;
    private javax.swing.JTable JTable_deportes;
    private javax.swing.JTextField TxtField_nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
