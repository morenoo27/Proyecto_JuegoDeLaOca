/*
    En cada casilla vamos a tener diferentes acciones
 */
package oca;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*

 */
final class Casilla {

    private int id;
    private TiposDeCasillas tipoDeCasilla;
    
    
    
    //creamos todas las imagenes
    private static final ImageIcon imagenOca = new ImageIcon("src/main/fotos/facherita.jpg");
    private static final ImageIcon imagenPuente = new ImageIcon("src/main/fotos/puente.jpg");
    private static final ImageIcon imagenPosada = new ImageIcon("src/main/fotos/mimir.jpg");
    private static final ImageIcon imagenPozo = new ImageIcon("src/main/fotos/pozo.jpg");
    private static final ImageIcon imagenLaberinto = new ImageIcon("src/main/fotos/laberinto.jpg");
    private static final ImageIcon imagenCarcel = new ImageIcon("src/main/fotos/carcel.jpg");
    private static final ImageIcon imagenDados = new ImageIcon("src/main/fotos/dados.jpg");
    private static final ImageIcon imagenCalavera = new ImageIcon("src/main/fotos/calavera.jpg");
    private static final ImageIcon imagenJardin = new ImageIcon("src/main/fotos/jardin.jpg");
    private static final ImageIcon imagenNormal = new ImageIcon("src/main/fotos/normal.jpg");
    

    public Casilla(int id, TiposDeCasillas casilla) {
        this.id = id;
        this.tipoDeCasilla = casilla;        
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
    
    public void mensaje(){
        
        String titulo = "";
        String mensaje = "";
        ImageIcon ICONO = null;
        
        if (null != this.getTipoDeCasilla()) switch (this.getTipoDeCasilla()) {
            case OCA5:
            case OCA4:
                
                titulo = "¡¡Has caido en una casilla OCA!!";
                mensaje = "¡De oca en oca y tiro por que me toca!";
                ICONO = imagenOca;
                break;
            case PUENTE6:
            case PUENTE12:
                
                titulo = "¡Te has caido del puente!";
                mensaje = "Help me glu glu glu im under the water";
                ICONO = imagenPuente;
                break;
            case POSADA:
                
                titulo = "Has llegado a la posada";
                mensaje = "Has acabado en la posada\n"
                        + "A mimir...";
                ICONO = imagenPosada;
                break;
            case POZO:
                
                titulo = "¡Has caido en el pozo, oh no!";
                mensaje = "No amigoooo, donde te caisteee";
                ICONO = imagenPozo;
                break;
            case DADOS:
                
                titulo = "¡¡DADOS!!";
                mensaje = "¡Pues sumate esta!";
                ICONO = imagenDados;
                break;
            case CARCEL:
                
                titulo = "Has caido en la carcel...";
                mensaje = "Por robar mi corazoncito bb te amo";
                ICONO = imagenCarcel;
                break;
            case CALAVERA:
                
                titulo = "¡¡¡Has caido en la calavera!!!";
                mensaje = "A llorar al parque bb";
                ICONO = imagenCalavera;
                break;
            case LABERINTO:
                
                titulo = "¡Has caido en el laberinto!";
                mensaje = "Estas mas perdio que el barco del arroz hulio";
                ICONO = imagenLaberinto;
                break;
            case JARDIN_OCA:
                
                titulo = "¡¡Has caido en el jardin!!";
                mensaje = "¡¡¡Enhorabuena Jugador!!!\n"
                        + "¡Has llegado primero al Jardin!\n"
                        + "WINNER WINNER CHICKEN DINNER";
                ICONO = imagenJardin;
                break;
            default:
                
                titulo = "Has caido en una casilla normal";
                mensaje = "Na nuevo...";
                ICONO = imagenNormal;
                break;
        }
        
        JOptionPane.showMessageDialog(null, mensaje, titulo, 0, ICONO);
    }

    @Override
    public String toString() {
        return "[ " + id + "\t | " + this.getTipoDeCasilla()+ "\t]";
    }

}
