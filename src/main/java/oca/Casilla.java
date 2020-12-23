/*
    En cada casilla vamos a tener diferentes acciones
 */
package oca;

/*

 */
final class Casilla {

    private boolean sentencia; //para si la casilla teniene una accion o no
    private boolean pierdeTurno;//true pierde turno
    private boolean vuelveATirar;//true vuelve a tirar

    //la casilla por defecto sera la normal, no tienen sentencia y una vez 
    //movida la ficha, de pierde el turno y tira otrto jugador
    public Casilla() {
        
        this.sentencia = false;
        this.pierdeTurno = true;
        this.vuelveATirar = false;
    }

    //luego, habra casillas que seran diferentes a las demas, por lo tanto,
    //recibiran valores parametrizados

    public Casilla(boolean sentencia, boolean pierdeTurno, boolean vuelveATirar) {
        
        this.sentencia = sentencia;
        this.pierdeTurno = pierdeTurno;
        this.vuelveATirar = vuelveATirar;
    }
}
