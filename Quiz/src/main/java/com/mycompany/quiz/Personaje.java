package com.mycompany.quiz;

public class Personaje {

    private String nombre;
    private int vida;
    private boolean saltando;

    public Personaje(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    
    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public boolean isSaltando() {
        return saltando;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setSaltando(boolean saltando) {
        this.saltando = saltando;
    }
    
    
    public void sufrirGolpe() {
        System.out.println(this.nombre+" sufrió un golpe");
        this.vida -= 1;
        comprobarVida(true);
    }
    
    
    public boolean comprobarVida(boolean imprimir) {
        if(this.vida>0 && imprimir)
            System.out.println(this.nombre+" tiene "+this.vida+" de vida");
        return this.vida>0;
    }
    
    
    public void saltarRandom() {
        this.saltando = Math.random()<0.5;
        if (this.saltando) System.out.println(this.nombre+" está saltando. ¡Agáchate!");
    }
    
    
}
