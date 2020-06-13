package com.company;

public class Posicion {
    private int posicionFila;
    private int posicionColumna;

    public Posicion (int posicionFila, int posicionColumna){
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
    }

    public int getPosicionFila() {
        return posicionFila;
    }

    public int getPosicionColumna() {
        return posicionColumna;
    }

}
