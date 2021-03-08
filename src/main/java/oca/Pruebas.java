/*
 * pruebas, nada que objetar
 */
package oca;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static oca.Juego.jugadores;
import static oca.Juego.mostrarJugadores;
import static oca.Juego.tablero;

/**
 *
 * @author aleja
 */
public class Pruebas {

    private static final ImageIcon ICONO = new ImageIcon("src/main/fotos/oca.jpg");

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

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, mapa, "turno", 0, ICONO);

        Casilla casilla = new Casilla(0, TiposDeCasillas.CARCEL);
        casilla = tablero.getCasilla(5);
        casilla.mensaje();
        casilla = tablero.getCasilla(6);
        casilla.mensaje();
        casilla = tablero.getCasilla(19);
        casilla.mensaje();
        casilla = tablero.getCasilla(26);
        casilla.mensaje();
        casilla = tablero.getCasilla(31);
        casilla.mensaje();
        casilla = tablero.getCasilla(+2);
        casilla.mensaje();
        casilla = tablero.getCasilla(52);
        casilla.mensaje();
        casilla = tablero.getCasilla(58);
        casilla.mensaje();
        casilla = tablero.getCasilla(63);
        casilla.mensaje();

//        Jugador a = new Jugador("ale");
//        Jugador b = new Jugador("albert");
//
//        jugadores.add(a);
//        jugadores.add(b);
//
//        boolean fin = true;
//        int t = 1;
//
//        do {
//
//            String turno = "Turno " + t;
//
//            for (int i = 0; i < jugadores.size(); i++) {
//
//                jugadores.get(i).jugarTurno();
//
//                //actualizamos el mapa
//                mapa = new JLabel("<html>"
//                        + "    <pre>"
//                        + "             |25| |24| |23| |22| |21| |20| |19| |18|\n"
//                        + "          |26|    |49| |48| |47| |46| |45| |44|    |17|\n"
//                        + "        |27|   |50|       ________            |43|   |16|\n"
//                        + "        |28| |51|        |         |62| |61|    |42| |15|\n"
//                        + "        |29| |52|        |   63   |        |60| |41| |14|\n"
//                        + "        |30|   |53|      |________|      |59|   |40| |13|\n"
//                        + "          |31|    |54| |55| |56| |57| |58|    |39|   |12|\n"
//                        + "             |32| |33| |34| |35| |36| |37| |38|    |11|\n"
//                        + "   | 1| | 2| | 3| | 4| | 5| | 6| | 7| | 8| | 9| |10|\n"
//                        + "    </pre>"
//                        + mostrarJugadores(jugadores)
//                        + "</html>");
//
//                JOptionPane.showMessageDialog(null, mapa, "turno", 0, ICONO);
//            }
//
//        } while (fin);
    }

    public static String mostrarJugadores(ArrayList<Jugador> jugadores) {

        String texto = "Jugadores:<br/>";

        for (int i = 0; i < jugadores.size(); i++) {

            texto += jugadores.get(i).toString() + "<br/>";
        }

        return texto;
    }
}
