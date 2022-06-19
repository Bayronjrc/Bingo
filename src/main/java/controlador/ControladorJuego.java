package controlador;
import com.opencsv.exceptions.CsvException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import dao.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ControladorJuego implements ActionListener
{
    public Juego objJuego;
    public ControladorInicio objControladorInicio;
    public JugadorDAO objJugadorDAO;

    public ControladorJuego(Juego objJuego, ControladorInicio objControladorInicio)
    {
        this.objJuego = objJuego;
        this.objJugadorDAO = new JugadorDAOXML();
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
            try
            {
                cantarNumero();
            } catch (IOException ex)
            {
                Logger.getLogger(ControladorJuego.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CsvException ex)
            {
                Logger.getLogger(ControladorJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            case "0" ->
            {
                this.objControladorInicio.CambiaPanelOpciones();
            }
    }
    }
    
    public void cantarNumero() throws IOException, FileNotFoundException, CsvException{
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
        this.objJuego.lbJugadores.setText(String.valueOf(objJugadorDAO.cantidadUsuarios()));
    }
    
    
    
    
    
}
