/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import controlador.Utilitarios;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Jugador;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author User
 */
public class JugadorDAOXML implements JugadorDAO
{

    @Override
    public Jugador registrarJugador(Jugador pJugador) throws ParserConfigurationException, ParserConfigurationException, ParserConfigurationException, SAXException, IOException
    {
        if (!Utilitarios.ExisteCedula(pJugador.getCedula()))
        {
            Jugador nuevoJugador = new Jugador();
            nuevoJugador.agregarJugador(pJugador.getNombreCompleto(), pJugador.getCorreoElectronico(), pJugador.getCedula());
            return nuevoJugador;
        } else
        {
            return null;
        }
    }

   

    @Override
    public Jugador buscarJugador(String pCedula)
    {
        try
        {
            File file = new File("Jugadores.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Jugador");

            for (int i = 0; i < nodeList.getLength(); ++i)
            {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element tElement = (Element) node;

                    if ((tElement.getElementsByTagName("Cedula").item(0).getTextContent()).equals(pCedula))
                    {
                        String nombre = tElement.getElementsByTagName("Nombre").item(0).getTextContent();
                        String cedula = tElement.getElementsByTagName("Cedula").item(0).getTextContent();
                        String correo = tElement.getElementsByTagName("Correo").item(0).getTextContent();
                        Jugador objJugador = new Jugador(nombre,correo,Integer.parseInt(cedula));
                        return objJugador;
                    }
                }
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e)
        {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public int cantidadUsuarios() throws FileNotFoundException,IOException,CsvException
    {
        String file = "Jugadores.csv";
        CSVReader csvReader = new CSVReader(new FileReader(file));
        ArrayList<String[]> datos = (ArrayList<String[]>) csvReader.readAll();
        int cantidad = datos.size();
        System.out.println(String.valueOf(cantidad));
        return cantidad;
    }
        

}
