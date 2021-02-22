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

    NORMAL("Normal", 0, 0, false, false),
    OCA4("Oca 4", 0, 4, true, true),
    OCA5("Oca 5", 0, 5, true, true),
    PUENTE6("Puente", 0, 13, false, true),
    PUENTE12("Puente", 0, 7, false, true),
    POSADA("Posada", 1, 0, false, true),
    POZO("Pozo negro", 100, 0, false, true),
    LABERINTO("Laberinto", 0, -12, false, true),
    CARCEL("Cárcel", 2, 0, false, true),
    DADOS26("Dados 26", 0, 26, false, true),
    DADOS53("Dados 53", 0, 53, false, true),
    CALAVERA("Calavera", 0, -57, false, true),
    JARDIN_OCA("Jardín", 0, 0, false, true);

    private final String tipo; // Oca, Puente, etc
    private final int turnosSinJugar; // Número de turnos sin jugar
    private final int siguienteMovimiento; // 0 no hago nada, +3 avanza 3
    private final boolean tiradaExtra; // Si se cae en esta casilla se tira otra vez
    private final boolean sentencia;

    private TiposDeCasillas(String tipo, int turnosSinJugar, int siguienteMovimiento, boolean tiradaExtra, boolean sentencia) {
        this.tipo = tipo;
        this.turnosSinJugar = turnosSinJugar;
        this.siguienteMovimiento = siguienteMovimiento;
        this.tiradaExtra = tiradaExtra;
        this.sentencia = sentencia;
    }

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

    public boolean isSentencia() {
        return sentencia;
    }
}
