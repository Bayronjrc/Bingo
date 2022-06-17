/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import modelo.Bingo;
import vista.*;

/**
 *
 * @author User
 */
public final class ControladorInicio implements ActionListener
{

    public Inicio objInicio;
    public Bingo objBingo;

    public ControladorInicio(Inicio objInicio)
    {
        this.objInicio = objInicio;
        this.objBingo = new Bingo();
        CambiaPanelOpciones();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
    }
    
    public void CambiaPanel(JPanel panel)
    {
        this.objInicio.getContentPane().removeAll(); 
        this.objInicio.setContentPane(panel);  
        this.objInicio.getContentPane().revalidate();
        this.objInicio.getContentPane().repaint(); 
    }
    
    public void CambiaPanelOpciones()
    {
        InicioOpcion objInicioOpcion = new InicioOpcion();
        objInicioOpcion.setSize(850, 450);
        objInicioOpcion.setVisible(true);
        ControladorOpciones objControladorOpciones = new ControladorOpciones(objInicioOpcion, this);
        CambiaPanel(objControladorOpciones.objInicioOpcion);  
    }
}
