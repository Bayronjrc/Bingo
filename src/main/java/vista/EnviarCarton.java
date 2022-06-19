/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

/**
 *
 * @author User
 */
public class EnviarCarton extends javax.swing.JPanel {

    /**
     * Creates new form EnviarCarton
     */
    public EnviarCarton() {
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

        jLabel2 = new javax.swing.JLabel();
        btEnviarCartones = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btRegresar = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 133, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cédula:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, -1));

        btEnviarCartones.setBackground(new java.awt.Color(102, 102, 102));
        btEnviarCartones.setFont(new java.awt.Font("Viner Hand ITC", 0, 20)); // NOI18N
        btEnviarCartones.setForeground(new java.awt.Color(255, 153, 0));
        btEnviarCartones.setText("Enviar Cartones Digitales");
        btEnviarCartones.setActionCommand("1");
        btEnviarCartones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(btEnviarCartones, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 270, -1));
        btEnviarCartones.getAccessibleContext().setAccessibleName("Enviar cartones digitales");

        txtCedula.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 262, 40));

        jLabel3.setFont(new java.awt.Font("Viner Hand ITC", 1, 47)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Enviar Cartón  a jugador registrado");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 840, -1));

        jLabel4.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 40));

        txtCantidad.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtCantidad.setToolTipText("Valor entre 1 y 500");
        txtCantidad.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtCantidadActionPerformed(evt);
            }
        });
        add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 230, 40));

        btRegresar.setBackground(new java.awt.Color(102, 102, 102));
        btRegresar.setFont(new java.awt.Font("Viner Hand ITC", 0, 20)); // NOI18N
        btRegresar.setForeground(new java.awt.Color(255, 153, 0));
        btRegresar.setText("Regresar");
        btRegresar.setActionCommand("0");
        btRegresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(btRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btEnviarCartones;
    public javax.swing.JButton btRegresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables
}
