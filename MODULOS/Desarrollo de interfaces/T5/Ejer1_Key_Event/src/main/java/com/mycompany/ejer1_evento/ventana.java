/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ejer1_evento;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.TrayIcon;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Ana
 */
public class ventana extends javax.swing.JFrame {

    public ventana() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JFrame");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel.setText("Hola");
        jLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
//Ejercicio 1 Mover JLabel con flechas

    //Este evento detecta que ocurre algo en un teclado        
    //Key Pressed en el Frame (porque esta "escuchando")

        //Capturar coordenadas
        int x = jLabel.getX();
        int y = jLabel.getY();

        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_W){ //coge la tecla presionada de evt(tecladp) y si es igual que keyEvnet que haga ño siguiente
            jLabel.setLocation(x, y - 10); //le restas 10 a la y entonces subes
        }
        if(evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_S){ //coge la tecla presionada de evt(tecladp) y si es igual que keyEvnet que haga ño siguiente
            jLabel.setLocation(x, y + 10); //le restas 10 a la y entonces subes
        }
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_D){ //coge la tecla presionada de evt(tecladp) y si es igual que keyEvnet que haga ño siguiente
            jLabel.setLocation(x + 10, y); //le restas 10 a la y entonces subes
        }
        if(evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_A){ //coge la tecla presionada de evt(tecladp) y si es igual que keyEvnet que haga ño siguiente
            jLabel.setLocation(x - 10, y - 10); //le restas 10 a la y entonces subes
        }
        
        
        //Ejercicio2 mostrar dialogo de ayuda cuando pulsamos la tecla f1
        if(evt.getKeyCode() == KeyEvent.VK_F1){ 
            mostrarDialogoAyuda();
        }
        
        
        //Ejercicio 3 
        //Maximizar pulsando F2
        if(evt.getKeyCode() == KeyEvent.VK_F2){
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        //Normal pulsando F3
        if(evt.getKeyCode() == KeyEvent.VK_F3){
            setExtendedState(JFrame.NORMAL);
        }
        //Minimizar pulsado F4
        if(evt.getKeyCode() == KeyEvent.VK_F4){
            setExtendedState(JFrame.ICONIFIED);
        }
        
        

    }//GEN-LAST:event_formKeyPressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf()); //Clase UI que dentro tiene un LookAndFeel y importamos la clase FlatDarkLaf

        } catch (Exception e) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
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
    private javax.swing.JLabel jLabel;
    // End of variables declaration//GEN-END:variables

    private void mostrarDialogoAyuda() {
        JDialog dialogoAyuda = new JDialog(this, "Ayuda", true);
        dialogoAyuda.setSize(300, 200);
        JLabel mensaje = new JLabel("Esta es una ventana de ayuda");
        dialogoAyuda.add(mensaje);
        dialogoAyuda.setVisible(true);
        
    }
}
