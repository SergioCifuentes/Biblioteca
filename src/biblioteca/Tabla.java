/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sergio
 */
public class Tabla extends javax.swing.JDialog {

    String identificador;
    Libro[] libros;
    Estudiante[] estudiante;
    boolean acendente;

    /**
     * Creates new form Tabla
     *
     * @param parent
     * @param modal
     * @param identificador
     * @throws java.io.IOException
     */
    public Tabla(java.awt.Frame parent, boolean modal, String identificador) throws IOException, FileNotFoundException, ClassNotFoundException {
        super(parent, modal);
        initComponents();
        this.identificador = identificador;
        lblError.setVisible(false);
        lblTitulo.setText(identificador);
        acendente = false;
        //Tabla de libros existentes
        if (identificador.equals(ManejadorDeArchivos.IDENTIFICADOR_LIBRO)) {
            agregarColumnasLibros();
            this.libros = LectorArchivos.cargarLibrosExistentes();
            agregarFilas();
            cargarRegistroLibro(LectorArchivos.cargarLibrosExistentes());
            //Tabla De Estudiantes existentes
        } else if (identificador.equals(ManejadorDeArchivos.IDENTIFICADOR_ESTUDIANTE)) {
            this.estudiante = LectorArchivos.cargarEstudianteExistentes();
            agregarColumnasEstudiantes();
            agregarFilas();
            cargarRegistroEstudiante(LectorArchivos.cargarEstudianteExistentes());
        }
    }

    private void agregarColumnasLibros() {
        DefaultTableModel modelo = (DefaultTableModel) tblRegistros.getModel();
        modelo.addColumn(ManejadorDeArchivos.IDENTIFICADOR_CODIGO);
        modelo.addColumn(ManejadorDeArchivos.IDENTIFICADOR_TITULO);
        modelo.addColumn(ManejadorDeArchivos.IDENTIFICADOR_AUTOR);
        modelo.addColumn(ManejadorDeArchivos.IDENTIFICADOR_CANTIDAD);
        modelo.addColumn("FECHA DE PUBLICACION");
        modelo.addColumn("EDITORIAL");
    }

    private void agregarFilas() {

        if (identificador.equals(ManejadorDeArchivos.IDENTIFICADOR_LIBRO)) {
            if (libros != null) {
                DefaultTableModel model = (DefaultTableModel) tblRegistros.getModel();
                for (int i = 0; i < libros.length; i++) {//Creacion de Celdas
                    model.addRow(new Object[]{"", "", "", ""});
                }
            }

        } else {
            if (estudiante != null) {
                DefaultTableModel model = (DefaultTableModel) tblRegistros.getModel();
                System.out.println(estudiante.length);
                for (int i = 0; i < estudiante.length; i++) {//Creacion de Celdas
                    model.addRow(new Object[]{"", "", "", "","",""});
                }
            }
        }
    }
//Arega los libros existentes a la tabla dependeindo del orden acendente o descendente
    private void cargarRegistroLibro(Libro[] libros) {
        if (libros != null) {
            if (acendente == false) {
                for (int i = 0; i < libros.length; i++) {
                    tblRegistros.setValueAt(libros[i].getCodigo(), i, 0);//codigo
                    tblRegistros.setValueAt(libros[i].getTitulo(), i, 1);//titulo
                    tblRegistros.setValueAt(libros[i].getAutor(), i, 2);//autor
                    tblRegistros.setValueAt(libros[i].getCantidad(), i, 3);//cantidad
                    if (libros[i].getFechaPublicacion()!= null) {
                            tblRegistros.setValueAt(libros[i].getFechaPublicacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), i, 4);//Fecha
                    } else {
                        tblRegistros.setValueAt("---", i, 4);
                    }
                    if (libros[i].getEditorial()!= null) {
                        tblRegistros.setValueAt(libros[i].getEditorial(),i, 5);//Editorial
                    } else {
                        tblRegistros.setValueAt("---", i, 5);
                    }
                    this.acendente = true;
                }
            } else {
                int cont = 0;
                for (int i = libros.length - 1; i >= 0; i--) {
                    tblRegistros.setValueAt(libros[i].getCodigo(), cont, 0);//codigo
                    tblRegistros.setValueAt(libros[i].getTitulo(), cont, 1);//titulo
                    tblRegistros.setValueAt(libros[i].getAutor(), cont, 2);//autor
                    tblRegistros.setValueAt(libros[i].getCantidad(), cont, 3);//cantidad
                    if (libros[i].getFechaPublicacion()!= null) {
                        tblRegistros.setValueAt(libros[i].getFechaPublicacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), cont, 4);//Fecha
                    } else {
                        tblRegistros.setValueAt("---", cont, 4);
                    }
                    if (libros[i].getEditorial()!= null) {
                        tblRegistros.setValueAt(libros[i].getEditorial(),cont, 5);//Editorial
                    } else {
                        tblRegistros.setValueAt("---", cont, 5);
                    }
                    cont++;
                    this.acendente = false;
                }

            }

        } else {
            lblError.setVisible(true);

        }

    }
