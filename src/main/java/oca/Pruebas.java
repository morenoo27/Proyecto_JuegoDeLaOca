/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca;

import javax.swing.JOptionPane;
import static oca.Juego.tablero;

/**
 *
 * @author aleja
 */
public class Pruebas {

    static Tablero tablero = new Tablero();//

    public static void main(String[] args) {

//        //vamos a tener aqui un jugador predeterminado para realizar pruebas de
//        //que el funcionamiento de las casillas es valido 
//        Jugador prueba = new Jugador("alejandro", 'm');
//
//        boolean fin = true;
//        int t = 1;
//        do {
//
//            prueba.jugarTruno();
//
//            
//
//            if (prueba.getPosicion() == tablero.getCasillas() - 1) {
//                fin = prueba.ganarPartida();
//            }
//
//        } while (fin);
        
        
        JOptionPane.showMessageDialog(null, tablero, "Turno", 0);
    }
}
