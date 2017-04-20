/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosEnModelos;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Emilio
 */
public class ModeloAlumno extends AbstractListModel {
    private ArrayList<Alumno> lista;    

    public ModeloAlumno() {
        lista = new ArrayList<Alumno>();
    }
    
    public void add(Alumno a) {
        lista.add(a);
        this.fireIntervalAdded(a, lista.size(), lista.size());
    }
    
    public void remove(int posicion) {
        lista.remove(posicion);
        this.fireIntervalRemoved(posicion, posicion, posicion+1);
    }
    
    public Alumno get(int posicion) {
        return lista.get(posicion);
    }
    
    public void set(int posicion, Alumno a) {
        lista.set(posicion, a);
        this.fireContentsChanged(a, posicion, posicion);
    }
    
    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Object getElementAt(int i) {
        return lista.get(i);
    }
    
}
