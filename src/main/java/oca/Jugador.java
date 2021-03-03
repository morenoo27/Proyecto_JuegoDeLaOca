/*

 */
package oca;

import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static oca.Juego.tablero;

/**
 *
 * @author aleja
 */
class Jugador {

    private String nombre;
    private int posicion;//no se si realmente es int, posible cambio
    private int tiradaInicial;
    private int turnosSinJugar;
    private boolean win;

    //vamosa a tener que crear un objeto de tipo random
    static Random random = new Random();
    static Scanner tec = new Scanner(System.in);

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
         * de forma aleatoria el numero que sale
         */

        String mensaje = "Te toca tirar " + this.getNombre()
                + "\n Pulsa OK para tirar";

        JOptionPane.showMessageDialog(null, mensaje, "TIRADA JUGADOR", 0, ICONO);
        int tirada = random.nextInt(6) + 1;//genera un num entre 1 y 6

        JOptionPane.showMessageDialog(null, "Has sacado un " + tirada, "TIRADA JUGADOR", 0, TIRADA);

        return tirada;//devuelve un numero entre 1-6
    }

    public void jugarTurno() {

        boolean tiraDeNuevo = false;

        if (this.getTurnosSinJugar() != 0) {

            this.turnosSinJugar--;
            String texto = "Tienes turnos sin jugar aun.\n"
                    + "Te quedan " + this.getTurnosSinJugar() + " turnos sin jugar";
            JOptionPane.showMessageDialog(null, texto, "TIRADA JUGADOR", 0, ESPERA);

        } else {

            do {

                Casilla actual = tablero.getCasilla(this.posicion);

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

                tiraDeNuevo = caerEnCasilla(this.posicion);

            } while (tiraDeNuevo);
        }

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

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
    

    @Override
    public String toString() {
        return nombre + ", casilla: " + posicion;
    }

    private boolean sePasa(int tirada, Casilla actual) {

        return actual.getId() + tirada > tablero.getCasillas() - 1;
    }

    private boolean caerEnCasilla(int posicion) {

        Casilla casilla = tablero.getCasilla(posicion);

        casilla.mensaje();

        //vamos a almacenar las acciones de la casilla y a realizarlas
        int turnos = casilla.getTipoDeCasilla().getTurnosSinJugar(); //no almacenamiento

        this.setTurnosSinJugar(turnos);

        int movimiento = casilla.getTipoDeCasilla().getSiguienteMovimiento();

        this.moverse(movimiento);

        //tambien vamosa a devolver si la casilla permite tirar de nuevo
        boolean tira = casilla.getTipoDeCasilla().isTiradaExtra();

        return tira;
    }
}
