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
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author aleja
 */
public class Juego {

    //implementamos la clase Scanner
    static Scanner teclado = new Scanner(System.in);

    static Tablero tablero = new Tablero();//vamos a tener siempre el mismo tablero

    static final ArrayList<Jugador> jugadores = new ArrayList<>();
    /**
     * El mapa es una ilustacion de lo que se mostrara en la plantalla del
     * JOption, ademas tambien le añadiremos los jugadores y sus respectivas
     * posiciones
     */
    private static final JLabel mapa = new JLabel("<html>"
            + "    <pre>"
            + "             |25| |24| |23| |22| |21| |20| |19| |18|\n"
            + "          |26|    |49| |48| |47| |46| |45| |44|    |17|\n"
            + "        |27|   |50|       ________            |43|   |16|\n"
            + "        |28| |51|        |         |62| |61|    |42| |15|\n"
            + "        |29| |52|        |   63   |        |60| |41| |14|\n"
            + "        |30|   |53|      |________|      |59|   |40| |13|\n"
            + "          |31|    |54| |55| |56| |57| |58|    |39|   |12|\n"
            + "             |32| |33| |34| |35| |36| |37| |38|    |11|\n"
            + "   | 1| | 2| | 3| | 4| | 5| | 6| | 7| | 8| | 9| |10|\n"
            + "    </pre>"
            + mostrarJugadores(jugadores)
            + "</html>");

    private static final ImageIcon ICONO = new ImageIcon("src/main/fotos/oca.jpg");

    public static void main(String[] args) {

        /**
         * Vamos a crear una lista variable para asi poder meter a la cantidad
         * de jugadores que nosotros queramos. Aunque normalmente el juego esta
         * pensado para 4 jugaores, por temas de testeo lo podremos hacer
         * incluso para una persona solo
         */
        String[] opciones = {"2", "3", "4"};
        
        String numero;
        
        numero = String.valueOf(JOptionPane.showInputDialog(null, "¿Cuantos jugadores?", "INICIO", 0, ICONO, opciones, 1));
        
        int players = Integer.parseInt(numero);
        
        for (int i = 0; i < players; i++) {

            int pos = i + 1;
            
            String nombre = JOptionPane.showInputDialog(null, "Jugador " + pos
                    + "\nIntroduzca su nombre:", "Jugador", JOptionPane.INFORMATION_MESSAGE);

            
            String aux = JOptionPane.showInputDialog(null, "Jugador " + pos
                    + "\nIntroduzca su apodo:", "Jugador", JOptionPane.INFORMATION_MESSAGE);
            char apodo = aux.charAt(0);

            Jugador jugador = new Jugador(nombre, apodo);
            jugadores.add(jugador);
        }

        decidirOrden(jugadores);

        boolean fin = true;
        int t = 1;

        do {

            String turno = "Turno " + t;

            for (int i = 0; i < jugadores.size(); i++) {

                jugadores.get(i).jugarTurno();

                JOptionPane.showMessageDialog(null, mapa, "turno", 0, ICONO);
                
                fin = jugadores.get(i).isWin(); 
            }

        } while (fin);
    }

    /**
     * Aqui lo que realizaremos una muerstra de toso los jugadores.Lo
     * utilizaremos en cada turno para mostrar tanto la pociciosn de cada uno de
     * los jugadores
     *
     * @param jugadores : jugadores que hay
     * @return texto con la info de los jugadores 
     */
    public static String mostrarJugadores(ArrayList<Jugador> jugadores) {

        String texto = "prueba<br/>";
        for (int i = 0; i < jugadores.size(); i++) {

            texto += jugadores.get(i).toString() + "<br/>";
        }

        texto += jugadores.size();
        return texto;
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
        }

        Collections.sort(jugadores, (j1, j2) -> (int) (j1.getTiradaInicial() - j2.getTiradaInicial()));
    }
}
