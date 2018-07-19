/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.PlainDocument;
import proyectopolilacolonia.Alumno;

/**
 *
 * @author Pablo2
 */
public class Alumno_CRUD extends javax.swing.JFrame {

    private ResultSet rs = null;
    private ResultSetMetaData rsmd = null;
    
    public Alumno_CRUD() {
        initComponents();
        
        this.BtnGroup_sexo.add(RButton_masculino);
        this.BtnGroup_sexo.add(RButton_femenino);
        this.BtnGroup_sexo.add(RButton_otro);
        this.RButton_masculino.setSelected(true);
        
        this.limpiar();
        this.RefrescarTabla();
        
        
        
    }
    
    private void RefrescarTabla() {
        
        Alumno alumno = new Alumno();
        rs = alumno.List();

        DefaultTableModel modelo = (DefaultTableModel) JTable_alumnos.getModel();
        modelo.setRowCount(0);
        
        
        int cantCols = 6;
        try {
            
            while(rs.next()) {
                
                Object[] fila = new Object[cantCols];
                
                fila[0] = rs.getObject(2);
                fila[1] = rs.getObject(4);
                fila[2] = rs.getObject(5);
                fila[3] = rs.getObject(6);
                fila[4] = rs.getObject(7);
                fila[5] = rs.getObject(8);
                
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Alumno_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void limpiar() {
        
        this.TxtField_dni.setText("");
        this.TxtField_nombre.setText("");
        this.RButton_masculino.setSelected(true);
        //this.Dpicker_fecha.setDate(null);
        this.TxtField_nombre.requestFocus();
        
        
    }
    
    private void validarCampos(String dni, String nombre) {
//        String regexDni = "^[1-9]";
//        String regexNombre = "^[aA-zZ]+\\s*";
//        
//        if(!regexDni.matches(dni)) {
//            JOptionPane.showMessageDialog(this, "¡El campo DNI solo puede tener números!", "¡Error!", JOptionPane.ERROR_MESSAGE);
//        }
//        
//        if(!regexNombre.matches(nombre)) {
//            JOptionPane.showMessageDialog(this, "¡El campo nombre solo puede tener letras!", "¡Error!", JOptionPane.ERROR_MESSAGE);
//        }
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGroup_sexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtField_nombre = new javax.swing.JTextField();
        TxtField_dni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        RButton_masculino = new javax.swing.JRadioButton();
        RButton_femenino = new javax.swing.JRadioButton();
        RButton_otro = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CBox_año = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        CBox_mes = new javax.swing.JComboBox<>();
        CBox_dia = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        Btn_registrar = new javax.swing.JButton();
        Btn_editar = new javax.swing.JButton();
        Btn_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TxtField_buscarPorDni = new javax.swing.JTextField();
        Btn_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_alumnos = new javax.swing.JTable();
        Btn_cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(25, 118, 210));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Registro de alumnos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nombre y apellido: (Editable)");

        jLabel2.setText("DNI:");

        jLabel3.setText("Sexo: (Editable)");

        RButton_masculino.setText("Masculino");

        RButton_femenino.setText("Femenino");

        RButton_otro.setText("Otro");

        jLabel4.setText("Fecha de nacimiento: (Editable)");

        jLabel6.setText("Año:");

        CBox_año.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050" }));
        CBox_año.setSelectedIndex(30);

        jLabel7.setText("Mes:");

        CBox_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        CBox_dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel8.setText("Día:");

        Btn_registrar.setBackground(new java.awt.Color(25, 118, 210));
        Btn_registrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Btn_registrar.setForeground(new java.awt.Color(255, 255, 255));
        Btn_registrar.setText("REGISTRAR");
        Btn_registrar.setToolTipText("Registrar un nuevo alumno");
        Btn_registrar.setPreferredSize(new java.awt.Dimension(97, 28));
        Btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_registrarActionPerformed(evt);
            }
        });

