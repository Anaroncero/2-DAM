/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ejer_2_elecciones;

import java.awt.Color;
import java.awt.Graphics;

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ppInput = new javax.swing.JTextField();
        psoeInput = new javax.swing.JTextField();
        sumarInput = new javax.swing.JTextField();
        voxInput = new javax.swing.JTextField();
        buttonGrafica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PP:");

        jLabel2.setText("PSOE:");

        jLabel3.setText("Sumar:");

        jLabel4.setText("Vox:");

        ppInput.setText(" ");

        psoeInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psoeInputActionPerformed(evt);
            }
        });

        sumarInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumarInputActionPerformed(evt);
            }
        });

        buttonGrafica.setText("Gráfica");
        buttonGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGraficaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(psoeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ppInput, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sumarInput, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(voxInput, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(buttonGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ppInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(psoeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sumarInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(voxInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void psoeInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psoeInputActionPerformed

    }//GEN-LAST:event_psoeInputActionPerformed

    private void sumarInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumarInputActionPerformed


    }//GEN-LAST:event_sumarInputActionPerformed

    private void buttonGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGraficaActionPerformed
        repaint();

    }//GEN-LAST:event_buttonGraficaActionPerformed

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
            @Override
            public void run() {
                new ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGrafica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField ppInput;
    private javax.swing.JTextField psoeInput;
    private javax.swing.JTextField sumarInput;
    private javax.swing.JTextField voxInput;
    // End of variables declaration//GEN-END:variables

    //Creo el método 
    public void paint(Graphics g) { //le paso objeto Graphics
        super.paint(g);

        if (ppInput.getText().isEmpty() || psoeInput.getText().isEmpty()
                || sumarInput.getText().isEmpty() || voxInput.getText().isEmpty()) {
            return; // No dibujar si faltan 
        }

        int ppValue = Integer.parseInt(ppInput.getText());
        int psoeValue = Integer.parseInt(psoeInput.getText());
        int sumarValue = Integer.parseInt(sumarInput.getText());
        int voxValue = Integer.parseInt(voxInput.getText());

        int totalVotos = ppValue + psoeValue + sumarValue + voxValue;

        int gradosPP = ppValue * 360 / totalVotos;
        int gradosPsoe = psoeValue * 360 / totalVotos;
        int gradosSumar = sumarValue * 360 / totalVotos;
        int gradosVox = voxValue * 360 / totalVotos;

        int inicio = 0;
        // Partido PSOE
        g.setColor(new Color(18, 196, 214)); // Color para PSOE
        g.fillArc(25, 80, 200, 200, inicio, gradosPsoe);
        inicio += gradosPsoe;

        // Partido Vox
        g.setColor(new Color(255, 0, 0)); // Color para Vox
        g.fillArc(25, 80, 200, 200, inicio, gradosVox);
        inicio += gradosVox;

        // Partido PP
        g.setColor(new Color(178, 0, 203)); // Color para PP
        g.fillArc(25, 80, 200, 200, inicio, gradosPP);
        inicio += gradosPP;

        // Partido Sumar
        g.setColor(new Color(22, 203, 0)); // Color para Sumar
        g.fillArc(25, 80, 200, 200, inicio, gradosSumar);

        //votos /360 x 100
        /*
        g.setColor(new Color(0,120,120));
        g.fillArc(100, 100, 200, 200, 0, 90); //x y ancho alto anguloinicio0º angulofin45º
        
        g.setColor(new Color(250,0,0));
        g.fillArc(100, 100, 200, 200, 90, 90); //el angulo que empieza y cuantos angulos abarca
         */
        //Que cunado ponga los numeros de botos (no porcentaje me haga el dibujo)
    }

}
