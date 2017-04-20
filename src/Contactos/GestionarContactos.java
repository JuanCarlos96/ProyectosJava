/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contactos;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author almc
 */
public class GestionarContactos extends javax.swing.JFrame {
    private ModeloContacto modelo;
    private File file = new File("");
    private static final int MOVILMAX = 749999999, MOVILMIN = 600000000, FIJOMAX = 988999999, FIJOMIN = 919999999;

    /**
     * Creates new form GestionarContactos
     */
    public GestionarContactos() {
        initComponents();
        modelo = new ModeloContacto();
        list.setModel(modelo);
        this.setTitle("Gestionar Contactos");
        actualizarModelo();
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
        list = new javax.swing.JList<>();
        jlabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMovil = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFijo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblName1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblMovil = new javax.swing.JLabel();
        lblFijo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        archivoNuevo = new javax.swing.JMenuItem();
        archivoAbrir = new javax.swing.JMenuItem();
        guardarArchivo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        salir = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        nuevo = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        eliminar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(list);

        jlabel1.setText("Nombre");

        jLabel1.setText("Apellidos");

        jLabel2.setText("Correo electrónico");

        jLabel3.setText("Móvil");

        jLabel4.setText("Fijo");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblName1.setText("Nombre");

        jLabel5.setText("Apellidos");

        jLabel6.setText("Correo electrónico");

        jLabel7.setText("Móvil");

        jLabel8.setText("Fijo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName1)
                            .addComponent(jLabel6))
                        .addGap(46, 46, 46)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(lblMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        archivo.setText("Archivo");

        archivoNuevo.setText("Nuevo");
        archivoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoNuevoActionPerformed(evt);
            }
        });
        archivo.add(archivoNuevo);

        archivoAbrir.setText("Abrir");
        archivoAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoAbrirActionPerformed(evt);
            }
        });
        archivo.add(archivoAbrir);

        guardarArchivo.setText("Guardar");
        guardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarArchivoActionPerformed(evt);
            }
        });
        archivo.add(guardarArchivo);
        archivo.add(jSeparator2);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        archivo.add(salir);

        jMenuBar1.add(archivo);

        jMenu4.setText("Contacto");

        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jMenu4.add(nuevo);

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jMenu4.add(guardar);

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jMenu4.add(eliminar);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlabel1)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabel1)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        if(!txtNombre.getText().isEmpty() && !txtApellidos.getText().isEmpty() && !txtEmail.getText().isEmpty() && !txtMovil.getText().isEmpty() && !txtFijo.getText().isEmpty()) {
            try{
                if(Integer.parseInt(txtMovil.getText()) > MOVILMIN && Integer.parseInt(txtMovil.getText()) < MOVILMAX && Integer.parseInt(txtFijo.getText()) > FIJOMIN && Integer.parseInt(txtFijo.getText()) < FIJOMAX) {
                    if(file.exists()) {
                        escribirObjeto();
                        actualizarModelo();
                        txtNombre.setText("");
                        txtApellidos.setText("");
                        txtEmail.setText("");
                        txtMovil.setText("");
                        txtFijo.setText("");
                    }else{
                        modelo.add(
                            new Contactos(
                                txtNombre.getText(),
                                txtApellidos.getText(),
                                txtEmail.getText(),
                                Integer.parseInt(txtMovil.getText()),
                                Integer.parseInt(txtFijo.getText())
                            )
                        );
                        txtNombre.setText("");
                        txtApellidos.setText("");
                        txtEmail.setText("");
                        txtMovil.setText("");
                        txtFijo.setText("");
                    }
                }else {
                    JOptionPane.showMessageDialog(this, "Número de móvil o fijo fuera del rango");
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Número de teléfono móvil o fijo incorrecto.");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar rellenos.");
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if(list.getSelectedIndex() != -1) {
            if(file.exists()) {
                eliminarObjeto();
                lblNombre.setText("");
                lblApellidos.setText("");
                lblEmail.setText("");
                lblMovil.setText("");
                lblFijo.setText("");
            }else {
                modelo.remove(list.getSelectedIndex());
                lblNombre.setText("");
                lblApellidos.setText("");
                lblEmail.setText("");
                lblMovil.setText("");
                lblFijo.setText("");
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        if(list.getSelectedIndex() != -1) {
            Contactos contacto = (Contactos)modelo.getElementAt(list.getSelectedIndex());
            lblNombre.setText(contacto.getNombre());
            lblApellidos.setText(contacto.getApellidos());
            lblEmail.setText(contacto.getEmail());
            lblMovil.setText(Integer.toString(contacto.getMovil()));
            lblFijo.setText(Integer.toString(contacto.getFijo()));
        }
    }//GEN-LAST:event_listMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(list.getSelectedIndex() != -1) {
            list.removeSelectionInterval(list.getSelectedIndex(), list.getSelectedIndex());
            lblNombre.setText("");
            lblApellidos.setText("");
            lblEmail.setText("");
            lblMovil.setText("");
            lblFijo.setText("");
        }
    }//GEN-LAST:event_formMouseClicked

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        if(list.getSelectedIndex() != -1) {
            list.removeSelectionInterval(list.getSelectedIndex(), list.getSelectedIndex());
            txtNombre.setText("");
            txtApellidos.setText("");
            txtEmail.setText("");
            txtMovil.setText("");
            txtFijo.setText("");
            lblNombre.setText("");
            lblApellidos.setText("");
            lblEmail.setText("");
            lblMovil.setText("");
            lblFijo.setText("");
        }else{
            txtNombre.setText("");
            txtApellidos.setText("");
            txtEmail.setText("");
            txtMovil.setText("");
            txtFijo.setText("");
            lblNombre.setText("");
            lblApellidos.setText("");
            lblEmail.setText("");
            lblMovil.setText("");
            lblFijo.setText("");
        }
    }//GEN-LAST:event_nuevoActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void archivoAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoAbrirActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.obj", "obj");
        fc.setFileFilter(filtro);
        int seleccion = fc.showOpenDialog(this);

        if(seleccion == JFileChooser.ERROR_OPTION) JOptionPane.showMessageDialog(this, "Error");

        if(seleccion == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            actualizarModelo();
        }

        if(seleccion == JFileChooser.CANCEL_OPTION) {}
    }//GEN-LAST:event_archivoAbrirActionPerformed

    private void archivoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoNuevoActionPerformed
        file = new File("");
        actualizarModelo();
    }//GEN-LAST:event_archivoNuevoActionPerformed

    private void guardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarArchivoActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.obj", "obj");
        fc.setFileFilter(filtro);
        int seleccion = fc.showSaveDialog(this);

        if(seleccion == JFileChooser.ERROR) JOptionPane.showMessageDialog(this, "Error");

        if(seleccion == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                for(int i = 0; i < modelo.getSize(); i++) {
                    oos.writeObject(modelo.getElementAt(i));
                }
                oos.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            actualizarModelo();
        }
        
        if(seleccion == JFileChooser.CANCEL_OPTION) {}
    }//GEN-LAST:event_guardarArchivoActionPerformed

    public void escribirObjeto() {
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            modelo.add(
                    new Contactos(
                            txtNombre.getText(),
                            txtApellidos.getText(),
                            txtEmail.getText(),
                            Integer.parseInt(txtMovil.getText()),
                            Integer.parseInt(txtFijo.getText())
                    )
            );
            for(int i = 0; i < modelo.getSize(); i++) {
                oos.writeObject(modelo.getElementAt(i));
            }
            oos.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Número de teléfono móvil o fijo incorrecto.");
        }
    }
    
    public void eliminarObjeto() {
        modelo.remove(list.getSelectedIndex());
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            for(int i = 0; i < modelo.getSize(); i++) {
                oos.writeObject(modelo.getElementAt(i));
            }
            oos.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Número de teléfono móvil o fijo incorrecto.");
        }
    }
    
    public void actualizarModelo() {
        if(file.exists()) {
            ObjectInputStream ois = null;
            try{
                ois = new ObjectInputStream(new FileInputStream(file));
                Object obj;
                modelo.removeAllElements();
                while((obj = ois.readObject()) instanceof Contactos) {
                    modelo.add((Contactos)obj);
                }
            }catch (EOFException e) {}catch (Exception e) {
                e.printStackTrace();
            }finally{
                try{
                    if(ois != null) {
                        ois.close();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.setTitle(file.getName()+": "+"Gestionar Contactos");
        }else {
            modelo.removeAllElements();
            this.setTitle("Gestionar Contactos");
        }
    }
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
            java.util.logging.Logger.getLogger(GestionarContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarContactos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu archivo;
    private javax.swing.JMenuItem archivoAbrir;
    private javax.swing.JMenuItem archivoNuevo;
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JMenuItem guardarArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFijo;
    private javax.swing.JLabel lblMovil;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JList<String> list;
    private javax.swing.JMenuItem nuevo;
    private javax.swing.JMenuItem salir;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFijo;
    private javax.swing.JTextField txtMovil;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}