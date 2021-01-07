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

/*
 * @author aleja
 */
public class Tablero {

    private Casilla[] casilla;
    private String[] nombreCasilla = new String[64];

    //vamos a crear la casilla normal, que la hemos creado como la 
    //predeterminada
    private final Casilla NORMAL = new Casilla();//No sentencia, solo una tirada

    //Casilla de inicio
    private final Casilla INICIO = new Casilla();//No sentencia , solo una tirada y se pasa al siguiente jugador

    //vamos a crear la casilla oca
    private final Casilla OCA = new Casilla(true, 0, true, true, false, false);
    //si sentencia, va a la siguiente oca y vuelve a tirar una vez mas

    //casilla puente
    private final Casilla PUENTE = new Casilla(true, 1, false, true, false, false);
    //Si sentencia, se va a la posada y se pierde el turno

    //casilla posada
    private final Casilla POSADA = new Casilla(true, 1, false, false, false, false);
    //si sentencia, se pierde el turno

    //casilla pozo
    private final Casilla POZO = new Casilla(true, 1, false, false, true, false);
    //si sentencia, se pierde el turno hasta que alguien pase por el

    //casilla laberinto
    private final Casilla LABERINTO = new Casilla(true, 1, false, true, false, false);
    //si sentencia, se pierde el turno y retrocede x casillas

    //casilla carcel
    private final Casilla CARCEL = new Casilla(true, 3, false, false, false, false);
    //si sentencia, pierde 3 turnos

    //caslla dados
    private final Casilla DADOS = new Casilla(true, 1, false, true, false, false);
    //si sentencia(cual, ya se vera)

    //casilla calavera
    private final Casilla CALAVERA = new Casilla(true, 1, false, true, false, false);
    //si sentencia, se vuelve al inicio

    //casilla final
    private final Casilla FINAL = new Casilla(true, 1, false, false, false, true);
    //si sentencia, acaba el tableroDePrueba

    //vamos a crear el tablero por defecto, ya que va a haber un solo tablero
    public Tablero() {

        //el tablero esta formado de 63 casillas, para representar eso,
        //crearemos un array de 63 posiciones
        this.casilla = new Casilla[64];
    }

    //getter de casilla, dependiendo del numero que recibas
    public Casilla getCasilla(int i) {
        
        Tablero tablero = new Tablero();
        tablero.llenarTablero();

        if (i == 0 || i == 5 || i == 6 || i == 9 || i == 12 || i == 14
                || i == 18 || i == 19 || i == 23 || i == 26 || i == 27
                || i == 31 || i == 32 || i == 36 || i == 41 || i == 42
                || i == 45 || i == 50 || i == 52 || i == 53 || i == 54
                || i == 58 || i == 59 || i == 63) {

            switch (i) {
                case 5:
                case 9:
                case 14:
                case 18:
                case 23:
                case 27:
                case 32:
                case 36:
                case 41:
                case 45:
                case 50:
                case 54:
                case 59:
                    this.casilla[i] = OCA;
                    break;
                case 6:
                case 12:
                    this.casilla[i] = PUENTE;
                    break;
                case 19:
                    this.casilla[i] = POSADA;
                    break;
                case 31:
                    this.casilla[i] = POZO;
                    break;
                case 42:
                    this.casilla[i] = LABERINTO;
                    break;
                case 26:
                case 53:
                    this.casilla[i] = DADOS;
                    break;
                case 52:
                    this.casilla[i] = CARCEL;
                    break;
                case 58:
                    this.casilla[i] = CALAVERA;
                    break;
                case 63:
                    this.casilla[i] = FINAL;
                    break;
            }
        } else {

            this.casilla[i] = NORMAL;
        }
        return casilla[i];
    }

    public Casilla getNombreCasilla(int i) {
        
        Tablero tablero = new Tablero();
        tablero.llenarTablero();

        if (i == 0 || i == 5 || i == 6 || i == 9 || i == 12 || i == 14
                || i == 18 || i == 19 || i == 23 || i == 26 || i == 27
                || i == 31 || i == 32 || i == 36 || i == 41 || i == 42
                || i == 45 || i == 50 || i == 52 || i == 53 || i == 54
                || i == 58 || i == 59 || i == 63) {

            switch (i) {
                case 5:
                case 9:
                case 14:
                case 18:
                case 23:
                case 27:
                case 32:
                case 36:
                case 41:
                case 45:
                case 50:
                case 54:
                case 59:
                    this.nombreCasilla[i] = "Oca";
                    break;
                case 6:
                case 12:
                    this.nombreCasilla[i] = "Puente";
                    break;
                case 19:
                    this.nombreCasilla[i] = "Posada";
                    break;
                case 31:
                    this.nombreCasilla[i] = "Pozo";
                    break;
                case 42:
                    this.nombreCasilla[i] = "Laberinto";
                    break;
                case 26:
                case 53:
                    this.nombreCasilla[i] = "Dados";
                    break;
                case 52:
                    this.nombreCasilla[i] = "Carcel";
                    break;
                case 58:
                    this.nombreCasilla[i] = "Calavera";
                    break;
                case 63:
                    this.nombreCasilla[i] = "Final";
                    break;
            }
        } else {

            this.nombreCasilla[i] = "Normal";
        }
        return casilla[i];
    }

