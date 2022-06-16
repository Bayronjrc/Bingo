package dao;

import java.util.ArrayList;
import modelo.Jugador;

/**
 *
 * @author User
 */
public interface JugadorDAO {
    
    abstract Jugador registrarJugador(Jugador pJugador);
    abstract ArrayList<Jugador> cargarListaUsuario();
    abstract Jugador buscarJugador(int pCedula);
}
