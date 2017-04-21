/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuscaminasEmilio;

import javax.swing.JButton;

/**
 *
 * @author Emilio
 */
public class Celda extends JButton {
    private boolean mina;
    private int fila, columna;
    private Estado estado;

    public Celda() {
        super();
        mina = false;
        estado = Estado.TAPADA;
    }
    
    public Celda(int fila, int columna) {
        this();
        this.fila = fila;
        this.columna = columna;
    } 

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return fila+","+columna;
    }
    
    
    
    
}
