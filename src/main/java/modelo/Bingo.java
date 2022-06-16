/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author User
 */
public class Bingo {
    private String modoJuego;
    private int monto;

    public Bingo(String pModoJuego, int pMonto) {
        this.modoJuego = pModoJuego;
        this.monto = pMonto;
    }
    
    public String getModoJuego() {
        return modoJuego;
    }

    public int getMonto() {
        return monto;
    }
}
