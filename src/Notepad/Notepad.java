package Notepad;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.*;
import javax.swing.*;

public class Notepad extends JFrame implements ActionListener{
    private BorderLayout bl;
    private JMenu menu;
    private JMenuBar barramenu;
    private JMenuItem abrir,guardar,salir;
    private JTextArea txtarea;

    public Notepad() {
        bl = new BorderLayout();
        this.setLayout(bl);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        barramenu = new JMenuBar();
        this.setJMenuBar(barramenu);
        
        menu = new JMenu("Archivo");
        barramenu.add(menu);
        
        abrir = new JMenuItem("Abrir");
        abrir.addActionListener(this);
        menu.add(abrir);
        
        guardar = new JMenuItem("Guardar");
        guardar.addActionListener(this);
        menu.add(guardar);
        
        menu.add(new JSeparator());
        
        salir = new JMenuItem("Salir");
        salir.addActionListener(this);
        menu.add(salir);
        
        txtarea = new JTextArea();
        
        this.getContentPane().add(txtarea, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        Notepad bloc = new Notepad();
        bloc.setBounds(400, 300, 400, 400);
        bloc.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == salir) System.exit(0);
        
        if(e.getSource() == abrir) {
            JFileChooser fc = new JFileChooser();
            int seleccion = fc.showOpenDialog(this);
            
            BufferedReader br = null;
                        
            if(seleccion == JFileChooser.ERROR_OPTION) JOptionPane.showMessageDialog(this, "Error");
            
            if(seleccion == JFileChooser.APPROVE_OPTION) {
                try{
                    File file = fc.getSelectedFile();
                    br = new BufferedReader(new FileReader(file));
                    String linea,texto = "";
                    while((linea = br.readLine()) != null) {
                        texto += linea+"\n";
                        txtarea.setText(texto);
                    }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }finally {
                    try{
                        if( null != br ){
                           br.close();
                        }
                    }catch (Exception ex2){
                        ex2.printStackTrace();
                    }
                }
            }
            
            if(seleccion == JFileChooser.CANCEL_OPTION) {
                
            }
        }
        
        if(e.getSource() == guardar) {
            JFileChooser fc = new JFileChooser();
            int seleccion = fc.showSaveDialog(this);
            
            BufferedWriter bw = null;
            
            if(seleccion == JFileChooser.ERROR) JOptionPane.showMessageDialog(this, "Error");
            
            if(seleccion == JFileChooser.APPROVE_OPTION) {
                try{
                    File file = fc.getSelectedFile();
                    bw = new BufferedWriter(new FileWriter(file));
                    bw.write(txtarea.getText().replaceAll("\\n", "\r\n"));
                }catch (Exception ex3) {
                    ex3.printStackTrace();
                }finally{
                    try {
                        if (null != bw)
                           bw.close();
                    } catch (Exception ex4) {
                       ex4.printStackTrace();
                    }
                }
            }
        }
    }
}