package com.mycompany.quiz;

import java.util.Scanner;
public class Principal {
    static Scanner sc;
    static Personaje jugador;
    static Personaje enemigo;
    static char tecla;

    
    static void comprobarTecla(){
        boolean reintentar;
        
        do {
            System.out.print("Acción: ");
            tecla = sc.next().charAt(0);
            tecla = Character.toLowerCase(tecla);
            reintentar = false;
            switch (tecla) {
                case 'a':
                    System.out.println("saltar");
                    jugador.setSaltando(true);
                break;
                case 'z':
                    System.out.println("agacharse");
                    jugador.setSaltando(false);
                break;
                case 'x':
                    System.out.println("salir");
                break;
                default:
                    System.out.println("acción inválida, reintente");
                    reintentar = true;
            }
        } while (reintentar==true);
        
        System.out.println();
    }
    
    
    static boolean repetirAccion(){
        return jugador.comprobarVida(false) && tecla!='x';
    }
    
    
    static void aparecerEnemigo(String nom, int vid, boolean salta) {
        if (repetirAccion()) {
            enemigo = new Personaje(nom, vid);
            System.out.println("Aparece un "+enemigo.getNombre());
            System.out.println();
            
            while (enemigo.comprobarVida(false) && repetirAccion()) {
              if (salta) enemigo.saltarRandom();
              comprobarTecla();
              interactuar();
            }
        }
        
    }
    
    
    static void interactuar(){
        if (tecla!='x') {
            if (enemigo.isSaltando() && !jugador.isSaltando()) {
                System.out.println(jugador.getNombre()+" esquiva");
            } else if (jugador.isSaltando()!=enemigo.isSaltando()) {
                enemigo.sufrirGolpe();
                //jugador.comprobarVida(true);
                } else {
                    jugador.sufrirGolpe();
                    enemigo.comprobarVida(true);
                }
            
            if (!enemigo.comprobarVida(false))
                System.out.println(jugador.getNombre()+" venció a "+ enemigo.getNombre());
            if (!jugador.comprobarVida(false))
                System.out.println(enemigo.getNombre()+" venció a "+ jugador.getNombre());
            
            System.out.println();
        }
        
    }
    
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        jugador = new Personaje("Mario", 3);
        
        System.out.println("Simulador de Mario Bros");
        System.out.println("acciones de teclas:");
        System.out.println("a. saltar");
        System.out.println("z. agacharse");
        System.out.println("x. salir");
        System.out.println();
        
        while (repetirAccion()) {
            aparecerEnemigo("Goomba", 1, false);
            //aparecerEnemigo("Koopa", 2, false);
            aparecerEnemigo("Paratroopa", 3, true);
        }
        
    }
    
    
}
