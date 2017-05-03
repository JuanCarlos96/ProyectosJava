/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author almc
 */
public class ModeloProductos extends AbstractTableModel{
    String nombresColumnas[] = { 
        "ID", "Nombre", "Precio"
    };
    
    ArrayList lista = new ListaProductos();

    public ModeloProductos() {
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto p = (Producto) lista.get(rowIndex);
            switch(columnIndex) {
                case 0: return p.getId();
                case 1: return p.getNombre();
                default: return p.getPrecio();
            }
    }
    
    @Override
    public Class<?> getColumnClass(int i) {
        return getValueAt(i,i).getClass();
    }
}
