package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public class ControladorEstadisticas implements ActionListener
{

    public Estadisticas objEstadisticas;
    public ControladorInicio objControladorInicio;

    /**
     * *
     * Constructor
     *
     * @param objEstadisticas
     * @param objControladorInicio
     */
    public ControladorEstadisticas(Estadisticas objEstadisticas, ControladorInicio objControladorInicio)
    {
        this.objControladorInicio = objControladorInicio;
        this.objEstadisticas = objEstadisticas;
        this.objEstadisticas.btRegresar1.addActionListener(this);
    }

    /**
     * *
     * Cambia el content panel de la vista principal.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            // Iniciar Juego
            case "0" ->
            {
                this.objControladorInicio.CambiaPanelOpcionesHabilitarBotones();
            }
        }
    }
}