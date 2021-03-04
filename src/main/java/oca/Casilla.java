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

    //GETTERS & SETTERS
    
    
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
    
    //METODO PARA MOSTRAR EL MENSAJE DE LA CASILLA
    
    public void mensaje(){
        
        String titulo = "";
        String mensaje = "";
        ImageIcon ICONO = null;
        
        if (null != this.getTipoDeCasilla()) switch (this.getTipoDeCasilla()) {
            case OCA5:
            case OCA4:
                
                titulo = "¡¡Has caido en una casilla OCA!!";
                mensaje = "¡De oca en oca y tiro por que me toca!\n";
                
                switch(this.getId()){
                    case 5:
                        mensaje += "Saltas a la casilla 9";
                        break;
                    case 9:
                        mensaje += "Saltas a la casilla 14";
                        break;
                    case 14:
                        mensaje += "Saltas a la casilla 18";
                        break;
                    case 18:
                        mensaje += "Saltas a la casilla 23";
                        break;
                    case 23:
                        mensaje += "Saltas a la casilla 27";
                        break;
                    case 27:
                        mensaje += "Saltas a la casilla 32";
                        break;
                    case 32:
                        mensaje += "Saltas a la casilla 36";
                        break;
                    case 36:
                        mensaje += "Saltas a la casilla 41";
                        break;
                    case 41:
                        mensaje += "Saltas a la casilla 45";
                        break;
                    case 45:
                        mensaje += "Saltas a la casilla 50";
                        break;
                    case 50:
                        mensaje += "Saltas a la casilla 54";
                        break;
                    case 54:
                        mensaje += "Saltas a la casilla 59";
                        break;
                    case 59:
                        mensaje += "¡Saltas al Jardin!";
                        break;
                }
                
                ICONO = imagenOca;
                break;
            case PUENTE6:
            case PUENTE12:
                
                titulo = "¡Te has caido del puente!";
                mensaje = "Oh no te ahs caido del puente y\n"
                        + "has llegado a parar en la posada...\n"
                        + "Pierdes un turno";
                ICONO = imagenPuente;
                break;
            case POSADA:
                
                titulo = "Has llegado a la posada";
                mensaje = "Has acabado en la posada, pierdes un turno\n"
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
                mensaje = "¡Te sumas 8!";
                ICONO = imagenDados;
                break;
            case CARCEL:
                
                titulo = "Has caido en la carcel...";
                mensaje = "3 turnos en la carcel";
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
        
        //montamos el mensaje
        JOptionPane.showMessageDialog(null, mensaje, titulo, 0, ICONO);
    }

    //TO STRING (aunque para nuestra ejecucion no hace falta)
    @Override
    public String toString() {
        return "[ " + id + "\t | " + this.getTipoDeCasilla()+ "\t]";
    }

}
