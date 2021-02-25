/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author aleja
 */
public class Pruebas {

    
    private static final ImageIcon ICONO = new ImageIcon("src/main/fotos/patata2.jpg");

    private static final JLabel a = new JLabel("<html>"
            + "    <pre>"
            + "             |25| |24| |23| |22| |21| |20| |19| |18|\n"
            + "        |26|      |49| |48| |47| |46| |45| |44|      |17|\n"
            + "        |27| |50|         ________              |43| |16|\n"
            + "        |28| |51|        |        |             |42| |15|\n"
            + "        |29| |52|        |   63  |62| |61| |60| |41| |14|\n"
            + "        |30| |53|        |________|      |59|   |40| |13|\n"
            + "        |31|      |54| |55| |56| |57| |58|      |39| |12|\n"
            + "             |32| |33| |34| |35| |36| |37| |38|      |11|\n"
            + "   | 1| | 2| | 3| | 4| | 5| | 6| | 7| | 8| | 9| |10|"
            + "    </pre>"
            + "</html>");

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, a, "turno", 0, ICONO);
    }
}
  