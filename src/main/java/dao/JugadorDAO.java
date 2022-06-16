package dao;

import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Jugador;

/**
 *
 * @author User
 */
public interface JugadorDAO {
    
    abstract Jugador registrarJugador(Jugador pJugador)throws ParserConfigurationException, ParserConfigurationException, ParserConfigurationException;
    abstract ArrayList<Jugador> cargarListaUsuario();
    abstract Jugador buscarJugador(int pCedula);
}
