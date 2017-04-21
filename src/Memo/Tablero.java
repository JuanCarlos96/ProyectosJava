package Memo;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class Tablero extends JPanel{
    private JPanel tablero;
    private int lado1,lado2;
    private Modo modo;

    public Tablero(Modo modo) {
        this.modo = modo;
        tablero = new JPanel();
        
        if(modo == Modo.PRINCIPIANTE) {
            lado1=2;
            lado2=4;
        }
        
        if(modo == Modo.INTERMEDIO) {
            lado1=4;
            lado2=4;
        }

        if(modo == Modo.AVANZADO) {
            lado1=4;
            lado2=6;
        }

        setLayout(new GridLayout(lado1,lado2));
    }

    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    public int getLado1() {
        return lado1;
    }

    public int getLado2() {
        return lado2;
    }
}