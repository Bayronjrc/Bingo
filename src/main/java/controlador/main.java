package controlador;

import vista.*;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public class main
{

    /***
     * Main
     * @param args 
     */
    public static void main(String[] args)
    {
        Inicio objInicio = new Inicio();
        objInicio.setSize(850, 450);
        ControladorInicio objControladorInicio = new ControladorInicio(objInicio);
        objControladorInicio.objInicio.setLocationRelativeTo(null);
        objControladorInicio.objInicio.setVisible(true);
    }
}
