package JListPersona;

import java.util.Random;

public class Persona {
    private String nombre,dni;
    private short edad;
    private char sexo;
    private float peso,altura;

    public Persona() {
    }

    public Persona(String nombre, short edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = this.comprobarSexo(sexo);
        this.dni = this.generaDNI();
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, short edad, char sexo, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = this.comprobarSexo(sexo);
        this.dni = this.generaDNI();
        this.peso = peso;
        this.altura = altura;
    }
    
    public int calcularIMC(){
        int num;
        float imc,m;
        m = altura/100;
        imc = (peso/(m*m));
        
        if(imc>=18.50 && imc<=24.99){
            num=0;
        }else{
            if(imc<18.50){
                num=-1;
            }else{
                num=1;
            }
        }
        return num;
    }
    
    public boolean esMayorDeEdad(){
        boolean mayor=true;
        if(edad<18){
            mayor=false;
        }
        return mayor;
    }
    
    private char comprobarSexo(char sexo){
        if(sexo!='H' && sexo!='M'){
            sexo = 'H';
        }
        return sexo;
    }
    
    private String generaDNI(){
        Random rnd = new Random();
        String alfabeto = "TRWAGMYFPDXBNJZSQVHLCKE";
        dni="";
        
        for(int i=1; i<9; i++){
            dni += rnd.nextInt(10);
        }
        int numerodni = Integer.parseInt(dni);
        int modulo = numerodni % 23;
        dni += alfabeto.charAt(modulo);
        return dni;
    }

    @Override
    public String toString() {
        String datos = this.getNombre();
        return datos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public short getEdad() {
        return edad;
    }

    public char getSexo() {
        return sexo;
    }

    public String getDni() {
        return dni;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }
}