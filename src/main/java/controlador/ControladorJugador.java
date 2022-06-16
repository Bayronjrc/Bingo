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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
/**
 *
 * @author User
 */
public class ControladorJugador implements ActionListener{
    public RegistroJugador vista;
    public JugadorDAO daoJugador;
    public Jugador jugador;

    public ControladorJugador(RegistroJugador pVista, Jugador pJugador) {
        vista = pVista;
        jugador = pJugador;
        daoJugador = new JugadorDAOXML();
        this.vista.btRegitstrar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Guardar" -> {
                try {
                    logIn();
                } catch (ParserConfigurationException | SAXException ex) {
                    Logger.getLogger(ControladorJugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    public void logIn() throws ParserConfigurationException, SAXException {
        if (vista.logInDatosCorrectos() == true) {
            String nombreJugador = vista.txtNombre.getText();
            String correo = vista.txtCorreo.getText();
            String cedula = vista.txtCedula.getText();
            jugador = new Jugador(nombreJugador, correo, Integer.parseInt(cedula));
            Jugador usuarioActual = daoJugador.registrarJugador(jugador);

            if (usuarioActual != null) {
                vista.setVisible(false);
                JOptionPane.showMessageDialog(vista, "Bienvenido: " + jugador.getNombreCompleto());
                vista.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(vista, "El usuario indicado no existe");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Todos lo datos son requeridos");
        }
    }

    public void cerrarVentanaLogin() {
        vista.cancelarIniciarSesion();
    }
    
}
