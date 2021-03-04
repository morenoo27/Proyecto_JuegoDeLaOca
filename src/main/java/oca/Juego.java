/**
 * Aqui haremos el funcionamiento del juego
 *
 */
package oca;

import java.util.ArrayList;
import java.util.Collections;
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
    private static JLabel mapa = new JLabel("<html>"
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
         * para empezar lo primero que realizaremos resa una ventana que decida
         * cuantos jugadorea van a jugar. Establecido estan 4, pero podemos
         * poner los que queramso
         */
        //cremos el array con las opciones(debe ser string para ser mostrado en JOption)
        String[] opciones = {"2", "3", "4"};

        //almacenamos el numero que sera
        String numero;

        numero = String.valueOf(JOptionPane.showInputDialog(null, "¿Cuantos jugadores?", "INICIO", 0, ICONO, opciones, 1));

        //por medio de conversion a int obtenemos los jugadores
        int players = Integer.parseInt(numero);

        //una evz sabemos los jugadores comencemos con la creacion de cada jugador
        for (int i = 0; i < players; i++) {

            //mensaje para pedir nombre de cada jugador
            int pos = i + 1;

            String nombre = JOptionPane.showInputDialog(null, "Jugador " + pos
                    + "\nIntroduzca su nombre:", "Jugador", JOptionPane.INFORMATION_MESSAGE);

            //una evz tenemos el parametro, creamos el objeto jugador y lo añadimos a nuestra lista
            Jugador jugador = new Jugador(nombre);
            jugadores.add(jugador);
        }

        decidirOrden(jugadores);

        /**
         * y a continuacion empezamos a jugar, haremos un do while para que los
         * turnos vayan avanzando segun van tirando los jugadores, hastaq ue uno
         * de ellos llegue al Jardin y rompa el bucle, proclamandose ganador de
         * la oca
         */
        boolean fin = true;
        int t = 1;

        do {

            String turno = "Turno " + t;

            for (int i = 0; i < jugadores.size(); i++) {

                //turno de que el jugador "i" juegue su turno
                jugadores.get(i).jugarTurno();

                //actualizamos el mapa
                mapa = new JLabel("<html>"
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

                //mostramos el mapa con el turno y ls posiciones de los jugadores
                JOptionPane.showMessageDialog(null, mapa, turno, 0, ICONO);

                fin = jugadores.get(i).isWin();
            }

            //actualizamos el turno sumando 1
            t++;
        } while (!fin);
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

        String texto = "<strong>Jugadores:</strong><br/>";
        for (int i = 0; i < jugadores.size(); i++) {

            texto += jugadores.get(i).toString() + "<br/>";
        }

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
