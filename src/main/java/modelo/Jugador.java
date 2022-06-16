package modelo;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 *
 * @authorBayron Rodriguez
 */
public class Jugador {
    private String nombreCompleto;
    private String correoElectronico;
    private int cedula;

    public Jugador(String pNombre,String pCorreo, int pCedula){
        this.nombreCompleto = pNombre;
        this.correoElectronico = pCorreo;
        this.cedula = pCedula;
    }
    
    public Jugador(){}
    
    public void agregarJugador(String pNombre,String pCorreo, int pCedula) throws ParserConfigurationException, ParserConfigurationException, ParserConfigurationException{
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            //Elemento raíz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Jugadores");
            doc.appendChild(rootElement);
            //Primer elemento
            Element elemento1 = doc.createElement("Jugador");
            rootElement.appendChild(elemento1);
            
            Element nombre = doc.createElement("Nombre");
            nombre.setTextContent(pNombre);
            elemento1.appendChild(nombre);
            
            Element correo = doc.createElement("Correo");
            correo.setTextContent(pCorreo);
            elemento1.appendChild(correo);
            
            Element Cedula = doc.createElement("Cedula");
            Cedula.setTextContent(String.valueOf(pCedula));
            elemento1.appendChild(Cedula);
            
            //Se escribe el contenido del XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Jugadores.xml"));
            transformer.transform(source, result);
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public int getCedula() {
        return cedula;
    }
    
    
}
