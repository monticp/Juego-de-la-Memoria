package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Juego {
    private Tablero tablero;
    private ArrayList<Jugador> jugadors;
    private Jugador jugadorActivo;
    private boolean hayGanador;
    private int cantJugadas;

    public Juego (ArrayList<String> nombres){
        this.jugadors = new ArrayList<Jugador>();
        for (int i=0; i<nombres.size(); i++){
            this.jugadors.add(i, new Jugador(nombres.get(i), i));
        }
        this.jugadorActivo = this.jugadors.get(0);
        this.tablero = new Tablero();
        this.hayGanador = false;
        this.cantJugadas = 0;
    }

    public boolean isHayGanador() {
        return hayGanador;
    }


    public Jugador getJugadorActivo() {
        return jugadorActivo;
    }

    public boolean fijarseSiLaFichaExiste (Posicion posicion) {
        return this.tablero.fijarseSiLaFichaExiste(posicion);
    }

    public int getCantJugadas() {
        return cantJugadas;
    }


    public void jugar (Posicion posicions []){
        try {
            this.tablero.mostrarFichas(posicions);
            this.cantJugadas++;
            sleep(3000);
            this.tablero.ocultarTablero();
            if (this.tablero.fijarseSiHayCoincidencia(posicions)) {
                this.tablero.eliminarFichas(posicions);
                this.hayGanador = fijarseSiHayGanador();
            } else {
                this.jugadorActivo = this.jugadors.get(this.jugadors.indexOf(jugadorActivo)+1 - ((this.jugadors.indexOf(jugadorActivo)+1)/this.jugadors.size())*(this.jugadors.size()));
            }
            this.tablero.mostrarTableroGenerico();
        }
        catch (Exception excepcionPorElSleep){
           //ManejarExcepcion
        }
    }

    private boolean fijarseSiHayGanador (){
        return this.tablero.fijarseSiHayGanador();
    }

}
