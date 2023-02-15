package ejercicios.sieteMedia;

public class Main {
    public static void main(String[] args) {

        //Declaramos las variables
        double puntosJ1 = 0;    //Variable donde guardaremos los puntos del jugador 1
        double puntosJ2 = 0;    //Variable donde guardaremos los puntos del jugador 2

        //Actualizaremos los puntos cada jugador según los puntos que nos salgan en las tiradas
        puntosJ1 = Utilidades.turno("Jugador 1", puntosJ1);
        puntosJ2 = Utilidades.turno("Jugador 2", puntosJ2);

        if (puntosJ1>7.5){  //Si el jugador 1 se pasa de 7.5
            if (puntosJ2>7.5){ //Si jugador 2 tambien se pasa declaramos empate
                System.out.println("Empate, ambos os habeis pasado");
            }else{ //Si jugador 2 no se pasa, jugador 2 gana
                System.out.println("Enhorabuena, has ganado Jugador 2");
            }
        }else{ //Si jugador 1 no se pasa
            if (puntosJ2>7.5){ //Si jugador 2 se pasa, gana el jugador 1
                System.out.println("Enhorabuena, has ganado Jugador 1");
            }else{ //Si jugador 2 no se pasa, comparamos las puntuaciones de ambos
                if (puntosJ1 > puntosJ2) { //Si los puntos de J1 son más que los de J2, gana J1
                    System.out.println("Enhorabuena, has ganado Jugador 1");
                } else if (puntosJ1 < puntosJ2) { //Si los puntos de J2 son más que los de J2, gana J2
                    System.out.println("Enhorabuena, has ganado Jugador 2");
                } else if (puntosJ1==puntosJ2){  //en caso de que ambos tengan misma puntuación se declara empate
                    System.out.println("Empate, ambos teneis la misma puntuacion");
                }
            }
        }

    }


}
