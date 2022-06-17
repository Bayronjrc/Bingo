/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import vista.*;
import modelo.*;

/**
 *
 * @author User
 */
public class ControladorInicio implements ActionListener{
    public Inicio vista;
    
    public ControladorInicio(Inicio pVista){
        vista = pVista;
        this.vista.btGenerar.addActionListener(this);
        this.vista.btEnviarCarton.addActionListener(this);
        this.vista.btEstadisticas.addActionListener(this);
        this.vista.btIniciar.addActionListener(this);
        this.vista.btRegistrar.addActionListener(this);
        this.vista.btVerCarton.addActionListener(this);
        this.vista.jButton9.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Generar Cartones" -> {
            }
            case "Ver Carton" -> {
            }
            case "Registrar" -> registrarJugador();
            case "Enviar Carton" -> {
            }
            case "Estadisticas" -> {
            }
            case "Iniciar Juego" -> {
            }
            case "Salir" -> {
            }
        }
    }
    
    public void registrarJugador(){
        RegistroJugador vista = new RegistroJugador();
        Jugador jugador = new Jugador();
        ControladorJugador controladorUsuario = new ControladorJugador(vista, jugador);
        cambiaPanel(vista);
        controladorUsuario.vista.setVisible(true); 
    }
    
    public void cambiaPanel(JPanel panel){
        this.vista.jPanel1.removeAll();
        this.vista.jPanel1.add(panel);
        this.vista.jPanel1.repaint();
        this.vista.jPanel1.revalidate();
    }
}
