package Buscaminas;

import java.awt.*;
import javax.swing.*;

public class Buscaminas extends JFrame{
    private JMenuBar menubar;
    private JMenu partida,ayuda;
    private JMenuItem principiante,medio,experto;
    private BorderLayout blayout;
    private FlowLayout flayout;
    private GridLayout glayout;
    private JLabel movimientos,movx,casillas,casx,tiempo;
    private JPanel norte,centro,sur;
    private int producto;
    
    public Buscaminas(int x, int y) {
        blayout = new BorderLayout();
        this.setLayout(blayout);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        //-----------MENÚ----------
        menubar = new JMenuBar();
        setJMenuBar(menubar);
        partida = new JMenu("Partida");
        menubar.add(partida);
        principiante = new JMenuItem("Principiante");
        partida.add(principiante);
        medio = new JMenuItem("Medio");
        partida.add(medio);
        experto = new JMenuItem("Experto");
        partida.add(experto);
        ayuda = new JMenu("Ayuda");
        menubar.add(ayuda);
        
        //---------PARTE DE ARRIBA------------
        norte = new JPanel();
        flayout = new FlowLayout();
        norte.setLayout(flayout);
        movimientos = new JLabel("Movimientos");
        movx = new JLabel("X");
        tiempo = new JLabel("000");
        this.getContentPane().add(norte,BorderLayout.NORTH);
        norte.add(movimientos);
        norte.add(movx);
        norte.add(tiempo);
        
        //---------PARTE DE ABAJO--------------
        sur = new JPanel();
        sur.setLayout(flayout);
        casillas = new JLabel("Casillas");
        casx = new JLabel("X");
        this.getContentPane().add(sur, BorderLayout.SOUTH);
        sur.add(casillas);
        sur.add(casx);
        
        //----------CELDAS-----------
        centro = new JPanel();
        glayout = new GridLayout(x, y);
        centro.setLayout(glayout);
        producto = x*y;
        for (int i=1; i<=producto; i++) {
            centro.add(new JButton());
        }
        centro.setBounds(0, 0, 100, 200);
        this.getContentPane().add(centro, BorderLayout.CENTER);
    }
    
    public static void main(String[] args){
        Buscaminas busca = new Buscaminas(20,20);
        busca.setBounds(100, 100, 300, 400);
        busca.setVisible(true);
    }
}