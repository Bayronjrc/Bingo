package modelo;

import controlador.Utilitarios;
import dao.BingoDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public final class Bingo implements BingoDAO
{

    // Atributos de clase
    public int ModoJuego;
    public double Monto;
    public ArrayList<Carton> ListaCarton;
    public String[] ListaIdentificadores;
    public int[] ListaBolas = new int[75];

    /// Constantes
    public final static int MODO_JUEGO_EN_X = 1;
    public final static int MODO_JUEGO_CUATRO_ESQUINAS = 2;
    public final static int MODO_JUEGO_CARTON_LLENO = 3;
    public final static int MODO_JUEGO_EN_Z = 4;

    /**
     * *
     * Genera los cartones.
     *
     * @param cantidadCartones
     */
    @Override
    public void GenerarCartones(int cantidadCartones)
    {
        Arrays.fill(this.ListaBolas, 0);
        this.ListaIdentificadores = new String[cantidadCartones];
        Arrays.fill(this.ListaIdentificadores, "");
        this.ListaCarton = GenerarCartonesBingo(cantidadCartones);
    }

    /**
     * *
     * Genera la cantidad de cartones indicada por el usuario.
     *
     * @param cantidadCartones
     * @return Lista de cartones.
     */
    @Override
    public ArrayList<Carton> GenerarCartonesBingo(int cantidadCartones)
    {
        ArrayList<Carton> listaCartones = new ArrayList<>();
        for (int cantidad = 0; cantidad < cantidadCartones; cantidad++)
        {

            Carton objCarton = new Carton(this.ListaIdentificadores);
            this.ListaIdentificadores[cantidad] = objCarton.getIdentificador();
            listaCartones.add(objCarton);
        }

        return listaCartones;
    }

    /**
     * *
     * Valida si el cartón tiene los números
     *
     * @param identificador
     * @return
     */
    @Override
    public Boolean ValidarCartonGanador(String identificador)
    {
        Carton objCarton = ObtenerCarton(identificador);

        int numerosAcertados;

        if (objCarton != null)
        {
            switch (this.ModoJuego)
            {
                case Bingo.MODO_JUEGO_CARTON_LLENO ->
                {
                    numerosAcertados = 0;
                    for (int numero : this.ListaBolas)
                    {
                        if (Utilitarios.ExisteNumero(numero, objCarton.getListaNumeros(), false))
                        {
                            numerosAcertados++;
                        }
                    }

                    return numerosAcertados == 25;
                }

                case Bingo.MODO_JUEGO_CUATRO_ESQUINAS ->
                {
                    return Utilitarios.ExisteNumero(objCarton.getListaNumeros()[0], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[4], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[20], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[24], ListaBolas, false);
                }

                case Bingo.MODO_JUEGO_EN_X ->
                {
                    return Utilitarios.ExisteNumero(objCarton.getListaNumeros()[0], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[4], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[20], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[24], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[6], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[8], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[16], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[18], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[12], ListaBolas, false);
                }
                case Bingo.MODO_JUEGO_EN_Z ->
                {
                    return Utilitarios.ExisteNumero(objCarton.getListaNumeros()[0], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[1], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[2], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[3], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[4], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[8], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[12], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[16], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[20], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[21], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[22], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[23], ListaBolas, false)
                            && Utilitarios.ExisteNumero(objCarton.getListaNumeros()[24], ListaBolas, false);
                }
            }
        }

        return false;
    }

    @Override
    public String validarCartones()
    {
        String cartones = "";
        for (Carton objCarton : this.ListaCarton)
        {
            if (ValidarCartonGanador(objCarton.getIdentificador()))
            {
                if (!cartones.equals(""))
                {
                    cartones += ", ";
                }
                cartones += objCarton.getIdentificador();
            }
        }
        return cartones;
    }

    /**
     * *
     * Genera las bolas para el bingo.
     *
     * @return El número de la bola, si ya no hay da -1.
     */
    @Override
    public int ObtenerBola()
    {
        int bola = 0;

        // Se valida que ya hayan salido todas las bolas, y se retorna -1 para identificarlo.
        if (!Utilitarios.ExisteNumero(0, this.ListaBolas, false))
        {
            bola = -1;
        } else
        {
            Random rn = new Random();

            Boolean bolaInvalida = true;

            // Genera bolas hasta encontrar una válida.
            while (bolaInvalida)
            {
                bola = rn.nextInt(75) + 1;
                bolaInvalida = Utilitarios.ExisteNumero(bola, this.ListaBolas, false);
            }
            this.ListaBolas[bola - 1] = bola;
        }

        return bola;
    }

    /**
     * *
     * Busca el cartón por el identificador.
     *
     * @param identificador
     * @return El cartón buscado, o null si no lo encuentra.
     */
    @Override
    public Carton ObtenerCarton(String identificador)
    {
        for (Carton objCarton : this.ListaCarton)
        {
            if (objCarton.getIdentificador().equals(identificador))
            {
                return objCarton;
            }
        }

        return null;
    }

    /**
     * *
     * Asigna el jugador a alguno de los cartones.
     *
     * @param objJugador
     * @return
     */
    @Override
    public Boolean AsingarJugador(Jugador objJugador)
    {
        for (Carton objCarton : this.ListaCarton)
        {
            if (objCarton.getJugador() == null)
            {
                objCarton.setJugador(objJugador);
                return true;
            }
        }

        return false;
    }

    /**
     * *
     * Asing
     *
     * @param objJugador
     * @param cantidad
     * @return
     */
    @Override
    public int AsingarCartones(Jugador objJugador, int cantidad)
    {
        for (int i = 0; i < cantidad; i++)
        {
            if (!AsingarJugador(objJugador))
            {
                if (i == 0)
                {
                    return -1;
                } else
                {
                    return i + 1;
                }
            }
        }

        return cantidad;
    }

    /**
     * *
     * Retorna la lista de cartones del jugador.
     *
     * @param strCedula
     * @return
     */
    @Override
    public ArrayList<Carton> ObtenerCartonesPorJugador(String strCedula)
    {
        ArrayList<Carton> lista = new ArrayList<>();

        for (Carton objCarton : this.ListaCarton)
        {
            if (objCarton.ObtenerCedulaJugador().equals(strCedula))
            {
                lista.add(objCarton);
            }
        }

        return lista;
    }

    /**
     * Obtiene el modo de juego.
     * @return
     */
    @Override
    public int getModoJuego()
    {
        return ModoJuego;
    }

    /**
     * Guarda el modo de juego.
     * @param ModoJuego
     */
    @Override
    public void setModoJuego(int ModoJuego)
    {
        this.ModoJuego = ModoJuego;
    }

    /**
     * Obtiene el monto.
     * @return
     */
    @Override
    public double getMonto()
    {
        return Monto;
    }

    /**
     * Guarda el monto.
     * @param Monto
     */
    @Override
    public void setMonto(double Monto)
    {
        this.Monto = Monto;
    }

    /**
     * Obtiene el lista de cartoness.
     * @return
     */
    @Override
    public ArrayList<Carton> getListaCarton()
    {
        return ListaCarton;
    }
}
