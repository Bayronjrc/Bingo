package dao;

import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.IOException;
import modelo.Jugador;

/**
 *
 * @author User
 */
public interface JugadorDAO
{
    abstract int cantidadUsuarios()throws FileNotFoundException,IOException,CsvException;

    abstract Jugador buscarJugador(String pCedula);
}
