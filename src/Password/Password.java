package Password;

import java.util.Random;

public class Password {
    private String password;
    public static int MIN_LENGTH=8;
    private int longitud;

    public Password() {
        generarPassword();
        longitud = MIN_LENGTH;
    }

    public Password(String password) {
        this.password = password;
        this.longitud = password.length();
    }

    public Password(int longitud) {
        generarPassword();
        this.longitud = longitud;
    }
    
    public boolean esFuerte(){
        boolean fuerte=false;
        int cont=0;
        
        for(int i=0; 1<longitud; i++){
            if(!Character.isAlphabetic(password.charAt(i))){
                cont+=1;
            }
            if(Character.isDigit(password.charAt(i))){
                cont+=1;
            }
            if(Character.isUpperCase(password.charAt(i))){
                cont+=1;
            }
        }
        
        if(cont>=7){
            fuerte=true;
        }
        
        return fuerte;
    }
    
    public void generarPassword(){
        password="";
        Random rnd = new Random();
        String mayus,noalfa;
        mayus = "QWERTYUIOPASDFGHJKLZXCVBNM";
        noalfa = "@#$%&Ç-_+*/¿?¡!<>=|";
            for(int i=0; i<MIN_LENGTH; i++){
                int num = rnd.nextInt(3);
                if(num==0){
                    password+=rnd.nextInt(10);
                }
                if(num==1){
                    password+=mayus.charAt(rnd.nextInt(mayus.length()));
                }
                if(num==2){
                    password+=noalfa.charAt(rnd.nextInt(noalfa.length()));
                }
            }
    }

    @Override
    public String toString() {
        return password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
}