/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Jugador;

/**
 *
 * @author User
 */
public class JugadorDAOXML implements JugadorDAO{

    @Override
    public Jugador registrarJugador(Jugador pJugador) throws ParserConfigurationException, ParserConfigurationException, ParserConfigurationException{
        if(pJugador.getCedula()== 123456789){
            Jugador nuevoJugador = new Jugador();
            nuevoJugador.agregarJugador(pJugador.getNombreCompleto(), pJugador.getCorreoElectronico(),pJugador.getCedula());
            return nuevoJugador;
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Jugador> cargarListaUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Jugador buscarJugador(int pCedula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
