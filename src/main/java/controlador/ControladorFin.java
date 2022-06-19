package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.*;

/**
 *
 * @author User
 */
public class ControladorFin implements ActionListener
{

    public Fin objFin;
    public ControladorInicio objControladorInicio;

    public ControladorFin(Fin objFin, ControladorInicio objControladorInicio)
    {
        this.objControladorInicio = objControladorInicio;
        this.objFin = objFin;
        this.objFin.btTerminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            // Iniciar Juego
            case "0" ->
            {
                finJuego();
            }
        }

    }

    public void finJuego()
    {
        String path = System.getProperty("user.dir");
                File file = new File(path + "\\Cartones");
                if (file.exists())
                {
                    try
                    {
                        deleteDirectoryRecursionJava6(file);
                    } catch (IOException ex)
                    {
                        Logger.getLogger(ControladorOpciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                this.objControladorInicio.CambiaPanelOpcionesHabilitarBotones();
    }
    
    void deleteDirectoryRecursionJava6(File file) throws IOException
    {
        if (file.isDirectory())
        {
            File[] entries = file.listFiles();
            if (entries != null)
            {
                for (File entry : entries)
                {
                    deleteDirectoryRecursionJava6(entry);
                }
            }
        }
        if (!file.delete())
        {
            throw new IOException("Failed to delete " + file);
        }
    }

}
