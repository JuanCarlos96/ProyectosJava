package ContactosBD;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class ModeloProfesor extends AbstractListModel{
    
    private ArrayList<Profesor> profesores;

    public ModeloProfesor() {
        profesores = new ArrayList<>();
    }
    
    public void add(Profesor c) {
        profesores.add(c);
        this.fireIntervalAdded(c, profesores.size(), profesores.size());
    }
    
    public void remove(int posicion) {
        profesores.remove(posicion);
        this.fireIntervalRemoved(posicion, posicion, posicion+1);
    }
    
    public void removeAllElements() {
        int index1 = profesores.size()-1;
        profesores.removeAll(profesores);
        if (index1 >= 0) {
            fireIntervalRemoved(this, 0, index1);
        }
    }
    
    public Profesor get(int posicion) {
        return profesores.get(posicion);
    }
    
    public void set(int posicion, Profesor c) {
        profesores.set(posicion, c);
        this.fireContentsChanged(c, posicion, posicion);
    }

    @Override
    public int getSize() {
        return profesores.size();
    }

    @Override
    public Object getElementAt(int index) {
        return profesores.get(index);
    }
}