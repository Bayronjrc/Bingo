/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import modelo.Carton;

/**
 *
 * @author HP
 */
public final class VistaCarton extends javax.swing.JPanel
{
    
    /**
     * Creates new form Carton
     */
    public VistaCarton()
    {
        initComponents();
    }

    public void AgregarLabels(Carton objCarton)
    {
        this. lbl0.setText(String.valueOf(objCarton.getListaNumeros()[ 0]));
        this. lbl1.setText(String.valueOf(objCarton.getListaNumeros()[ 1]));
        this. lbl2.setText(String.valueOf(objCarton.getListaNumeros()[ 2]));
        this. lbl3.setText(String.valueOf(objCarton.getListaNumeros()[ 3]));
        this. lbl4.setText(String.valueOf(objCarton.getListaNumeros()[ 4]));
        this. lbl5.setText(String.valueOf(objCarton.getListaNumeros()[ 5]));
        this. lbl6.setText(String.valueOf(objCarton.getListaNumeros()[ 6]));
        this. lbl7.setText(String.valueOf(objCarton.getListaNumeros()[ 7]));
        this. lbl8.setText(String.valueOf(objCarton.getListaNumeros()[ 8]));
        this. lbl9.setText(String.valueOf(objCarton.getListaNumeros()[ 9]));
        this.lbl10.setText(String.valueOf(objCarton.getListaNumeros()[10]));
        this.lbl11.setText(String.valueOf(objCarton.getListaNumeros()[11]));
        this.lbl12.setText(String.valueOf(objCarton.getListaNumeros()[12]));
        this.lbl13.setText(String.valueOf(objCarton.getListaNumeros()[13]));
        this.lbl14.setText(String.valueOf(objCarton.getListaNumeros()[14]));
        this.lbl15.setText(String.valueOf(objCarton.getListaNumeros()[15]));
        this.lbl16.setText(String.valueOf(objCarton.getListaNumeros()[16]));
        this.lbl17.setText(String.valueOf(objCarton.getListaNumeros()[17]));
        this.lbl18.setText(String.valueOf(objCarton.getListaNumeros()[18]));
        this.lbl19.setText(String.valueOf(objCarton.getListaNumeros()[19]));
        this.lbl20.setText(String.valueOf(objCarton.getListaNumeros()[20]));
        this.lbl21.setText(String.valueOf(objCarton.getListaNumeros()[21]));
        this.lbl22.setText(String.valueOf(objCarton.getListaNumeros()[22]));
        this.lbl23.setText(String.valueOf(objCarton.getListaNumeros()[23]));
        this.lbl24.setText(String.valueOf(objCarton.getListaNumeros()[24]));
        this.lblIdentificador.setText(objCarton.getIdentificador());
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

        lbl0 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        lbl13 = new javax.swing.JLabel();
        lbl14 = new javax.swing.JLabel();
        lbl15 = new javax.swing.JLabel();
        lbl16 = new javax.swing.JLabel();
        lbl17 = new javax.swing.JLabel();
        lbl18 = new javax.swing.JLabel();
        lbl19 = new javax.swing.JLabel();
        lbl20 = new javax.swing.JLabel();
        lbl21 = new javax.swing.JLabel();
        lbl22 = new javax.swing.JLabel();
        lbl23 = new javax.swing.JLabel();
        lbl24 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblIdentificador = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(420, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl0.setBackground(new java.awt.Color(102, 102, 102));
        lbl0.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl0.setForeground(new java.awt.Color(255, 153, 0));
        lbl0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl0.setToolTipText("");
        lbl0.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 80, 70));

