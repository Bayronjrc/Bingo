package modelo;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public class Bingo
{

    private String modoJuego;
    private int monto;
    
    private int[] numeros;

    public int[] getNumeros()
    {
        return numeros;
    }

    public void setNumeros(int[] numeros)
    {
        this.numeros = numeros;
    }

    public String getModoJuego()
    {
        return modoJuego;
    }

    public int getMonto()
    {
        return monto;
    }

    public void setModoJuego(String modoJuego)
    {
        this.modoJuego = modoJuego;
    }

    public void setMonto(int monto)
    {
        this.monto = monto;
    }

    
}
