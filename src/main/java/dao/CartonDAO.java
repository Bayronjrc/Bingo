package dao;

import modelo.Carton;

/**
 *
 * @author User
 */
public interface CartonDAO {
    
    abstract Carton crearCarton(int pCantidad);
    abstract void verCarton(String pIdentificacion);
}
