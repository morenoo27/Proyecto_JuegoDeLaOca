/*

 */
package oca;

import java.util.Random;
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
        //en el juego real, se tirar un dado de forma que el numero que sale es
        //de forma aleatoria el numero que sale
        return random.nextInt(7);//devuelve un numero entre 0-6
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

            if (caida.getTipoDeCasilla().isSentencia()) {

                //miramos si tenemos que movernos
                if (caida.getTipoDeCasilla().getSiguienteMovimiento() != 0) {

                    if (caida.getTipoDeCasilla().getSiguienteMovimiento() == -12) {
                        System.out.println("Has caido en el laberinto..."
                                + "\nEstas mas perdio que el barco del arro hulio");
                        this.retroceder(12);
                    } else {
                        this.moverse(caida.getTipoDeCasilla().getSiguienteMovimiento());
                    }
                }

                //ahora miramos si perdemos turnos
                if (caida.getTipoDeCasilla().getTurnosSinJugar() != 0) {
                    this.setTurnosSinJugar(caida.getTipoDeCasilla().getTurnosSinJugar());
                }
                
                //ahora miramos si tiramos de nuevo
                tiraDeNuevo = caida.getTipoDeCasilla().isTiradaExtra();
                
            } else {
                System.out.println("Has caido en una casilla normal");
            }
            
            caida.addJugador(this);
        } while (tiraDeNuevo);
    }

    public void moverse(int movimiento) {

        this.posicion += movimiento;
    }

    public void retroceder(int movimiento) {

        this.posicion -= movimiento;
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
        return apodo + ", posicion: " + posicion;
    }

    private boolean sePasa(int tirada, Casilla actual) {

        return actual.getId() + tirada > tablero.getCasillas() - 1;
    }
}
