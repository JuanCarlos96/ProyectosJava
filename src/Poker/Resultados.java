package Poker;

public enum Resultados {
    ESCALERA_REAL(10),
    ESCALERA_DE_COLOR(9),
    POQUER(8),
    FULL(7),
    COLOR(6),
    ESCALERA(5),
    TRIO(4),
    DOBLE_PAREJA(3),
    PAREJA(2),
    JARDIN(1);
    
    private int resul;

    private Resultados() {
    }

    private Resultados(int resul) {
        this.resul = resul;
    }

    public int getResul() {
        return resul;
    }

    public void setResul(int resul) {
        this.resul = resul;
    }
}