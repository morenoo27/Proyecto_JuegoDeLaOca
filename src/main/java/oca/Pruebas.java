/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca;

import static oca.Juego.tablero;

/**
 *
 * @author aleja
 */
public class Pruebas {
    public static void main(String[] args) {
        System.out.println(tablero.getCasilla(tablero.getCasillas() - 1).getId());
        
    }
}
