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
        this.objJuego.btCantarNumero.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            // cantar Numero
            case "1" ->
            {
                cantarNumero();
            }
    }
    }
    
    public void cantarNumero(){
        this.objJuego.lbPremio.setText(String.valueOf(this.objControladorInicio.objBingo.getMonto()));
        switch(String.valueOf(this.objControladorInicio.objBingo.getModoJuego())){
            case "1"->{
                this.objJuego.lbTipoJuego.setText("Juego en X");
            }
            case "2"->{
                this.objJuego.lbTipoJuego.setText("Cuatro Esquinas");
            }
            case "3"->{
                this.objJuego.lbTipoJuego.setText("Cartón Lleno");
            }
            case "4"->{
                this.objJuego.lbTipoJuego.setText("Juego en Z");
            }
        }
        this.objJuego.lbCartones.setText(String.valueOf(this.objControladorInicio.objBingo.getListaCarton().size()));
        this.objJuego.lbJugadores.setText("");
    }
    
    
    
    
    
}
