package controlador;

import com.opencsv.exceptions.CsvException;
import dao.JugadorDAO;
import dao.JugadorDAOXML;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.*;

/**
 *
 * @author Bayron Rodriguez
 */
public class ControladorIniciarJuego implements ActionListener
{

    public IniciarJuego objIniciarJuego;
    public ControladorInicio objControladorInicio;
    public JugadorDAO objJugadorDAO;

    public ControladorIniciarJuego(IniciarJuego objIniciarJuego, ControladorInicio objControladorInicio)
    {
        this.objControladorInicio = objControladorInicio;
        this.objIniciarJuego = objIniciarJuego;
        this.objJugadorDAO = new JugadorDAOXML();
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

            try
            {
                IniciarJuego();
            } catch (CsvException ex)
            {
                Logger.getLogger(ControladorIniciarJuego.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex)
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

    public void IniciarJuego() throws CsvException, IOException
    {
        int Tipo = objIniciarJuego.jComboBox1.getSelectedIndex();
        String premio = objIniciarJuego.jTextField1.getText();
        if (Utilitarios.ValidarEntero(premio, Boolean.FALSE))
        {
            this.objControladorInicio.objBingo.setModoJuego(Tipo + 1);
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
            objJuego.lbJugadores.setText(String.valueOf(objJugadorDAO.cantidadUsuarios()));
            objControladorInicio.CambiaPanel(objControladorJuego.objJuego);

        }

    }
    
}
