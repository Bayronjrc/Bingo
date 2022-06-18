package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;

/**
 *
 * @author User
 */
public class ControladorJuego implements ActionListener
{
    public Juego objJuego;
    public ControladorInicio objControladorInicio;

    public ControladorJuego(Juego objJuego, ControladorInicio objControladorInicio)
    {
        this.objJuego = objJuego;
        this.objControladorInicio = objControladorInicio;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
}
