package ejercicios.sieteMedia;

public class Main {
    public static void main(String[] args) {

        //Declaramos las variables
        double puntosJ1=0;//donde guardamos los puntos del jugador 1
        double puntosJ2=0;//donde guardamos los puntos del jugador 2

        //actualizamos los puntos del jugador uno segun los puntos que nos salgan en las tiradas
        puntosJ1=Utilidades.turno("Jugador 1", puntosJ1);

        if (puntosJ1>7.5){ //En caso de que se pasen de 7,5 automáticamente perdería el jugador 1
            System.out.println("Jugador 1 ha perdido, enhorabuena Jugador 2.");
        }
        else {  //si no es el caso actualizamos los puntos del jugador 2
            puntosJ2=Utilidades.turno("Jugador 2", puntosJ2);

            if (puntosJ2>7.5){  //si el jugador 2 se pasa de 7,5 ganara el jugador 1
                System.out.println("Jugador 2 ha perdido, enhorabuena Jugador 1.");
            }else { //si ninguno se pasase comprobamos quien tiene mayor puntuacion, es decir, quien se acercaria mas a 7,5 y se declarara ganador
                if (puntosJ1>puntosJ2){
                    System.out.println("Jugador 2 ha perdido, enhorabuena Jugador 1.");
                } else if (puntosJ1<puntosJ2) {
                    System.out.println("Jugador 1 ha perdido, enhorabuena Jugador 2.");
                }
                else { //en caso de que ambos tengan misma puntuacion se declara empate
                    System.out.println("Empate.");
                }
            }
        }


    }


}
