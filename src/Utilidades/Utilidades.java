package Utilidades;

public class Utilidades {
    public static boolean esNumero(String cadena){
        boolean loes = false;
        int punto = 0;
        
        for(int i=0; i<cadena.length(); i++){
            if(cadena.charAt(i)=='.'){
                punto++;
            }
        }
        
        if(punto==1){
            try{
                double numero = Double.parseDouble(cadena);
                loes=true;
            }catch(Exception e){
            }
        }
        
        if(punto==0){
            try{
                long numero = Long.parseLong(cadena);
                loes=true;
            }catch(Exception e){
            }
        }
        
        return loes;
    }
}