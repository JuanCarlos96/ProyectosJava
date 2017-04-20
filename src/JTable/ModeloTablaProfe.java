/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTable;

import java.util.ArrayList;
import javax.swing.table.*;

/**
 *
 * @author almc
 */
public class ModeloTablaProfe extends AbstractTableModel{
    ArrayList lista = listaProfesores();
    String titulos[] = {"Nombre","Apellidos","DNI","Edad","Departamento","FP"};

    public ModeloTablaProfe() {
    }
    
    public ArrayList listaProfesores() {
        ArrayList<Profesor> lista = new ArrayList();
        lista.add(new Profesor("Pepe","Ramírez","55555555X",30,"Matemáticas",true));
        lista.add(new Profesor("Gloria","Sánchez","58749635L",35,"Lengua",false));
        lista.add(new Profesor("David","López","98765421V",28,"Sociales",true));
        lista.add(new Profesor("Luna","González","89732125G",38,"Química",false));
        return lista;
    }
    

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public String getColumnName(int column) {
        return titulos[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0,columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Profesor p = (Profesor) lista.get(rowIndex);
        switch (columnIndex){
            case 0: return p.getNombre();
            case 1: return p.getApellidos();
            case 2: return p.getDni();
            case 3: return p.getEdad();
            case 4: return p.getDepartamento();
            default: return p.isFp();
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        if (getValueAt(row, 4).toString().equals("Informática") || getValueAt(row, 4).toString().equals("Cocina"))
            return col<5;
        else
            return true;
    }

    @Override
    public void setValueAt(Object o, int row, int col) {
        Profesor p = (Profesor) lista.get(row);
        switch(col) {
            case 0: p.setNombre((String)o);
            case 1: p.setApellidos((String)o);
            case 2: p.setDni((String)o);
            case 3: p.setEdad((int)o);
            case 4: p.setDepartamento((String)o);
                if(getValueAt(row, 4).toString().equals("Informática") || getValueAt(row, 4).toString().equals("Cocina"))
                    p.setFp(true);
                fireTableCellUpdated(row,5);
            default: p.setFp((boolean)o);
        }
        fireTableCellUpdated(row,col);
    }
}