package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdministradorDeJuegos {
    private int cantDeMemotestJugados;
    private List<Juego> juegosActivos;
    private Consola consola;
    private Validator validator;

    public AdministradorDeJuegos (){
        this.cantDeMemotestJugados = 0;
        this.consola = new Consola();
        this.juegosActivos = new ArrayList<Juego>();
        this.validator = new Validator();
    }

    public int getCantDeMemotestJugados() {
        return cantDeMemotestJugados;
    }

    public void empezarJuego (){
        this.cantDeMemotestJugados++;
        ArrayList<String> nombres = new ArrayList<String>(this.consola.obtenerListaDeNombres());
        Juego juego1 = new Juego(nombres);
        this.juegosActivos.add(juego1);
        while (!juego1.isHayGanador()) {
            Posicion posicions[] = {new Posicion(0,0), new Posicion(0,1)};
            this.consola.imprimirCartelDeJugadorActivo(juego1);
            for (int i = 0; i < 2; i++) {
                while (!this.validator.validacionPosicionFichas(juego1, posicions[i])||this.validator.validacionFichaRepetida(posicions)) {
                    this.consola.imprimirCartelDeComoIndicarPosiciones();
                    Scanner lecturaEntero = new Scanner(System.in);
                    posicions[i] = new Posicion(lecturaEntero.nextInt(), lecturaEntero.nextInt());
                }
            }
            juego1.jugar(posicions);
        }
        this.consola.imprimirCartelDeGanadorDeJuego(juego1);
    }
}
