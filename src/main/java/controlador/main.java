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
    public static void main(String[] args) {
        
        RegistroJugador vista = new RegistroJugador();
        Jugador jugador = new Jugador();
        ControladorJugador controladorJugador = new ControladorJugador(vista, jugador);
        controladorJugador.vista.setVisible(true);
        

    }
    
}
