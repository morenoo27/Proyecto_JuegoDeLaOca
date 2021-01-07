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

        boolean sentencia; //para si la casilla teniene una accion o no
        int pierdeTurno;// pierde posicion
        boolean vuelveATirar = false;//true vuelve a tirar
        boolean finalDelJuego = true, saltoDeCasilla, dependeDeJugador;

        int[] posicion = new int[2];
        posicion[0] = 0;
        posicion[1] = 0;
        //for para meter los nombres
        for (int i = 0; i < jugadores.length; i++) {

            System.out.println("¿Nombre del jugador " + (i + 1) + "?");
            nombre = teclado.nextLine();

            System.out.println("¿Apodo del jugador " + (i + 1) + "?(Solo una letra)");
            apodo = teclado.nextLine();

            jugadores[i] = new Jugador(nombre, apodo);
        }

        mostrarJugadores(jugadores);

        //empezamos el tablero(tambien tenemos que crear uno)
        Tablero tablero = new Tablero();

        tablero.llenarTablero();
        tablero.nombrarTablero();

        do {
            for (int i = 0; i < jugadores.length; i++) {
                do {
                    //el jugador primero tira y se mueve
//                    jugadores[i].moverse(jugadores[i].tirarDados());

                    //vamos a forzar que el jugador 2 caiga en la casilla de la oca de momento solo para practicar y el uno vaya de uno en uno
                    jugadores[1].moverse(5);
                    jugadores[0].moverse(1);

                    //leemos la casilla en la que se encuentra el jugador
                    posicion[i] += jugadores[i].getPosicion();

                    //nombramos la casilla actual del jugador
                    Casilla casillaActual = tablero.getCasilla(posicion[i]);

                    //recogemos la caracteristicas de dicha casilla
                    sentencia = casillaActual.getSENTENCIA();

                    //pillamos tambien las demas caracteristcas de la casilla
                    vuelveATirar = casillaActual.getVUELVEATIRAR();

                    pierdeTurno = casillaActual.getPIERDETURNO();

                    dependeDeJugador = casillaActual.getDEPENDEDEJUGADOR();

                    saltoDeCasilla = casillaActual.getSALTODECASILLA();
                    
                    if (sentencia) {

                        if (vuelveATirar) {

                            //si entra en este bucle significa que entra 
                            //posiblemente en la casilla de la oca, ya que 
                            //ninguna casilla tiene la caracteristica de que se 
                            //vuelva a tirar
                            System.out.println("Jugador " + (i + 1) + ": ¡Has caido en una casilla de OCA!");
                            System.out.println("¡De oca en oca y tiro por que me toca!");

                            //salta a la siguiente oca(se mueve)
                            jugadores[i].moverse(casillaOca(jugadores[i].getPosicion()));

                        }
                    } else {

                        System.out.println("Jugador " + (i + 1) + ": Has caido en una casilla normal");
                    }

                    mostrarJugadores(jugadores);
                } while (!vuelveATirar);
            }
        } while (finalDelJuego);
    }

    public static int casillaOca(int numero) {

        int movimiento = 0;
        switch (numero) {
            case 5:
            case 14:
            case 23:
            case 32:
            case 41:
            case 50:
                movimiento = 4;
                break;
            case 9:
            case 18:
            case 27:
            case 36:
            case 45:
            case 54:
                movimiento = 5;
                break;
            case 59:
                movimiento = -5;
                break;
        }
        return movimiento;
    }

    public static void mostrarJugadores(Jugador[] jugadores) {

        //bucle para mostrar los jugadores
        for (int i = 0; i < jugadores.length; i++) {

            System.out.println("Jugador " + (i + 1) + " : " + jugadores[i]);
        }
    }
}
