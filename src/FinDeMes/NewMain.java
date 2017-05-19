package FinDeMes;

import java.util.Scanner;

public class NewMain {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op,num1,num2;
        String cadena;
        String[] num;
        String resultado="--------------------------\n";
        num1=0;
        
        op = Integer.parseInt(teclado.nextLine());
        
        if(op>0) {
            for(int i=0;i<op;i++){
                cadena = teclado.nextLine();
                num = cadena.split(" ");
                num1 += Integer.parseInt(num[0]);
                num2 = Integer.parseInt(num[1]);
                num1 = num1-num2;
                
                if(num1<0) {
                    resultado+="NO\n";
                }else{
                    resultado+="SI\n";
                }
            }
            
        }
        System.out.println(resultado);
    }
}
