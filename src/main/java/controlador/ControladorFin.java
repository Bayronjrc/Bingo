package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public class ControladorFin implements ActionListener
{

    public Fin objFin;
    public ControladorInicio objControladorInicio;

    /***
     * Constructor
     * @param objFin
     * @param objControladorInicio 
     */
    public ControladorFin(Fin objFin, ControladorInicio objControladorInicio)
    {
        this.objFin = objFin;
        this.objControladorInicio = objControladorInicio;
        this.objFin.btTerminar.addActionListener(this);
    }

    /***
     * Evento de los botones de la interfaz.
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
                finJuego();
            }
        }

    }

    /***
     * Borra la carpeta de catones y redirecciona a la pantalla principal.
     */
    public void finJuego()
    {
        Utilitarios.BorrarCarpeta("Cartones");
        this.objControladorInicio.CambiaPanelOpcionesHabilitarBotones();
    }
}
