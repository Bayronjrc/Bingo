package modelo;

import controlador.Utilitarios;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Bayron Rodriguez
 */
public final class Carton
{
    private String Identificador;
    private int[] ListaNumeros;
    private Jugador objJugador;

    public Carton(String[] listaIdentificadores)
    {
        ListaNumeros = GenerarNumerosCarton();
        Identificador = GenerarIdentificadorCarton(listaIdentificadores);
    }

    public String getIdentificador()
    {
        return Identificador;
    }

    public void setIdentificador(String identificador)
    {
        this.Identificador = identificador;
    }

    public Jugador getJugador()
    {
        return objJugador;
    }

    public void setJugador(Jugador objJugador)
    {
        this.objJugador = objJugador;
    }
    
    /***
     * Asigna el jugador a los cartones.
     * @param objJugador
     */
    public void AsignarJugador(Jugador objJugador)
    {
        this.objJugador = objJugador;
    }
    
    /**
     * *
     * Genera los números del cartón en una lista de enteros
     *
     * @return
     */
    public int[] GenerarNumerosCarton()
    {
        int[] numerosCarton = new int[25];
        Arrays.fill(numerosCarton, 0);

        int primeraFila = 0;
        int segundaFila = 0;
        int terceraFila = 0;
        int cuartaFila = 0;
        int quintaFila = 0;

        while (primeraFila != 5)
        {
            // Números entre 1 y 15
            numerosCarton[primeraFila * 5 + 0] = ObtenerNumeroRandom(1, 15, numerosCarton);
            primeraFila++;
        }

        while (segundaFila != 5)
        {
            // Números entre 16 y 30
            numerosCarton[segundaFila * 5 + 1] = ObtenerNumeroRandom(16, 30, numerosCarton);
            segundaFila++;
        }
        while (terceraFila != 5)
        {
            // Números entre 31 y 45
            numerosCarton[terceraFila * 5 + 2] = ObtenerNumeroRandom(31, 45, numerosCarton);
            terceraFila++;
        }
        while (cuartaFila != 5)
        {
            // Números entre 46 y 60
            numerosCarton[cuartaFila * 5 + 3] = ObtenerNumeroRandom(46, 60, numerosCarton);
            cuartaFila++;
        }

        while (quintaFila != 5)
        {
            // Números entre 61 y 75
            numerosCarton[quintaFila * 5 + 4] = ObtenerNumeroRandom(61, 75, numerosCarton);
            quintaFila++;
        }

        return numerosCarton;
    }

    /**
     * *
     * Genera un número random en el rango indicado, sin repetir en la lista.
     *
     * @param rangoInferior
     * @param rangoSuperior
     * @param lista
     * @return Número aleatorio sin repetir en la lista de entrada.
     */
    private int ObtenerNumeroRandom(int rangoInferior, int rangoSuperior, int[] lista)
    {
        Random rn = new Random();
        
        int numeroAleatorio = 0;
        Boolean numeroInvalido = true;

        // Se ejecuta hasta encontrar un número valido, sin repetir.
        while (numeroInvalido)
        {
            // Número aleatorio menor al rango superior indicado en el proyecto.
            numeroAleatorio = rn.nextInt(rangoSuperior);
            
            // Se valida, si el número es menor al rango inferior, se setea el rango inferior más un random entre 0 y 15.
            numeroAleatorio = numeroAleatorio < rangoInferior ? rangoInferior + rn.nextInt(15) : numeroAleatorio;
            
            // Se envía a evaluar si el número está repetido o no.
            numeroInvalido = Utilitarios.ExisteNumero(numeroAleatorio, lista, false);
        }

        return numeroAleatorio;
    }

    /**
     * *
     * Genera los números del cartón en una lista de enteros
     *
     * @param listaIdentificadores
     * @return Identificador
     */
    public String GenerarIdentificadorCarton(String[] listaIdentificadores)
    {
        Random rn = new Random();
        
        String identificador = "";
        Boolean identificadorInvalido = true;
        String[] letras = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        
        while (identificadorInvalido)
        {
            int numeroIdentificador = rn.nextInt(999);
            identificador = letras[rn.nextInt(25)] + "" + letras[rn.nextInt(25)] + "" + letras[rn.nextInt(25)] + "" + (numeroIdentificador < 100? "0" + numeroIdentificador : numeroIdentificador < 10? "00" + numeroIdentificador : numeroIdentificador + "");
            identificadorInvalido = Utilitarios.ExisteString(identificador, listaIdentificadores, true);
        }

        return identificador;
    }

    public int[] getListaNumeros()
    {
        return ListaNumeros;
    }

    public void setListaNumeros(int[] ListaNumeros)
    {
        this.ListaNumeros = ListaNumeros;
    }
}
