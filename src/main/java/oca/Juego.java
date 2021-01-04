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
        
        //empezamos el tablero(tambien tenemos que crear uno)
        Tablero tablero = new Tablero();
        
        tablero.llenarTablero();
        tablero.nombrarTablero();
        
        do{
            int numero = 0;
            if (tablero.equals("Oca")) {
                
            }
            numero++;
        }while(finalJuego);
    }
    
    public void Oca(int numero, int i) {
        
        switch (numero) {
            case 5:
            case 14:
            case 23:
            case 32:
            case 41:
            case 50:
                jugador.moverse(5);
                jugador.moverse(jugador.tirarDados());
                break;
            case 9:
            case 18:
            case 27:
            case 36:
            case 45:
            case 54:
                jugador.moverse(5);
                jugador.moverse(jugador.tirarDados());
                break;
            case 59:
                jugador.moverse(-5);
                jugador.moverse(jugador.tirarDados());
                break;
        }
    }
}