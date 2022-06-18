package dao;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Jugador;
import org.xml.sax.SAXException;

/**
 *
 * @author User
 */
public interface JugadorDAO
{

    abstract Jugador registrarJugador(Jugador pJugador) throws ParserConfigurationException, ParserConfigurationException, ParserConfigurationException, SAXException, IOException;

    abstract ArrayList<Jugador> cargarListaUsuario();

    abstract Jugador buscarJugador(String pCedula);
}
