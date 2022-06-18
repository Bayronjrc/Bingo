package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;

/**
 *
 * @author Bayron Rodriguez
 */
public class ControladorIniciarJuego implements ActionListener
{
    public IniciarJuego objIniciarJuego;
    public ControladorInicio objControladorInicio;
    
    public ControladorIniciarJuego(IniciarJuego objIniciarJuego, ControladorInicio objControladorInicio)
    {
        this.objControladorInicio = objControladorInicio;
        this.objIniciarJuego = objIniciarJuego;
        this.objIniciarJuego.btInciar.addActionListener(this);
        this.objIniciarJuego.btRegresar1.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            // Iniciar
            case "1" ->
            {
                
                IniciarJuego();
                
                
            }
            // Regresar
            case "0" ->
            {
                this.objControladorInicio.CambiaPanelOpciones();
            }
        }
    }
    
    public void IniciarJuego()
    {
        int Tipo = objIniciarJuego.jComboBox1.getSelectedIndex();
        String premio = objIniciarJuego.jTextField1.getText();
        
    }
    
}
