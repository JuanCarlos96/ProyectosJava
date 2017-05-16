package Dalton;

import java.util.ArrayList;
import java.util.Scanner;

public class NewMain {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String medidas,resultado="";
        ArrayList<Integer> alturas = new ArrayList();
        String[] medidas2;
        int cont,personajes;
        
        System.out.print("Introduzca nº de personajes en la viñeta: ");
        personajes = teclado.nextInt();
        
        while(personajes!=0) {
            System.out.println("Introduzca altura de los personajes: ");
            for(int i=0;i<personajes;i++) {
                alturas.add(teclado.nextInt());
            }
            
//            medidas = teclado.nextLine();
//            
//            medidas2 = medidas.split(" ");
//            
//            for (String s : medidas2) {
//                alturas.add(Integer.parseInt(s));
//            }

            cont=0;
            for(int i=0; i<alturas.size()-1; i++) {
                int j = alturas.get(i);
                int k = alturas.get(i+1);
                if (j>k){
                    if (j-1==k){
                        cont++;
                    }
                }
                if (j<k){
                    if (j==k-1){
                        cont++;
                    }
                }
            }
            if (cont==3) resultado+="DALTON\n";

            if (cont!=3 && cont>alturas.size()-2) resultado+="DUDA\n";

            if (cont<alturas.size()-2) resultado+="DESCONOCIDO\n";
            
            System.out.print("Introduzca nº de personajes en la viñeta: ");
            personajes = teclado.nextInt();
        }
        System.out.println(resultado);
    }
}