package Contactos;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class ModeloContacto extends AbstractListModel{
    
    private ArrayList<Contactos> contactos;

    public ModeloContacto() {
        contactos = new ArrayList<>();
    }
    
    public void add(Contactos c) {
        contactos.add(c);
        this.fireIntervalAdded(c, contactos.size(), contactos.size());
    }
    
    public void remove(int posicion) {
        contactos.remove(posicion);
        this.fireIntervalRemoved(posicion, posicion, posicion+1);
    }
    
    public void removeAllElements() {
        int index1 = contactos.size()-1;
        contactos.removeAll(contactos);
        if (index1 >= 0) {
            fireIntervalRemoved(this, 0, index1);
        }
    }
    
    public Contactos get(int posicion) {
        return contactos.get(posicion);
    }
    
    public void set(int posicion, Contactos c) {
        contactos.set(posicion, c);
        this.fireContentsChanged(c, posicion, posicion);
    }

    @Override
    public int getSize() {
        return contactos.size();
    }

    @Override
    public Object getElementAt(int index) {
        return contactos.get(index);
    }
}