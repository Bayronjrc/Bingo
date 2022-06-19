package dao;

import java.util.ArrayList;
import modelo.Carton;
import modelo.Jugador;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public interface BingoDAO
{

    abstract void GenerarCartones(int cantidadCartones);

    abstract ArrayList<Carton> GenerarCartonesBingo(int cantidadCartones);

    abstract Boolean ValidarCartonGanador(String identificador);

    abstract String validarCartones();

    abstract int ObtenerBola();

    abstract Carton ObtenerCarton(String identificador);

    abstract Boolean AsingarJugador(Jugador objJugador);

    abstract int AsingarCartones(Jugador objJugador, int cantidad);

    abstract ArrayList<Carton> ObtenerCartonesPorJugador(String strCedula);

    abstract int getModoJuego();

    abstract void setModoJuego(int ModoJuego);

    abstract double getMonto();

    abstract void setMonto(double Monto);

    abstract ArrayList<Carton> getListaCarton();
}