        Btn_editar.setBackground(new java.awt.Color(25, 118, 210));
        Btn_editar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Btn_editar.setForeground(new java.awt.Color(255, 255, 255));
        Btn_editar.setText("EDITAR");
        Btn_editar.setToolTipText("Editar un alumno existente");
        Btn_editar.setPreferredSize(new java.awt.Dimension(69, 28));
        Btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_editarActionPerformed(evt);
            }
        });

        Btn_eliminar.setBackground(new java.awt.Color(25, 118, 210));
        Btn_eliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        Btn_eliminar.setText("ELIMINAR");
        Btn_eliminar.setToolTipText("Borrar un alumno existente");
        Btn_eliminar.setPreferredSize(new java.awt.Dimension(87, 28));
        Btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(RButton_masculino, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RButton_femenino, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RButton_otro, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(TxtField_nombre)
                            .addComponent(TxtField_dni)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(14, 14, 14)
                        .addComponent(CBox_año, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBox_mes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CBox_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Btn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtField_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(RButton_masculino)
                    .addComponent(RButton_femenino)
                    .addComponent(RButton_otro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(CBox_año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(CBox_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBox_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Buscar alumnos por DNI:");

        Btn_buscar.setBackground(new java.awt.Color(25, 118, 210));
        Btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        Btn_buscar.setText("BUSCAR");
        Btn_buscar.setToolTipText("Buscar un alumno en el listado por el DNI.");
        Btn_buscar.setPreferredSize(new java.awt.Dimension(83, 28));
        Btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_buscarActionPerformed(evt);
            }
        });

        JTable_alumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Dni", "Nombre y apellido", "Fecha de nacimiento", "Sexo", "Fecha de registro", "Ultima vez modificado"
            }
        ));
        JTable_alumnos.setGridColor(new java.awt.Color(204, 204, 204));
        JTable_alumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_alumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_alumnos);

        Btn_cerrar.setBackground(new java.awt.Color(25, 118, 210));
        Btn_cerrar.setForeground(new java.awt.Color(255, 255, 255));
        Btn_cerrar.setText("CERRAR");
        Btn_cerrar.setToolTipText("Cerrar formulario");
        Btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtField_buscarPorDni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(Btn_cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtField_buscarPorDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_registrarActionPerformed
        if(this.TxtField_nombre.getText() == "" || this.TxtField_dni.getText() == ""/*this.Dpicker_fecha.getDate() == null*/) {
            JOptionPane.showMessageDialog(this, "¡Todos los campos son obligatorios!", "¡Error!", JOptionPane.ERROR_MESSAGE);
        } else {
//            this.validarCampos(TxtField_dni.getText().trim(), TxtField_nombre.getText().trim());
            
            
            Alumno alumno = new Alumno();
            String codTarjeta = this.TxtField_dni.getText().trim() + this.TxtField_nombre.getText().trim();
            int ano = Integer.valueOf(this.CBox_año.getSelectedItem().toString());
            int mes = 1;
            int dia = Integer.valueOf(this.CBox_dia.getSelectedItem().toString());
            
            switch(this.CBox_mes.getSelectedItem().toString()) {
                case "Enero":mes=1;
                break;
                case "Febrero":mes=2;
                break;
                case "Marzo":mes=3;
                break;
                case "Abril":mes=4;
                break;
                case "Mayo":mes=5;
                break;
                case "Junio":mes=6;
                break;
                case "Julio":mes=7;
                break;
                case "Agosto":mes=8;
                break;
                case "Septiembre":mes=9;
                break;
                case "Octubre":mes=10;
                break;
                case "Noviembre":mes=11;
                break;
                case "Diciembre":mes=12;
                break;
            }
            
            LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);
            
            //LocalDate fechaNacimiento = this.Dpicker_fecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            //LocalDate fechaNacimiento = LocalDate.now();
            alumno.setDni(this.TxtField_dni.getText().trim());
            alumno.setCodTarjeta(codTarjeta);
            alumno.setNombreCompleto(this.TxtField_nombre.getText().trim());
            alumno.setFechaNacimiento(fechaNacimiento);
            //alumno.setFechaNacimiento(fechaNacimiento);
            
            if(this.RButton_masculino.isSelected()) {
                alumno.setSexo(this.RButton_masculino.getText());
            } else if (this.RButton_femenino.isSelected()) {
                alumno.setSexo(this.RButton_femenino.getText());
            } else {
                alumno.setSexo(this.RButton_otro.getText());
            }
            
            alumno.setCreated_at(LocalDateTime.now());
            alumno.setUpdated_at(LocalDateTime.now());
           
            
            alumno.save(alumno);
            
            this.RefrescarTabla();
            
        }
    }//GEN-LAST:event_Btn_registrarActionPerformed

    private void JTable_alumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_alumnosMouseClicked
        int fila = this.JTable_alumnos.getSelectedRow();
        String dni = this.JTable_alumnos.getValueAt(fila, 0).toString();
        Alumno a1 = new Alumno();
        Alumno a2 = new Alumno();
        
        a2 = a1.find(dni);
        this.TxtField_dni.setText(a2.getDni());
        this.TxtField_nombre.setText(a2.getNombreCompleto());
        
        if(a2.getSexo().equalsIgnoreCase("Masculino")) {
            
            this.RButton_masculino.setSelected(true);
        } else if(a2.getSexo().equalsIgnoreCase("Femenino")) {
            
            this.RButton_femenino.setSelected(true);
        } else {
            this.RButton_otro.setSelected(true);
        }
        String fechaNacimiento = a2.getFechaNacimiento().toString();
        String[] fechas = fechaNacimiento.split("-");
        this.CBox_año.setSelectedItem(fechas[0]);
        this.CBox_dia.setSelectedItem(fechas[2]);
        switch(fechas[1]) {
            case "01": this.CBox_mes.setSelectedIndex(0);
            break;
            case "02": this.CBox_mes.setSelectedIndex(1);
            break;
            case "03": this.CBox_mes.setSelectedIndex(2);
            break;
            case "04": this.CBox_mes.setSelectedIndex(3);
            break;
            case "05": this.CBox_mes.setSelectedIndex(4);
            break;
            case "06": this.CBox_mes.setSelectedIndex(5);
            break;
            case "07": this.CBox_mes.setSelectedIndex(6);
            break;
            case "08": this.CBox_mes.setSelectedIndex(7);
            break;
            case "09": this.CBox_mes.setSelectedIndex(8);
            break;
            case "10": this.CBox_mes.setSelectedIndex(9);
            break;
            case "11": this.CBox_mes.setSelectedIndex(10);
            break;
            case "12": this.CBox_mes.setSelectedIndex(11);
            break;
        }
        
        //this.Dpicker_fecha.setDate(Date.valueOf(a2.getFechaNacimiento()));
        
    }//GEN-LAST:event_JTable_alumnosMouseClicked

    private void Btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cerrarActionPerformed
        this.limpiar();
        this.dispose();
        this.setVisible(false);
        
    }//GEN-LAST:event_Btn_cerrarActionPerformed

    private void Btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_editarActionPerformed
        Alumno a1 = new Alumno();
        a1.setNombreCompleto(this.TxtField_nombre.getText().trim());
        a1.setDni(this.TxtField_dni.getText().trim());
        
        int ano = Integer.valueOf(this.CBox_año.getSelectedItem().toString());
        int dia = Integer.valueOf(this.CBox_dia.getSelectedItem().toString());
        int mes = 0;
        
        switch(this.CBox_mes.getSelectedItem().toString()) {
                case "Enero":mes=1;
                break;
                case "Febrero":mes=2;
                break;
                case "Marzo":mes=3;
                break;
                case "Abril":mes=4;
                break;
                case "Mayo":mes=5;
                break;
                case "Junio":mes=6;
                break;
                case "Julio":mes=7;
                break;
                case "Agosto":mes=8;
                break;
                case "Septiembre":mes=9;
                break;
                case "Octubre":mes=10;
                break;
                case "Noviembre":mes=11;
                break;
                case "Diciembre":mes=12;
                break;
            }
        
        LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);
        a1.setFechaNacimiento(fechaNacimiento);
        //a1.setFechaNacimiento(this.Dpicker_fecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        
        if(this.RButton_masculino.isSelected()) {
            a1.setSexo(this.RButton_masculino.getText());
        } else if (this.RButton_femenino.isSelected()) {
            a1.setSexo(this.RButton_femenino.getText());
        } else {
            a1.setSexo(this.RButton_otro.getText());
        }
        
        a1.setUpdated_at(LocalDateTime.now());
        
        a1.update(a1);
        
        this.RefrescarTabla();
        this.limpiar();
    }//GEN-LAST:event_Btn_editarActionPerformed

    private void Btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_eliminarActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "¿Estas seguro que quieres eliminar este usuario?");
        if(result == JOptionPane.YES_NO_OPTION) {
            String dni = this.TxtField_dni.getText().trim();
            Alumno a1 = new Alumno();
            a1.delete(dni);
            this.RefrescarTabla();
            this.limpiar();
        }
    }//GEN-LAST:event_Btn_eliminarActionPerformed

    private void Btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_buscarActionPerformed
        String dni = this.TxtField_buscarPorDni.getText().trim();
        int cantRows = this.JTable_alumnos.getModel().getRowCount();
        int cantCols = this.JTable_alumnos.getModel().getColumnCount();
        
        for(int i=0; i < cantRows; i++) {
            for(int j=0; j < cantCols; j++) {
                if(this.JTable_alumnos.getValueAt(i, j).toString().equalsIgnoreCase(dni)) {
                    this.JTable_alumnos.setRowSelectionInterval(i, i);
                    
                }
                
            }
        }
    }//GEN-LAST:event_Btn_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(Alumno_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alumno_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alumno_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alumno_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alumno_CRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnGroup_sexo;
    private javax.swing.JButton Btn_buscar;
    private javax.swing.JButton Btn_cerrar;
    private javax.swing.JButton Btn_editar;
    private javax.swing.JButton Btn_eliminar;
    private javax.swing.JButton Btn_registrar;
    private javax.swing.JComboBox<String> CBox_año;
    private javax.swing.JComboBox<String> CBox_dia;
    private javax.swing.JComboBox<String> CBox_mes;
    private javax.swing.JTable JTable_alumnos;
    private javax.swing.JRadioButton RButton_femenino;
    private javax.swing.JRadioButton RButton_masculino;
    private javax.swing.JRadioButton RButton_otro;
    private javax.swing.JTextField TxtField_buscarPorDni;
    private javax.swing.JTextField TxtField_dni;
    private javax.swing.JTextField TxtField_nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
