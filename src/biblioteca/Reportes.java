/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sergio
 */
public class Reportes extends javax.swing.JFrame {

    /**
     * Creates new form Reportes
     */
    public Reportes() throws IOException, FileNotFoundException, ClassNotFoundException {
        initComponents();
        ocultarMensajesDeError();
        cargarTodasLasEstadisticas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtCarnetPrestamo = new javax.swing.JTextField();
        btnBuscarPresXEstud = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblErrorPresXEstud = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPresXEstud = new javax.swing.JTable();
        lblErrorPXENoRegistro = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtCarnetLibro = new javax.swing.JTextField();
        btnBuscarLibro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblErrorLibro = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        comBCarreras = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbtPresXCarrera = new javax.swing.JTable();
        lblErrorPresXCarrera = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Prestamos Para Hoy", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Prestamos En Mora", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Ingresos", jPanel3);

        btnBuscarPresXEstud.setText("Buscar");
        btnBuscarPresXEstud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPresXEstudActionPerformed(evt);
            }
        });

        jLabel2.setText("Carnet:");

        lblErrorPresXEstud.setText("Carnet Invalido");

        tblPresXEstud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo De Libro", "Fecha De Prestamo", "Estado"
            }
        ));
        jScrollPane2.setViewportView(tblPresXEstud);

        lblErrorPXENoRegistro.setText("No Existen Registros");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lblErrorPresXEstud, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lblErrorPXENoRegistro)
                                .addGap(121, 121, 121)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtCarnetPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btnBuscarPresXEstud)
                                .addContainerGap())))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCarnetPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPresXEstud)
                    .addComponent(jLabel2)
                    .addComponent(lblErrorPXENoRegistro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorPresXEstud)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Prestamos Por Estudiante", jPanel4);

        btnBuscarLibro.setText("Buscar");

        jLabel1.setText("Carnet:");

        lblErrorLibro.setText("Carnet Invalido");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Titulo", "Autor", "Fecha De Publicacion", "Editorial"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCarnetLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarLibro)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(lblErrorLibro)
                                .addGap(148, 148, 148))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCarnetLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarLibro)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorLibro)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Libros Por Estudiante", jPanel5);

        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        comBCarreras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Ingenieria", "2 Medicina", "3 Derecho", "4 Arquitectura", "5 Administracion" }));
        comBCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBCarrerasActionPerformed(evt);
            }
        });

        tbtPresXCarrera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Carnet", "Codigo Libro", "Fecha De Prestamo", "Estado"
            }
        ));
        jScrollPane3.setViewportView(tbtPresXCarrera);

        lblErrorPresXCarrera.setText("No Existen Registros");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblErrorPresXCarrera)
                .addGap(219, 219, 219)
                .addComponent(comBCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comBCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorPresXCarrera))
                .addGap(63, 63, 63)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Prestamos Por Carrera", jPanel6);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("Reportes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
    }//GEN-LAST:event_jPanel6MouseClicked

    private void comBCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBCarrerasActionPerformed
        try {
            lblErrorPresXCarrera.setVisible(false);
            recetearTabla(tbtPresXCarrera);
            cargarPrestamosPorCarrera();
        } catch (IOException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comBCarrerasActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarPresXEstudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPresXEstudActionPerformed
        ocultarMensajesDeError();
        recetearTabla(tblPresXEstud);
        try {
            //Verificacion deque se ingrese un entero
            int num =  Integer.valueOf(txtCarnetPrestamo.getText());
        } catch (NumberFormatException e) {
            lblErrorPresXEstud.setVisible(true);
        }
        //Verificaccion que el carnet sea de 9 digitos
        if (lblErrorPresXEstud.isVisible()==false && txtCarnetPrestamo.getText().length()==9) {
            try {
            lblErrorPresXEstud.setVisible(false);
            lblErrorPXENoRegistro.setVisible(false);            
            cargarPrestamosPorEsudiante();
        } catch (IOException | ClassNotFoundException | NumberFormatException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            lblErrorPresXEstud.setVisible(true);
        }
        
    }//GEN-LAST:event_btnBuscarPresXEstudActionPerformed
   //Metodo que oculta todos los mensajes errores
    private void ocultarMensajesDeError() {
        lblErrorPXENoRegistro.setVisible(false);
        lblErrorPresXEstud.setVisible(false);
        lblErrorLibro.setVisible(false);
        lblErrorPresXCarrera.setVisible(false);
    }

    private void cargarTodasLasEstadisticas() throws IOException, FileNotFoundException, ClassNotFoundException {
        cargarPrestamosPorCarrera();
    }

    private void cargarPrestamosPorEsudiante() throws IOException, FileNotFoundException, ClassNotFoundException {
        agregarATablaPrestamosPorEstudiante(LectorArchivos.buscarPrestamosPorCarnet(Integer.valueOf(txtCarnetPrestamo.getText())));
    }

    private void cargarPrestamosPorCarrera() throws IOException, FileNotFoundException, ClassNotFoundException {
        agregarATablaPrestamosPorCarrera(LectorArchivos.buscarPrestamosPorCarrera(comBCarreras.getSelectedIndex() + 1));
    }
//Agrega los prestamos a la tabla prestamosPorCarrera
    private void agregarATablaPrestamosPorCarrera(ArrayList<Prestamo> prestamos) {
        if (prestamos != null) {
            DefaultTableModel model = (DefaultTableModel) tbtPresXCarrera.getModel();
            for (int i = 0; i < prestamos.size(); i++) {//Creacion de Celdas
                model.addRow(new Object[]{"", "", "", ""});
            }
            for (int i = 0; i < prestamos.size(); i++) {
                tbtPresXCarrera.setValueAt(prestamos.get(i).getCarnetEstudiante(), i, 0);//codigo
                tbtPresXCarrera.setValueAt(prestamos.get(i).getCodigoLibro(), i, 1);//titulo
                tbtPresXCarrera.setValueAt(prestamos.get(i).getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), i, 2);//Fecha
                if (prestamos.get(i).isEstado()) {
                    tbtPresXCarrera.setValueAt("Activo", i, 3);//estado
                } else {
                    tbtPresXCarrera.setValueAt("Desactivo", i, 3);//estado
                }
            }
        } else {
            lblErrorPresXCarrera.setVisible(true);
        }
    }
