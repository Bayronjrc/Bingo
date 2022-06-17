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
                this.objControladorInicio.CambiaPanelOpciones();
            }
        }
    }

    public void MostrarCarton() throws ParserConfigurationException, SAXException, IOException
    {
        String strIdentificacion = this.objConsultarCartones.txtIdentificación.getText();
        
//        if (Utilitarios.ValidarIdentificacion(strIdentificacion, Boolean.TRUE))
//        {
                GenerarVistaCarton(strIdentificacion);
//        }
//        else
//        {
//            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Debe ingregar un valor entero positivo, entre 1 y 500.","Error", JOptionPane.INFORMATION_MESSAGE);
//        }
    }
    
    public void GenerarVistaCarton (String strIdentificacion)
    {
        Carton objCarton = objControladorInicio.objBingo.ObtenerCarton(strIdentificacion);
        VistaCarton objVistaCarton = new VistaCarton();
        objVistaCarton.setSize(464, 610);
        objVistaCarton.AgregarLabels(objCarton);

        JFrame frame = new JFrame();
        frame.setContentPane(objVistaCarton);
        frame.setSize(464, 610);
        frame.setVisible(true);
    }
}
