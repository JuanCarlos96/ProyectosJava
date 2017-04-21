/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContactosBD;

import com.mysql.jdbc.Connection;
import java.awt.event.WindowListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author almc
 */
public class GestionarContactos extends javax.swing.JFrame {
    private DefaultListModel modelo;
    Connection conexion = null;

    /**
     * Creates new form GestionarContactos
     */
    public GestionarContactos() {
        initComponents();
        modelo = new DefaultListModel();
        list.setModel(modelo);
        this.setTitle("Gestionar Profesores");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Cargado...");
            String cadenaconexion, usuario, pass;
            usuario = "juanca";
            pass = "juanca5121996";
            cadenaconexion = "jdbc:mysql://localhost/profesores";
            conexion = (Connection) DriverManager.getConnection(cadenaconexion,usuario,pass);
            System.out.println("Base de datos conectada.");
        } catch (ClassNotFoundException ex) {
             System.out.println("Driver no cargado");           
        } catch (SQLException ex) {
            System.out.println("Instruccion SQL no ejecutada");
        }
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
        txtDNI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDep = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblName1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblDNI = new javax.swing.JLabel();
        lblDep = new javax.swing.JLabel();
        lblFP = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        tieneFP = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        nuevo = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        eliminar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 240, 368));

        jlabel1.setText("Nombre");
        getContentPane().add(jlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, -1));

        jLabel1.setText("Apellidos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));
        getContentPane().add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 120, -1));

        jLabel2.setText("DNI");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        getContentPane().add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, -1));

        jLabel3.setText("Departamento");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        getContentPane().add(txtDep, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblName1.setText("Nombre");
        jPanel1.add(lblName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 13, -1, -1));

        jLabel5.setText("Apellidos");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 13, -1, -1));

        jLabel6.setText("DNI");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 68, -1, -1));

        jLabel7.setText("Departamento");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 123, -1, -1));

        jLabel8.setText("FP");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 123, -1, -1));
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 33, 135, 17));
        jPanel1.add(lblApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 33, 135, 17));
        jPanel1.add(lblDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 88, 100, 17));
        jPanel1.add(lblDep, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 143, 135, 17));
        jPanel1.add(lblFP, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 143, 135, 17));

        jLabel4.setText("Edad");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 68, -1, -1));
        jPanel1.add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 88, 112, 17));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 350, 190));

        jLabel9.setText("Edad");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));
        getContentPane().add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 120, -1));

        tieneFP.setText("¿Tiene FP?");
        getContentPane().add(tieneFP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        jMenu4.setText("Profesor");

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
        jMenu4.add(jSeparator1);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jMenu4.add(salir);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        if(!txtNombre.getText().isEmpty() && !txtApellidos.getText().isEmpty() && !txtDNI.getText().isEmpty() && !txtEdad.getText().isEmpty() && !txtDep.getText().isEmpty()) {
            try{
                String nombre = txtNombre.getText();
                String apellidos = txtApellidos.getText();
                String dni = txtDNI.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                String departamento = txtDep.getText();
                String fp = (tieneFP.isSelected())?"Si":"No";
                
                try {
                    String sql = "INSERT INTO profesor VALUES ('"+nombre+"','"+apellidos+"','"+dni+"',"+edad+",'"+departamento+"','"+fp+"');";
                    Statement st = conexion.createStatement();
                    st.executeUpdate(sql);
                    System.out.println("Datos insertados.");
                    actualizarModelo();
                    
                    txtNombre.setText("");
                    txtApellidos.setText("");
                    txtDNI.setText("");
                    txtEdad.setText("");
                    txtDep.setText("");
                    tieneFP.setSelected(false);
                } catch (SQLException ex) {
                    System.out.println("Error al insertar datos.");
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Edad incorrecta.");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar rellenos.");
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if(list.getSelectedIndex() != -1) {
            String profe = (String) modelo.getElementAt(list.getSelectedIndex());
            String[] split = profe.split(", ");
            String apellidos = split[0];
            String nombre = split[1];
            String dni = null;
            
            try {
                String sql = "SELECT DNI FROM profesor WHERE Apellidos='"+apellidos+"' AND Nombre='"+nombre+"';";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    dni = rs.getString("DNI");
                }
            } catch (SQLException ex) {
                System.out.println("Error en consulta");
            }
            
            try {
                String sql = "DELETE FROM profesor WHERE DNI='"+dni+"';";
                Statement st = conexion.createStatement();
                st.executeUpdate(sql);
                System.out.println("Datos eliminados.");
                actualizarModelo();
            } catch (SQLException ex) {
                System.out.println("Error al eliminar los datos.");
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        if(list.getSelectedIndex() != -1) {
            String profe = (String) modelo.getElementAt(list.getSelectedIndex());
            String[] split = profe.split(", ");
            String apellidos = split[0];
            String nombre = split[1];
            String dni = null;
            String profesor = null;
            
            try {
                String sql = "SELECT DNI FROM profesor WHERE Apellidos='"+apellidos+"' AND Nombre='"+nombre+"';";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    dni = rs.getString("DNI");
                }
            } catch (SQLException ex) {
                System.out.println("Error en consulta");
            }
            
            try {
                String sql = "SELECT * FROM profesor WHERE DNI='"+dni+"';";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    profesor = (
                        rs.getString("Nombre")+","+
                        rs.getString("Apellidos")+","+
                        rs.getString("DNI")+","+
                        rs.getInt("Edad")+","+
                        rs.getString("Departamento")+","+
                        rs.getString("FP")
                    );
                }

                String[] datos = profesor.split(",");
                lblNombre.setText(datos[0]);
                lblApellidos.setText(datos[1]);
                lblDNI.setText(datos[2]);
                lblEdad.setText(datos[3]);
                lblDep.setText(datos[4]);
                lblFP.setText(datos[5]);

            } catch (SQLException ex) {
                System.out.println("Error en consulta");
            }
        }
    }//GEN-LAST:event_listMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(list.getSelectedIndex() != -1) {
            list.removeSelectionInterval(list.getSelectedIndex(), list.getSelectedIndex());
            lblNombre.setText("");
            lblApellidos.setText("");
            lblDNI.setText("");
            lblEdad.setText("");
            lblDep.setText("");
            lblFP.setText("");
        }
    }//GEN-LAST:event_formMouseClicked

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        
    }//GEN-LAST:event_nuevoActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        if (conexion!=null) {
            try {
                conexion.close();
                System.out.println("Conexion cerrada.");
            } catch (Exception e) {
                System.out.println("No se pudo cerrar la conexión.");
            }
        }
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (conexion!=null) {
            try {
                conexion.close();
                System.out.println("Conexion cerrada.");
            } catch (Exception e) {
                System.out.println("No se pudo cerrar la conexión.");
            }
        }
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing
    
    public void escribirObjeto() {
        
    }
    
    public void eliminarObjeto() {
        
    }
    
    public void actualizarModelo() {
        modelo.removeAllElements();
        try {
            String sql = "SELECT Apellidos,Nombre FROM profesor";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                String profe = (
                        rs.getString("Apellidos")+", "+
                        rs.getString("Nombre")
                );
                modelo.addElement(profe);
            }
        } catch (SQLException ex) {
            System.out.println("Error en consulta");
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarContactos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDep;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblFP;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JList<String> list;
    private javax.swing.JMenuItem nuevo;
    private javax.swing.JMenuItem salir;
    private javax.swing.JRadioButton tieneFP;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDep;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}