//Agrega Prestamos a la tabla de Estudiantes
    private void agregarATablaPrestamosPorEstudiante(ArrayList<Prestamo> prestamos) {
        if (prestamos != null) {
            DefaultTableModel model = (DefaultTableModel) tblPresXEstud.getModel();
            for (int i = 0; i < prestamos.size(); i++) {//Creacion de Celdas
                model.addRow(new Object[]{"", "", "", ""});
            }
            for (int i = 0; i < prestamos.size(); i++) {
                tblPresXEstud.setValueAt(prestamos.get(i).getCodigoLibro(), i, 0);//Codigo
                tblPresXEstud.setValueAt(prestamos.get(i).getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), i, 1);//Fecha
                if (prestamos.get(i).isEstado()) {
                    tblPresXEstud.setValueAt("Activo", i, 2);//estado
                } else {
                    tblPresXEstud.setValueAt("Desactivo", i, 2);//estado
                }

            }
        } else {
            lblErrorPXENoRegistro.setVisible(true);
        }
    }
//Borra las celdas de la talba que se envia de parametro
    private void recetearTabla(JTable tabla) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        System.out.println(model.getRowCount());
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i >= 0; i--) {//Creacion de Celdas
                model.removeRow(0);
            }
        }
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarLibro;
    private javax.swing.JButton btnBuscarPresXEstud;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comBCarreras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblErrorLibro;
    private javax.swing.JLabel lblErrorPXENoRegistro;
    private javax.swing.JLabel lblErrorPresXCarrera;
    private javax.swing.JLabel lblErrorPresXEstud;
    private javax.swing.JTable tblPresXEstud;
    private javax.swing.JTable tbtPresXCarrera;
    private javax.swing.JTextField txtCarnetLibro;
    private javax.swing.JTextField txtCarnetPrestamo;
    // End of variables declaration//GEN-END:variables
}
