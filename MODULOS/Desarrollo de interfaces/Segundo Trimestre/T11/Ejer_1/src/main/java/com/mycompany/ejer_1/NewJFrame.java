/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ejer_1;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

/**
 *
 * @author Ana
 */
public class NewJFrame extends javax.swing.JFrame {

    DefaultListModel<String> peliculas = new DefaultListModel<>(); //Suele llamarse modelo
    DefaultListModel<String> series = new DefaultListModel<>();
    int contadorPelis = 0;
    int contadorSeries = 0;

    public NewJFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonIngresar = new javax.swing.JButton();
        jComboBox = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        peliculasList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        seriesList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(453, 300));
        setPreferredSize(new java.awt.Dimension(453, 300));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Introducir nombre:");
        jPanel1.add(jLabel1);

        jTextField1.setMinimumSize(new java.awt.Dimension(90, 26));
        jTextField1.setPreferredSize(new java.awt.Dimension(90, 26));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);

        jButtonIngresar.setText("Ingresar");
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonIngresar);

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pelicula", "Serie", " " }));
        jPanel1.add(jComboBox);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel2.setLayout(new java.awt.BorderLayout());

        peliculasList.setMaximumSize(new java.awt.Dimension(30, 90));
        peliculasList.setMinimumSize(new java.awt.Dimension(30, 90));
        peliculasList.setPreferredSize(new java.awt.Dimension(30, 90));
        jScrollPane1.setViewportView(peliculasList);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel2.setText("Peliculas");
        jPanel2.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField3, java.awt.BorderLayout.PAGE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.8;
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel3.setLayout(new java.awt.BorderLayout());

        seriesList.setMaximumSize(new java.awt.Dimension(30, 90));
        seriesList.setMinimumSize(new java.awt.Dimension(30, 90));
        seriesList.setPreferredSize(new java.awt.Dimension(30, 90));
        jScrollPane2.setViewportView(seriesList);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jLabel3.setText("Series");
        jPanel3.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField2, java.awt.BorderLayout.PAGE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.8;
        getContentPane().add(jPanel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed

        //Comprobar si es pelicula o serie al añadirlo
        if (jComboBox.getSelectedItem().equals("Pelicula")) {
            peliculasList.setModel(peliculas); //se asocia el modelo a la lista
            peliculas.addElement(jTextField1.getText());
            contadorPelis++;
        } else {
            seriesList.setModel(series);
            series.addElement(jTextField1.getText());
            contadorSeries++;
        }

        //Comprobar cual tiene más con el contador
        if(contadorPelis > contadorSeries){
            jTextField3.setBackground(Color.green);
            jTextField2.setBackground(Color.red);
        }else if(contadorPelis == contadorSeries){
            jTextField3.setBackground(Color.green);
            jTextField2.setBackground(Color.green);
        }else {
            jTextField3.setBackground(Color.red);
            jTextField2.setBackground(Color.green);
        }
        
        

    }//GEN-LAST:event_jButtonIngresarActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        
    }//GEN-LAST:event_jTextField3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            SwingUtilities.updateComponentTreeUI(null);
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
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JList<String> peliculasList;
    private javax.swing.JList<String> seriesList;
    // End of variables declaration//GEN-END:variables
}
