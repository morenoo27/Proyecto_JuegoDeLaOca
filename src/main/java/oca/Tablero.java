/*
    Para esta clase vamos a tener las siguientes sentencias, ya que tenemos
diferentes tipos de casillas:
    
    ·Oca: Casillas 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54 y 59. 
The mitical "De oca a oca y tiro porque me toca"
    ·Puente: Casilla 6 y 12.
Se va a la posada.
    ·Posada: Casilla 19.
Si se cae en esta casilla se pierde un turno.
    ·Pozo: Casilla 31.
Si se cae en esta casilla, NO se puede volver a jugar hasta que no pase otro 
jugador por esa casilla.
    ·Laberinto: Casilla 42. 
Si se cae en esta casilla, se está obligado a retroceder a la casilla 30.
    ·Cárcel: Casilla 56.
Si se cae en esta casilla, hay que permanecer dos turnos sin jugar.
    ·Dados: Casillas 26 y 53. 
Si se cae en estas casillas, se suma la marcación de la casilla de los dados 
(26 o 53) y se avanza tanto como resulte.
    ·Calavera: Casilla 58. 
Si se cae en esta casilla, hay que volver a la Casilla 1.
    
    ¡¡Mirar como hacer esto!!

    ·Entrar al Jardín de la Oca: 
Es necesario sacar los puntos justos para entrar, en caso de exceso se 
retroceden tantas casillas como puntos sobrantes.


Las dimensiones de un tablero de la oca son de la siguiente manera:
    

         |24| |23| |22| |21| |20| |19| |18| |17| |16|
         |25| |46| |45| |44| |43| |42| |41| |40| |15|
         |26| |47| |60| |59| |58| |57| |56| |39| |14|
         |27| |48| |61| |62| |62| |63| |55| |38| |13|
         |28| |49| |50| |51| |52| |53| |54| |37| |12|
         |29| |30| |31| |32| |33| |34| |35| |36| |11|
    | 1| | 2| | 3| | 4| | 5| | 6| | 7| | 8| | 9| |10|



             |25| |24| |23| |22| |21| |20| |19| |18|
        |26|      |47| |46| |45| |44| |43| |42|      |17|
        |27| |48|           |62| |61| |60|      |41| |16|
        |28| |49|        |        |        |59| |40| |15|
        |29| |50|        |   63   |        |58| |39| |14|
        |30| |51|        |________|        |57| |40| |13|
        |31|      |52| |53| |54| |55| |56|      |39| |12|
             |32| |33| |34| |35| |36| |37| |38|      |11|
   | 1| | 2| | 3| | 4| | 5| | 6| | 7| | 8| | 9| |10|

 */
package oca;

import javax.swing.JOptionPane;
import static oca.Juego.jugadores;
import static oca.Pruebas.tablero;


/*
 * @author aleja
 */
public class Tablero {

    private Casilla[] casilla;
    private String[] nombreCasilla = new String[64];

    static String tablero1 = "         |25|   |24|   |23|   |22|   |21|   |20|   |19|   |18|";
    static String tablero2 = "    |26|        |49|   |48|   |47|   |46|   |45|   |44|        |17|";
    static String tablero3 = "    |27|   |50|     _________                           |43|   |16|";
    static String tablero4 = "    |28|   |51|    |                  |                          |42|   |15|";
    static String tablero5 = "    |29|   |52|    |     63    |62|  |61|   |60|          |41|   |14|";
    static String tablero6 = "    |30|   |53|    |_________|          |59|          |40|   |13|";
    static String tablero7 = "    |31|        |54|   |55|   |56|   |57|   |58|          |39|   |12|";
    static String tablero8 = "           |32|   |33|   |34|   |35|   |36|   |37|   |38|        |11|";
    static String tablero9 = "|1|   | 2|   | 3|   | 4|   | 5|   | 6|   | 7|   | 8|   | 9|   |10|";

    //vamos a crear el tablero por defecto, ya que va a haber un solo tablero
    public Tablero() {

        //el tablero esta formado de 63 casillas, para representar eso,
        //crearemos un array de 63 posiciones
        this.casilla = new Casilla[64];
        llenarTablero();
    }

    public int getCasillas() {
        return casilla.length;
    }

    //getter de casilla, dependiendo del numero que recibas
    public Casilla getCasilla(int i) {

        return this.casilla[i];
    }

    public String getNombreCasilla(int i) {

        return this.nombreCasilla[i];
    }

    @Override
    public String toString() {

        String tablero = tablero1 + "\n" + tablero2 + "\n" + tablero3 + "\n" + tablero4 + "\n" + tablero5 + "\n" + tablero6 + "\n" + tablero7 + "\n" + tablero8 + "\n" + tablero9 + "\n";

        for (int i = 0; i < jugadores.size(); i++) {
        
            tablero += "Jugador " + jugadores.get(i).toString() + "\n";
        }
        return tablero;
    }

//    Al hacer la prueba, vemos que todo apunta a null, por tanto vamos a rellenar
//    el tablero de las diferentes casillas
    public void llenarTablero() {

        //creamos un for para recorrer el arrat con las casillas
        for (int i = 0; i < this.casilla.length; i++) {

            if (i == 5 || i == 6 || i == 9 || i == 12 || i == 14
                    || i == 18 || i == 19 || i == 23 || i == 26 || i == 27
                    || i == 31 || i == 32 || i == 36 || i == 41 || i == 42
                    || i == 45 || i == 50 || i == 52 || i == 53 || i == 54
                    || i == 58 || i == 59 || i == 63) {

                switch (i) {
                    case 5:
                    case 14:
                    case 23:
                    case 32:
                    case 41:
                    case 50:
                    case 59:
                        this.casilla[i] = new Casilla(i, TiposDeCasillas.OCA4);
                        break;
                    case 9:
                    case 18:
                    case 27:
                    case 36:
                    case 45:
                    case 54:
                        this.casilla[i] = new Casilla(i, TiposDeCasillas.OCA5);
                        break;
                    case 6:
                        this.casilla[i] = new Casilla(i, TiposDeCasillas.PUENTE6);
                        break;
                    case 12:
                        this.casilla[i] = new Casilla(i, TiposDeCasillas.PUENTE12);
                        break;
                    case 19:
                        this.casilla[i] = new Casilla(i, TiposDeCasillas.POSADA);
                        break;
                    case 31:
                        this.casilla[i] = new Casilla(i, TiposDeCasillas.POZO);
                        break;
                    case 42:
                        this.casilla[i] = new Casilla(i, TiposDeCasillas.LABERINTO);
                        break;
                    case 26:
                        this.casilla[i] = new Casilla(i, TiposDeCasillas.DADOS26);
                        break;
                    case 53:
                        this.casilla[i] = new Casilla(i, TiposDeCasillas.DADOS53);
                        break;
                    case 52:
                        this.casilla[i] = new Casilla(i, TiposDeCasillas.LABERINTO);
                        break;
                    case 58:
                        this.casilla[i] = new Casilla(i, TiposDeCasillas.CALAVERA);
                        break;
                    case 63:
                        this.casilla[i] = new Casilla(i, TiposDeCasillas.JARDIN_OCA);
                        break;
                }
            } else {

                this.casilla[i] = new Casilla(i, TiposDeCasillas.NORMAL);
            }
        }
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, tablero, "Turno", 0);
    }
}
