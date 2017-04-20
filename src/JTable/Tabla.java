package JTable;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class Tabla extends JPanel {
    private class MiModelo extends AbstractTableModel {
        String nombresColumnas[] = { 
            "Marca", "Modelo", "Puertas", "CV", "Deportivo"
        };
        
        public ArrayList listaDeCoches() {
            ArrayList<Coche> lista = new ArrayList();
            Coche coche1 = new Coche("Nissan","GT-R",2,570,true);
            Coche coche2 = new Coche("Nissan","Primera",5,100,false);
            Coche coche3 = new Coche("Renault","Laguna",5,120,false);
            Coche coche4 = new Coche("Lamborghini","Centenario",2,770,true);
            Coche coche5 = new Coche("Nissan","Skyline GT-R R34",4,320,true);
            lista.add(coche1);
            lista.add(coche2);
            lista.add(coche3);
            lista.add(coche4);
            lista.add(coche5);
            return lista;
        }
        
        ArrayList lista = listaDeCoches();

        public MiModelo() {
        }
        
        @Override
        public int getRowCount() {
            return lista.size();
        }

        @Override
        public int getColumnCount() {
            return nombresColumnas.length;
        }
        
        @Override
        public String getColumnName(int column) {
            return nombresColumnas[column];
        }

        @Override
        public Object getValueAt(int row, int col) {
            Coche c = (Coche) lista.get(row);
            switch(col) {
                case 0: return c.getMarca();
                case 1: return c.getModelo();
                case 2: return c.getPuertas();
                case 3: return c.getCaballos();
                default: return c.isDeportivo();
            }
        }

        @Override
        public Class<?> getColumnClass(int i) {
            return getValueAt(i,i).getClass();
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return true;
        }

        @Override
        public void setValueAt(Object o, int row, int col) {
            Coche c = (Coche) lista.get(row);
            switch(col) {
                case 0: c.setMarca((String)o);
                case 1: c.setModelo((String)o);
                case 2: c.setPuertas((Integer)o);
                case 3: c.setCaballos((Integer)o);
                default: c.setDeportivo((Boolean)o);
            }
            fireTableCellUpdated(row,col);
        }                
                
    }
    
    public Tabla() {
        super(new GridLayout(1,0));
        JTable tabla = new JTable(new MiModelo());
        
        tabla.setPreferredScrollableViewportSize(new Dimension(500,70));
        tabla.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(tabla);
        this.add(scrollPane);
    }       
    
    private static void crearIG() {
        JFrame frame = new JFrame("Ejemplo de JTable");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Tabla panelTabla = new Tabla();
        frame.setContentPane(panelTabla);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main (String [] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                crearIG();
            }
        });
    }
}