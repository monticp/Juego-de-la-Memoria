package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      try {
          AdministradorDeJuegos administrador = new AdministradorDeJuegos();
          administrador.empezarJuego();
      }
      catch (Exception excepcionGenerica){

      }
    }
}
