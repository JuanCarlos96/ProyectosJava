package Poker;

import java.util.ArrayList;
import java.util.Scanner;

public class NewMain {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String carta1,carta2;
        Carta c;
        String[] c1;
        String[] c2;
        Partida partida;
        ArrayList<Carta> jugada1,jugada2;
        
        jugada1 = new ArrayList();
        jugada2 = new ArrayList();
        
        carta1 = teclado.nextLine();
        carta2 = teclado.nextLine();
        
        c1 = carta1.split(" ");
        c2 = carta2.split(" ");
        
        for(int i=0; i<10; i++) {
            c = new Carta();
            switch (c1[i]) {
                case "A":
                    c.setPosicion(14);
                    break;
                case "K":
                    c.setPosicion(13);
                    break;
                case "Q":
                    c.setPosicion(12);
                    break;
                case "J":
                    c.setPosicion(11);
                    break;
                default:
                    c.setPosicion(Integer.parseInt(c1[i]));
                    break;
            }
            c.setPalo(c1[i+1]);
            jugada1.add(c);
            i++;
        }
        
        for(int i=0; i<10; i++) {
            c = new Carta();
            switch (c2[i]) {
                case "A":
                    c.setPosicion(14);
                    break;
                case "K":
                    c.setPosicion(13);
                    break;
                case "Q":
                    c.setPosicion(12);
                    break;
                case "J":
                    c.setPosicion(11);
                    break;
                default:
                    c.setPosicion(Integer.parseInt(c2[i]));
                    break;
            }
            c.setPalo(c2[i+1]);
            jugada2.add(c);
            i++;
        }
        
        partida = new Partida(jugada1,jugada2);
        partida.comprobarj1();
        partida.comprobarj2();
        
        System.out.println(partida.comprobacionfinal());
    }
}