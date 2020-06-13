package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Consola {

    public List<String> obtenerListaDeNombres (){
        ArrayList<String> nombres = new ArrayList<String>();
        try {
            System.out.println("Ingrese la cantidad de jugadores");
            int cantJugadores = leerCantDeJugadores();
            for (int i=0; i<cantJugadores; i++){
                System.out.println("Ingrese nombre del jugador " + (i+1));
                Scanner lecturaNombre = new Scanner(System.in);
                String nombre = lecturaNombre.nextLine();
                nombres.add(i, nombre);
            }
        }
        catch (Exception cantDeJugadoresMayorA6Exception){
            System.out.println("Cantidad de jugadores mayor a 6");
        }
        return nombres;
    }

    private int leerCantDeJugadores (){
        Scanner lecturaEntero = new Scanner(System.in);
        int cantJugadores = lecturaEntero.nextInt();
        if (cantJugadores>6){
            throw new cantDeJugadoresMayorA6Exception();
        }
        return cantJugadores;
    }

    public void imprimirCartelDeJugadorActivo (Juego juego){
        System.out.println("Jugador: " + juego.getJugadorActivo().getNombre() + ":");
    }

    public void imprimirCartelDeComoIndicarPosiciones (){
        System.out.println("Ingrese la posición de la ficha (fila + enter + columna)");
    }

    public void imprimirCartelDeGanadorDeJuego (Juego juego){
        System.out.println("Felicidades! Ha ganado el jugador " + juego.getJugadorActivo().getNombre());
    }

}
