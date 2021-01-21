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

    OCA (true, 0, true, true, false, false),
    PUENTE (true, 1, false, true, false, false),
    POSADA (true, 1, false, false, false, false),
    POZO (true, 1, false, false, true, false),
    LABERINTO (true, 1, false, true, false, false),
    CARCEL (true, 3, false, false, false, false),
    DADOS (true, 1, false, true, false, false),
    CALAVERA (true, 1, false, true, false, false),
    FINAL (true, 1, false, false, false, true);

    private boolean SENTENCIA; //para si la casilla teniene una accion o no
    private int PIERDETURNO;//true pierde turno
    private boolean VUELVEATIRAR;//true vuelve a tirar
    private boolean SALTODECASILLA;//true hay salto, false, no
    private boolean DEPENDEDEJUGADOR;
    private boolean FINALDELJUEGO;
    
    

    private TiposDeCasillas(boolean sentencia, int perdeTurno, boolean vuelveATirar, boolean saltoDeCasilla, boolean dependeDeJugador, boolean finalDelJuego) {

        this.SENTENCIA = sentencia;
        this.PIERDETURNO = perdeTurno;
        this.VUELVEATIRAR = vuelveATirar;
        this.SALTODECASILLA = saltoDeCasilla;
        this.DEPENDEDEJUGADOR = dependeDeJugador;
        this.FINALDELJUEGO = finalDelJuego;
    }
    
    public boolean isSENTENCIA() {
        return SENTENCIA;
    }

    public int getPIERDETURNO() {
        return PIERDETURNO;
    }

    public boolean isVUELVEATIRAR() {
        return VUELVEATIRAR;
    }

    public boolean isSALTODECASILLA() {
        return SALTODECASILLA;
    }

    public boolean isDEPENDEDEJUGADOR() {
        return DEPENDEDEJUGADOR;
    }

    public boolean isFINALDELJUEGO() {
        return FINALDELJUEGO;
    }
}
