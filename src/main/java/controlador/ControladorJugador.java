/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    public JugadorDAO daoJugador;
    public Jugador jugador;

    public ControladorJugador(RegistroJugador objRegistroJugador, Jugador pJugador)
    {
        this.objRegistroJugador = objRegistroJugador;
        this.jugador = pJugador;
        this.daoJugador = new JugadorDAOXML();
        this.objRegistroJugador.btRegresar.addActionListener(this);
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

        }
    }

    public void logIn() throws ParserConfigurationException, SAXException, IOException
    {
        if (objRegistroJugador.logInDatosCorrectos() == true)
        {
            String nombreJugador = objRegistroJugador.txtNombre.getText();
            String correo = objRegistroJugador.txtCorreo.getText();
            String cedula = objRegistroJugador.txtCedula.getText();
            jugador = new Jugador(nombreJugador, correo, Integer.parseInt(cedula));
            Jugador usuarioActual = daoJugador.registrarJugador(jugador);

            if (usuarioActual != null)
            {
                objRegistroJugador.setVisible(false);
                JOptionPane.showMessageDialog(objRegistroJugador, "Bienvenido: " + jugador.getNombreCompleto());
                objRegistroJugador.setVisible(true);
            } else
            {
                JOptionPane.showMessageDialog(objRegistroJugador, "El usuario indicado no existe");
            }
        } else
        {
            JOptionPane.showMessageDialog(objRegistroJugador, "Todos lo datos son requeridos");
        }
    }

    public void cerrarVentanaLogin()
    {
        objRegistroJugador.cancelarIniciarSesion();
    }
}
