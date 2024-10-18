/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ejercicio6;

import java.awt.CardLayout; //0.Importar manejador de paneles
/**
 * @author Ana
 */
public class ventana extends javax.swing.JFrame {

    public ventana() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonInicio = new javax.swing.JButton();
        jButtonSistema = new javax.swing.JButton();
        jButtonRed = new javax.swing.JButton();
        jButtonCuentas = new javax.swing.JButton();
        jButtonWindows = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel1.setLayout(new java.awt.GridLayout(6, 1, 10, 10));

        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1);

        jButtonInicio.setText("Inicio");
        jPanel1.add(jButtonInicio);

        jButtonSistema.setText("Sistema");
        jButtonSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSistemaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSistema);

        jButtonRed.setText("Red e Internet");
        jPanel1.add(jButtonRed);

        jButtonCuentas.setText("Cuentas");
        jPanel1.add(jButtonCuentas);

        jButtonWindows.setText("Windows Update");
        jPanel1.add(jButtonWindows);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setMinimumSize(new java.awt.Dimension(600, 500));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 500));
        jPanel2.setLayout(new java.awt.CardLayout());
        jPanel2.add(jLabel2, "card2");

        getContentPane().add(jPanel2, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSistemaActionPerformed

    }//GEN-LAST:event_jButtonSistemaActionPerformed

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
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCuentas;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonRed;
    private javax.swing.JButton jButtonSistema;
    private javax.swing.JButton jButtonWindows;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
