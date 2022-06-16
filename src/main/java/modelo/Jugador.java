package modelo;

/**
 *
 * @authorBayron Rodriguez
 */
public class Jugador {
    private String nombreCompleto;
    private String correoElectronico;
    private int cedula;

    public Jugador(String pNombre,String pCorreo, int pCedula){
        this.nombreCompleto = pNombre;
        this.correoElectronico = pCorreo;
        this.cedula = pCedula;
    }
    
    public Jugador(){}
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public int getCedula() {
        return cedula;
    }
    
    
}
