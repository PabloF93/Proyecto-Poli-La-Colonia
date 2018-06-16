/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import proyectopolilacolonia.Categoria;
import proyectopolilacolonia.Clase;
import proyectopolilacolonia.Deporte;
import proyectopolilacolonia.Profesor;

/**
 *
 * @author Pablo2
 */
public class Clase_CRUD extends javax.swing.JFrame {

    private ResultSet rs = null;
    
    public Clase_CRUD() {
        initComponents();
        this.refrescarProfesores();
        this.refrescarDeportes();
        this.refrescarClases();
        
    }
    
    private void refrescarProfesores() {
        
        this.CBox_profesores.removeAllItems();
        rs = new Profesor().list();
        
        try {
            while(rs.next()) {
                this.CBox_profesores.addItem(rs.getString(4));
                
            }
        } catch (Exception e) {
        }
        
    }

    private void refrescarDeportes() {
        this.CBox_deportes.removeAllItems();
        rs = new Deporte().list();
        try {
            while(rs.next()) {
                this.CBox_deportes.addItem(rs.getString(2));
            }
        } catch (Exception e) {
        }
        
    }
    
    private void refrescarCategorias() {
        
        String deporte = this.CBox_deportes.getSelectedItem().toString();
        if(!deporte.equalsIgnoreCase("")) {
            this.CBox_categorias.removeAllItems();
            Deporte d1 = new Deporte().find(deporte);
            
            rs = new Deporte().findCategories(d1.getId());
            

            try {
                while(rs.next()) {
                    this.CBox_categorias.addItem(rs.getString(2));
                }
            } catch (Exception e) {
            }
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
                for (int i = 0; i < cantCols; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                modelo.addRow(fila);
            }
        } catch (Exception e) {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtField_precio = new javax.swing.JTextField();
        CBox_profesores = new javax.swing.JComboBox<>();
        CBox_deportes = new javax.swing.JComboBox<>();
        CBox_categorias = new javax.swing.JComboBox<>();
        Btn_registrar = new javax.swing.JButton();
        Btn_editar = new javax.swing.JButton();
        Btn_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_clases = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        CBox_dias = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        CBox_horaEnt = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        CBox_horaSal = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccione un profesor: (Editable)");

        jLabel2.setText("Seleccione un deporte:");

        jLabel3.setText("Seleccione una categoría:");

        jLabel4.setText("Precio de la clase:");

        TxtField_precio.setEnabled(false);

        CBox_profesores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CBox_deportes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBox_deportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CBox_deportesMouseEntered(evt);
            }
        });

        CBox_categorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBox_categorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CBox_categoriasMouseEntered(evt);
            }
        });

        Btn_registrar.setText("Crear");
        Btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_registrarActionPerformed(evt);
            }
        });

        Btn_editar.setText("Editar");

        Btn_eliminar.setText("Eliminar");

        JTable_clases.setBorder(new javax.swing.border.MatteBorder(null));
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
        jScrollPane1.setViewportView(JTable_clases);

        jLabel5.setText("Horario:");

        CBox_dias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sabado", "Domingo" }));

        jLabel7.setText("de");

        CBox_horaEnt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));

        jLabel8.setText("a");

        CBox_horaSal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btn_registrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_eliminar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtField_precio)
                            .addComponent(CBox_profesores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CBox_deportes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CBox_categorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CBox_dias, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CBox_horaEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CBox_horaSal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CBox_profesores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CBox_deportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CBox_categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtField_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CBox_dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(CBox_horaEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(CBox_horaSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_registrar)
                    .addComponent(Btn_editar)
                    .addComponent(Btn_eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBox_deportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBox_deportesMouseEntered
        this.refrescarCategorias();
    }//GEN-LAST:event_CBox_deportesMouseEntered

    private void CBox_categoriasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBox_categoriasMouseEntered
        String categoria = this.CBox_categorias.getSelectedItem().toString();
        Categoria c1 = new Deporte().findCategory(categoria);
        this.TxtField_precio.setText(String.valueOf(c1.getValorCuota()));
        
        
        
    }//GEN-LAST:event_CBox_categoriasMouseEntered

    private void Btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_registrarActionPerformed
        String profesor = this.CBox_profesores.getSelectedItem().toString();
        String deporte = this.CBox_deportes.getSelectedItem().toString();
        String categoria = this.CBox_categorias.getSelectedItem().toString();
        String dia = this.CBox_dias.getSelectedItem().toString();
        String horaEnt = this.CBox_horaEnt.getSelectedItem().toString();
        String horaSal = this.CBox_horaSal.getSelectedItem().toString();
        String diaHora = "Día: "+dia+" de "+horaEnt+" a "+horaSal+".";
        
        Profesor p1 = new Profesor().findByName(profesor);
        Deporte d1 = new Deporte().find(deporte);
        Categoria c1 = d1.findCategory(categoria);
        
        Clase clase = new Clase();
        clase.setEntrenador(p1);
        clase.setDeporte(d1);
        clase.setCategoria(c1);
        clase.setDiaHora(diaHora);
        
        clase.save(clase);
        
        this.refrescarClases();
    }//GEN-LAST:event_Btn_registrarActionPerformed

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
            java.util.logging.Logger.getLogger(Clase_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clase_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clase_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clase_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clase_CRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_editar;
    private javax.swing.JButton Btn_eliminar;
    private javax.swing.JButton Btn_registrar;
    private javax.swing.JComboBox<String> CBox_categorias;
    private javax.swing.JComboBox<String> CBox_deportes;
    private javax.swing.JComboBox<String> CBox_dias;
    private javax.swing.JComboBox<String> CBox_horaEnt;
    private javax.swing.JComboBox<String> CBox_horaSal;
    private javax.swing.JComboBox<String> CBox_profesores;
    private javax.swing.JTable JTable_clases;
    private javax.swing.JTextField TxtField_precio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}