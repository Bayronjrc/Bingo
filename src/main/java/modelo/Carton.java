package modelo;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Bayron Rodriguez
 */
public class Carton
{
    private String Identificador;
    private int[] ListaNumeros;

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
     * @return
     */
    private int ObtenerNumeroRandom(int rangoInferior, int rangoSuperior, int[] lista)
    {
        int numeroAleatorio = 0;
        Random rn = new Random();
        Boolean numeroInvalido = true;

        while (numeroInvalido)
        {
            numeroAleatorio = rn.nextInt(rangoSuperior);

            numeroAleatorio = numeroAleatorio < rangoInferior ? rangoInferior + rn.nextInt(15) : numeroAleatorio;

            numeroInvalido = ExisteNumero(numeroAleatorio, lista);
        }

        return numeroAleatorio;
    }

    /**
     * *
     * Verfica si existe o no el número en la lista.
     *
     * @param numero
     * @param listaNumeros
     * @return
     */
    private Boolean ExisteNumero(int numeroAleatorio, int[] listaNumeros)
    {
        for (int numero : listaNumeros)
        {
            if (numero == 0)
            {
                return false;
            }
            else if (numero == numeroAleatorio)
            {
                return true;
            }
        }

        return false;
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
        Boolean identificadorInvalido = true;
        String identificador = "";
        String[] letras = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        Random rn = new Random();
        
        while (identificadorInvalido)
        {
            int numeroIdentificador = rn.nextInt(999);
            identificador = letras[rn.nextInt(25)] + "" + letras[rn.nextInt(25)] + "" + letras[rn.nextInt(25)] + "" + (numeroIdentificador < 100? "0" + numeroIdentificador : numeroIdentificador < 10? "00" + numeroIdentificador : numeroIdentificador + "");
            identificadorInvalido = ExisteIdentificador(identificador, listaIdentificadores);
        }

        return identificador;
    }
    
    /**
     * *
     * Verfica si existe o no el identificador en la lista.
     *
     * @param identificadorAleatorio
     * @param listaIdentificadores
     * @return
     */
    private Boolean ExisteIdentificador(String identificadorAleatorio, String[] listaIdentificadores)
    {
        for (String identificador : listaIdentificadores)
        {
            if(identificador.equals(""))
            {
                return false;
            }
            if (identificador.equals(identificadorAleatorio))
            {
                return true;
            }
        }

        return false;
    }

    
    
    /*
    Main de pruebas del los números de los cartones de bingo
     
        package controlador;

        import java.util.Arrays;
        import modelo.Bingo;

        public class main
        {
            public static void main(String[] args)
            {
                Bingo objBingo = new Bingo();
                int[] numerosBungo = objBingo.GenerarNumerosCarton();
                System.err.println(Arrays.toString(numerosBungo));
                int cont = 0;
                for(int numero: numerosBungo)
                {
                    if(cont == 5)
                    {
                        cont = 0;
                        System.err.println("");
                    }

                    System.out.format("%02d | ", numero);
                    cont++;
                }
            }
        }
     */

    public int[] getListaNumeros()
    {
        return ListaNumeros;
    }

    public void setListaNumeros(int[] ListaNumeros)
    {
        this.ListaNumeros = ListaNumeros;
    }
}
