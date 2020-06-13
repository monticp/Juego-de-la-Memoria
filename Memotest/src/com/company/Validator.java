package com.company;

public class Validator {

    Consola consola;

    public boolean validacionPosicionFichas (Juego juego, Posicion posicion){
        if(posicion.getPosicionFila()<1||posicion.getPosicionFila()>3||posicion.getPosicionColumna()<1||posicion.getPosicionColumna()>4){
            return false;
        }
        if(!juego.fijarseSiLaFichaExiste(posicion)){
            return false;
        }
        return true;
    }

    public boolean validacionFichaRepetida (Posicion posicion []){
        return (posicion[0].getPosicionFila()==posicion[1].getPosicionFila()&&posicion[0].getPosicionColumna()==posicion[1].getPosicionColumna());
    }
}
