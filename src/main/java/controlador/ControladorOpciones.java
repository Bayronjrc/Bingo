/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import modelo.*;

/**
 *
 * @author User
 */
public class ControladorOpciones implements ActionListener
{

    public InicioOpcion objInicioOpcion;
    private final ControladorInicio objControladorInicio;

    public ControladorOpciones(InicioOpcion objInicioOpcion, ControladorInicio objControladorInicio)
    {
        this.objInicioOpcion = objInicioOpcion;
        this.objControladorInicio = objControladorInicio;
        
        this.objInicioOpcion.btGenerar.addActionListener(this);
        this.objInicioOpcion.btEnviarCarton.addActionListener(this);
        this.objInicioOpcion.btEstadisticas.addActionListener(this);
        this.objInicioOpcion.btIniciar.addActionListener(this);
        this.objInicioOpcion.btRegistrar.addActionListener(this);
        this.objInicioOpcion.btVerCarton.addActionListener(this);
        this.objInicioOpcion.btSalir.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case "Generar Cartones" ->
            {
            }
            case "Ver Carton" ->
            {
            }
            case "Registrar jugador" ->
                registrarJugador();
            case "Enviar Carton" ->
            {
            }
            case "Estadisticas" ->
            {
            }
            case "Iniciar Juego" ->
            {
            }
            case "Salir" ->
            {
            }
        }
    }

    public void registrarJugador()
    {
        RegistroJugador objRegistroJugador = new RegistroJugador();
        objRegistroJugador.setSize(850, 450);
        objRegistroJugador.setVisible(true);
        Jugador jugador = new Jugador();
        ControladorJugador controladorUsuario = new ControladorJugador(objRegistroJugador, jugador);
        objControladorInicio.CambiaPanel(controladorUsuario.objRegistroJugador);
    }
}
