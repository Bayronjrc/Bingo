package modelo;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @authorBayron Rodriguez
 */
public final class Jugador
{

    private String nombreCompleto;
    private String correoElectronico;
    private String cedula;

    public Jugador(String pNombre, String pCorreo, String pCedula) throws ParserConfigurationException, SAXException, IOException
    {
        this.nombreCompleto = pNombre;
        this.correoElectronico = pCorreo;
        this.cedula = pCedula;
        this.agregarJugador(this.nombreCompleto, this.correoElectronico, this.cedula);
    }
    
    public Jugador(){}

    /**
     * *
     * Guarda el jugador.
     *
     * @param pNombre
     * @param pCorreo
     * @param pCedula
     * @throws ParserConfigurationException
     * @throws ParserConfigurationException
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public void agregarJugador(String pNombre, String pCorreo, String pCedula) throws ParserConfigurationException, ParserConfigurationException, ParserConfigurationException, SAXException, IOException
    {
        try
        {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Elemento raíz
            Document doc = docBuilder.parse("Jugadores.xml");
            doc.getDocumentElement().normalize();

            Node root = doc.getFirstChild();
            Element elemento1 = doc.createElement("Jugador");
            root.appendChild(elemento1);
            Element nombre = doc.createElement("Nombre");
            nombre.setTextContent(pNombre);
            elemento1.appendChild(nombre);

            Element correo = doc.createElement("Correo");
            correo.setTextContent(pCorreo);
            elemento1.appendChild(correo);

            Element Cedula = doc.createElement("Cedula");
            Cedula.setTextContent(pCedula);
            elemento1.appendChild(Cedula);

            //Se escribe el contenido del XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(("Jugadores.xml"));
            transformer.transform(source, result);

            String[] Jugadores =
            {
                pNombre, pCorreo, pCedula
            };

            String archCSV = "Jugadores.csv";
            try ( CSVWriter writer = new CSVWriter(new FileWriter(archCSV, true)))
            {
                writer.writeNext(Jugadores);
            }
        } catch (ParserConfigurationException | TransformerException pce)
        {
        }
    }

    /**
     * *
     * Obtiene el nombre.
     *
     * @return
     */
    public String getNombreCompleto()
    {
        return nombreCompleto;
    }

    /**
     * Obtiene el correo.
     *
     * @return
     */
    public String getCorreoElectronico()
    {
        return correoElectronico;
    }

    /**
     * *
     * Obtiene la cédula.
     *
     * @return
     */
    public String getCedula()
    {
        return cedula;
    }
}
