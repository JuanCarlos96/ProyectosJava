/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuscaminasEmilio;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Emilio
 */
public class Tablero {
    private static final int LADO_VF = 8;
    
    private ArrayList<Point> adyacencias;
    
    private Celda [][] tablero;
    private int lado;

    public Tablero() {
        this(LADO_VF);
    }
    
    public Tablero(int lado) {
        this.lado = lado;
        tablero = new Celda[lado][lado];
        adyacencias = new ArrayList<>();
        adyacencias.add(new Point(-1,-1));
        adyacencias.add(new Point(-1,0));
        adyacencias.add(new Point(-1,1));
        adyacencias.add(new Point(0,-1));
        adyacencias.add(new Point(0,1));
        adyacencias.add(new Point(1,-1));
        adyacencias.add(new Point(1,0));
        adyacencias.add(new Point(1,1));
    }

    public Celda getCelda(int x, int y) {
        return tablero[x][y];
    }

    public void setCelda(Celda celda, int x, int y) {
        this.tablero[x][y] = celda;
    }
    
    public void asignarMinas(int numMinas) {
        Random r = new Random();               
        int fila, columna, contador=0;      
        
        while (contador<numMinas) {

            fila = r.nextInt(lado);
            columna = r.nextInt(lado);

            if (!tablero[fila][columna].isMina()) {
                tablero[fila][columna].setMina(true);
                contador++;
            }
        }
    }
    
    public void destaparMinas() {
        for (int i=0; i<lado; i++) {
            for (int j=0; j<lado; j++) {
                if (tablero[i][j].isMina()) {
                    tablero[i][j].setText("*");
                    tablero[i][j].setBackground(Color.RED);
                }
            }
        }
    }
    
    public boolean coordenadasValidas(int x, int y) {
        return (x>=0 && x<lado && y>=0 && y<lado);
    }
    
    public int minasAdyacentes(Celda celda) {
        int contador=0;
        
        for (Point p: adyacencias) {
            int fila = celda.getFila()+p.x;
            int columna = celda.getColumna()+p.y;
            if (coordenadasValidas(fila,columna)) {
                if (tablero[fila][columna].isMina()) {
                    contador++;
                }
            }
        }
        
        return contador;
    }
    
    public int destapar(Celda celda) {
        int celdasdestapadas = 0;
        if (!celda.getEstado().equals(Estado.DESTAPADA)) {
            celda.setEstado(Estado.DESTAPADA);
            if (celda.isMina()) {
                celda.setBackground(Color.RED);
                celda.setText("*");
                this.destaparMinas();
                JOptionPane.showMessageDialog(null, "Has perdido");
                Buscaminas buscaminas = new Buscaminas();
                buscaminas.reiniciar();
            } else {
                int adyacentes = minasAdyacentes(celda);
                celda.setBackground(Color.WHITE);
                if (adyacentes==0) {
                    for (Point p: adyacencias) {
                        int fila = celda.getFila()+p.x;
                        int columna = celda.getColumna()+p.y;
                        if (coordenadasValidas(fila,columna)) {
                            destapar(tablero[fila][columna]);
                        }
                    }
                } else {
                    celda.setText(Integer.toString(adyacentes));                    
                }
                celdasdestapadas++;
            }
        }
        return celdasdestapadas;
    }
}