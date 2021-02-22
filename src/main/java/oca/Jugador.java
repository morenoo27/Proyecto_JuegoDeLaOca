/*

 */
package oca;

import java.util.Random;

/**
 *
 * @author aleja
 */
class Jugador {

    private String nombre;
    private char apodo;
    private int posicion;//no se si realmente es int, posible cambio
    private int tiradaInicial;

    //vamosa a tener que crear un objeto de tipo random
    static Random random = new Random();

    //Un jugador siempre va a ser parametrizado, ya que vamos a tener que 
    //introducir nuestros datos
    public Jugador(String nombre, char apodo) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.posicion = 0;
        this.tiradaInicial = 0;
    }

    public int tirarDados() {
        //en el juego real, se tirar un dado de forma que el numero que sale es
        //de forma aleatoria el numero que sale
        return random.nextInt(7);//devuelve un numero entre 0-6
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

    @Override
    public String toString() {
        return apodo + ", posicion: " + posicion;
    }
}
