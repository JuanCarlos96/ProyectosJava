package Capicua;

import java.util.Scanner;

public class Capicua {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num,cont=0,totales,sobrantes,finales;
        String num1,resultado="----------------------------\n";
        boolean iguales;
        
        System.out.println("Introduce números(0 para terminar):");
        num = Integer.parseInt(teclado.nextLine());
        
        while(num!=0){
            totales = (int) Math.pow(10, num);
            sobrantes = (int) Math.pow(10, num-1);
            finales = totales-sobrantes;
            
            if(num>1) finales=finales+9;
            
            for(int i=sobrantes;i<=finales;i++) {
                iguales=true;
                num1=Integer.toString(i);
                int k=num1.length()-1;
                int[] numero = new int[num];
                for(int x=0;x<num1.length();x++) {
                    numero[x]=(int)num1.charAt(x);
                }
                
                for(int j=0;j<num1.length()/2;j++) {
                    if(numero[j]!=numero[k]) iguales=false;
                    k--;
                }
                if(iguales==true) cont++;
            }
            
            resultado += Integer.toString(cont)+"\n";
            cont=0;
            num = Integer.parseInt(teclado.nextLine());
        }
        
        System.out.println(resultado);
    }
}