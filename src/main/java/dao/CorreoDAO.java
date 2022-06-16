package dao;

import modelo.Correo;

/**
 *
 * @author User
 */
public interface CorreoDAO {
    
    abstract void enviarCorreo(Correo pCorreo);
}
