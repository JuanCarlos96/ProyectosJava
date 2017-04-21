/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTable;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.TableColumn;

/**
 *
 * @author almc
 */
public class TablaProfesor extends JPanel{
    private ModeloTablaProfe modelo = new ModeloTablaProfe();

    public TablaProfesor() {
        super(new GridLayout(1,0));
        JTable tabla = new JTable(modelo);
        columnaComboBox(tabla, tabla.getColumnModel().getColumn(4));
        tabla.setPreferredScrollableViewportSize(new Dimension(500,70));
        tabla.setFillsViewportHeight(true);
    }
    
    public void columnaComboBox(JTable tabla, TableColumn comboColumna) {
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Informática");
        comboBox.addItem("Matemáticas");
        comboBox.addItem("Lengua");
        comboBox.addItem("Inglés");
        comboBox.addItem("Cocina");
        comboColumna.setCellEditor (new DefaultCellEditor(comboBox));
    }
    
    private static void crearIG() {
        JFrame frame = new JFrame("JTable");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        TablaProfesor panelTabla = new TablaProfesor();
        frame.setContentPane(panelTabla);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                crearIG();
            }
        });
    }
}