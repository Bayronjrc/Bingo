package controlador;

import javax.swing.*;
import java.awt.event.*;
import modelo.*;
import vista.*;
import dao.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public ControladorJugador(RegistroJugador objRegistroJugador, Jugador objJugador, ControladorInicio objControladorInicio)
    {
        this.objRegistroJugador = objRegistroJugador;
        this.objJugador = objJugador;
        this.objJugadorDAO = new JugadorDAOXML();
        this.objControladorInicio = objControladorInicio;
        this.objRegistroJugador.btRegresar.addActionListener(this);
        this.objRegistroJugador.btRegistrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case "Guardar" ->
            {
                try
                {
                    logIn();
                } catch (ParserConfigurationException | SAXException | IOException ex)
                {
                    Logger.getLogger(ControladorJugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case "Regresar" ->
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

    public void logIn() throws ParserConfigurationException, SAXException, IOException
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
                objJugador = new Jugador(strNombre, strCorreo, strCedula);
                JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Jugador " + objJugador.getNombreCompleto() + " registra con éxito.");
                this.objRegistroJugador.txtNombre.setText("");
                this.objRegistroJugador.txtCorreo.setText("");
                this.objRegistroJugador.txtCedula.setText("");
            }
        } else
        {
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Todos lo datos son requeridos", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void cerrarVentanaLogin()
    {
        objRegistroJugador.cancelarIniciarSesion();
    }
}
