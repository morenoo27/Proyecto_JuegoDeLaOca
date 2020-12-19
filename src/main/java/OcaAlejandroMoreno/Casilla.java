/*
    Para esta clase vamos a tener las siguientes sentencias, ya que tenemos
diferentes tipos de casillas:
    
    ·Oca: Casillas 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54 y 59. 
The mitical "De oca a oca y tiro porque me toca"
    ·Puente: Casilla 6 y 12.
The mitical "De puente a puente y tiro porque me lleva la corriente"
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
 */
package OcaAlejandroMoreno;

/**
 *
 * @author aleja
 */
final class Casilla {

    //Cada casilla va a tener una sentencia/accion ademas de un numero, por lo
    //tanto estos seran los atributos que tendra la casilla.
    private final int[] numCasilla;
    private final int sentenciaCasilla;

    //inicializamos un contador a 0
    private int posicionArrayOca = 0;
    private int posicionArrayPuente = 0;
    

    //solo vamos a tener un tablero, por lo tanto sera un constructor sin
    //parametros, es decir, un constructor por defecto
    public Casilla(int numero) {

        this.numCasilla = new int[63];
        //si en algun momento queremos varias las casilas, con crear un 
        //constructor parametrizado, y que el array sea el numero que reciba
        //dicho constructor

        this.sentenciaCasilla = numero;

        switch (numero) {

            //sentencia "Oca"
            case 5:
                System.out.println("De oca en oca y tiro porque me toca");
                //Avanza hasta la siguiente casilla "oca" y tira de nuevo
                casillaOca(posicionArrayOca);
                break;
            case 6:
                System.out.println("De puente a puente y tiro porque me lleva "
                        + "la corriente");
                //avanza hasta el siguente puente y tira de nuevo
                casillaPuente(posicionArrayPuente);
                break;
            case 9:
                System.out.println("De oca en oca y tiro porque me toca");
                //Avanza hasta la siguiente casilla "oca" y tira de nuevo
                this.posicionArrayOca = 1;
                casillaOca(posicionArrayOca);
                break;
            case 12:
                System.out.println("De puente a puente y tiro porque me lleva "
                        + "la corriente");
                //retrocede hasta el anterior puente y tira de nuevo
                this.posicionArrayPuente = 1;
                casillaPuente(posicionArrayPuente);
                break;
            case 14:
                System.out.println("De oca en oca y tiro porque me toca");
                //Avanza hasta la siguiente casilla "oca" y tira de nuevo
                this.posicionArrayOca = 2;
                casillaOca(posicionArrayOca);
                break;
            case 18:
                System.out.println("De oca en oca y tiro porque me toca");
                //Avanza hasta la siguiente casilla "oca" y tira de nuevo
                this.posicionArrayOca = 3;
                casillaOca(posicionArrayOca);
                break;
            case 19:
                System.out.println("Posada, a mimir");
                //se pierde 1 turno
                break;
            case 23:
                System.out.println("De oca en oca y tiro porque me toca");
                //Avanza hasta la siguiente casilla "oca" y tira de nuevo
                this.posicionArrayOca = 4;
                casillaOca(posicionArrayOca);
                break;
            case 26:
                System.out.println("¡¡Dados!! Pues sumate esta");
                //se suma la marcación de la casilla de los dados 
                //26 y se avanza 26.
                break;
            case 27:
                System.out.println("De oca en oca y tiro porque me toca");
                //Avanza hasta la siguiente casilla "oca" y tira de nuevo
                this.posicionArrayOca = 5;
                casillaOca(posicionArrayOca);
                break;
            case 31:
                System.out.println("Al pozo mi rei");
                //hasta que alguien no pse por el pozo, no se vuelev a tirar
                break;
            case 32:
                System.out.println("De oca en oca y tiro porque me toca");
                //Avanza hasta la siguiente casilla "oca" y tira de nuevo
                this.posicionArrayOca = 6;
                casillaOca(posicionArrayOca);
                break;
            case 36:
                System.out.println("De oca en oca y tiro porque me toca");
                //Avanza hasta la siguiente casilla "oca" y tira de nuevo
                this.posicionArrayOca = 7;
                casillaOca(posicionArrayOca);
                break;
            case 41:
                System.out.println("De oca en oca y tiro porque me toca");
                //Avanza hasta la siguiente casilla "oca" y tira de nuevo
                this.posicionArrayOca = 8;
                casillaOca(posicionArrayOca);
                break;
            case 42:
                System.out.println("Bienvenido al laberinto, ¿te has perdido?"
                        + " ¿necesitas un mapa?");
                //tiene que retroceder 30 casillas
                break;
            case 45:
                System.out.println("De oca en oca y tiro porque me toca");
                //Avanza hasta la siguiente casilla "oca" y tira de nuevo
                this.posicionArrayOca = 9;
                casillaOca(posicionArrayOca);
                break;
            case 50:
                System.out.println("De oca en oca y tiro porque me toca");
                //Avanza hasta la siguiente casilla "oca" y tira de nuevo
                this.posicionArrayOca = 10;
                casillaOca(posicionArrayOca);
                break;
            case 53:
                System.out.println("¡¡Dados!! Pues sumate esta");
                //se suma la marcación de la casilla de los dados 
                //53 y se avanza 53.
                break;
            case 54:
                System.out.println("De oca en oca y tiro porque me toca");
                //Avanza hasta la siguiente casilla "oca" y tira de nuevo
                this.posicionArrayOca = 11;
                casillaOca(posicionArrayOca);
                break;
            case 56:
                System.out.println("A la carcel, maleante");
                //pierde 2 turnos
                break;
            case 58:
                System.out.println("Calavera... A llorar ar parque");
                //se vuelve a la casilla 1 y se pierde el turno
                break;
            case 59:
                System.out.println("De oca en oca y tiro porque me toca");
                //Avanza hasta la siguiente casilla "oca" y tira de nuevo
                this.posicionArrayOca = 12;
                casillaOca(posicionArrayOca);
                break;
        }
    }

    //ahora vamos a crear la metodo-sentencia "Oca"
    public void casillaOca(int posicionArrayOca) {

        //creamos el array de las ocas
        //Oca: Casillas 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54 y 59.
        final int[] ocas = {5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59};

        switch (posicionArrayOca) {
            case 0:
                //nueva posicion de jugador x => 9
                break;
            case 1:
                //nueva posicion de jugador x => 14
                break;
            case 2:
                //nueva posicion de jugador x => 18
                break;
            case 3:
                //nueva posicion de jugador x => 23
                break;
            case 4:
                //nueva posicion de jugador x => 27
                break;
            case 5:
                //nueva posicion de jugador x => 32
                break;
            case 6:
                //nueva posicion de jugador x => 36
                break;
            case 7:
                //nueva posicion de jugador x => 41
                break;
            case 8:
                //nueva posicion de jugador x => 45
                break;
            case 9:
                //nueva posicion de jugador x => 50
                break;
            case 10:
                //nueva posicion de jugador x => 54
                break;
            case 11:
                //nueva posicion de jugador x => 59
                break;
            case 12:
                //nueva posicion de jugador x => 54
                break;
        }
    }
    
    public void casillaPuente(int posicionArrayPuente) {
        final int[] puentes = {6, 12};
        
        switch(posicionArrayPuente){
            case 0:
                //nueva posicion de jugador x => 12
                break;
            case 1:
                //nueva posicion de jugador x => 6
                break;
        }
    }
}
