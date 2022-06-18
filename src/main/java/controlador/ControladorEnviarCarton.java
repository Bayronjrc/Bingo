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
 * @author User
 */
public class ControladorEnviarCarton implements ActionListener
{

    public EnviarCarton objEnviarCarton;
    public ControladorInicio objControladorInicio;

    public ControladorEnviarCarton(EnviarCarton objEnviarCarton, ControladorInicio objControladorInicio)
    {
        this.objControladorInicio = objControladorInicio;
        this.objEnviarCarton = objEnviarCarton;
        this.objEnviarCarton.btEnviarCartones.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case "Enviar Cartones Digitales" ->
            {
                try
                {
                    EnviarCarton();
                } catch (MessagingException ex)
                {
                    Logger.getLogger(ControladorEnviarCarton.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public void EnviarCarton() throws MessagingException
    {
        String strCantidad = this.objEnviarCarton.txtCantidad.getText();
        String strCedula = this.objEnviarCarton.txtCedula.getText();

        if (Utilitarios.ValidarEntero(strCantidad, Boolean.TRUE) && !Utilitarios.ExisteCedula(strCedula))
        {
            JugadorDAOXML objJugadorDAOXML = new JugadorDAOXML();
            Jugador objJugador = objJugadorDAOXML.buscarJugador(strCedula);
            
            this.objControladorInicio.objBingo.AsingarCartones(objJugador, Integer.parseInt(strCantidad));
            Utilitarios.EnviarCartonCorreo(Utilitarios.BuscaCorreo(strCedula), objControladorInicio.objBingo.ListaCarton);
            
            this.objControladorInicio.CambiaPanelOpcionesHabilitarBotones();
        }
        else
        {
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Debe ingregar un valor entero positivo, entre 1 y 500.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
