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
                }
                catch (ParserConfigurationException | SAXException | IOException ex)
                {
                    Logger.getLogger(ControladorJugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case "Regresar" ->
            {
                InicioOpcion objInicioOpcion = new InicioOpcion();
                objInicioOpcion.setSize(850, 450);
                objInicioOpcion.setVisible(true);
                ControladorOpciones objControladorOpciones = new ControladorOpciones(objInicioOpcion, this.objControladorInicio);
                this.objControladorInicio.CambiaPanel(objControladorOpciones.objInicioOpcion);
            }
        }
    }

    public void logIn() throws ParserConfigurationException, SAXException, IOException
    {
        if (objRegistroJugador.logInDatosCorrectos())
        {
            String nombreJugador = objRegistroJugador.txtNombre.getText();
            String correo = objRegistroJugador.txtCorreo.getText();
            String cedula = objRegistroJugador.txtCedula.getText();
            objJugador = new Jugador(nombreJugador, correo, Integer.parseInt(cedula));
            Jugador usuarioActual = objJugadorDAO.registrarJugador(objJugador);

            if (usuarioActual != null)
            {
                objRegistroJugador.setVisible(false);
                JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Bienvenido: " + objJugador.getNombreCompleto());
                objRegistroJugador.setVisible(true);
            } else
            {
                JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "El usuario indicado no existe");
            }
        } else
        {
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Todos lo datos son requeridos");
        }
    }

    public void cerrarVentanaLogin()
    {
        objRegistroJugador.cancelarIniciarSesion();
    }
}
