package dao;

import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
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

    abstract int cantidadUsuarios()throws FileNotFoundException,IOException,CsvException;

    abstract Jugador buscarJugador(String pCedula);
}
