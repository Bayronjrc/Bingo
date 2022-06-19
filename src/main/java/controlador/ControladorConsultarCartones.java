package controlador;

import javax.swing.*;
import java.awt.event.*;
import vista.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Carton;
import modelo.Jugador;
import org.xml.sax.SAXException;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public class ControladorConsultarCartones implements ActionListener
{

    public ConsultarCarton objConsultarCartones;
    public ControladorInicio objControladorInicio;

    public ControladorConsultarCartones(ConsultarCarton objConsultarCartones, ControladorInicio objControladorInicio)
    {
        this.objConsultarCartones = objConsultarCartones;
        this.objControladorInicio = objControladorInicio;
        this.objConsultarCartones.btRegresar.addActionListener(this);
        this.objConsultarCartones.btMostrar.addActionListener(this);
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            // Consultar
            case "1" ->
            {
                try
                {
                    MostrarCarton();
                }
                catch (ParserConfigurationException | SAXException | IOException ex)
                {
                    Logger.getLogger(ControladorJugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // Regresar
            case "0" ->
            {
                this.objControladorInicio.CambiaPanelOpcionesHabilitarBotones();
            }
        }
    }

    public void MostrarCarton() throws ParserConfigurationException, SAXException, IOException
    {
        String strIdentificacion = this.objConsultarCartones.txtIdentificación.getText();
        GenerarVistaCarton(strIdentificacion);
    }
    
    public void GenerarVistaCarton (String strIdentificacion)
    {
        Carton objCarton = objControladorInicio.objBingo.ObtenerCarton(strIdentificacion);
        Jugador objJugador = objCarton.getJugador();
        
        if(objJugador != null)
        {
            this.objConsultarCartones.lblNombre.setText(objJugador.getNombreCompleto());
            this.objConsultarCartones.lblCedula.setText(objJugador.getCedula());
        }
        
        VistaCarton objVistaCarton = new VistaCarton();
        objVistaCarton.setSize(464, 610);
        objVistaCarton.AgregarLabels(objCarton);

        JFrame frame = new JFrame();
        frame.setContentPane(objVistaCarton);
        frame.setSize(480, 650);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
