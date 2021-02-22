/*
    En cada casilla vamos a tener diferentes acciones
 */
package oca;

import java.util.ArrayList;

/*

 */
final class Casilla {

    private int id;
    private TiposDeCasillas tipoDeCasilla;
    private ArrayList<Jugador> jugadores;

    public Casilla(int id, TiposDeCasillas casilla) {
        this.id = id;
        this.tipoDeCasilla = casilla;
        this.jugadores = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TiposDeCasillas getTipoDeCasilla() {
        return tipoDeCasilla;
    }

    public void setTipoDeCasilla(TiposDeCasillas casilla) {
        this.tipoDeCasilla = casilla;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    public void addJugador(Jugador jugador){
        
        this.jugadores.add(jugador);
    }
    
    public void removeJugador(Jugador jugador){
        
        this.jugadores.remove(jugador);
    }

    @Override
    public String toString() {
        return id + "\t" + tipoDeCasilla + "\t" + mostraJugadores();
    }

    private String mostraJugadores() {

        String tmp = "|";
        
        if(!this.jugadores.isEmpty()){
            
            for (int i = 0; i < jugadores.size(); i++) {
                
                tmp += " " + this.jugadores.get(i).getApodo();
            }
        }
        
        tmp += " |";
        return tmp;
    }

}
