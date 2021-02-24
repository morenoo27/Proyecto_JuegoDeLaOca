/*

 */
package oca;

import java.util.Random;
import java.util.Scanner;
import static oca.Juego.tablero;

/**
 *
 * @author aleja
 */
class Jugador {

    private String nombre;
    private char apodo;
    private int posicion;//no se si realmente es int, posible cambio
    private int tiradaInicial;
    private int turnosSinJugar;

    //vamosa a tener que crear un objeto de tipo random
    static Random random = new Random();
    static Scanner tec = new Scanner(System.in);

    //Un jugador siempre va a ser parametrizado, ya que vamos a tener que 
    //introducir nuestros datos
    public Jugador(String nombre, char apodo) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.posicion = 0;
        this.tiradaInicial = 0;
        this.turnosSinJugar = 0;
    }

    public int tirarDados() {
        /**
         * en el juego real, se tirar un dado de forma que el numero que sale es
         * de forma aleatoria el numero que sale
         */

        System.out.println(this.nombre + ",\n"
                + "Pulse ENTER para tirar");
        tec.nextLine();
        int tirada = random.nextInt(6) + 1;//genera un num entre 1 y 6

        System.out.println("Has sacado un " + tirada);
        System.out.println("");//saltamos de linea(tema visual)

        return tirada;//devuelve un numero entre 1-6
    }

    public void jugarTruno() {

        boolean tiraDeNuevo = false;

        do {
            //pillamos la posicion actual(y su casilla correspondiente)
            int posi = this.posicion;

            Casilla actual = tablero.getCasilla(posi);
            actual.removeJugador(this);

            int tirada = this.tirarDados();
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

                this.moverse(tirada);
            }

            //ahora recibimos la casilla en la que caemos y comprobamos si
            //tiene sentencia o es una casilla normal y que pase al siguiente jugador
            Casilla caida = tablero.getCasilla(this.posicion);
            caida.addJugador(this);

            mensajeDeCasilla(caida);
        } while (tiraDeNuevo);
    }

    public void moverse(int movimiento) {

        this.posicion += movimiento;
    }

    public void retroceder(int movimiento) {

        this.posicion -= movimiento;
    }

    public boolean ganarPartida() {

        System.out.println("Felicidades " + this.nombre + ",\n"
                + "¡Has llegado primero al Jardin!\n"
                + "¡¡Winner Winner Chicken Dinner!!");

        return false;
    }

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

    public char getApodo() {
        return apodo;
    }

    public void setApodo(char apodo) {
        this.apodo = apodo;
    }

    @Override
    public String toString() {
        return nombre + ", posicion: " + posicion;
    }

    private boolean sePasa(int tirada, Casilla actual) {

        return actual.getId() + tirada > tablero.getCasillas() - 1;
    }

    private void mensajeDeCasilla(Casilla caida) {

        System.out.println("Has caido en una casilla de tipo " + caida.getTipoDeCasilla().getTipo());
        if (caida.getTipoDeCasilla().getTipo().contains("oca")) {
            System.out.println("¡¡De oca en oca y tiro por que me toca!!");
        } else if (caida.getTipoDeCasilla().getTipo().contains("puente")) {
            System.out.println("¡Te has caido del puente!");
        } else if (caida.getTipoDeCasilla().getTipo().contains("posada")) {
            System.out.println("a mimir...");
        } else if (caida.getTipoDeCasilla().getTipo().contains("laberinto")) {
            System.out.println("Estas mas perdio que el barco del arroz hulio");
        } else if (caida.getTipoDeCasilla().getTipo().contains("dado")) {
            System.out.println("¡¡DE dado a dado y tiro porque me ha tocado!!");
        } else if (caida.getTipoDeCasilla().getTipo().contains("pozo")) {
            System.out.println("EL pozitoooooo");
        } else if (caida.getTipoDeCasilla().getTipo().contains("calavera")) {
            
            System.out.println("VEnga, a llorar al parque");
        }
    }
}
