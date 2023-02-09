package ejercicios.buscaminas;

import java.util.Arrays;
import java.util.Scanner;

public class Utilidades {

    //Declaramos un Scanner para poder leer por consola
    public static Scanner sc = new Scanner(System.in);

    //Declaramos las constantes
    public static final int MINAS = 6;

    /**
     * Método que va a colocar 6 minas en 6 posiciones aleatorias del
     * @param arrayMinas que vamos a señalar con un número 1. Así mismo, en el
     * @param pintarArray lo rellenaremos en un principio con espacios en blanco
     */
    public static void colocarMinas(int[] arrayMinas, char[] pintarArray) {

        int indice;             //Para guardar las minas en valores aleatorios
        int contadorMinas = 0;  //Contador para rellenar las minas necesarias

        //Rellenamos el array a pintar con espacios en blanco
        Arrays.fill(pintarArray, ' ');

        // Las minas van a estar representadas por 1 y las casillas sin minas con 0
        while (contadorMinas < MINAS){
            indice = (int) (Math.random() * (20 + 1) - 1); // Guardamos el índice generado aleatoriamente
            if (arrayMinas[indice]==1){
                contadorMinas--;
            }else {
                arrayMinas[indice]=1;
            }
            contadorMinas++;
        }
    }

    /**
     * Método que pintará en la consola el
     * @param arrayPintar con las casillas [] que se iran rellenando a medida que el usuario las vaya seleccionando
     */
    public static void pintarTablero(char[] arrayPintar) {
        for (int casilla = 0; casilla < arrayPintar.length; casilla++) {
            System.out.print("[" + (char) arrayPintar[casilla] + "]");
        }
        System.out.println();
    }

    /**
     * Método que comprueba si el usuario introduce una casilla que contiene una mina en
     * @param arrayMinas . Si ese es el caso, se acaba el juego. Si la casilla no tiene una mina indicamos en
     * @param arrayPintar cuantas minas hay alrededor de la casilla seleccionada.
     * @return un booleano que indica si el juego termina o no.
     */
    public static boolean jugar(int[] arrayMinas, char[] arrayPintar) {

        //Delcaramos las variables
        boolean acabaJuego = false;

        //Le pedimos al usuario que introduzca la posición de una casilla
        System.out.println("Indique la casilla que desea ver (se comienza desde 0):");
        int casilla = sc.nextInt();

        if (arrayMinas[casilla] == 1){          //si hay una bomba en la casilla

            System.out.println("Pisaste una mina! Tus tropas acaban de morir, has perdido.");
            arrayPintar[casilla] = '*';
            acabaJuego = true;                  //game over

        } else {                                //Si no hay una bomba en la casilla
            arrayPintar[casilla] = (contarMinas(arrayMinas, casilla) + "").charAt(0); //mostramos en la casilla el número de bombas alrededor de la casilla
            arrayMinas[casilla] = -1;           //marcamos esta casilla como que ya ha sido elegida

            if (usuarioGanaJuego(arrayMinas)){  //Si el usuario gana
                System.out.println("Felicidades! Has conseguido guiar a tus tropas a salvo por el campo de minas, has ganado.");
                acabaJuego = true;              //game over
            }
        }
        return acabaJuego;
    }

    /**
     *
     * @param arrayMinas
     * @param casilla
     * @return
     */
    public static int contarMinas(int[] arrayMinas, int casilla) {
        //Declaramos las variables
        int izquierdaCasilla = casilla - 1;
        int derechaCasilla = casilla + 1;
        int contadorMinas = 0;

        //Tratamos con los posibles errores que podríamos tener en los bordes del tablero

        //Si el usuario elige la casilla en la posición 0, indicamos que la por así decirlo "casilla a su izquierda"
        // es igual a 0
        if (casilla == 0) {
            izquierdaCasilla = 0;
        }

        //Si el usuario elige la casilla en la última posición del tablero, indicamos que la por así decirlo
        // "casilla a su derecha" es igual al tamaño del tablero
        if (casilla == arrayMinas.length - 1) {
            derechaCasilla = arrayMinas.length - 1;
        }

        //Una vez tratadas las posibles excepciones
        //Recorremos tres casillas, la seleccionada por el usuario, y las de sus laterales
        for (int i = izquierdaCasilla; i <= derechaCasilla; i++) {
            if (arrayMinas[i] == 1 && i != casilla) {   //Si hay una mina en alguna de las casillas y no es la que ha elegido el usuario
                contadorMinas++;                       //Contamos que hay una mina
            }
        }
        return contadorMinas;
    }

    public static boolean usuarioGanaJuego(int[] arrayMinas) {
        int contador = 0;
        boolean ganador = false;

        for (int casilla = 0; casilla < arrayMinas.length; casilla++) {
            if (arrayMinas[casilla] == 1 || arrayMinas[casilla] == -1) { //Contamos las minas y los espacios marcados
                contador++;
            }

            //Si el contador es igual al tamaño del tablero, el juego acaba porque no hay más espacios sin minas sin marcar
            if (contador == arrayMinas.length) {
                ganador = true;
            }
        }
        return ganador; //grid not complete
    }



}
