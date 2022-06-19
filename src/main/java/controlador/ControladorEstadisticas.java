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
     * Evento de los botones de la interfaz.
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
                objControladorInicio.objInicio.setSize(850,450);
                this.objControladorInicio.CambiaPanelOpcionesHabilitarBotones();
                
            }
        }
    }
}