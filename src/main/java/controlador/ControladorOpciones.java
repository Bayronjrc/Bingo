/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import vista.*;
import modelo.*;
import org.jfree.data.general.DefaultPieDataset;

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
            // Iniciar Juego
            case "1" ->
            {
                iniciarJuego();
            }
            // Registrar jugador
            case "2" ->
            {
                registrarJugador();
            }
            // Enviar Cartón
            case "3" ->
            {
                enviarCartones();
            }
            // Generar Cartones
            case "4" ->
            {
                generarCartones();
            }
            // Ver Carton
            case "5" ->
            {
                consultarCartones();
            }
            // Estadisticas
            case "6" ->
            {
                estadisticas();
            }
            // Salir
            case "0" ->
            {
                Utilitarios.BorrarCarpeta("Cartones");
                System.exit(0);
            }
        }
    }

    public void iniciarJuego()
    {
        IniciarJuego objIniciarJuego = new IniciarJuego();
        objIniciarJuego.setSize(850,450);
        ControladorIniciarJuego controladorIniciarJuego = new ControladorIniciarJuego(objIniciarJuego,objControladorInicio);
        objControladorInicio.CambiaPanel(controladorIniciarJuego.objIniciarJuego);
    }
    
    public void registrarJugador()
    {
        RegistroJugador objRegistroJugador = new RegistroJugador();
        objRegistroJugador.setSize(850, 450);
        Jugador jugador = new Jugador();
        ControladorJugador controladorUsuario = new ControladorJugador(objRegistroJugador, jugador, objControladorInicio);
        objControladorInicio.CambiaPanel(controladorUsuario.objRegistroJugador);
    }

    public void enviarCartones()
    {
        EnviarCarton objEnviarCarton = new EnviarCarton();
        objEnviarCarton.setSize(850, 450);
        ControladorEnviarCarton controladorEnviarCarton = new ControladorEnviarCarton(objEnviarCarton, objControladorInicio);
        objControladorInicio.CambiaPanel(controladorEnviarCarton.objEnviarCarton);
    }

    public void generarCartones()
    {
        GenerarCartones objGenerarCartones = new GenerarCartones();
        objGenerarCartones.setSize(850, 450);
        ControladorGenerarCartones objControladorGenerarCartones = new ControladorGenerarCartones(objGenerarCartones, objControladorInicio);
        objControladorInicio.CambiaPanel(objControladorGenerarCartones.objGenerarCartones);
    }
    
    public void consultarCartones()
    {
        ConsultarCarton objConsultarCarton = new ConsultarCarton();
        objConsultarCarton.setSize(850, 450);
        ControladorConsultarCartones objControladorConsultarCartones = new ControladorConsultarCartones(objConsultarCarton, objControladorInicio);
        objControladorInicio.CambiaPanel(objControladorConsultarCartones.objConsultarCartones);
    }
    
    public void estadisticas()
    {
        Estadisticas objEstadisticas = new Estadisticas();
        objEstadisticas.setSize(850, 850);
        ControladorEstadisticas objControladorEstadisticas = new ControladorEstadisticas(objEstadisticas, objControladorInicio);
       
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Value 1", 10);
        dataset.setValue("Value 2", 20);
        dataset.setValue("Value 3", 30);
        dataset.setValue("Value 4", 40);
        JFreeChart chart = ChartFactory.createPieChart("Your title", dataset, true, true, true);
        ChartFrame ff = new ChartFrame("Your title", chart);
        objEstadisticas.pnlCircularHistorica.add(ff);
  
        objControladorInicio.CambiaPanel(objControladorEstadisticas.objEstadisticas);
    }

    
}
