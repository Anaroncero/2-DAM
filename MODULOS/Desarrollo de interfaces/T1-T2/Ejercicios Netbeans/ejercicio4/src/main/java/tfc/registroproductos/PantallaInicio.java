/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tfc.registroproductos;

/**
 *
 * @author Ana
 */
public class PantallaInicio extends javax.swing.JFrame {

    /**
     * Creates new form PantallaInicio
     */
    public PantallaInicio() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setAlignmentX(20.0F);
        jPanel1.setAlignmentY(29.0F);
        jPanel1.setLayout(new java.awt.GridLayout(5, 2, 20, 20));

        jLabel13.setText("Producto:");
        jPanel1.add(jLabel13);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);

        jLabel14.setText("Marca");
        jPanel1.add(jLabel14);
        jPanel1.add(jTextField2);

        jLabel15.setText("Categoría:");
        jPanel1.add(jLabel15);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Portatiles", "Moviles", "Ratones", "Monitores" }));
        jPanel1.add(jComboBox1);

        jLabel16.setText("Cantidad:");
        jPanel1.add(jLabel16);
        jPanel1.add(jTextField3);

        jLabel17.setText("Precio Unitario:");
        jPanel1.add(jLabel17);
        jPanel1.add(jTextField5);

        getContentPane().add(jPanel1);

        jPanel2.setPreferredSize(new java.awt.Dimension(455, 50));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 50));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Creo variables 
        
        String producto = jTextField1.getText();
        String marca = jTextField2.getText();
        String categoria = jComboBox1.getSelectedItem().toString();
        String cantidad = jTextField3.getText();
        String precio = jTextField5.getText();
        
        String parrafo = "el producto " + producto + "\nde la marca " +  marca + "\nde la categoria " + categoria + "\ncon el precio unitario " + precio + "\n" + cantidad + " productos ";

        
        //Creo ventana y obtengo el texto
        Ventana2 ventana2 = new Ventana2();
        ventana2.obtenerTexto(parrafo);
        ventana2.setVisible(true);
        
        
        setVisible(false);
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PantallaInicio Ventana1 = new PantallaInicio();

                Ventana1.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    
    //metodo volver a inicio
    public void VolverInico() {
    jTextField1.setText(" ");
    jTextField2.setText(" ");
    jTextField3.setText(" ");
    jTextField5.setText(" ");
    
        setVisible(true);
        
       
    }
}
