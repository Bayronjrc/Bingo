/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.*;
import java.awt.event.*;
import modelo.*;
import vista.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
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
        
        if (this.objControladorInicio.objBingo.ValidarCantidadCartones(strCantidad, Boolean.FALSE))
        {
            this.objControladorInicio.objBingo.GenerarCartones(Integer.parseInt(strCantidad));
            this.objControladorInicio.CambiaPanelOpciones();
        }
        else
        {
            JOptionPane.showMessageDialog(this.objControladorInicio.objInicio, "Debe ingregar un valor entero positivo, entre 1 y 500.");
        }
    }
}
