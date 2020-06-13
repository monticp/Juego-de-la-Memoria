package com.company;

public class InterpreteTablero {

    public void mostrarTableroGenerico (int fichas [][]){
        System.out.println("  | 1234");
        System.out.println("--------");
        for(int i=0; i<3; i++) {
            System.out.print((i+1) + " | ");
            for (int j = 0; j < 4; j++) {
                if(fichas[i][j]!=0) {
                    System.out.print('X');
                }
                else {
                    System.out.print(' ');
                }
            }
            System.out.println("");
        }
        System.out.println("--------");
    }

    public void mostrarTablero (int fichas [][]){
        System.out.println("------");
        for(int i=0; i<3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print((char) (fichas[i][j] + 64));
            }
        System.out.println("");
        }
        System.out.println("------");
    }

    public void ocultarTablero () {
        try {
            //Runtime.getRuntime().exec("cls");
            //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            for(int i=0; i<50; i++){
                System.out.println("");
            }

        }
        catch (Exception execException){
            System.out.println("Ocurrió una excepción con el exec");
        }
    }

    public void mostrarFichas (int fichas[][], Posicion posicions[]) {
        System.out.println("------");
        for(int i=0; i<3; i++) {
            for (int j = 0; j < 4; j++) {
                if (fichas[i][j]==0){
                    System.out.print(' ');
                }
                else if ((((i+1)==posicions[0].getPosicionFila())&&((j+1)==posicions[0].getPosicionColumna()))||(((i+1)==posicions[1].getPosicionFila())&&((j+1)==posicions[1].getPosicionColumna()))) {
                    System.out.print((char) (fichas[i][j] + 64));
                }
                else {
                    System.out.print('X');
                }
            }
            System.out.println("");
        }
        System.out.println("------");
    }
}
