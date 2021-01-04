/*
Aqui haremos el funcionamiento del juego


Para que sea de jugadores variables empezariamos con

int cantidadJugadores;

do{
    System.out.println("¿Cantidad de jugaores?");
    cantidadJugadores = teclado.nextInt();
}while(cantidadJugadores < 0)

for (int i = 0; i < cantidadJugadores; i++) {
            
    System.out.println("¿Nombre del jugador " + (i+1) + "?");
    nombre = teclado.nextLine();
            
    System.out.println("¿Apodo del jugador " + (i+1) + "?(Solo una letra)");
    apodo = teclado.nextLine();
            
    jugadores[i] = new Jugador(nombre, apodo);
            
}
 */
package oca;

import java.util.Scanner;

/**
 *
 * @author aleja
 */
public class Juego {

    private Tablero tablero;
    private Jugador jugador;

    public static void main(String[] args) {

        //Para este proyecto podremos fijo que sean 2 personas aunque podemos 
        //hacer que sea de varios jugadores.
        //Para ello, si queremos implementar esa funcion, usaremos las lineas de
        //codigo que estan comentadas arriba.
        //implementamos la clase Scanner
        Scanner teclado = new Scanner(System.in);

        //declaramos los jugadores que vamos a a ser
        Jugador[] jugadores = new Jugador[2];
        String nombre, apodo;
        boolean finalJuego = true;

        //for para meter los nombres
        for (int i = 0; i < jugadores.length; i++) {

            System.out.println("¿Nombre del jugador " + (i + 1) + "?");
            nombre = teclado.nextLine();

            System.out.println("¿Apodo del jugador " + (i + 1) + "?(Solo una letra)");
            apodo = teclado.nextLine();

            jugadores[i] = new Jugador(nombre, apodo);
        }

        //bucle para mostrar los jugadores
        for (int i = 0; i < jugadores.length; i++) {

            System.out.println("Jugador " + (i + 1) + " : " + jugadores[i]);
        }
        
        do{
            for (int i = 0; i < 10; i++) {
                System.out.print(i + "-");
                
                if (i==3) {
                    finalJuego = false;
                    break;
                }
            }
        }while(finalJuego);
    }
}