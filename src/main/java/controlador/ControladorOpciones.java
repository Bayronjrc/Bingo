package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import vista.*;
import modelo.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Bayron Rodriguez Centeno
 */
public class ControladorOpciones implements ActionListener
{

    public InicioOpcion objInicioOpcion;
    private final ControladorInicio objControladorInicio;

    public ControladorOpciones(InicioOpcion objInicioOpcion, ControladorInicio objControladorInicio)
    {
        this.objInicioOpcion = objInicioOpcion;
        this.objControladorInicio = objControladorInicio;

        this.objInicioOpcion.btGenerar.addActionListener(this);
        this.objInicioOpcion.btEnviarCarton.addActionListener(this);
        this.objInicioOpcion.btEstadisticas.addActionListener(this);
        this.objInicioOpcion.btIniciar.addActionListener(this);
        this.objInicioOpcion.btRegistrar.addActionListener(this);
        this.objInicioOpcion.btVerCarton.addActionListener(this);
        this.objInicioOpcion.btSalir.addActionListener(this);
    }

    /**
     * *
     * Evento de los botones de la interfaz.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            // Iniciar Juego
            case "1" ->
            {
                iniciarJuego();
            }
            // Registrar jugador
            case "2" ->
            {
                registrarJugador();
            }
            // Enviar Cartón
            case "3" ->
            {
                enviarCartones();
            }
            // Generar Cartones
            case "4" ->
            {
                generarCartones();
            }
            // Ver Carton
            case "5" ->
            {
                consultarCartones();
            }
            // Estadisticas
            case "6" ->
            {
                estadisticas();
            }
            // Salir
            case "0" ->
            {
                Utilitarios.BorrarCarpeta("Cartones");
                System.exit(0);
            }
        }
    }

    /**
     * *
     * Configura el panel de juego y lo envía al frame principal.
     */
    public void iniciarJuego()
    {
        IniciarJuego objIniciarJuego = new IniciarJuego();
        ControladorIniciarJuego controladorIniciarJuego = new ControladorIniciarJuego(objIniciarJuego, objControladorInicio);
        objControladorInicio.CambiaPanel(controladorIniciarJuego.objIniciarJuego);
    }

    /**
     * *
     * Configura el panel de registrar jugador y lo envía al frame principal.
     */
    public void registrarJugador()
    {
        RegistroJugador objRegistroJugador = new RegistroJugador();
        Jugador jugador = new Jugador();
        ControladorJugador controladorUsuario = new ControladorJugador(objRegistroJugador, jugador, objControladorInicio);
        objControladorInicio.CambiaPanel(controladorUsuario.objRegistroJugador);
    }

    /**
     * *
     * Configura el panel de enviar cartones y lo envía al frame principal.
     */
    public void enviarCartones()
    {
        EnviarCarton objEnviarCarton = new EnviarCarton();
        ControladorEnviarCarton controladorEnviarCarton = new ControladorEnviarCarton(objEnviarCarton, objControladorInicio);
        objControladorInicio.CambiaPanel(controladorEnviarCarton.objEnviarCarton);
    }

    /**
     * *
     * Configura el panel de generar cartones y lo envía al frame principal.
     */
    public void generarCartones()
    {
        GenerarCartones objGenerarCartones = new GenerarCartones();
        ControladorGenerarCartones objControladorGenerarCartones = new ControladorGenerarCartones(objGenerarCartones, objControladorInicio);
        objControladorInicio.CambiaPanel(objControladorGenerarCartones.objGenerarCartones);
    }

    /**
     * *
     * Configura el panel de consultar cartones y lo envía al frame principal.
     */
    public void consultarCartones()
    {
        ConsultarCarton objConsultarCarton = new ConsultarCarton();
        ControladorConsultarCartones objControladorConsultarCartones = new ControladorConsultarCartones(objConsultarCarton, objControladorInicio);
        objControladorInicio.CambiaPanel(objControladorConsultarCartones.objConsultarCartones);
    }

    /**
     * *
     * Configura el panel de estadísticas y lo envía al frame principal.
     */
    public void estadisticas()
    {
        objControladorInicio.objInicio.setSize(1000, 1000);

        Estadisticas objEstadisticas = new Estadisticas();
        ControladorEstadisticas objControladorEstadisticas = new ControladorEstadisticas(objEstadisticas, objControladorInicio);

        //Grafico Circular Historia
        DefaultPieDataset objPieDataSetCircular = new DefaultPieDataset();
        objPieDataSetCircular.setValue("Value 1", 10);
        objPieDataSetCircular.setValue("Value 2", 20);
        objPieDataSetCircular.setValue("Value 3", 30);
        objPieDataSetCircular.setValue("Value 4", 40);
        JFreeChart objChartBarrasCircular = ChartFactory.createPieChart("Frecuencia Historica", objPieDataSetCircular, true, true, true);
        ChartPanel objChartPanel = new ChartPanel(objChartBarrasCircular);
        objChartPanel.setSize(400, 400);

        //Grafico Barras
        DefaultCategoryDataset objCategoryDataSetBarra = new DefaultCategoryDataset();
        objCategoryDataSetBarra.setValue(10, "numeros", "1");
        objCategoryDataSetBarra.setValue(10, "numeros", "2");
        objCategoryDataSetBarra.setValue(10, "numeros", "3");
        JFreeChart objChartBarras = ChartFactory.createBarChart("Top 10 Números Cantados", "Números", "Promedios", objCategoryDataSetBarra, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel objChartPanelBarras = new ChartPanel(objChartBarras);
        objChartPanelBarras.setSize(400, 400);

        //Grafo date Handling
        XYSeriesCollection xyDataset = new XYSeriesCollection(new XYSeries("Sensor"));
        JFreeChart objChartDataHandling = ChartFactory.createTimeSeriesChart("Compras realizadas", "Compras realizadas, 2007", "Numero de Compras", xyDataset);
        ChartPanel objChartPanelDataHandling = new ChartPanel(objChartDataHandling);
        objChartPanelDataHandling.setSize(400, 400);

        //Grafo cicular 3D
        DefaultPieDataset objPieDataSetCircular3D = new DefaultPieDataset();
        objPieDataSetCircular3D.setValue("Value 1", 10);
        objPieDataSetCircular3D.setValue("Value 2", 20);
        objPieDataSetCircular3D.setValue("Value 3", 30);
        objPieDataSetCircular3D.setValue("Value 4", 40);
        JFreeChart objChartBarrasCircular3D = ChartFactory.createPieChart3D("Frecuencia Historica", objPieDataSetCircular3D, true, true, true);
        ChartPanel objChartPanel3D = new ChartPanel(objChartBarrasCircular3D);
        objChartPanel3D.setSize(400, 400);

        //implementacion
        objEstadisticas.pnlCircularHistorica.add(objChartPanel);
        objEstadisticas.pnlGrafoBarras.add(objChartPanelBarras);
        objEstadisticas.pnlDateHanding.add(objChartPanelDataHandling);
        objEstadisticas.pnlTopCinco.add(objChartPanel3D);

        objControladorInicio.CambiaPanel(objControladorEstadisticas.objEstadisticas);
    }
}
