package modelo;

/**
 *
 * @author User
 */
public class Correo {
    private int cantidad;
    private int cedula;
    
    public Correo(int pCantidad, int pCedula){
        this.cantidad = pCantidad;
        this.cedula = pCedula;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCedula() {
        return cedula;
    }

  
}
