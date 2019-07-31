/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author grifiun
 */
public class RealizarPrestamo extends javax.swing.JFrame {
    private final String PRESTAMO_REGISTRADO_EXITOSAMENTE = "El prestamo ha sido registrado de forma exitosa";
    private final String MAS_DE_TRES_LIBROS = "El estudiante ya posee 3 prestamos activos";
    /**
     * Creates new form RealizarPrestamo
     */
    public RealizarPrestamo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPrestamos = new javax.swing.JLabel();
        lblCodigoLibro = new javax.swing.JLabel();
        lblCarnet = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtFdCodigoLibro = new javax.swing.JTextField();
        txtFdCarnet = new javax.swing.JTextField();
        txtFdDia = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtFdMes = new javax.swing.JTextField();
        txtFdAnio = new javax.swing.JTextField();
        lblMes = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblPrestamos.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblPrestamos.setText("PRESTAMOS");

        lblCodigoLibro.setText("Codigo libro");

        lblCarnet.setText("Carnet");

        lblFecha.setText("Fecha");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblMes.setText("Mes:");

        lblDia.setText("Dia:");

        lblAnio.setText("Año:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblPrestamos)
                .addGap(230, 230, 230))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblCarnet)
                        .addComponent(lblCodigoLibro))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFecha)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDia)
                        .addGap(4, 4, 4)
                        .addComponent(txtFdDia, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lblMes)
                        .addGap(6, 6, 6)
                        .addComponent(txtFdMes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAnio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFdAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFdCarnet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFdCodigoLibro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblPrestamos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoLibro)
                    .addComponent(txtFdCodigoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFdCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCarnet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFdDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFdMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFdAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha)
                    .addComponent(lblMes)
                    .addComponent(lblDia)
                    .addComponent(lblAnio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSalir))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Accion que toma el boton btnGuardar al ser presionado.
     * Revisa si 
     * @param evt 
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        verificarEntradaDatos(txtFdCodigoLibro.getText(), txtFdCarnet.getText(), txtFdDia.getText(), txtFdMes.getText(), txtFdAnio.getText());        
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    private void verificarEntradaDatos(String codLibro, String carnetF, String diaF, String mesF, String anioF){
        if ("".equals(codLibro) || "".equals(carnetF) || "".equals(diaF) || "".equals(mesF) || "".equals(anioF)){
            JOptionPane.showMessageDialog(this, ManejadorDeErrores.ERROR_PARAMETRO_FALTANTE);        
        }else{
            try {
                    int carnet = Integer.parseInt(carnetF);                    
                    int dia = Integer.parseInt(diaF);
                    int mes = Integer.parseInt(mesF);
                    int anio = Integer.parseInt(anioF);
                    
                    if(ManejadorDeErrores.verificarCodigo(codLibro) == false)
                        JOptionPane.showMessageDialog(this, ManejadorDeErrores.ERROR_CODIGO_INVALIDO);
                    else{
                        verificarErrorDatos(codLibro, carnetF, dia, mes, anio, carnet);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, ManejadorDeErrores.ERROR_NO_ES_UN_ENTERO); 
                }
        }
    }
    
    private void verificarErrorDatos(String codLibro, String carnetF, int dia, int mes, int anio, int carnet){
        if(ManejadorDeErrores.revisarRangoDia(dia) && ManejadorDeErrores.revisarRangoMes(mes) && ManejadorDeErrores.revisarRangoAnio(anio)){
            if(ManejadorDeErrores.verificarCarnet(carnetF) == null){
                if(verificarCantidadPrestamosActivos(carnet) >= 3){
                    JOptionPane.showMessageDialog(this, MAS_DE_TRES_LIBROS);
                }else{
                    registrarPrestamo(codLibro, carnet, dia, mes, anio);
                    JOptionPane.showMessageDialog(this, PRESTAMO_REGISTRADO_EXITOSAMENTE);
                    limpiarCajasTexto();
                }
            }
            else{
                JOptionPane.showMessageDialog(this, ManejadorDeErrores.ERROR_CARNET_INVALIDO);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, ManejadorDeErrores.ERROR_FECHA_INVALIDO);
        }
                            
    }
    
    private void registrarPrestamo(String codLibro, int carnet, int dia, int mes, int anio){        
        try {
            LocalDate fecha = LocalDate.of(anio, mes, dia);
            Prestamo prestamo = new Prestamo(codLibro, carnet, fecha); //Creamos un objeto de tipo Prestamo utilizando su contructor
            ManejadorDeArchivos.crearArchivoPrestamo(prestamo);            
            
        } catch (IOException ex) {
            Logger.getLogger(RegistrarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int verificarCantidadPrestamosActivos(int carnet){
        Prestamo prestamo[] = null;
        int cantidadPrestamosActivos = 0;
        
        try {
            prestamo = LectorArchivos.cargarPrestamosExistentes();
            for(int i = 0; i < prestamo.length; i++){                
                if(prestamo[i].getCarnetEstudiante() == carnet && prestamo[i].isEstado()){
                    cantidadPrestamosActivos++;                     
                }                
            }
            
            return cantidadPrestamosActivos;
        } catch (IOException ex) {
            Logger.getLogger(RealizarPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RealizarPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    private void limpiarCajasTexto(){
        txtFdAnio.setText("");
        txtFdCarnet.setText("");        
        txtFdDia.setText("");
        txtFdMes.setText("");
        txtFdCodigoLibro.setText("");
    }
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(RealizarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarPrestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblCarnet;
    private javax.swing.JLabel lblCodigoLibro;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblPrestamos;
    private javax.swing.JTextField txtFdAnio;
    private javax.swing.JTextField txtFdCarnet;
    private javax.swing.JTextField txtFdCodigoLibro;
    private javax.swing.JTextField txtFdDia;
    private javax.swing.JTextField txtFdMes;
    // End of variables declaration//GEN-END:variables
}