        lbl1.setBackground(new java.awt.Color(102, 102, 102));
        lbl1.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 153, 0));
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setToolTipText("");
        lbl1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 80, 70));

        lbl2.setBackground(new java.awt.Color(102, 102, 102));
        lbl2.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 153, 0));
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setToolTipText("");
        lbl2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 80, 70));

        lbl3.setBackground(new java.awt.Color(102, 102, 102));
        lbl3.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl3.setForeground(new java.awt.Color(255, 153, 0));
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl3.setToolTipText("");
        lbl3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 80, 70));

        lbl4.setBackground(new java.awt.Color(102, 102, 102));
        lbl4.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl4.setForeground(new java.awt.Color(255, 153, 0));
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl4.setToolTipText("");
        lbl4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 80, 70));

        lbl5.setBackground(new java.awt.Color(102, 102, 102));
        lbl5.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl5.setForeground(new java.awt.Color(255, 153, 0));
        lbl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl5.setToolTipText("");
        lbl5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 80, 70));

        lbl6.setBackground(new java.awt.Color(102, 102, 102));
        lbl6.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl6.setForeground(new java.awt.Color(255, 153, 0));
        lbl6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl6.setToolTipText("");
        lbl6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 80, 70));

        lbl7.setBackground(new java.awt.Color(102, 102, 102));
        lbl7.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl7.setForeground(new java.awt.Color(255, 153, 0));
        lbl7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl7.setToolTipText("");
        lbl7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 80, 70));

        lbl8.setBackground(new java.awt.Color(102, 102, 102));
        lbl8.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl8.setForeground(new java.awt.Color(255, 153, 0));
        lbl8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl8.setToolTipText("");
        lbl8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 80, 70));

        lbl9.setBackground(new java.awt.Color(102, 102, 102));
        lbl9.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl9.setForeground(new java.awt.Color(255, 153, 0));
        lbl9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl9.setToolTipText("");
        lbl9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 80, 70));

        lbl10.setBackground(new java.awt.Color(102, 102, 102));
        lbl10.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl10.setForeground(new java.awt.Color(255, 153, 0));
        lbl10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl10.setToolTipText("");
        lbl10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 80, 70));

        lbl11.setBackground(new java.awt.Color(102, 102, 102));
        lbl11.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl11.setForeground(new java.awt.Color(255, 153, 0));
        lbl11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl11.setToolTipText("");
        lbl11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 80, 70));

        lbl12.setBackground(new java.awt.Color(102, 102, 102));
        lbl12.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl12.setForeground(new java.awt.Color(255, 153, 0));
        lbl12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl12.setToolTipText("");
        lbl12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 80, 70));

        lbl13.setBackground(new java.awt.Color(102, 102, 102));
        lbl13.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl13.setForeground(new java.awt.Color(255, 153, 0));
        lbl13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl13.setToolTipText("");
        lbl13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 80, 70));

        lbl14.setBackground(new java.awt.Color(102, 102, 102));
        lbl14.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl14.setForeground(new java.awt.Color(255, 153, 0));
        lbl14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl14.setToolTipText("");
        lbl14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 80, 70));

        lbl15.setBackground(new java.awt.Color(102, 102, 102));
        lbl15.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl15.setForeground(new java.awt.Color(255, 153, 0));
        lbl15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl15.setToolTipText("");
        lbl15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 80, 70));

        lbl16.setBackground(new java.awt.Color(102, 102, 102));
        lbl16.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl16.setForeground(new java.awt.Color(255, 153, 0));
        lbl16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl16.setToolTipText("");
        lbl16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 80, 70));

        lbl17.setBackground(new java.awt.Color(102, 102, 102));
        lbl17.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl17.setForeground(new java.awt.Color(255, 153, 0));
        lbl17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl17.setToolTipText("");
        lbl17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 80, 70));

        lbl18.setBackground(new java.awt.Color(102, 102, 102));
        lbl18.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl18.setForeground(new java.awt.Color(255, 153, 0));
        lbl18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl18.setToolTipText("");
        lbl18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl18, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 80, 70));

        lbl19.setBackground(new java.awt.Color(102, 102, 102));
        lbl19.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl19.setForeground(new java.awt.Color(255, 153, 0));
        lbl19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl19.setToolTipText("");
        lbl19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 80, 70));

        lbl20.setBackground(new java.awt.Color(102, 102, 102));
        lbl20.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl20.setForeground(new java.awt.Color(255, 153, 0));
        lbl20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl20.setToolTipText("");
        lbl20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 80, 70));

        lbl21.setBackground(new java.awt.Color(102, 102, 102));
        lbl21.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl21.setForeground(new java.awt.Color(255, 153, 0));
        lbl21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl21.setToolTipText("");
        lbl21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 80, 70));

        lbl22.setBackground(new java.awt.Color(102, 102, 102));
        lbl22.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl22.setForeground(new java.awt.Color(255, 153, 0));
        lbl22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl22.setToolTipText("");
        lbl22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl22, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 80, 70));

        lbl23.setBackground(new java.awt.Color(102, 102, 102));
        lbl23.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl23.setForeground(new java.awt.Color(255, 153, 0));
        lbl23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl23.setToolTipText("");
        lbl23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 80, 70));

        lbl24.setBackground(new java.awt.Color(102, 102, 102));
        lbl24.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbl24.setForeground(new java.awt.Color(255, 153, 0));
        lbl24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl24.setToolTipText("");
        lbl24.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(lbl24, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 80, 70));

        lblTitulo.setFont(new java.awt.Font("Viner Hand ITC", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 153, 0));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("B I N G O !");
        lblTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 445, -1));

        lblIdentificador.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblIdentificador.setForeground(new java.awt.Color(255, 153, 0));
        lblIdentificador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lblIdentificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 445, -1));

        lblNombre.setFont(new java.awt.Font("Viner Hand ITC", 1, 30)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 153, 0));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 445, -1));

        lblCedula.setFont(new java.awt.Font("Viner Hand ITC", 1, 30)); // NOI18N
        lblCedula.setForeground(new java.awt.Color(255, 153, 0));
        lblCedula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lblCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 445, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lbl0;
    public javax.swing.JLabel lbl1;
    public javax.swing.JLabel lbl10;
    public javax.swing.JLabel lbl11;
    public javax.swing.JLabel lbl12;
    public javax.swing.JLabel lbl13;
    public javax.swing.JLabel lbl14;
    public javax.swing.JLabel lbl15;
    public javax.swing.JLabel lbl16;
    public javax.swing.JLabel lbl17;
    public javax.swing.JLabel lbl18;
    public javax.swing.JLabel lbl19;
    public javax.swing.JLabel lbl2;
    public javax.swing.JLabel lbl20;
    public javax.swing.JLabel lbl21;
    public javax.swing.JLabel lbl22;
    public javax.swing.JLabel lbl23;
    public javax.swing.JLabel lbl24;
    public javax.swing.JLabel lbl3;
    public javax.swing.JLabel lbl4;
    public javax.swing.JLabel lbl5;
    public javax.swing.JLabel lbl6;
    public javax.swing.JLabel lbl7;
    public javax.swing.JLabel lbl8;
    public javax.swing.JLabel lbl9;
    public javax.swing.JLabel lblCedula;
    public javax.swing.JLabel lblIdentificador;
    public javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
