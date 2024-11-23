/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ejer_evaluable_4_ux_reportes_ana;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ana
 */
public class ventana extends javax.swing.JFrame {

    /**
     * Creates new form ventana
     */
    public ventana() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreInput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        nDI = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        nPMD = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        nPSP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        nAD = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        nSGE = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        nEIE = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        nI = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        buttonGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(3, 1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("INSTITUTO DE FORMACIÓN PROFESIONAL");
        jPanel4.add(jLabel8);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("REALIZACIÓN DE CERTIFICADO ACADÉMICO PERSONAL");
        jPanel4.add(jLabel9);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CFGS DAM - SEGUNDO CURSO");
        jPanel4.add(jLabel10);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridLayout(10, 3));

        jLabel18.setText(" ");
        jLabel18.setMaximumSize(new java.awt.Dimension(20, 16));
        jLabel18.setMinimumSize(new java.awt.Dimension(20, 16));
        jLabel18.setPreferredSize(new java.awt.Dimension(20, 16));
        jPanel2.add(jLabel18);
        jPanel2.add(jLabel17);

        jLabel19.setText(" ");
        jPanel2.add(jLabel19);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nombre Alumno: ");
        jPanel2.add(jLabel4);
        jPanel2.add(jLabel2);

        nombreInput.setMaximumSize(new java.awt.Dimension(40, 26));
        nombreInput.setMinimumSize(new java.awt.Dimension(40, 26));
        nombreInput.setName(""); // NOI18N
        nombreInput.setPreferredSize(new java.awt.Dimension(40, 26));
        nombreInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreInputActionPerformed(evt);
            }
        });
        jPanel2.add(nombreInput);

        jLabel6.setText("Desarrollo de interfaces:");
        jPanel2.add(jLabel6);

        jLabel20.setText(" ");
        jPanel2.add(jLabel20);

        nDI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nDIActionPerformed(evt);
            }
        });
        jPanel2.add(nDI);

        jLabel13.setText("Programación Multimedia y Dispositivos Móviles");
        jPanel2.add(jLabel13);

        jLabel21.setText(" ");
        jPanel2.add(jLabel21);
        jPanel2.add(nPMD);

        jLabel15.setText("Programación de Servicios y Procesos:");
        jPanel2.add(jLabel15);

        jLabel22.setText(" ");
        jPanel2.add(jLabel22);
        jPanel2.add(nPSP);

        jLabel12.setText("Acceso a Datos:");
        jPanel2.add(jLabel12);

        jLabel23.setText(" ");
        jPanel2.add(jLabel23);

        nAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nADActionPerformed(evt);
            }
        });
        jPanel2.add(nAD);

        jLabel11.setText("Sistemas de Gestión Empresarial:");
        jPanel2.add(jLabel11);

        jLabel24.setText(" ");
        jPanel2.add(jLabel24);

        nSGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nSGEActionPerformed(evt);
            }
        });
        jPanel2.add(nSGE);

        jLabel7.setText("Empresas e Iniciativa Emprendedora:");
        jPanel2.add(jLabel7);

        jLabel25.setText(" ");
        jPanel2.add(jLabel25);
        jPanel2.add(nEIE);

        jLabel14.setText("Inglés:");
        jPanel2.add(jLabel14);

        jLabel26.setText(" ");
        jPanel2.add(jLabel26);
        jPanel2.add(nI);
        jPanel2.add(jLabel16);

        jLabel5.setText("  ");
        jPanel2.add(jLabel5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        getContentPane().add(jPanel2, gridBagConstraints);

        buttonGenerar.setBackground(new java.awt.Color(0, 0, 102));
        buttonGenerar.setForeground(new java.awt.Color(255, 255, 255));
        buttonGenerar.setText("generar");
        buttonGenerar.setMaximumSize(new java.awt.Dimension(130, 27));
        buttonGenerar.setMinimumSize(new java.awt.Dimension(130, 27));
        buttonGenerar.setPreferredSize(new java.awt.Dimension(130, 27));
        buttonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerarActionPerformed(evt);
            }
        });
        jPanel3.add(buttonGenerar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(jPanel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreInputActionPerformed

    private void nDIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nDIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nDIActionPerformed

    private void buttonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerarActionPerformed
        //En un txt guardamos el valor en un txt, si volvemos a ejecutar el programa empezara la variable en el txt
        //y asi el contador empezaria por donde se quedo y si volvemos a hacer facturas, ya no se soobrescribiran al ejecutar
        //de nuevo el programa empezaría de 0

        //FICHERO TXT ALMACENA EL CONTADOR
        int contador = 0;

        // Definir la ruta del archivo donde se guardará el contador
        String rutaContador = "E:\\GitHub\\2-DAM\\MODULOS\\Desarrollo de interfaces\\Primer Trimestre\\T8-T9\\ejer_evaluable_4_ux_reportes_Ana\\contador.txt";

        // Cargar contador desde el archivo
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaContador))) {
            String line = reader.readLine();
            if (line != null) {
                contador = Integer.parseInt(line);
            }
        } catch (IOException | NumberFormatException e) {
            // Si el archivo no existe o hay un error, se crea el archivo y el contador se queda en 0
            contador = 0;
            try {
                // Crear el archivo si no existe
                new FileWriter(rutaContador).close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        contador++; // Incrementar el contador

        // Guardar el contador actualizado en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaContador))) {
            writer.write(String.valueOf(contador));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar el contador:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        //GENERAR REPORTE..............................................................
        // Obtener el texto del JTextField lo que ha escrito el usuario
        String nombre = nombreInput.getText();
        int notaDI = Integer.parseInt(nDI.getText());
        int notaPMD = Integer.parseInt(nPMD.getText());
        int notaPSD = Integer.parseInt(nPSP.getText());
        int notaAD = Integer.parseInt(nAD.getText());
        int notanSGE = Integer.parseInt(nSGE.getText());
        int notanEIE = Integer.parseInt(nEIE.getText());
        int notaI = Integer.parseInt(nI.getText());

        try {
            // Cargar el diseño del reporte
            InputStream reportStream = getClass().getResourceAsStream("/reporteMedac.jrxml");
            //compila el diseño:
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Prepara parámetros para enviar al reporte
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("nombre", nombre); //nombre del parametro y el texto que vamos a meterle
            parameters.put("n1", notaDI);
            parameters.put("n2", notaPMD);
            parameters.put("n3", notaPSD);
            parameters.put("n4", notaAD);
            parameters.put("n5", notanSGE);
            parameters.put("n6", notanEIE);
            parameters.put("n7", notaI);

            // RELLENA CON XML Generar el reporte con los parámetros (Rellena con los parametros) 
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            // Exportar el reporte a un archivo PDF
            String outputPdfPath = "CertificadoAcademico_" + nombre + ".pdf"; //RUTA DONDE QUIERO GUARDARLO COMO PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputPdfPath);

            // Mostrar el reporte en una ventana
            JasperViewer.viewReport(jasperPrint, false);

            // Confirmación de éxito
            JOptionPane.showMessageDialog(null, "El reporte ha sido generado correctamente como PDF.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (JRException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar el reporte:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_buttonGenerarActionPerformed

    private void nADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nADActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nADActionPerformed

    private void nSGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nSGEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nSGEActionPerformed

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
    private javax.swing.JButton buttonGenerar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nAD;
    private javax.swing.JTextField nDI;
    private javax.swing.JTextField nEIE;
    private javax.swing.JTextField nI;
    private javax.swing.JTextField nPMD;
    private javax.swing.JTextField nPSP;
    private javax.swing.JTextField nSGE;
    private javax.swing.JTextField nombreInput;
    // End of variables declaration//GEN-END:variables
}