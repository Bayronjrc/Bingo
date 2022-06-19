package controlador;

import com.opencsv.exceptions.CsvException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.*;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public class ControladorIniciarJuego implements ActionListener
{

    public IniciarJuego objIniciarJuego;
    public ControladorInicio objControladorInicio;

    /**
     * *
     * Constructor
     *
     * @param objIniciarJuego
     * @param objControladorInicio
     */
    public ControladorIniciarJuego(IniciarJuego objIniciarJuego, ControladorInicio objControladorInicio)
    {
        this.objControladorInicio = objControladorInicio;
        this.objIniciarJuego = objIniciarJuego;
        this.objIniciarJuego.btInciar.addActionListener(this);
        this.objIniciarJuego.btRegresar1.addActionListener(this);
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
            // Iniciar
            case "1" ->
            {
                try
                {
                    IniciarJuego();
                } catch (CsvException | IOException ex)
                {
                    Logger.getLogger(ControladorIniciarJuego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // Regresar
            case "0" ->
            {
                this.objControladorInicio.CambiaPanelOpciones();
            }
        }
    }

    /**
     * *
     *
     * @throws CsvException
     * @throws IOException
     */
    public void IniciarJuego() throws CsvException, IOException
    {
        int tipo = objIniciarJuego.jComboBox1.getSelectedIndex();
        String premio = objIniciarJuego.jTextField1.getText();

        // Se valida que el premio sea entero positivo.
        if (!Utilitarios.ValidarEntero(premio, Boolean.FALSE) || Double.parseDouble(premio) < 0)
        {
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "EL premio debe ser un valor decimal positivo.", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else
        {
            this.objControladorInicio.objBingo.setModoJuego(tipo + 1);
            this.objControladorInicio.objBingo.setMonto(Double.valueOf(premio));

            Juego objJuego = new Juego();
            objJuego.setSize(850, 450);
            ControladorJuego objControladorJuego = new ControladorJuego(objJuego, objControladorInicio);
            objJuego.lbPremio.setText(String.valueOf(this.objControladorInicio.objBingo.getMonto()));

            switch (String.valueOf(this.objControladorInicio.objBingo.getModoJuego()))
            {
                case "1" ->
                {
                    objJuego.lbTipoJuego.setText("Juego en X");
                }
                case "2" ->
                {
                    objJuego.lbTipoJuego.setText("Cuatro Esquinas");
                }
                case "3" ->
                {
                    objJuego.lbTipoJuego.setText("Cartón Lleno");
                }
                case "4" ->
                {
                    objJuego.lbTipoJuego.setText("Juego en Z");
                }
            }

            objJuego.lbCartones.setText(String.valueOf(this.objControladorInicio.objBingo.getListaCarton().size()));
            objJuego.lbJugadores.setText(String.valueOf(Utilitarios.CantidadUsuarios()));
            objControladorInicio.CambiaPanel(objControladorJuego.objJuego);
        }
    }
}