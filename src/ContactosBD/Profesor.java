/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContactosBD;

/**
 *
 * @author almc
 */
public class Profesor {
    private String nombre,apellidos,dni,departamento,fp;
    private int edad;

    public Profesor() {
    }

    public Profesor(String nombre, String appelidos, String dni, int edad, String departamento, String fp) {
        this.nombre = nombre;
        this.apellidos = appelidos;
        this.dni = dni;
        this.edad = edad;
        this.departamento = departamento;
        this.fp = fp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getFp() {
        return fp;
    }

    public void setFp(String fp) {
        this.fp = fp;
    }
}