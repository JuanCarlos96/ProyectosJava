package JListPersona;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class ModeloPersona extends AbstractListModel{
    private ArrayList<Persona> lista;

    public ModeloPersona() {
        this.lista = new ArrayList<Persona>();
    }
    
    public void add(Persona p){
        lista.add(p);
        this.fireIntervalAdded(p, lista.size(), lista.size());
    }
    
    public void remove(int posicion){
        lista.remove(posicion);
        this.fireIntervalRemoved(posicion, posicion, posicion+1);
    }
    
    public Persona get(int posicion){
        return lista.get(posicion);
    }
    
    public void set(int posicion,Persona p){
        lista.set(posicion, p);
        this.fireContentsChanged(p, posicion, posicion);
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Object getElementAt(int index) {
        return lista.get(index);
    }
}