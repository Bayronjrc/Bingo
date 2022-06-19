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
import javax.swing.JOptionPane;

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
        this.objJuego.btRegresar.addActionListener(this);
        
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
                this.objControladorInicio.CambiaPanelOpcionesHabilitarBotones();
            }
    }
    }
    
    public void cantarNumero() throws IOException, FileNotFoundException, CsvException{
        if(objControladorInicio.objBingo.ObtenerBola()==-1){
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Se acabaron las bolas", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            this.objJuego.txtNumerosCantados.setText(String.valueOf(objControladorInicio.objBingo.ObtenerBola()));
            
        }
    }
    
    
    
    
    
}
