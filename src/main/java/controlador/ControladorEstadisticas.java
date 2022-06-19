package controlador;

import javax.swing.UIManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import vista.*;
/**
 *
 * @author User
 */
public class ControladorEstadisticas
{
    public Estadisticas objEstadisticas;
    public ControladorInicio objControladorInicio;
    
    public ControladorEstadisticas(Estadisticas objEstadisticas, ControladorInicio objControladorInicio)
    {
        this.objControladorInicio = objControladorInicio;
        this.objEstadisticas = objEstadisticas;
    }
    
}
