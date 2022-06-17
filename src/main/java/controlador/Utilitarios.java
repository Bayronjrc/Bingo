package controlador;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public class Utilitarios
{

    public Utilitarios()
    {
    }
    
    /**
     * *
     * Verfica si existe o no el número en la lista.
     *
     * @param numeroBuscado
     * @param listaNumeros
     * @param listaLlenadaUniforme
     * @return Si el número está o no en la lista.
     */
    public static Boolean ExisteNumero(int numeroBuscado, int[] listaNumeros, Boolean listaLlenadaUniforme)
    {
        for (int numero : listaNumeros)
        {
            if(listaLlenadaUniforme && numero == 0)
            {
                return false;
            }
            else if (numero == numeroBuscado)
            {
                return true;
            }
        }

        return false;
    }
    
    /**
     * *
     * Verfica si existe o no el string en la lista.
     *
     * @param stringBuscado
     * @param listaStrings
     * @return
     */
    public static Boolean ExisteString(String stringBuscado, String[] listaStrings, Boolean listaLlenadaUniforme)
    {
        for (String string : listaStrings)
        {
            // Si es vacío quiere decir que el resto de la lista está vacío y no está repetido.
            if(listaLlenadaUniforme && string.equals(""))
            {
                return false;
            }
            // Si coincide es que ya existe.
            else if (string.equals(stringBuscado))
            {
                return true;
            }
        }

        return false;
    }
    
    public 
}
