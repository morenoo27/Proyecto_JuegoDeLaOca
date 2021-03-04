/*
PROTOTIPOS DWE TABLERO:
    

         |24| |23| |22| |21| |20| |19| |18| |17| |16|
         |25| |46| |45| |44| |43| |42| |41| |40| |15|
         |26| |47| |60| |59| |58| |57| |56| |39| |14|
         |27| |48| |61| |62| |62| |63| |55| |38| |13|
         |28| |49| |50| |51| |52| |53| |54| |37| |12|
         |29| |30| |31| |32| |33| |34| |35| |36| |11|
    | 1| | 2| | 3| | 4| | 5| | 6| | 7| | 8| | 9| |10|



                 |25| |24| |23| |22| |21| |20| |19| |18|
              |26|    |49| |48| |47| |46| |45| |44|    |17|
              |27|   |50|       ________            |43|   |16|
              |28| |51|        |         |62| |61|    |42| |15|
              |29| |52|        |   63   |        |60| |41| |14|
              |30|   |53|      |________|      |59|   |40| |13|
                |31|    |54| |55| |56| |57| |58|    |39|   |12|
                   |32| |33| |34| |35| |36| |37| |38|    |11|
         | 1| | 2| | 3| | 4| | 5| | 6| | 7| | 8| | 9| |10|

 */
package oca;

/*
 * @author aleja
 */
public class Tablero {

    private Casilla[] casilla;
    private String[] nombreCasilla = new String[64];
  

    //vamos a crear el tablero por defecto, ya que va a haber un solo tablero
    public Tablero() {

        //el tablero esta formado de 63 casillas, para representar eso,
        //crearemos un array de 63 posiciones
        this.casilla = new Casilla[64];
        
        //metodo para llenar el tablero de casillas
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

//    Al hacer la prueba, vemos que todo apunta a null, por tanto vamos a rellenar
//    el tablero de las diferentes casillas
    public void llenarTablero() {

        //creamos un for para recorrer el arrat con las casillas
        for (int i = 0; i < this.casilla.length; i++) {

            //dependeindo de la casilla, sera de un tipo u otro
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
                    case 53:
                        this.casilla[i] = new Casilla(i, TiposDeCasillas.DADOS);
                        break;
                    case 52:
                        this.casilla[i] = new Casilla(i, TiposDeCasillas.CARCEL);
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
}
