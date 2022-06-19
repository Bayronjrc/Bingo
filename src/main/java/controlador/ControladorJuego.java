package controlador;
import com.opencsv.exceptions.CsvException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import dao.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
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
    public JugadorDAO objJugadorDAO;

    public ControladorJuego(Juego objJuego, ControladorInicio objControladorInicio)
    {
        this.objJuego = objJuego;
        this.objJugadorDAO = new JugadorDAOXML();
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

    public void cantarNumero() throws IOException, FileNotFoundException, CsvException
    {
        this.objJuego.btCantarNumero.setEnabled(true);
        String carton = this.objControladorInicio.objBingo.validarCartones();
        int bola = objControladorInicio.objBingo.ObtenerBola();
        if (bola == -1)
        {
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Se acabaron las bolas", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else
        {
            this.objJuego.txtNumerosCantados.setText(this.objJuego.txtNumerosCantados.getText() + ", " + String.valueOf(bola));
            if (carton.equals(""))
            {

            } else
            {
                System.out.println(Arrays.toString(this.objControladorInicio.objBingo.ListaBolas));
                JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Carton Ganador" + carton, "Felicidades", JOptionPane.INFORMATION_MESSAGE);
                Fin objFin = new Fin();
                objFin.setSize(850, 450);
                ControladorFin controladorFin = new ControladorFin(objFin, objControladorInicio);
                
                objFin.lblPremio.setText(String.valueOf(this.objControladorInicio.objBingo.getMonto()));
                switch (String.valueOf(this.objControladorInicio.objBingo.getModoJuego()))
                {
                    case "1" ->
                    {
                        objFin.lblTipoJuego.setText("Juego en X");
                    }
                    case "2" ->
                    {
                        objFin.lblTipoJuego.setText("Cuatro Esquinas");
                    }
                    case "3" ->
                    {
                        objFin.lblTipoJuego.setText("Cartón Lleno");
                    }
                    case "4" ->
                    {
                        objFin.lblTipoJuego.setText("Juego en Z");
                    }
                }
                
                objFin.lblGanadores.setText(carton);
                objControladorInicio.CambiaPanel(controladorFin.objFin);
                
            }

        }
        
    }


}
