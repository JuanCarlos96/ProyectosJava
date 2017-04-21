/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuscaminasEmilio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Emilio
 */
public class Buscaminas extends JFrame implements ActionListener {
    int lado = 8;
    Tablero tablero;
    JPanel pCenter;

    public Buscaminas() {
        
        tablero = new Tablero(lado);
        
        this.getContentPane().setLayout(new BorderLayout());
        
        JPanel pNorth = new JPanel();
        JPanel pSouth = new JPanel();
        pCenter = new JPanel();
        
        this.getContentPane().add(pCenter,BorderLayout.CENTER );
        this.getContentPane().add(pNorth,BorderLayout.NORTH);
        this.getContentPane().add(pSouth,BorderLayout.SOUTH);
        
        pNorth.setLayout(new BoxLayout(pNorth,BoxLayout.X_AXIS));
        pCenter.setLayout(new GridLayout(lado,lado));
        pSouth.setLayout(new BoxLayout(pSouth,BoxLayout.X_AXIS));
        pNorth.add(new JLabel("Movimientos: "));
        pNorth.add(new JLabel(" X "));
        pNorth.add(new JLabel(" 000 "));
        for (int i=0; i<lado; i++) {
            for (int j=0; j<lado; j++) {
                Celda b = new Celda(i,j);
                pCenter.add(b);
                b.addActionListener(this);
                tablero.setCelda(b, i, j);
            }            
        }
        tablero.asignarMinas(lado);
        //tablero.destaparMinas();
        pSouth.add(new JLabel("Casillas restantes: "));
        JLabel casillas = new JLabel(" X ");
        pSouth.add(casillas);
        
        JMenuBar barraMenu = new JMenuBar();
        this.setJMenuBar(barraMenu);
        JMenu menuJuego = new JMenu("Juego");
        barraMenu.add(menuJuego);
        menuJuego.add(new JMenuItem("Principante"));
        menuJuego.add(new JMenuItem("Intermedio"));
        menuJuego.add(new JMenuItem("Avanzado"));

        JMenu menuAyuda = new JMenu("Ayuda");
        barraMenu.add(menuAyuda);
        menuAyuda.add(new JMenuItem("Ayuda"));
    
    }
    
    public void reiniciar() {
        this.pCenter.removeAll();
        for (int i=0; i<lado; i++) {
            for (int j=0; j<lado; j++) {
                Celda b = new Celda(i,j);
                pCenter.add(b);
                b.addActionListener(this);
                tablero.setCelda(b, i, j);
            }            
        }
    }
    
    public static void main (String args[]) {        
        Buscaminas f = new Buscaminas();        

        f.setBounds(0,0,360,460);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);               
    }    

    @Override
    public void actionPerformed(ActionEvent ae) {
        tablero.destapar((Celda)ae.getSource());
    }
}
