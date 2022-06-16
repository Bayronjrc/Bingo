package modelo;

/**
 *
 * @author Bayron Rodriguez
 */
public class Carton {
    private int id;
    private int cantidad;
    private String nombre;

    public Carton(int pId, int pCantidad) {
        this.id = pId;
        this.cantidad = pCantidad;
        this.nombre = "ICC"+ String.valueOf(pId);
    }

    public int getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }
}
