package dao;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public interface JugadorDAO
{
    abstract void agregarJugador(String pNombre, String pCorreo, String pCedula) throws ParserConfigurationException, ParserConfigurationException, ParserConfigurationException, SAXException, IOException;

    abstract String getNombreCompleto();
    
    abstract String getCorreoElectronico();
    
    abstract String getCedula();
}
