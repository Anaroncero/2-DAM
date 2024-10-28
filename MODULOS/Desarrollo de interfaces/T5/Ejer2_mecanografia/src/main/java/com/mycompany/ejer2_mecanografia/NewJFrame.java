/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ejer2_mecanografia;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author Ana
 */
public class NewJFrame extends javax.swing.JFrame {

    private char[] letrasABC = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private int indiceAleatorio;
    private char letraSeleccionada;
    private long comienzoTiempo, finTiempo;


    public NewJFrame() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jLabelEnunciado = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabelLetra = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabelTiempo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelEnunciado.setText("Juego presionar letra");
        jPanel4.add(jLabelEnunciado);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jPanel4, gridBagConstraints);

        jPanel5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel5KeyPressed(evt);
            }
        });
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabelLetra.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        jLabelLetra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLetra.setText("-");
        jLabelLetra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabelLetraKeyPressed(evt);
            }
        });
        jPanel5.add(jLabelLetra, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.8;
        getContentPane().add(jPanel5, gridBagConstraints);

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1);

        jLabelTiempo.setMinimumSize(new java.awt.Dimension(50, 0));
        jLabelTiempo.setPreferredSize(new java.awt.Dimension(50, 0));
        jPanel6.add(jLabelTiempo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jPanel6, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Cuando pulse iniciar salga una letra aleatoria de un array con el abecedario
        jLabelEnunciado.setText("Presiona la tecla... ¡Rápido!");
        
        comienzoTiempo = System.currentTimeMillis();
        indiceAleatorio = (int) (Math.random() * letrasABC.length); //numero aleatorio entre 0 y longitud del array
        
        jLabelLetra.setText(""+ letrasABC[indiceAleatorio]);
        
        /*for (int i = 0; i < letrasABC.length; i++) {
            letraSeleccionada = letrasABC[indiceAleatorio];
            jLabelLetra.setText("" + letraSeleccionada);

        }*/
        
        //Le pongo el foco al panel
        jPanel5.requestFocus();

        


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabelLetraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabelLetraKeyPressed
        
    }//GEN-LAST:event_jLabelLetraKeyPressed

    private void jPanel5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel5KeyPressed
        // Evento tecla 
        finTiempo = System.currentTimeMillis();
        
        if(evt.getKeyChar() == letrasABC[indiceAleatorio]){ //me da la letra presionada en char comparamos si coincide con la del array
            jLabelTiempo.setText("Correcto! en: " + ((finTiempo-comienzoTiempo)/1000) + " segundos"); //entre mil para que lo imprima en segundos
            jLabelLetra.setForeground(Color.GREEN);
        }else{
            jLabelTiempo.setText("Incorrecto!");
            jLabelLetra.setForeground(Color.RED);
        }
    }//GEN-LAST:event_jPanel5KeyPressed

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf()); //Clase UI que dentro tiene un LookAndFeel y importamos la clase FlatDarkLaf

        } catch (Exception e) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelEnunciado;
    private javax.swing.JLabel jLabelLetra;
    private javax.swing.JLabel jLabelTiempo;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
