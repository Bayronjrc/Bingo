/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author User
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Inicio() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btGenerar = new javax.swing.JButton();
        btIniciar = new javax.swing.JButton();
        btVerCarton = new javax.swing.JButton();
        btRegistrar = new javax.swing.JButton();
        btEstadisticas = new javax.swing.JButton();
        btEnviarCarton = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        jButton7.setText("jButton7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btGenerar.setText("Generar Cartones");
        jPanel1.add(btGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 40));

        btIniciar.setText("Iniciar Juego");
        jPanel1.add(btIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 40));

        btVerCarton.setText("Ver Carton");
        jPanel1.add(btVerCarton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 120, 40));

        btRegistrar.setText("Registrar jugador");
        jPanel1.add(btRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 120, 40));

        btEstadisticas.setText("Estadisticas");
        jPanel1.add(btEstadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 120, 40));

        btEnviarCarton.setText("Enviar Carton");
        jPanel1.add(btEnviarCarton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 120, 40));

        jButton9.setText("Salir");
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btEnviarCarton;
    public javax.swing.JButton btEstadisticas;
    public javax.swing.JButton btGenerar;
    public javax.swing.JButton btIniciar;
    public javax.swing.JButton btRegistrar;
    public javax.swing.JButton btVerCarton;
    private javax.swing.JButton jButton7;
    public javax.swing.JButton jButton9;
    public javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
