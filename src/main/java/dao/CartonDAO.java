package dao;

import modelo.Jugador;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public interface CartonDAO
{

    abstract String getIdentificador();

    abstract void setIdentificador(String identificador);

    abstract Jugador getJugador();

    abstract void setJugador(Jugador objJugador);

    abstract int[] GenerarNumerosCarton();

    abstract int ObtenerNumeroRandom(int rangoInferior, int rangoSuperior, int[] lista);

    abstract String GenerarIdentificadorCarton(String[] listaIdentificadores);

    abstract int[] getListaNumeros();

    abstract void setListaNumeros(int[] ListaNumeros);

    abstract String ObtenerCedulaJugador();

}