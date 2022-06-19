/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author User
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

    public void iniciarJuego()
    {
        IniciarJuego objIniciarJuego = new IniciarJuego();
        objIniciarJuego.setSize(850,450);
        ControladorIniciarJuego controladorIniciarJuego = new ControladorIniciarJuego(objIniciarJuego,objControladorInicio);
        objControladorInicio.CambiaPanel(controladorIniciarJuego.objIniciarJuego);
    }
    
    public void registrarJugador()
    {
        RegistroJugador objRegistroJugador = new RegistroJugador();
        objRegistroJugador.setSize(850, 450);
        Jugador jugador = new Jugador();
        ControladorJugador controladorUsuario = new ControladorJugador(objRegistroJugador, jugador, objControladorInicio);
        objControladorInicio.CambiaPanel(controladorUsuario.objRegistroJugador);
    }

    public void enviarCartones()
    {
        EnviarCarton objEnviarCarton = new EnviarCarton();
        objEnviarCarton.setSize(850, 450);
        ControladorEnviarCarton controladorEnviarCarton = new ControladorEnviarCarton(objEnviarCarton, objControladorInicio);
        objControladorInicio.CambiaPanel(controladorEnviarCarton.objEnviarCarton);
    }

    public void generarCartones()
    {
        GenerarCartones objGenerarCartones = new GenerarCartones();
        objGenerarCartones.setSize(850, 450);
        ControladorGenerarCartones objControladorGenerarCartones = new ControladorGenerarCartones(objGenerarCartones, objControladorInicio);
        objControladorInicio.CambiaPanel(objControladorGenerarCartones.objGenerarCartones);
    }
    
    public void consultarCartones()
    {
        ConsultarCarton objConsultarCarton = new ConsultarCarton();
        objConsultarCarton.setSize(850, 450);
        ControladorConsultarCartones objControladorConsultarCartones = new ControladorConsultarCartones(objConsultarCarton, objControladorInicio);
        objControladorInicio.CambiaPanel(objControladorConsultarCartones.objConsultarCartones);
    }
    
    public void estadisticas()
    {
        Estadisticas objEstadisticas = new Estadisticas();
        objEstadisticas.setSize(850, 850);
        ControladorEstadisticas objControladorEstadisticas = new ControladorEstadisticas(objEstadisticas, objControladorInicio);
       
        //Grafico Circular Historia
        DefaultPieDataset objPieDataSetCircular = new DefaultPieDataset();
        objPieDataSetCircular.setValue("Value 1", 10);
        objPieDataSetCircular.setValue("Value 2", 20);
        objPieDataSetCircular.setValue("Value 3", 30);
        objPieDataSetCircular.setValue("Value 4", 40);
        JFreeChart objChartBarrasCircular = ChartFactory.createPieChart("Frecuencia Historica", objPieDataSetCircular, true, true, true);
        ChartPanel objChartPanel = new ChartPanel(objChartBarrasCircular);
        objChartPanel.setSize(400,400);
        //Grafico Barras
        DefaultCategoryDataset objCategoryDataSetBarra = new DefaultCategoryDataset();
        objCategoryDataSetBarra.setValue(10,"numeros","1");
        objCategoryDataSetBarra.setValue(10,"numeros","2");
        objCategoryDataSetBarra.setValue(10,"numeros","3");
        JFreeChart objChartBarras = ChartFactory.createBarChart("Top 10 Números Cantados","Números", "Promedios",objCategoryDataSetBarra, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel objChartPanelBarras = new ChartPanel(objChartBarras);
        objChartPanelBarras.setSize(400,400);
        
        //Grafo date Handling
        XYSeriesCollection xyDataset = new XYSeriesCollection(new XYSeries("Sensor"));
        JFreeChart objChartDataHandling = ChartFactory.createTimeSeriesChart("Compras realizadas","Compras realizadas, 2007", "Numero de Compras", xyDataset);
        ChartPanel objChartPanelDataHandling = new ChartPanel(objChartDataHandling);
        objChartPanelDataHandling.setSize(400,400);
        
        //Grafo cicular 3D
        DefaultPieDataset objPieDataSetCircular3D = new DefaultPieDataset();
        objPieDataSetCircular3D.setValue("Value 1", 10);
        objPieDataSetCircular3D.setValue("Value 2", 20);
        objPieDataSetCircular3D.setValue("Value 3", 30);
        objPieDataSetCircular3D.setValue("Value 4", 40);
        JFreeChart objChartBarrasCircular3D = ChartFactory.createPieChart3D("Frecuencia Historica", objPieDataSetCircular3D, true, true, true);
        ChartPanel objChartPanel3D = new ChartPanel(objChartBarrasCircular3D);
        objChartPanel3D.setSize(400,400);
        //implementacion
        objEstadisticas.pnlCircularHistorica.add(objChartPanel);
        objEstadisticas.pnlGrafoBarras.add(objChartPanelBarras);
        objEstadisticas.pnlDateHanding.add(objChartPanelDataHandling);
        objEstadisticas.pnlTopCinco.add(objChartPanel3D);
        objControladorInicio.objInicio.setSize(1000,1000);
  
        objControladorInicio.CambiaPanel(objControladorEstadisticas.objEstadisticas);
    }

    
}
