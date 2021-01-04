/*

 */
package oca;

import java.util.Random;

/**
 *
 * @author aleja
 */
class Jugador {

    private final String NOMBRE;
    private final String APODO;
    private int posicion;//no se si realmente es int, posible cambio

    //Un jugador siempre va a ser parametrizado, ya que vamos a tener que 
    //introducir nuestros datos
    public Jugador(String nombre, String apodo) {
        this.NOMBRE = nombre;
        this.APODO = apodo;
        this.posicion = 0;
    }

    public int tiradaInicial() {

        //vamosa a tener que crear un objeto de tipo random
        Random random = new Random();

        return random.nextInt(7);//devuelve un numero entre 0-6
    }

    public int tirarDados() {

        //vamosa a tener que crear un objeto de tipo random
        Random random = new Random();

        //en el juego real, se tirar un dado de forma que el numero que sale es
        //de forma aleatoria el numero que sale
        return random.nextInt(7);//devuelve un numero entre 0-6
    }

    public void moverse(int movimiento){
        
        this.posicion += movimiento;
    }
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + NOMBRE + ", apodo=" + APODO + ", posicion=" + posicion + '}';
    }
    
    
}
