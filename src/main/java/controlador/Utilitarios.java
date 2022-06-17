package controlador;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public class Utilitarios
{

    public Utilitarios()
    {
    }
    
    /**
     * *
     * Verfica si existe o no el número en la lista.
     *
     * @param numeroBuscado
     * @param listaNumeros
     * @param listaLlenadaUniforme
     * @return Si el número está o no en la lista.
     */
    public static Boolean ExisteNumero(int numeroBuscado, int[] listaNumeros, Boolean listaLlenadaUniforme)
    {
        for (int numero : listaNumeros)
        {
            if(listaLlenadaUniforme && numero == 0)
            {
                return false;
            }
            else if (numero == numeroBuscado)
            {
                return true;
            }
        }

        return false;
    }
    
    /**
     * *
     * Verfica si existe o no el string en la lista.
     *
     * @param stringBuscado
     * @param listaStrings
     * @return
     */
    public static Boolean ExisteString(String stringBuscado, String[] listaStrings, Boolean listaLlenadaUniforme)
    {
        for (String string : listaStrings)
        {
            // Si es vacío quiere decir que el resto de la lista está vacío y no está repetido.
            if(listaLlenadaUniforme && string.equals(""))
            {
                return false;
            }
            // Si coincide es que ya existe.
            else if (string.equals(stringBuscado))
            {
                return true;
            }
        }

        return false;
    }
    
    public static boolean ExisteCedula(String pCedula){
        
         try {
            File file = new File("Jugadores.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
 
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            

            NodeList nodeList = doc.getElementsByTagName("Jugador");

            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);
                if (node.getNodeType()== Node.ELEMENT_NODE) {
                    Element tElement = (Element)node;
                    int o=0;
                    if((tElement.getElementsByTagName("Cedula").item(0).getTextContent()).equals(pCedula)){
                        
                        return false;
                    }
                }
            }return true;
        }
        

        catch (Exception e) {
            System.out.println(e);
        }return true;
    }
}
