package Poker;

import java.util.ArrayList;

public class Partida {
    private ArrayList<Carta> jugada1,jugada2;
    private Resultados resultado1,resultado2;

    public Partida(ArrayList<Carta> jugada1, ArrayList<Carta> jugada2) {
        this.jugada1 = jugada1;
        this.jugada2 = jugada2;
    }

    public ArrayList<Carta> getCarta1() {
        return jugada1;
    }

    public void setCarta1(ArrayList<Carta> jugada1) {
        this.jugada1 = jugada1;
    }

    public ArrayList<Carta> getCarta2() {
        return jugada2;
    }

    public void setCarta2(ArrayList<Carta> jugada2) {
        this.jugada2 = jugada2;
    }

    public Resultados getResultado1() {
        return resultado1;
    }

    public void setResultado1(Resultados resultado1) {
        this.resultado1 = resultado1;
    }

    public Resultados getResultado2() {
        return resultado2;
    }

    public void setResultado2(Resultados resultado2) {
        this.resultado2 = resultado2;
    }
    
    public void comprobarj1() {
        int cont=0;
        boolean resul=false;
        
        //Comprobación Escalera Real
        if (jugada1.get(0).getPosicion()==14 || jugada1.get(0).getPosicion()==10) {
            for(int i=0;i<4;i++) {
                int pos1,pos2;
                String palo1,palo2;
                
                pos1 = jugada1.get(i).getPosicion();
                pos2 = jugada1.get(i+1).getPosicion();
                
                palo1 = jugada1.get(i).getPalo();
                palo2 = jugada1.get(i+1).getPalo();
                
                if (Math.abs(pos1-pos2)==1 && palo1.equals(palo2)) cont++;
            }
            if (cont==4) {
                resul=true;
                this.setResultado1(Resultados.ESCALERA_REAL);
            }
        }
        cont=0;
        
        //Comprobación Escalera de Color
        if (jugada1.get(0).getPosicion()!=14 && jugada1.get(4).getPosicion()!=14 && resul==false) {
            for(int i=0;i<4;i++) {
                int pos1,pos2;
                String palo1,palo2;
                
                pos1 = jugada1.get(i).getPosicion();
                pos2 = jugada1.get(i+1).getPosicion();
                
                palo1 = jugada1.get(i).getPalo();
                palo2 = jugada1.get(i+1).getPalo();
                
                if (Math.abs(pos1-pos2)==1 && palo1.equals(palo2)) cont++;
            }
            if (cont==4) {
                resul=true;
                this.setResultado1(Resultados.ESCALERA_DE_COLOR);
            }
        }
        cont=0;
        
        //Comprobacion Poquer
        if (resul==false) {
            for(int i=0;i<4;i++) {
                int pos1,pos2;
                
                pos1 = jugada1.get(i).getPosicion();
                pos2 = jugada1.get(i+1).getPosicion();
                
                if (pos1==pos2) cont++;
            }
            if (cont==3) {
                resul=true;
                this.setResultado1(Resultados.POQUER);
            }
        }
        cont=0;
        
        //Comprobacion Full
//        if (resul==false) {
//            
//        }
//        cont=0;
        
        //Comprobacion Color
        if (resul==false) {
            for(int i=0;i<4;i++) {
                String palo1,palo2;
                
                palo1 = jugada1.get(i).getPalo();
                palo2 = jugada1.get(i+1).getPalo();
                
                if (palo1.equals(palo2)) cont++;
            }
            if (cont==4) {
                resul=true;
                this.setResultado1(Resultados.COLOR);
            }
        }
        cont=0;
        
        //Comprobacion Escalera
        if (resul==false) {
            for(int i=0;i<4;i++) {
                int pos1,pos2;
                
                pos1 = jugada1.get(i).getPosicion();
                pos2 = jugada1.get(i+1).getPosicion();
                
                if (Math.abs(pos1-pos2)==1) cont++;
            }
            if (cont==4) {
                resul=true;
                this.setResultado1(Resultados.ESCALERA);
            }
        }
        cont=0;
        
        //Comprobacion Trio
        if (resul==false) {
            for(int i=0;i<4;i++) {
                int pos1,pos2;
                
                pos1 = jugada1.get(i).getPosicion();
                pos2 = jugada1.get(i+1).getPosicion();
                
                if (pos1==pos2) cont++;
            }
            if (cont==2) {
                resul=true;
                this.setResultado1(Resultados.TRIO);
            }
        }
        cont=0;
        
        //Comprobacion Doble Pareja
        
        //Comprobacion Pareja
        if (resul==false) {
            int diferentes=0;
            for(int i=0;i<4;i++) {
                int pos1,pos2;
                
                pos1 = jugada1.get(i).getPosicion();
                pos2 = jugada1.get(i+1).getPosicion();
                
                if (pos1==pos2) {
                    cont++;
                }else{
                    diferentes++;
                }
            }
            if (cont==1 && diferentes==3) {
                resul=true;
                this.setResultado1(Resultados.PAREJA);
            }
        }
        cont=0;
        
        if (resul==false) this.setResultado1(Resultados.JARDIN);
    }
    
