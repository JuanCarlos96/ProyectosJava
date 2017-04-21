package Contactos;

import java.io.Serializable;

public class Contactos implements Serializable{
    private String nombre,apellidos,email;
    private int movil,fijo;

    public Contactos() {
    }

    public Contactos(String nombre, String apellidos, String email, int movil, int fijo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.movil = movil;
        this.fijo = fijo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public int getMovil() {
        return movil;
    }

    public int getFijo() {
        return fijo;
    }

    @Override
    public String toString() {
        return getNombre()+" "+getApellidos();
    }
}