package Capicua;

import java.util.Scanner;

public class Capicua {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num;
        
        System.out.println("Introduce números(0 para terminar):");
        num = Integer.parseInt(teclado.nextLine());
        
        while(num!=0){
            
            num = Integer.parseInt(teclado.nextLine());
        }
    }
}