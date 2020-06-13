package com.company;

public class Tablero {
    private int fichas[][];
    private InterpreteTablero interpreteTablero;

    public Tablero (){
        this.fichas = new int[3][4];
        this.interpreteTablero = new InterpreteTablero();
        ordenarTablero();
        desordenarTablero();
    }

    public void ordenarTablero(){
        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                this.fichas[i][j] = i+3*j+1 - 6*((i+3*j)/6);
            }
        }
    }

    public void desordenarTablero (){
        for (int i=0; i<50; i++){
            int auxPosicion1Ficha1 = (int)(Math.random()*3);
            int auxPosicion2Ficha1 = (int)(Math.random()*4);
            int auxPosicion1Ficha2 = (int)(Math.random()*3);
            int auxPosicion2Ficha2 = (int)(Math.random()*4);
            int aux = this.fichas[auxPosicion1Ficha1][auxPosicion2Ficha1];
            this.fichas[auxPosicion1Ficha1][auxPosicion2Ficha1] = this.fichas[auxPosicion1Ficha2][auxPosicion2Ficha2];
            this.fichas[auxPosicion1Ficha2][auxPosicion2Ficha2] = aux;
        }
        this.interpreteTablero.mostrarTableroGenerico(this.fichas);
    }

    public void ocultarTablero (){
        this.interpreteTablero.ocultarTablero();
    }

    public void mostrarTableroGenerico (){
        this.interpreteTablero.mostrarTableroGenerico(this.fichas);
    }

    public void mostrarFichas (Posicion posicions[]){
        this.interpreteTablero.mostrarFichas(this.fichas, posicions);
    }

    public boolean fijarseSiHayCoincidencia (Posicion posicions[]){
        return this.fichas[posicions[1].getPosicionFila()-1][posicions[1].getPosicionColumna()-1]==this.fichas[posicions[0].getPosicionFila()-1][posicions[0].getPosicionColumna()-1];
    }

    public void eliminarFichas (Posicion posicion []){
        this.fichas[posicion[0].getPosicionFila()-1][posicion[0].getPosicionColumna()-1] = 0;
        this.fichas[posicion[1].getPosicionFila()-1][posicion[1].getPosicionColumna()-1] = 0;
    }

    public boolean fijarseSiLaFichaExiste (Posicion posicion){
        return this.fichas[posicion.getPosicionFila()-1][posicion.getPosicionColumna()-1]!=0;
    }

    public boolean fijarseSiHayGanador () {
        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                if (this.fichas[i][j]!=0){
                    return false;
                }
            }
        }
        return true;
    }

}
