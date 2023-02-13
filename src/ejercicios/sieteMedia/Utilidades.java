package ejercicios.sieteMedia;

import java.util.Scanner;

public class Utilidades {

    public static String[] palosCartas = {"copas", "bastos", "espadas", "oro"};
    public static int[] numerosCartas = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
    public static Scanner sc = new Scanner(System.in);


    /**
     * Metodo que va a elegir uno de los palos de la baraja
     *
     * @return nombre del palo
     */
    public static String sacarPalo() {
        //Declaramos variables
        int paloAleatorio = (int) (Math.random() * (3) + 1);  //Genera un numero aleatorio de 0 a 3

        return palosCartas[paloAleatorio];
    }

    /**
     * Método que va a sacar un numero aleatorio del 0 al 9 y devolverá
     * @return uno de los posibles numeros de las cartas (1,2,3,4,5,6,7,10,11 o 12)
     */
    public static int sacarNumCarta() {
        //Declaramos las variables
        int numeroCarta = (int) ((Math.random() * 9) + 1);

        return numerosCartas[numeroCarta];
    }

    /**
     * Metodo al que le pasaremos el resultado de los dos metodos anteriores por parámetro
     * @param numCarta
     * @param palo
     * y devoverá un sout que muestre al usuario que carta ha sacado
     */
    public static void sacarCarta(int numCarta, String palo) {
        System.out.println("Tu carta es: " + numCarta + " de " + palo);
    }

    /**
     *
     * @param numCarta
     * @return
     */
    public static double puntuaciones(int numCarta) {
        double puntos = 0;
        if (numCarta >= 1 && numCarta <= 7) {
            puntos += (double) numCarta;
        } else {
            puntos += 0.5;
        }
        return puntos;
    }

    public static double turno(String nombre, double puntos) {
        String respuesta;
        int numeroCarta;

        System.out.println("Comienza " + nombre + ":");

        do {
            System.out.println("Desea sacar una carta?");
            respuesta = sc.next();

            if (respuesta.equals("si")) {
                numeroCarta=sacarNumCarta();
                sacarCarta(numeroCarta, sacarPalo());
                puntos += puntuaciones(numeroCarta);
                System.out.println("Actualmente tienes: " + puntos + " puntos");
            }

        } while (respuesta.equals("si") && puntos <= 7.5);

        if (puntos>7.5){
            System.out.println("Te has pasado!!");
        }

        return puntos;
    }
}
