/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.*;

/**
 *
 * @author User
 */
public class main
{
    public static void main(String[] args)
    {
        Inicio objInicio = new Inicio();
        objInicio.setSize(850,450);
        ControladorInicio objControladorInicio = new ControladorInicio(objInicio);
        objControladorInicio.objInicio.setLocationRelativeTo(null);
        objControladorInicio.objInicio.setVisible(true);
    }
}