/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

/**
 *
 * @author User
 */
public class Juego extends javax.swing.JPanel {

    /**
     * Creates new form Juego
     */
    public Juego() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbPremio = new javax.swing.JLabel();
        btCantarNumero = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        lbCartones = new javax.swing.JLabel();
        lbJugadores = new javax.swing.JLabel();
        lbTipoJuego = new javax.swing.JLabel();
        btRegresar = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(51, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Tipo de Juego:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("Total Cartones");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        jLabel3.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Total jugadores");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 320, -1, -1));

        jLabel4.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Premio:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 10, -1, -1));

        lbPremio.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbPremio.setForeground(new java.awt.Color(255, 153, 0));
        lbPremio.setText("x");
        add(lbPremio, new org.netbeans.lib.awtextra.AbsoluteConstraints(749, 10, 91, 39));

        btCantarNumero.setBackground(new java.awt.Color(102, 102, 102));
        btCantarNumero.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        btCantarNumero.setForeground(new java.awt.Color(255, 153, 0));
        btCantarNumero.setText("Cantar Numero");
        btCantarNumero.setActionCommand("1");
        btCantarNumero.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btCantarNumero.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btCantarNumeroActionPerformed(evt);
            }
        });
        add(btCantarNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 79, 200, -1));

        jLabel6.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Numeros Cantados:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 137, -1, -1));

        jScrollPane1.setForeground(new java.awt.Color(255, 153, 0));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 194, 812, 79));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 10, 145, -1));

        lbCartones.setBackground(new java.awt.Color(255, 255, 255));
        lbCartones.setForeground(new java.awt.Color(255, 153, 0));
        lbCartones.setText("x");
        add(lbCartones, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 91, 39));

        lbJugadores.setForeground(new java.awt.Color(255, 153, 0));
        lbJugadores.setText("x");
        add(lbJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 320, 66, 39));

        lbTipoJuego.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        lbTipoJuego.setForeground(new java.awt.Color(255, 153, 0));
        lbTipoJuego.setText("x");
        add(lbTipoJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        btRegresar.setBackground(new java.awt.Color(102, 102, 102));
        btRegresar.setFont(new java.awt.Font("Viner Hand ITC", 0, 20)); // NOI18N
        btRegresar.setForeground(new java.awt.Color(255, 153, 0));
        btRegresar.setText("Regresar");
        btRegresar.setActionCommand("0");
        btRegresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(btRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btCantarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCantarNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCantarNumeroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btCantarNumero;
    public javax.swing.JButton btRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JLabel lbCartones;
    public javax.swing.JLabel lbJugadores;
    public javax.swing.JLabel lbPremio;
    public javax.swing.JLabel lbTipoJuego;
    // End of variables declaration//GEN-END:variables
}
