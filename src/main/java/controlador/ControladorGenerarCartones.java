/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    public ControladorGenerarCartones(GenerarCartones objGenerarCartones, ControladorInicio objControladorInicio)
    {
        this.objGenerarCartones = objGenerarCartones;
        this.objControladorInicio = objControladorInicio;
        this.objGenerarCartones.btRegresar.addActionListener(this);
        this.objGenerarCartones.btGenerar.addActionListener(this);
    }

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
                    GenerarCartones();
                }
                catch (ParserConfigurationException | SAXException | IOException ex)
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

    public void GenerarCartones() throws ParserConfigurationException, SAXException, IOException
    {
        String strCantidad = this.objGenerarCartones.txtCantidad.getText();
        
        if (Utilitarios.ValidarEntero(strCantidad, Boolean.TRUE))
        {
            this.objControladorInicio.objBingo.GenerarCartones(Integer.parseInt(strCantidad));
            GenerarVistaCarton();
            this.objControladorInicio.CambiaPanelOpcionesHabilitarBotones();
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Se han generado los cartones.","Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Debe ingregar un valor entero positivo, entre 1 y 500.","Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    public void GenerarVistaCarton ()
    {
        String path = System.getProperty("user.dir");
        File file = new File(path + "\\Cartones");
        
        if(!file.exists())
        {
            for(Carton objCarton: objControladorInicio.objBingo.ListaCarton)
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
                        file.mkdir();
                        ImageIO.write(image, "png", new File(path + "\\Cartones\\" + objCarton.getIdentificador() + ".png"));

                }
                catch (IOException exp)
                {
                }
            }
        }
    }
}
