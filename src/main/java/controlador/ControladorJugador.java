package controlador;

import javax.swing.*;
import java.awt.event.*;
import modelo.*;
import vista.*;
import dao.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public class ControladorJugador implements ActionListener
{

    public RegistroJugador objRegistroJugador;
    public JugadorDAO objJugadorDAO;
    public Jugador objJugador;
    public ControladorInicio objControladorInicio;

    /**
     * *
     * Constructor
     *
     * @param objRegistroJugador
     * @param objJugador
     * @param objControladorInicio
     */
    public ControladorJugador(RegistroJugador objRegistroJugador, Jugador objJugador, ControladorInicio objControladorInicio)
    {
        this.objRegistroJugador = objRegistroJugador;
        this.objJugador = objJugador;
        this.objJugadorDAO = new JugadorDAOXML();
        this.objControladorInicio = objControladorInicio;
        this.objRegistroJugador.btRegresar.addActionListener(this);
        this.objRegistroJugador.btRegistrar.addActionListener(this);
    }

    /**
     * *
     * Evento de los botones de la interfaz.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            // Guardar.
            case "1" ->
            {
                try
                {
                    ValidarRegistrarJugador();
                } catch (ParserConfigurationException | SAXException | IOException ex)
                {
                    Logger.getLogger(ControladorJugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // Regresar.
            case "0" ->
            {
                if (this.objControladorInicio.objBingo.getListaCarton() == null)
                {
                    this.objControladorInicio.CambiaPanelOpciones();
                } else
                {
                    this.objControladorInicio.CambiaPanelOpcionesHabilitarBotones();
                }
            }
        }
    }

    /**
     * *
     * Valida y registra los datos para un nuevo jugador.
     *
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public void ValidarRegistrarJugador() throws ParserConfigurationException, SAXException, IOException
    {
        if (objRegistroJugador.logInDatosCorrectos())
        {
            String strNombre = objRegistroJugador.txtNombre.getText();
            String strCorreo = objRegistroJugador.txtCorreo.getText();
            String strCedula = objRegistroJugador.txtCedula.getText();

            if (Utilitarios.ExisteCedula(strCedula) || strCedula.length() > 9 || strCedula.length() < 1)
            {
                JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "La cédula debe ser un número entero de 9 dígitos", "Error", JOptionPane.INFORMATION_MESSAGE);
            } else
            {
                this.objRegistroJugador.txtNombre.setText("");
                this.objRegistroJugador.txtCorreo.setText("");
                this.objRegistroJugador.txtCedula.setText("");

                objJugador = new Jugador(strNombre, strCorreo, strCedula);
                JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Jugador " + objJugador.getNombreCompleto() + " registra con éxito.");
            }
        } else
        {
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Todos lo datos son requeridos", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}