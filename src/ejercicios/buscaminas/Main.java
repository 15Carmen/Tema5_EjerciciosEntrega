package ejercicios.buscaminas;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int LENGTH = 20;

    public static void main(String[] args) {
        //Declaramos las variables array que van a ser nuestros tableros
        int[] arrayMinas = new int[LENGTH];
        char[] arrayPintar = new char[LENGTH];

        Utilidades.colocarMinas(arrayMinas, arrayPintar);

        //System.out.println(Arrays.toString(arrayMinas));

        Utilidades.pintarTablero(arrayPintar);

        boolean gameOver = false;
        do {
            gameOver = Utilidades.jugar(arrayMinas, arrayPintar);
            if (gameOver == false){
                //System.out.println(Arrays.toString(arrayMinas));
                Utilidades.pintarTablero(arrayPintar);
            }
        }while (gameOver == false);
    }
}
