/*
    En cada casilla vamos a tener diferentes acciones
 */
package oca;

/*

 */
final class Casilla {

    private final boolean SENTENCIA; //para si la casilla teniene una accion o no
    private final int PIERDETURNO;//true pierde turno
    private final boolean VUELVEATIRAR;//true vuelve a tirar
    private final boolean SALTODECASILLA;//true hay salto, false, no
    private final boolean DEPENDEDEJUGADOR;
    private final boolean FINAL;
    

    //la casilla por defecto sera la normal, no tienen SENTENCIA y una vez 
    //movida la ficha, de pierde el turno y tira otrto jugador
    public Casilla() {

        this.SENTENCIA = false;
        this.PIERDETURNO = 1;
        this.VUELVEATIRAR = false;
        this.SALTODECASILLA = false;
        this.DEPENDEDEJUGADOR = false;
        this.FINAL = false;
    }

    //luego, habra casillas que seran diferentes a las demas, por lo tanto,
    //recibiran valores parametrizados
    public Casilla(boolean SENTENCIA, int PIERDETURNO, boolean VUELVEATIRAR, boolean SALTODECASILLA, boolean DEPENDEDEJUGADOR, boolean FINAL) {
        
        this.SENTENCIA = SENTENCIA;
        this.PIERDETURNO = PIERDETURNO;
        this.VUELVEATIRAR = VUELVEATIRAR;
        this.SALTODECASILLA = SALTODECASILLA;
        this.DEPENDEDEJUGADOR = DEPENDEDEJUGADOR;
        this.FINAL = FINAL;
    }

    public boolean getSENTENCIA() {
        
        return this.SENTENCIA;
    }

    public int getPIERDETURNO() {
        
        return this.PIERDETURNO;
    }

    public boolean getVUELVEATIRAR() {
        
        return this.VUELVEATIRAR;
    }

    public boolean getSALTODECASILLA() {
        
        return this.SALTODECASILLA;
    }

    public boolean getDEPENDEDEJUGADOR() {
        
        return DEPENDEDEJUGADOR;
    }

    public boolean getFINAL() {
        
        return this.FINAL;
    }

    @Override
    public String toString() {
        
        return "Casilla {" + "sentencia = " + SENTENCIA + ", pierdeTurno = " + PIERDETURNO + ", vuelveATirar = " + VUELVEATIRAR + '}';
    }
}
