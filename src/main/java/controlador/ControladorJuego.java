package controlador;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import modelo.Carton;
import org.xml.sax.SAXException;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public class ControladorJuego implements ActionListener
{

    public Juego objJuego;
    public ControladorInicio objControladorInicio;

    /**
     * *
     * Constructor
     *
     * @param objJuego
     * @param objControladorInicio
     */
    public ControladorJuego(Juego objJuego, ControladorInicio objControladorInicio)
    {
        this.objJuego = objJuego;
        this.objControladorInicio = objControladorInicio;
        this.objJuego.btCantarNumero.addActionListener(this);
        this.objJuego.btRegresar.addActionListener(this);
    }

    /**
     * *
     * Evento de los botones de la interfaz.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            // Cantar número
            case "1" ->
            {
                try
                {
                    ObtenerBolaValidarGanador();
                } catch (IOException | CsvException | MessagingException | SAXException ex)
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

    /**
     * *
     * Muestra las botas en las interfaz y valida si ya ganó algún cartón.
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws CsvException
     * @throws MessagingException
     * @throws org.xml.sax.SAXException
     */
    public void ObtenerBolaValidarGanador() throws IOException, FileNotFoundException, CsvException, MessagingException, SAXException
    {
        this.objJuego.btCantarNumero.setEnabled(true);
        int bola = objControladorInicio.objBingo.ObtenerBola();
        String cartonGanador = this.objControladorInicio.objBingo.validarCartones();

        if (bola == -1)
        {
            System.out.println(Arrays.toString(this.objControladorInicio.objBingo.ListaBolas));
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Se acabaron las bolas", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else
        {
            String bolas = this.objJuego.txtNumerosCantados.getText() + ", " + String.valueOf(bola);
            this.objJuego.txtNumerosCantados.setText(bolas + (bolas.length() % 50 == 0? ICSVParser.NEWLINE : ""));

            if (!cartonGanador.equals(""))
            {
                System.out.println(Arrays.toString(this.objControladorInicio.objBingo.ListaBolas));

                Fin objFin = new Fin();
                objFin.setSize(850, 450);
                ControladorFin objControladorFin = new ControladorFin(objFin, objControladorInicio);
                Carton objCarton = this.objControladorInicio.objBingo.ObtenerCarton(cartonGanador);
                objControladorFin.objFin.lblPremio.setText(String.valueOf(this.objControladorInicio.objBingo.getMonto()));

                switch (String.valueOf(this.objControladorInicio.objBingo.getModoJuego()))
                {
                    case "1" ->
                    {
                        objControladorFin.objFin.lblTipoJuego.setText("Juego en X");
                    }
                    case "2" ->
                    {
                        objControladorFin.objFin.lblTipoJuego.setText("Cuatro Esquinas");
                    }
                    case "3" ->
                    {
                        objControladorFin.objFin.lblTipoJuego.setText("Cartón Lleno");
                    }
                    case "4" ->
                    {
                        objControladorFin.objFin.lblTipoJuego.setText("Juego en Z");
                    }
                }

                objControladorFin.objFin.lblGanadores.setText(cartonGanador);

                if (objCarton.getJugador() == null)
                {
                    objControladorInicio.CambiaPanel(objControladorFin.objFin);
                } else
                {
                    Utilitarios.EnviarCartonCorreo(objCarton.getJugador().getCorreoElectronico(), new ArrayList<>(), "Ganador", "Felicidades tu cartón " + objCarton.getIdentificador() + " Fue el ganador del bingo");
                    //Utilitarios.GuardarHistorialPartidas(objControladorFin.objFin.lblTipoJuego.getText(), this.objJuego.txtNumerosCantados.getText(), objCarton.getIdentificador(), LocalDate.now(), LocalDateTime.now());
                    objControladorInicio.CambiaPanel(objControladorFin.objFin);
                }

                JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Carton Ganador " + cartonGanador, "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
