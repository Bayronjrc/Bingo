package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import vista.*;
/**
 *
 * @author User
 */
public class ControladorEstadisticas implements ActionListener
{
    public Estadisticas objEstadisticas;
    public ControladorInicio objControladorInicio;
    
    public ControladorEstadisticas(Estadisticas objEstadisticas, ControladorInicio objControladorInicio)
    {
        this.objControladorInicio = objControladorInicio;
        this.objEstadisticas = objEstadisticas;
        this.objEstadisticas.btRegresar1.addActionListener(this);
    }

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
