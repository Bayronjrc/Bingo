package controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Carton;
import modelo.Correo;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
            if (listaLlenadaUniforme && numero == 0)
            {
                return false;
            } else if (numero == numeroBuscado)
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
     * @param listaLlenadaUniforme
     * @return
     */
    public static Boolean ExisteString(String stringBuscado, String[] listaStrings, Boolean listaLlenadaUniforme)
    {
        for (String string : listaStrings)
        {
            // Si es vacío quiere decir que el resto de la lista está vacío y no está repetido.
            if (listaLlenadaUniforme && string.equals(""))
            {
                return false;
            } // Si coincide es que ya existe.
            else if (string.equals(stringBuscado))
            {
                return true;
            }
        }

        return false;
    }

    /**
     * *
     * Verfica si existe o no la cedula en la lista de jugadores.
     *
     * @param pCedula
     * @return
     */
    public static boolean ExisteCedula(String pCedula)
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

                        return true;
                    }
                }
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e)
        {
            System.out.println(e);
        }
        return false;
    }

    /**
     * *
     * Verfica si existe o no la cedula en la lista de jugadores y retorna el
     * correo.
     *
     * @param pCedula
     * @return
     */
    public static String BuscaCorreo(String pCedula)
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
                        String correo = tElement.getElementsByTagName("Correo").item(0).getTextContent();
                        return correo;
                    }
                }
            }
            return "";
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e)
        {
            System.out.println(e);
        }
        return "";
    }

    /**
     * *
     * Validar que el valor ingresados ea entero y en el rango solicitado.
     *
     * @param strCantidad
     * @param validarRango
     * @return
     */
    public static Boolean ValidarEntero(String strCantidad, Boolean validarRango)
    {
        try
        {
            // Convierte a entero,
            int cantidad = Integer.parseInt(strCantidad);

            // Si se validad el rango.
            if (validarRango)
            {
                return !(cantidad > 500 || cantidad < 1);
            } else
            {
                return true;
            }
        } catch (NumberFormatException e)
        {
            return false;
        }
    }

    /**
     * *
     * Función que envía correos.
     *
     * @param pPara
     * @param listaCartones
     * @return 
     * @throws javax.mail.internet.AddressException
     */
    public static Boolean EnviarCartonCorreo(String pPara, ArrayList<Carton> listaCartones,String pAsunto,String pMensaje) throws AddressException, MessagingException
    {
        

        try
        {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "25");
            props.setProperty("mail.smtp.user", Correo.DE);

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(pMensaje);

            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(texto);
            
            for(Carton objCarton: listaCartones)
            {
                BodyPart archivos = new MimeBodyPart();
                String path = System.getProperty("user.dir");
                File file = new File(path + "\\Cartones");
                
                if(file.exists())
                {
                    archivos.setDataHandler(new DataHandler(new FileDataSource(path + "\\Cartones\\" + objCarton.getIdentificador() + ".png")));
                    archivos.setFileName(objCarton.getIdentificador() + ".png");
                }
                
                multipart.addBodyPart(archivos);
            }

            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(Correo.DE));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(pPara));
            mensaje.setSubject(pAsunto);
            mensaje.setContent(multipart);

//            Transport objTransport = session.getTransport("smtp");
//            objTransport.connect(Correo.DE, Correo.CONTRASENA);
//            objTransport.sendMessage(mensaje, mensaje.getAllRecipients());
//            objTransport.close();
            
            return true;
        }
        catch (MessagingException e)
        {
        }
        return false;
    }
}
