package Memo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Interfaz extends JFrame{
    
    private Tablero tablero;
    private JMenuBar barra;
    private JMenu juego,nuevo;
    private JMenuItem salir,principiante,intermedio,avanzado;
    private Baraja baraja;

    public Interfaz() {
        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        tablero = new Tablero(Modo.AVANZADO);
        this.getContentPane().add(tablero,BorderLayout.CENTER);
        
        baraja = new Baraja(tablero.getModo());
        
        for (int i=0; i<(tablero.getLado1()*tablero.getLado2()); i++) {
            Carta c = baraja.getBaraja().get(i);
            c.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    c.tapar(false);
//                    comprobar();
                }
                @Override
                public void mousePressed(MouseEvent e) {}
                @Override
                public void mouseReleased(MouseEvent e) {}
                @Override
                public void mouseEntered(MouseEvent e) {}
                @Override
                public void mouseExited(MouseEvent e) {}
            });
            tablero.add(c);
        }

        barra = new JMenuBar();
        this.setJMenuBar(barra);
        juego = new JMenu("Juego");
        barra.add(juego);
        nuevo = new JMenu("Nuevo");
        juego.add(nuevo);
        principiante = new JMenuItem("Principiante");
        principiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        intermedio = new JMenuItem("Intermedio");
        intermedio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        avanzado = new JMenuItem("Avanzado");
        avanzado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        nuevo.add(principiante);
        nuevo.add(intermedio);
        nuevo.add(avanzado);
        salir = new JMenuItem("Salir");
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        juego.add(salir);
    }
    
//    public void comprobar() {
//        int contador = 0;
//        ArrayList<Carta> lista = new ArrayList();;
//        for (int i=0; i<(tablero.getLado1()*tablero.getLado2()); i++) {
//            if(!baraja.getBaraja().get(i).isTapada()) {
//                contador += 1;
//            }
//        }
//        while(contador==2){
//            for (int i=0; i<(tablero.getLado1()*tablero.getLado2()); i++) {
//                if(!baraja.getBaraja().get(i).isTapada()) {
//                    lista.add(baraja.getBaraja().get(i));
//                }
//            }
//            if(!lista.get(0).equals(lista.get(1))) {
//                for (int i=0; i<(tablero.getLado1()*tablero.getLado2()); i++) {
//                    if(!baraja.getBaraja().get(i).isTapada()) {
//                        baraja.getBaraja().get(i).setTapada(true);
//                    }
//                }
//            }
//        }
//        lista.remove(0);
//        lista.remove(0);
//    }

    public static void main(String[] args) {
        Interfaz juego = new Interfaz();

        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                juego.setVisible(true);
                juego.pack();
            }
        });
    }
}