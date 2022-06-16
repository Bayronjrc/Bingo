package modelo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public class Bingo
{
    // Atributos de clase
    private int modoJuego;
    private double monto;
    private ArrayList<Carton> listaCarton;
    String[] listaIdentificadores;
    
    
    /// Constantes
    public static int MODO_JUEGO_EN_X = 1;
    public static int MODO_JUEGO_CUATRO_ESQUINAS = 2;
    public static int MODO_JUEGO_CARTON_LLENO = 3;
    public static int MODO_JUEGO_EN_Z = 4;
    
    /***
     * Constructor.
     * @param cantidadCartones 
     * @param monto 
     * @param modoJuego 
     */
    public Bingo(int cantidadCartones, double monto, int modoJuego)
    {
        this.modoJuego = modoJuego;
        this.monto = monto;
        this.listaIdentificadores = new String[cantidadCartones];
        Arrays.fill(listaIdentificadores, "");
        this.listaCarton = GenerarCartonesBingo(cantidadCartones);
    }
    
    /***
     * Genera la cantidad de cartones indicada por el usuario.
     * @param cantidadCartones 
     */
    private ArrayList<Carton> GenerarCartonesBingo(int cantidadCartones)
    {
        ArrayList<Carton> listaCartones = new ArrayList<>();
        for(int cantidad = 0; cantidad < cantidadCartones; cantidad++)
        {
            
            Carton objCarton = new Carton(listaIdentificadores);
            listaIdentificadores[cantidad] = objCarton.getIdentificador();
            listaCartones.add(objCarton);
        }
        
        return listaCartones;
    }
    
    /***
     * 
     * @param args 
     */
    public static void main(String[] args)
    {
        Bingo objBingo = new Bingo(10, 2000.00, Bingo.MODO_JUEGO_EN_X);
        
        for(Carton objCarton: objBingo.listaCarton)
        {
            int cont = 0;
            System.err.format("%n");
            System.err.format("%n");
            System.err.format("Bingo: " + objCarton.getIdentificador());
            System.err.format("%n");
            System.err.format("%n");
            
            for(int numero: objCarton.getListaNumeros())
            {
                System.out.format("%02d | ", numero);
                
                if(cont != 4)
                {
                    cont++;
                }
                else
                {
                    cont = 0;
                    System.err.format("%n");
                }
            }
        }
        
        System.err.format("%n");
        System.err.format("%n");
        System.err.format(Arrays.toString(objBingo.listaIdentificadores));
        
    }
}
