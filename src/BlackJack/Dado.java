package BlackJack;

import java.util.Random;

public class Dado {
    private Random rnd;
    int resultado;

    public Dado() {
        rnd = new Random();
    }
    
    public int tirar(){
        resultado = rnd.nextInt(10)+1;
        return resultado;
    }
}