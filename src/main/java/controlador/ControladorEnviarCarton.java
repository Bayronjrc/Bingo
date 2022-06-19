package controlador;

import dao.*;
import javax.swing.*;
import java.awt.event.*;
import vista.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import modelo.Jugador;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public class ControladorEnviarCarton implements ActionListener
{

    public EnviarCarton objEnviarCarton;
    public ControladorInicio objControladorInicio;

    /**
     * *
     * Constructor
     *
     * @param objEnviarCarton
     * @param objControladorInicio
     */
    public ControladorEnviarCarton(EnviarCarton objEnviarCarton, ControladorInicio objControladorInicio)
    {
        this.objControladorInicio = objControladorInicio;
        this.objEnviarCarton = objEnviarCarton;
        this.objEnviarCarton.btEnviarCartones.addActionListener(this);
        this.objEnviarCarton.btRegresar.addActionListener(this);
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
            // Enviar Cartones Digitales
            case "1" ->
            {
                try
                {
                    EnviarCarton();
                } catch (MessagingException ex)
                {
                    Logger.getLogger(ControladorEnviarCarton.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // Regresar
            case "0" ->
            {
                this.objControladorInicio.CambiaPanelOpcionesHabilitarBotones();
            }
        }

    }

    /**
     * *
     * Envía los cartones indicados al jugador indicado.
     *
     * @throws MessagingException
     */
    public void EnviarCarton() throws MessagingException
    {
        String strCantidad = this.objEnviarCarton.txtCantidad.getText();
        String strCedula = this.objEnviarCarton.txtCedula.getText();

        if (!Utilitarios.ValidarEntero(strCantidad, Boolean.TRUE))
        {
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Debe ingregar un valor entero positivo de 9 dígitos.", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else if (!Utilitarios.ExisteCedula(strCedula) && (strCedula.length() > 9 || strCedula.length() < 1))
        {
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "La cédula no existe.", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else
        {
            JugadorDAOXML objJugadorDAOXML = new JugadorDAOXML();
            Jugador objJugador = objJugadorDAOXML.buscarJugador(strCedula);

            int respuesta = this.objControladorInicio.objBingo.AsingarCartones(objJugador, Integer.parseInt(strCantidad));
            Utilitarios.EnviarCartonCorreo(Utilitarios.BuscaCorreo(strCedula), objControladorInicio.objBingo.ObtenerCartonesPorJugador(strCedula), "Bingo", "Saludos " + objJugador.getNombreCompleto() + ", \n\n Adjunto encontrará las imágenes del bingo con los cartones que usted solicitó.\n\n Muchos éxitos!");

            if (respuesta == -1)
            {
                JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Ya no quedan cartones disponibles", "Error", JOptionPane.INFORMATION_MESSAGE);
            } else
            {
                JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Se enviaron " + respuesta + " cartón(es) al correo del jugador.", "", JOptionPane.INFORMATION_MESSAGE);
            }

            objEnviarCarton.txtCantidad.setText("");
            objEnviarCarton.txtCedula.setText("");
        }
    }
}
