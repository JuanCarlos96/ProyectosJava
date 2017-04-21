package Memo;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja extends ArrayList{
    private ArrayList<Carta> baraja;
    private Modo modo;
    private final String ruta = "/Memo/res/";
    private final Carta carta1 = new Carta(ruta+"ballena.png");
    private final Carta carta2 = new Carta(ruta+"buho.png");
    private final Carta carta3 = new Carta(ruta+"canguro.png");
    private final Carta carta4 = new Carta(ruta+"comadreja.png");
    private final Carta carta5 = new Carta(ruta+"elefante.png");
    private final Carta carta6 = new Carta(ruta+"gallina.png");
    private final Carta carta7 = new Carta(ruta+"hipo.png");
    private final Carta carta8 = new Carta(ruta+"oveja.png");
    private final Carta carta9 = new Carta(ruta+"perrito.png");
    private final Carta carta10 = new Carta(ruta+"pinguino.png");
    private final Carta carta11 = new Carta(ruta+"pulpo.png");
    private final Carta carta12 = new Carta(ruta+"rana.png");

    public Baraja(Modo modo) {
        baraja = new ArrayList<>();
        this.modo = modo;
        baraja.add(carta1);
        baraja.add(carta2);
        baraja.add(carta3);
        baraja.add(carta4);
        baraja.add(carta5);
        baraja.add(carta6);
        baraja.add(carta7);
        baraja.add(carta8);
        baraja.add(carta9);
        baraja.add(carta10);
        baraja.add(carta11);
        baraja.add(carta12);
        
        if(modo == Modo.PRINCIPIANTE) setBaraja(barajaPrincipiante());
        
        if(modo == Modo.INTERMEDIO) setBaraja(barajaIntermedio());
        
        if(modo == Modo.AVANZADO) setBaraja(barajaAvanzado());
    }

    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    public ArrayList<Carta> getBaraja() {
        return baraja;
    }

    public void setBaraja(ArrayList<Carta> baraja) {
        this.baraja = baraja;
    }
    
    public ArrayList<Carta> barajaPrincipiante() {
        ArrayList<Carta> barajap = new ArrayList<>();
        
        Collections.shuffle(baraja);
        
        for(int i = 0; i < 4; i++) {
            barajap.add(baraja.get(i));
            try{
                barajap.add((Carta)baraja.get(i).clone());
            }catch (CloneNotSupportedException e) {
                System.out.print("No se puede clonar");
            }
        }
        Collections.shuffle(barajap);
        Collections.shuffle(barajap);
        return barajap;
    }
    
    public ArrayList<Carta> barajaIntermedio() {
        ArrayList<Carta> barajai = new ArrayList<>();
        
        Collections.shuffle(baraja);
        
        for(int i = 0; i < 8; i++) {
            barajai.add(baraja.get(i));
            try{
                barajai.add((Carta)baraja.get(i).clone());
            }catch (CloneNotSupportedException e) {
                System.out.print("No se puede clonar");
            }
        }
        Collections.shuffle(barajai);
        Collections.shuffle(barajai);
        return barajai;
    }
    
    public ArrayList<Carta> barajaAvanzado() {
        ArrayList<Carta> barajaa = new ArrayList<>();
        
        for(int i = 0; i < baraja.size(); i++) {
            barajaa.add(baraja.get(i));
            try{
                barajaa.add((Carta)baraja.get(i).clone());
            }catch (CloneNotSupportedException e) {
                System.out.print("No se puede clonar");
            }
        }
        Collections.shuffle(barajaa);
        Collections.shuffle(barajaa);
        return barajaa;
    }
}