    //vamosa a crear un metodo para ver como estaran las casillas, es decir,
    //para saber si esta todo correctamente implementado
    public void mostrarTablero() {

        //creamos un for que recorra cada posicion del tablero
        for (int i = 0; i < casilla.length; i++) {
            System.out.println("Casilla " + i + "=" + casilla[i]);
        }
    }

//    Al hacer la prueba, vemos que todo apunta a null, por tanto vamos a rellenar
//    el tablero de las diferentes casillas
    public void llenarTablero() {

        //creamos un for para recorrer el arrat con las casillas
        for (int i = 0; i < this.casilla.length; i++) {

            if (i == 0 || i == 5 || i == 6 || i == 9 || i == 12 || i == 14
                    || i == 18 || i == 19 || i == 23 || i == 26 || i == 27
                    || i == 31 || i == 32 || i == 36 || i == 41 || i == 42
                    || i == 45 || i == 50 || i == 52 || i == 53 || i == 54
                    || i == 58 || i == 59 || i == 63) {

                switch (i) {
                    case 0:
                        this.casilla[i] = INICIO;
                        break;
                    case 5:
                    case 9:
                    case 14:
                    case 18:
                    case 23:
                    case 27:
                    case 32:
                    case 36:
                    case 41:
                    case 45:
                    case 50:
                    case 54:
                    case 59:
                        this.casilla[i] = OCA;
                        break;
                    case 6:
                    case 12:
                        this.casilla[i] = PUENTE;
                        break;
                    case 19:
                        this.casilla[i] = POSADA;
                        break;
                    case 31:
                        this.casilla[i] = POZO;
                        break;
                    case 42:
                        this.casilla[i] = LABERINTO;
                        break;
                    case 26:
                    case 53:
                        this.casilla[i] = DADOS;
                        break;
                    case 52:
                        this.casilla[i] = CARCEL;
                        break;
                    case 58:
                        this.casilla[i] = CALAVERA;
                        break;
                    case 63:
                        this.casilla[i] = FINAL;
                        break;
                }
            } else {

                this.casilla[i] = NORMAL;
            }
        }
    }

    public void nombrarTablero() {

        //creamos un for para recorrer el arrat con las casillas
        for (int i = 0; i < this.casilla.length; i++) {
            if (i == 0 || i == 5 || i == 6 || i == 9 || i == 12 || i == 14
                    || i == 18 || i == 19 || i == 23 || i == 26 || i == 27
                    || i == 31 || i == 32 || i == 36 || i == 41 || i == 42
                    || i == 45 || i == 50 || i == 52 || i == 53 || i == 54
                    || i == 58 || i == 59 || i == 63) {

                switch (i) {
                    case 5:
                    case 9:
                    case 14:
                    case 18:
                    case 23:
                    case 27:
                    case 32:
                    case 36:
                    case 41:
                    case 45:
                    case 50:
                    case 54:
                    case 59:
                        this.nombreCasilla[i] = "Oca";
                        break;
                    case 6:
                    case 12:
                        this.nombreCasilla[i] = "Puente";
                        break;
                    case 19:
                        this.nombreCasilla[i] = "Posada";
                        break;
                    case 31:
                        this.nombreCasilla[i] = "Pozo";
                        break;
                    case 42:
                        this.nombreCasilla[i] = "Laberinto";
                        break;
                    case 26:
                    case 53:
                        this.nombreCasilla[i] = "Dados";
                        break;
                    case 52:
                        this.nombreCasilla[i] = "Carcel";
                        break;
                    case 58:
                        this.nombreCasilla[i] = "Calavera";
                        break;
                    case 63:
                        this.nombreCasilla[i] = "Final";
                        break;
                }
            } else {

                this.nombreCasilla[i] = "Normal";
            }
        }
    }

    public void mostrarNombresTablero() {

        //creamos un for que recorra cada posicion del tablero
        for (int i = 0; i < this.nombreCasilla.length; i++) {
            System.out.println("Casilla " + i + "=" + this.nombreCasilla[i]);

        }
    }

    public static void main(String[] args) {

        //creamos el tablero
        Tablero tableroDePrueba = new Tablero();

        tableroDePrueba.llenarTablero();
        tableroDePrueba.nombrarTablero();
        tableroDePrueba.mostrarTablero();
        tableroDePrueba.mostrarNombresTablero();
    }
}
