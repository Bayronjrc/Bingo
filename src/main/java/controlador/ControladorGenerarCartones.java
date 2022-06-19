package controlador;

import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import vista.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Carton;
import org.xml.sax.SAXException;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public class ControladorGenerarCartones implements ActionListener
{

    public GenerarCartones objGenerarCartones;
    public ControladorInicio objControladorInicio;

    /**
     * *
     * Constructor
     *
     * @param objGenerarCartones
     * @param objControladorInicio
     */
    public ControladorGenerarCartones(GenerarCartones objGenerarCartones, ControladorInicio objControladorInicio)
    {
        this.objGenerarCartones = objGenerarCartones;
        this.objControladorInicio = objControladorInicio;
        this.objGenerarCartones.btRegresar.addActionListener(this);
        this.objGenerarCartones.btGenerar.addActionListener(this);
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
            // Generar
            case "1" ->
            {
                try
                {
                    ObtenerValidarCampos();
                } catch (ParserConfigurationException | SAXException | IOException ex)
                {
                    Logger.getLogger(ControladorJugador.class.getName()).log(Level.SEVERE, null, ex);
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
     * Obtiene los datos de la interfaz y los valida.
     *
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public void ObtenerValidarCampos() throws ParserConfigurationException, SAXException, IOException
    {
        String strCantidad = this.objGenerarCartones.txtCantidad.getText();

        // Valida que la cantidad sea entera positiva entre 1 y 500.
        if (!Utilitarios.ValidarEntero(strCantidad, Boolean.TRUE))
        {
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Debe ingregar un valor entero positivo, entre 1 y 500.", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else
        {
            this.objControladorInicio.objBingo.GenerarCartones(Integer.parseInt(strCantidad));
            GenerarVistaCarton();
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Se han generado los cartones.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.objControladorInicio.CambiaPanelOpcionesHabilitarBotones();
        }
    }

    /**
     * *
     * Se generan los cartones si no han sido creados.
     *
     */
    public void GenerarVistaCarton()
    {
        String path = Utilitarios.CrearCarpeta("Cartones");

        if (path != null)
        {
            for (Carton objCarton : objControladorInicio.objBingo.ListaCarton)
            {
                VistaCarton objVistaCarton = new VistaCarton();
                objVistaCarton.setSize(464, 610);
                objVistaCarton.AgregarLabels(objCarton);

                JFrame frame = new JFrame();
                frame.setContentPane(objVistaCarton);
                frame.setSize(464, 610);
                frame.setUndecorated(true);
                frame.setVisible(true);

                BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                frame.printAll(g);
                g.dispose();
                frame.dispose();

                try
                {
                    ImageIO.write(image, "png", new File(path + "\\" + objCarton.getIdentificador() + ".png"));
                } catch (IOException exp)
                {
                }
            }
        }
    }
}