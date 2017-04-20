package JTable;

public class Coche {
    private String marca,modelo;
    private int puertas,caballos;
    private boolean deportivo;

    public Coche() {
    }

    public Coche(String marca, String modelo, int puertas, int caballos, boolean deportivo) {
        this.marca = marca;
        this.modelo = modelo;
        this.puertas = puertas;
        this.caballos = caballos;
        this.deportivo = deportivo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getCaballos() {
        return caballos;
    }

    public void setCaballos(int caballos) {
        this.caballos = caballos;
    }

    public boolean isDeportivo() {
        return deportivo;
    }

    public void setDeportivo(boolean deportivo) {
        this.deportivo = deportivo;
    }
}