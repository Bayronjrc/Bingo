package controlador;

import javax.swing.JPanel;
import modelo.Bingo;
import vista.*;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public final class ControladorInicio
{

    public Inicio objInicio;
    public Bingo objBingo;

    /**
     * *
     * Constructor
     *
     * @param objInicio
     */
    public ControladorInicio(Inicio objInicio)
    {
        this.objInicio = objInicio;
        this.objBingo = new Bingo();
        CambiaPanelOpciones();
    }

    /**
     * *
     * Cambia el content panel de la vista principal.
     *
     * @param panel
     */
    public void CambiaPanel(JPanel panel)
    {
        this.objInicio.getContentPane().removeAll();
        this.objInicio.setContentPane(panel);
        this.objInicio.getContentPane().revalidate();
        this.objInicio.getContentPane().repaint();
    }

    /**
     * *
     * Establece el panel de opciones con botones desactivados en el content
     * panel.
     */
    public void CambiaPanelOpciones()
    {
        InicioOpcion objInicioOpcion = new InicioOpcion();
        objInicioOpcion.setSize(850, 450);
        objInicioOpcion.setVisible(true);
        ControladorOpciones objControladorOpciones = new ControladorOpciones(objInicioOpcion, this);
        CambiaPanel(objControladorOpciones.objInicioOpcion);
    }

    /**
     * *
     * Establece el panel de opciones con botones habilitados en el content
     * panel.
     */
    public void CambiaPanelOpcionesHabilitarBotones()
    {
        InicioOpcion objInicioOpcion = new InicioOpcion();
        objInicioOpcion.setSize(850, 450);
        objInicioOpcion.setVisible(true);
        ControladorOpciones objControladorOpciones = new ControladorOpciones(objInicioOpcion, this);
        objControladorOpciones.objInicioOpcion.btIniciar.setEnabled(true);
        objControladorOpciones.objInicioOpcion.btEnviarCarton.setEnabled(true);
        objControladorOpciones.objInicioOpcion.btVerCarton.setEnabled(true);
        objControladorOpciones.objInicioOpcion.btEstadisticas.setEnabled(true);
        objControladorOpciones.objInicioOpcion.btGenerar.setEnabled(false);
        CambiaPanel(objControladorOpciones.objInicioOpcion);
    }
}