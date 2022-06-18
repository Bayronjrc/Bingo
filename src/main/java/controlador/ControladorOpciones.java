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
            }
            // Salir
            case "0" ->
            {
                String path = System.getProperty("user.dir");
                File file = new File(path + "\\Cartones");
                if (file.exists())
                {
                    try
                    {
                        deleteDirectoryRecursionJava6(file);
                    } catch (IOException ex)
                    {
                        Logger.getLogger(ControladorOpciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
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

    void deleteDirectoryRecursionJava6(File file) throws IOException
    {
        if (file.isDirectory())
        {
            File[] entries = file.listFiles();
            if (entries != null)
            {
                for (File entry : entries)
                {
                    deleteDirectoryRecursionJava6(entry);
                }
            }
        }
        if (!file.delete())
        {
            throw new IOException("Failed to delete " + file);
        }
    }
}
