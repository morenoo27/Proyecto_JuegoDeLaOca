/*

 */
package oca;

import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static oca.Juego.jugadores;
import static oca.Juego.tablero;

/**
 *
 * @author aleja
 */
class Jugador {

    private String nombre;
    private int posicion;
    private int tiradaInicial;
    private int turnosSinJugar;
    private boolean win; //TRUE HA GANADO - FALSE SIGUE SIN GANAR

    //vamosa a tener que crear un objeto de tipo random
    static Random random = new Random();
    static Scanner tec = new Scanner(System.in);

    //IMAGENES NECESARIAS
    private static final ImageIcon ICONO = new ImageIcon("src/main/fotos/oca.jpg");
    private static final ImageIcon TIRADA = new ImageIcon("src/main/fotos/altoke.jpg");
    private static final ImageIcon ESPERA = new ImageIcon("src/main/fotos/pozo.jpg");

    //Un jugador siempre va a ser parametrizado, ya que vamos a tener que 
    //introducir nuestros datos
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.posicion = 0;
        this.tiradaInicial = 0;
        this.turnosSinJugar = 0;
        this.win = false;
    }

    public int tirarDados() {
        /**
         * en el juego real, se tirar un dado de forma que el numero que sale es
         * de forma aleatoria el numero que sale. Aqui, por medio de JOption con
         * el boton de Ok simularemos que tiramos un dado
         */

        String mensaje = "Te toca tirar " + this.getNombre()
                + "\n Pulsa OK para tirar";

        JOptionPane.showMessageDialog(null, mensaje, "TIRADA JUGADOR", 0, ICONO);
        int tirada = random.nextInt(6) + 1;//genera un num entre 1 y 6

        JOptionPane.showMessageDialog(null, "Has sacado un " + tirada, "TIRADA JUGADOR", 0, TIRADA);

        return tirada;//devuelve un numero entre 1-6
    }

    public void jugarTurno() {

        //inicializaremos un booleano poara saber si en el turno del jugador 
        // se tirara de nuevo(cae en una oca)
        boolean tiraDeNuevo = false;

        //aqui filtramos si esta en el pozo y aun nadie ha pasado, ya que si ha 
        //pasado alguien los turnos se ponderan he cero y en el siguiente turno tirara
        if (this.getTurnosSinJugar() != 0 && this.getPosicion() == 31) {

            for (int i = 0; i < jugadores.size(); i++) {

                //si hay algun jugador que no sea el propio jugador que este por
                //delante del pozo, automaticamente sale del pozo
                if (jugadores.get(i) != this && jugadores.get(i).getPosicion() > 31) {

                    this.setTurnosSinJugar(0);

                    String texto = "¡Alguien ha pasado y te ha ayudado a salir!";

                    JOptionPane.showMessageDialog(null, texto, "TIRADA JUGADOR", 0, ESPERA);

                } else {

                    String texto = "Aun no ha pasado nadie por el pozo, te toca esperar...";

                    JOptionPane.showMessageDialog(null, texto, "TIRADA JUGADOR", 0, ESPERA);

                }
            }

            //en este if lo unico que hacemos es identificar si debe turnos, 
            //si los debe, mostrara un mensaje con los turnos que quedan
        } else if (this.getTurnosSinJugar() != 0) {

            //restamos uno a los turnos sin jugar(simulando que va a cumplir el 
            //turno sin tirar ni moverse)
            this.turnosSinJugar--;

            //se muestra por pantalla los turnos restantes
            String texto = "Tienes turnos sin jugar aun.\n"
                    + "Te quedan " + (this.getTurnosSinJugar() + 1) + " turnos sin jugar";
            JOptionPane.showMessageDialog(null, texto, "TIRADA JUGADOR", 0, ESPERA);

            //si no se situa en el pozo ni debe turnos, tirara sin restricciones
        } else {

            //crearemos un do while para controlar que pueda tirar de nuevo
            do {

                //captamos la info de la casilla actual para saber donde se situa
                Casilla actual = tablero.getCasilla(this.posicion);

                /**
                 * A la hora de moverse por el principio no generara ningun
                 * problema sacar cualquier puntuacion pero conforme nos vamos
                 * acercando al jardin, los numeros de mas nos haran retroceder
                 */
                int tirada = this.tirarDados();

                //con la tirada y la casilla vemos si se pasa del tablero
                if (sePasa(tirada, actual)) {

                    //calculamos cuanto hay hasta el jardin
                    int hastaJardin = tablero.getCasilla(tablero.getCasillas() - 1).getId() - actual.getId();

                    //nos movemos hasta el jardin
                    this.moverse(hastaJardin);

                    //calculamos el rebote
                    int rebote = tirada - hastaJardin;

                    //retrocedemos la cantidad
                    this.retroceder(rebote);

                } else {

                    //si no se pasa, hace un movimiento normal
                    this.moverse(tirada);
                }

                /**
                 * Una vez nos hemos movido, habermos caido en una casilla. Esa
                 * casilla tendra una informacion tanto de turnos sin jugar de
                 * si hace un movimiento extra, si tira de nuevo, etc. para eso
                 * nos iremos a otro metodo que devolvera un booleano para el
                 * tema de si el jugador tira de nuevo o no
                 */
                tiraDeNuevo = caerEnCasilla(this.posicion);

                if (this.isWin()) {
                    tiraDeNuevo = false;
                }

            } while (tiraDeNuevo);
        }

    }

    public void moverse(int movimiento) {

        this.posicion += movimiento;
    }

    public void retroceder(int movimiento) {

        this.posicion -= movimiento;
    }
    
    //GETTERS & SETTERS

    public int getPosicion() {
        return posicion;
    }

    public int getTiradaInicial() {
        return tiradaInicial;
    }

    public void setTiradaInicial(int tiradaInicial) {
        this.tiradaInicial = tiradaInicial;
    }

    public int getTurnosSinJugar() {
        return turnosSinJugar;
    }

    public void setTurnosSinJugar(int turnosSinJugar) {
        this.turnosSinJugar = turnosSinJugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
    
    //TO STRING con el nombre y la posicion

    @Override
    public String toString() {
        return nombre + ", casilla: " + posicion;
    }

    //METODOS NECESARIOS
    
    
    private boolean sePasa(int tirada, Casilla actual) {

        return actual.getId() + tirada > tablero.getCasillas() - 1;
    }

    private boolean caerEnCasilla(int posicion) {

        //se capta la informacion de la casilla en un objeto de este tipo
        Casilla casilla = tablero.getCasilla(posicion);

        //salta el mensaje de que tipo de casilla es
        casilla.mensaje();

        //vamos a almacenar las acciones de la casilla y a realizarlas
        int turnos = casilla.getTipoDeCasilla().getTurnosSinJugar(); //no almacenamiento

        //los turnos que se queda sin tirar
        this.setTurnosSinJugar(turnos);
        
        //realmente se podria realizar de l siguiente manera, pero por temas de 
        //visibilidad he preferido hacerlo de este modo en vez de :
        //this.setTurnosSinJugar(casilla.getTipoDeCasilla().getTurnosSinJugar());

        //almacenamos los movimientos extra que proporciona la casilla
        int movimiento = casilla.getTipoDeCasilla().getSiguienteMovimiento();

        //indicamops el movimiento
        this.moverse(movimiento);

        //tambien vamosa a devolver si la casilla permite tirar de nuevo
        boolean tira = casilla.getTipoDeCasilla().isTiradaExtra();

        //aqui almacenamos si el jugador gana la partida o no
        this.setWin(casilla.getTipoDeCasilla().isFinalOca());

        //devolvemos la info de si tira o no de nuevo
        return tira;
    }
}
