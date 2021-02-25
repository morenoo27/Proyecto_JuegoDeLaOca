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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author aleja
 */
public class Juego {

    //implementamos la clase Scanner
    static Scanner teclado = new Scanner(System.in);

    static Tablero tablero = new Tablero();//vamos a tener siempre el mismo tablero
    
    static ArrayList<Jugador> jugadores = new ArrayList<>();

    public static void main(String[] args) {

        /**
         * Vamos a crear una lista variable para asi poder meter a la cantidad
         * de jugadores que nosotros queramos. Aunque normalmente el juego esta
         * pensado para 4 jugaores, por temas de testeo lo podremos hacer
         * incluso para una persona solo
         */
        jugadores = jugadores();

        decidirOrden(jugadores);

        mostrarJugadores(jugadores);

        boolean fin = true;
        int t = 1;

        do {

            String turno = "Turno " + t;
            
            for (int i = 0; i < jugadores.size(); i++) {

                jugadores.get(i).jugarTurno();
                
                JOptionPane.showMessageDialog(null, tablero, turno, 3);
            }
            
            for (int i = 0; i < jugadores.size(); i++) {

                if (jugadores.get(i).getPosicion() == tablero.getCasillas() - 1) {
                    fin = jugadores.get(i).ganarPartida();
                }
            }
            
        } while (fin);
    }

    /**
     * Aqui lo que realizaremos una muerstra de toso los jugadores. Lo
     * utilizaremos en cada turno para mostrar tanto la pociciosn de cada uno de
     * los jugadores
     *
     * @param jugadores : jugadores que hay
     */
    public static void mostrarJugadores(ArrayList<Jugador> jugadores) {

        for (int i = 0; i < jugadores.size(); i++) {

            System.out.println(jugadores.get(i).toString());
        }
    }

    /**
     * Aqui lo que vamos a realizar es un inicio de los jugadores que van a
     * jugar. los almacenaos en una lita y los devolvemos para ustilizarlos
     * posteriormente
     *
     * @return
     */
    public static ArrayList<Jugador> jugadores() {

        ArrayList<Jugador> lista = new ArrayList<>();

        System.out.println("¿Cuantos jugadores van a jugar?");
        int numero = teclado.nextInt();

        teclado.nextLine();//limpiamos le teclado

        for (int i = 0; i < numero; i++) {

            int pos = i + 1;
            System.out.println("Jugador " + pos
                    + "\nIntroduzca su nombre:");
            String nombre = teclado.nextLine();

            System.out.println("Introduzca su apodo:");
            String aux = teclado.nextLine();
            char apodo = aux.charAt(0);

            Jugador jugador = new Jugador(nombre, apodo);
            lista.add(jugador);
        }

        return lista;
    }

    private static void decidirOrden(ArrayList<Jugador> jugadores) {

        /**
         * Una vez los jugadores se han "registrado", decidiremos el orden. Para
         * eso usamos la casilla 0, ordenando la lista con la "sentencia"
         * Collections.sort. Para ello, usaremos el atributo de "tiradaInicial"
         * y tiraran una vez los dados cada uno de los jugadores
         */
        for (int i = 0; i < jugadores.size(); i++) {

            int tirada = jugadores.get(i).tirarDados();
            jugadores.get(i).setTiradaInicial(tirada);
            tablero.getCasilla(0).addJugador(jugadores.get(i));
        }

        Collections.sort(jugadores, (j1, j2) -> (int) (j1.getTiradaInicial() - j2.getTiradaInicial()));
    }
}
