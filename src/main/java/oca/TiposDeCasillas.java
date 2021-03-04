/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca;

/**
 *
 * @author aleja
 */
public enum TiposDeCasillas {

    /**
     * Aqui vamos a crear la info de cada una de las casillas: 
     *      ·Oca: Casillas 5,9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54 y 59. 
     * The mitical "De oca a oca y tiro porque me toca" 
     *      ·Puente: Casilla 6 y 12. Se va a la posada.
     *      ·Posada: Casilla 19. Si se cae en esta casilla se pierde un turno. 
     *      ·Pozo: Casilla 31. Si se cae en esta casilla, NO se puede volver a 
     * jugar hasta que no pase otro jugador por esa casilla. Por estadistica en 
     * 100 turnos se ha debido o bien terminar el juego o haber pasado un
     * jugador por el pozo
     *      ·Laberinto: Casilla 42. Si se cae en esta casilla, se está obligado 
     * a retroceder a la casilla 30.
     *      ·Cárcel: Casilla 56. Si se cae en esta casilla, hay que permanecer 
     * dos turnos sin jugar. ·Dados: Casillas 26 y 53. Si se cae en estas 
     * casillas, se suma la marcación de la casilla de los dados (26 o 53) y se 
     * avanza tanto como resulte (8).
     *      ·Calavera: Casilla 58. Si se cae en esta casilla, hay que volver a 
     * la Casilla 1.
     *      ·Entrar al Jardín de la Oca: Es necesario sacar los puntos justos 
     * para entrar, en caso de exceso se retroceden tantas casillas como puntos
     * sobrantes.
     */
    
    NORMAL("Normal", 0, 0, false, false),
    OCA4("Oca 4", 0, 4, true, false),
    OCA5("Oca 5", 0, 5, true, false),
    PUENTE6("Puente", 0, 13, false, false),
    PUENTE12("Puente", 0, 7, false, false),
    POSADA("Posada", 1, 0, false, false),
    POZO("Pozo negro", 100, 0, false, false),
    LABERINTO("Laberinto", 0, -12, false, false),
    CARCEL("Cárcel", 2, 0, false, false),
    DADOS("Dados 26", 0, 8, false, false),
    CALAVERA("Calavera", 0, -57, false, false),
    JARDIN_OCA("Jardín", 0, 0, false, true);

    private final String tipo; // Oca, Puente, etc
    private final int turnosSinJugar; // Número de turnos sin jugar
    private final int siguienteMovimiento; // 0 no hago nada, +3 avanza 3
    private final boolean tiradaExtra; // Si se cae en esta casilla se tira otra vez
    private final boolean finalOca; // si tiene true, acaba el juego

    private TiposDeCasillas(String tipo, int turnosSinJugar, int siguienteMovimiento, boolean tiradaExtra, boolean finalOca) {
        this.tipo = tipo;
        this.turnosSinJugar = turnosSinJugar;
        this.siguienteMovimiento = siguienteMovimiento;
        this.tiradaExtra = tiradaExtra;
        this.finalOca = finalOca;
    }

    //GETETRS
    
    
    public String getTipo() {
        return tipo;
    }

    public int getTurnosSinJugar() {
        return turnosSinJugar;
    }

    public int getSiguienteMovimiento() {
        return siguienteMovimiento;
    }

    public boolean isTiradaExtra() {
        return tiradaExtra;
    }

    public boolean isFinalOca() {
        return finalOca;
    }
}
