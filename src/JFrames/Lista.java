package JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Lista extends JFrame implements ActionListener{
    private JList lista;
    private JButton agregar,quitar,modificar;
    private JTextField nombre;
    private JLabel lbl;
    private DefaultListModel modelo;

    public Lista(){
        this.setLayout(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        modelo = new DefaultListModel();
        
        lbl = new JLabel("Nombre");
        nombre = new JTextField();
        agregar = new JButton(">>");
        quitar = new JButton("<<");
        modificar = new JButton("Modificar");
        lista = new JList();
        lista.setModel(modelo);
        
        add(lbl);
        add(agregar);
        add(quitar);
        add(modificar);
        add(nombre);
        add(lista);
        
        lbl.setBounds(10, 10, 50, 20);
        nombre.setBounds(10, 30, 100, 20);
        agregar.setBounds(35, 80, 50, 20);
        quitar.setBounds(35, 110, 50, 20);
        modificar.setBounds(10, 140, 100, 20);
        lista.setBounds(150, 10, 100, 200);
        agregar.addActionListener(this);
        quitar.addActionListener(this);
        modificar.addActionListener(this);
    }
    
    
    public static void main(String[] args){
        Lista l = new Lista();
        l.setBounds(100, 100, 280, 260);
        l.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultListModel modelo = new DefaultListModel();
        modelo = (DefaultListModel)lista.getModel();
        
        if(e.getSource()==agregar){
            if(!nombre.getText().isEmpty()){
                modelo.addElement(nombre.getText());
                nombre.setText("");
            }
        }
        
        if(e.getSource()==quitar){
            if(lista.getSelectedIndex()!=-1){
                modelo.remove(lista.getSelectedIndex());
            }
        }
        
        if(e.getSource()==modificar){
            if(!nombre.getText().isEmpty() && lista.getSelectedIndex()!=-1){
                modelo.setElementAt(nombre.getText(), lista.getSelectedIndex());                
            }
        }
    }
}