/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Jugador;
import vista.*;
import controlador.*;

/**
 *
 * @author User
 */
public class main {
    public static void main(String[] args)
    {
        
        Inicio ini = new Inicio();
        ControladorInicio cI = new ControladorInicio(ini);
        cI.vista.setVisible(true);
    
    }
}