    public void comprobarj2() {
        int cont=0;
        boolean resul=false;
        
        //Comprobación Escalera Real
        if (jugada2.get(0).getPosicion()==14 || jugada2.get(0).getPosicion()==10) {
            for(int i=0;i<4;i++) {
                int pos1,pos2;
                String palo1,palo2;
                
                pos1 = jugada2.get(i).getPosicion();
                pos2 = jugada2.get(i+1).getPosicion();
                
                palo1 = jugada2.get(i).getPalo();
                palo2 = jugada2.get(i+1).getPalo();
                
                if (Math.abs(pos1-pos2)==1 && palo1.equals(palo2)) cont++;
            }
            if (cont==4) {
                resul=true;
                this.setResultado2(Resultados.ESCALERA_REAL);
            }
        }
        cont=0;
        
        //Comprobación Escalera de Color
        if (jugada2.get(0).getPosicion()!=14 && jugada2.get(4).getPosicion()!=14 && resul==false) {
            for(int i=0;i<4;i++) {
                int pos1,pos2;
                String palo1,palo2;
                
                pos1 = jugada2.get(i).getPosicion();
                pos2 = jugada2.get(i+1).getPosicion();
                
                palo1 = jugada2.get(i).getPalo();
                palo2 = jugada2.get(i+1).getPalo();
                
                if (Math.abs(pos1-pos2)==1 && palo1.equals(palo2)) cont++;
            }
            if (cont==4) {
                resul=true;
                this.setResultado2(Resultados.ESCALERA_DE_COLOR);
            }
        }
        cont=0;
        
        //Comprobacion Poquer
        if (resul==false) {
            for(int i=0;i<4;i++) {
                int pos1,pos2;
                
                pos1 = jugada2.get(i).getPosicion();
                pos2 = jugada2.get(i+1).getPosicion();
                
                if (pos1==pos2) cont++;
            }
            if (cont==3) {
                resul=true;
                this.setResultado2(Resultados.POQUER);
            }
        }
        cont=0;
        
        //Comprobacion Full
        if (resul==false) {
            
        }
        cont=0;
        
        //Comprobacion Color
        if (resul==false) {
            for(int i=0;i<4;i++) {
                String palo1,palo2;
                
                palo1 = jugada2.get(i).getPalo();
                palo2 = jugada2.get(i+1).getPalo();
                
                if (palo1.equals(palo2)) cont++;
            }
            if (cont==4) {
                resul=true;
                this.setResultado2(Resultados.COLOR);
            }
        }
        cont=0;
        
        //Comprobacion Escalera
        if (resul==false) {
            for(int i=0;i<4;i++) {
                int pos1,pos2;
                
                pos1 = jugada2.get(i).getPosicion();
                pos2 = jugada2.get(i+1).getPosicion();
                
                if (Math.abs(pos1-pos2)==1) cont++;
            }
            if (cont==4) {
                resul=true;
                this.setResultado2(Resultados.ESCALERA);
            }
        }
        cont=0;
        
        //Comprobacion Trio
        if (resul==false) {
            for(int i=0;i<4;i++) {
                int pos1,pos2;
                
                pos1 = jugada2.get(i).getPosicion();
                pos2 = jugada2.get(i+1).getPosicion();
                
                if (pos1==pos2) cont++;
            }
            if (cont==2) {
                resul=true;
                this.setResultado2(Resultados.TRIO);
            }
        }
        cont=0;
        
        //Comprobacion Doble Pareja
        
        //Comprobacion Pareja
        if (resul==false) {
            int diferentes=0;
            for(int i=0;i<4;i++) {
                int pos1,pos2;
                
                pos1 = jugada2.get(i).getPosicion();
                pos2 = jugada2.get(i+1).getPosicion();
                
                if (pos1==pos2) {
                    cont++;
                }else{
                    diferentes++;
                }
            }
            if (cont==1 && diferentes==3) {
                resul=true;
                this.setResultado2(Resultados.PAREJA);
            }
        }
        cont=0;
        
        if (resul==false) this.setResultado2(Resultados.JARDIN);
    }
    
    public String comprobacionfinal() {
        String ganador="";
        
        int j1,j2;
        
        j1 = this.getResultado1().getResul();
        j2 = this.getResultado2().getResul();
        
        if (j1>j2) {
            ganador = "JUGADOR 1 GANA\n";
        }
        if (j2>j1) {
            ganador = "JUGADOR 2 GANA\n";
        }
        
        if (j1==j2 && j1==1) {
            int max1,max2;
            max1=jugada1.get(0).getPosicion();
            max2=jugada1.get(0).getPosicion();
            for(int i=1;i<4;i++) {
                
            }
        }
        
        return ganador;
    }
}