/*
    En cada casilla vamos a tener diferentes acciones
 */
package oca;

/*

 */
final class Casilla {

    private final boolean SENTENCIA; //para si la casilla teniene una accion o no
    private final boolean PIERDETURNO;//true pierde turno
    private final boolean VUELVEATIRAR;//true vuelve a tirar
    private final boolean FINAL;

    //la casilla por defecto sera la normal, no tienen SENTENCIA y una vez 
    //movida la ficha, de pierde el turno y tira otrto jugador
    public Casilla() {
        
        this.SENTENCIA = false;
        this.PIERDETURNO = true;
        this.VUELVEATIRAR = false;
        this.FINAL = false;
    }

    //luego, habra casillas que seran diferentes a las demas, por lo tanto,
    //recibiran valores parametrizados
    public Casilla(boolean SENTENCIA, boolean PIERDETURNO, boolean VUELVEATIRAR, boolean FINAL) {
        this.SENTENCIA = SENTENCIA;
        this.PIERDETURNO = PIERDETURNO;
        this.VUELVEATIRAR = VUELVEATIRAR;
        this.FINAL = FINAL;
    }

    @Override
    public String toString() {
        return "Casilla {" + "sentencia = " + SENTENCIA + ", pierdeTurno = " + PIERDETURNO + ", vuelveATirar = " + VUELVEATIRAR + '}';
    }
}
