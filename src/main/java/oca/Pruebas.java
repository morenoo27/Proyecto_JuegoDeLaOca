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
public class Pruebas {
    public static void main(String[] args) {
        boolean repetir = true;
        int numero = 0;
        
        do{
            
            System.out.println(numero + "-");
            
            if (numero==4){
                repetir = false;
                
            }
            
            numero++;
        }while(repetir);
    }
}