//Arega los estudiantes existentes a la tabla dependeindo del orden acendente o descendente
    private void cargarRegistroEstudiante(Estudiante[] estudiantes) {
        if (estudiantes != null) {
            if (acendente == false) {
                for (int i = 0; i < estudiantes.length; i++) {
                    tblRegistros.setValueAt(estudiantes[i].getCarnet(), i, 0);//carnet
                    tblRegistros.setValueAt(estudiantes[i].getNombre(), i, 1);//nombre
                    tblRegistros.setValueAt(estudiantes[i].getCarrer(), i, 2);//carera
                    if (estudiantes[i].getFechaDeNacimiento() != null) {
                        tblRegistros.setValueAt(estudiantes[i].getFechaDeNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), i, 3);//Fecha
                    } else {
                        tblRegistros.setValueAt("---", i, 3);
                    }
                }
                this.acendente=true;
            } else {
                int cont = 0 ;
                for (int i = estudiantes.length-1; i >= 0; i--) {
                    tblRegistros.setValueAt(estudiantes[i].getCarnet(), cont, 0);//carnet
                    tblRegistros.setValueAt(estudiantes[i].getNombre(), cont, 1);//nombre
                    tblRegistros.setValueAt(estudiantes[i].getCarrer(), cont, 2);//carera
                    if (estudiantes[i].getFechaDeNacimiento() != null) {
                        tblRegistros.setValueAt(estudiantes[i].getFechaDeNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), cont, 3);//Fecha

                    } else {
                        tblRegistros.setValueAt("---", cont, 3);
                    }
                    cont++;
                }
                    
                    this.acendente=false;

            }

        } else {
            lblError.setVisible(true);

        }

    }
//Columnas en caso de tabal de estudisntes
    private void agregarColumnasEstudiantes() {
        DefaultTableModel modelo = (DefaultTableModel) tblRegistros.getModel();
        modelo.addColumn(ManejadorDeArchivos.IDENTIFICADOR_CARNET);
        modelo.addColumn(ManejadorDeArchivos.IDENTIFICADOR_NOMBRE);
        modelo.addColumn(ManejadorDeArchivos.IDENTIFICADOR_CARRERA);
        modelo.addColumn(ManejadorDeArchivos.IDENTIFICADOR_FECHA);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        btnColumna1 = new javax.swing.JButton();
        btnColumna2 = new javax.swing.JButton();
        btnColumna3 = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblRegistros);

        btnColumna1.setText("Ordenar");
        btnColumna1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColumna1ActionPerformed(evt);
            }
        });

        btnColumna2.setText("Ordenar");
        btnColumna2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColumna2ActionPerformed(evt);
            }
        });

        btnColumna3.setText("Ordenar");
        btnColumna3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColumna3ActionPerformed(evt);
            }
        });

        lblError.setText("No existen Registros");

        lblTitulo.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("jLabel1");

        btnSalir.setText("Regresar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnColumna1)
                                .addGap(43, 43, 43)
                                .addComponent(btnColumna2)
                                .addGap(52, 52, 52)
                                .addComponent(btnColumna3)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lblError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnColumna2)
                    .addComponent(btnColumna3)
                    .addComponent(btnColumna1))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnColumna1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColumna1ActionPerformed
        if (identificador.equals(ManejadorDeArchivos.IDENTIFICADOR_LIBRO)) {
            cargarRegistroLibro(Ordenaciones.ordenarLibros(libros, Ordenaciones.IDENTFICADOR_DE_ORDEN_CODIGO));
        } else {
            cargarRegistroEstudiante(Ordenaciones.ordenarEstudiantes(estudiante, Ordenaciones.IDENTFICADOR_DE_ORDEN_CARNET));
        }
    }//GEN-LAST:event_btnColumna1ActionPerformed

    private void btnColumna2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColumna2ActionPerformed
        if (identificador.equals(ManejadorDeArchivos.IDENTIFICADOR_LIBRO)) {
            cargarRegistroLibro(Ordenaciones.ordenarLibros(libros, Ordenaciones.IDENTFICADOR_DE_ORDEN_TITULO));
        } else {
            cargarRegistroEstudiante(Ordenaciones.ordenarEstudiantes(estudiante, Ordenaciones.IDENTFICADOR_DE_ORDEN_NOMBRE));
        }

    }//GEN-LAST:event_btnColumna2ActionPerformed

    private void btnColumna3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColumna3ActionPerformed
        if (identificador.equals(ManejadorDeArchivos.IDENTIFICADOR_LIBRO)) {
            cargarRegistroLibro(Ordenaciones.ordenarLibros(libros, Ordenaciones.IDENTFICADOR_DE_ORDEN_AUTOR));
        } else {
            cargarRegistroEstudiante(Ordenaciones.ordenarEstudiantes(estudiante, Ordenaciones.IDENTFICADOR_DE_ORDEN_CARRERA));
        }

    }//GEN-LAST:event_btnColumna3ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColumna1;
    private javax.swing.JButton btnColumna2;
    private javax.swing.JButton btnColumna3;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblRegistros;
    // End of variables declaration//GEN-END:variables
}
