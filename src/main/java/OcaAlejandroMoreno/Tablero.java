/*
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
    |1| | 2| | 3| | 4| | 5| | 6| | 7| | 8| | 9| |10|

 */
package OcaAlejandroMoreno;

/**
 *
 * @author aleja
 */
public class Tablero {
    
    private Casilla casilla;
    private Jugador jugador;
    private String[] filasTablero;
    
    public Tablero(){
        
    }
}
