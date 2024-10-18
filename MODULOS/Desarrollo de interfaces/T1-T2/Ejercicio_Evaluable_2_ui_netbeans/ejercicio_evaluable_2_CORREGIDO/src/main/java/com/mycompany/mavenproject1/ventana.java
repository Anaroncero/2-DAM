/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

import javax.swing.JOptionPane;

/**
 *
 * @author Ana Pastor Roncero
 */
public class ventana extends javax.swing.JFrame {

    public ventana() {
        initComponents();
comentarioInput.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        nombreOut = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonAutor = new javax.swing.JButton();
        Python = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPaneJava = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textPanePython = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textPaneC = new javax.swing.JTextPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        textPaneJavaScript = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombreInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        valorVariable = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        checkBox = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        comentarioInput = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        verCodigo = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tipoLenguaje = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 487));
        setPreferredSize(new java.awt.Dimension(800, 487));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.GridBagLayout());

        nombreOut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nombreOut.setForeground(new java.awt.Color(255, 102, 204));
        nombreOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombreOut.setToolTipText("");
        nombreOut.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        nombreOut.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 20, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.2;
        jPanel2.add(nombreOut, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Aprender a crear variables en diferentes lenguajes de programación");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.weighty = 0.8;
        jPanel2.add(jLabel1, gridBagConstraints);

        buttonAutor.setBackground(new java.awt.Color(204, 204, 204));
        buttonAutor.setText("Autor/a");
        buttonAutor.setBorder(null);
        buttonAutor.setPreferredSize(new java.awt.Dimension(41, 34));
        buttonAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAutorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.8;
        jPanel2.add(buttonAutor, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(jPanel2, gridBagConstraints);

        Python.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));

        jScrollPane2.setViewportView(textPaneJava);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        Python.addTab("Java", jPanel7);

        jScrollPane3.setViewportView(textPanePython);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        Python.addTab("Python", jPanel1);

        jScrollPane4.setViewportView(textPaneC);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        Python.addTab("C#", jPanel4);

        jScrollPane5.setViewportView(textPaneJavaScript);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        Python.addTab("JavaScript", jPanel6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        getContentPane().add(Python, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.GridLayout(8, 2, 10, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Configura tu variable:");
        jPanel3.add(jLabel2);
        jPanel3.add(jLabel3);

        jLabel5.setText("Nombre de la variable:");
        jPanel3.add(jLabel5);
        jPanel3.add(nombreInput);

        jLabel4.setText("Tipo de variable:");
        jPanel3.add(jLabel4);

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "char", "String", "int", "double" }));
        jPanel3.add(comboBox);

        jLabel6.setText("Valor de la variable:");
        jPanel3.add(jLabel6);
        jPanel3.add(valorVariable);

        jLabel7.setText("Añadir un comentario:");
        jPanel3.add(jLabel7);

        checkBox.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        checkBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        checkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });
        jPanel3.add(checkBox);

        jLabel9.setText("Comentario:");
        jPanel3.add(jLabel9);
        jPanel3.add(jLabel10);

        comentarioInput.setColumns(20);
        comentarioInput.setRows(5);
        jScrollPane1.setViewportView(comentarioInput);

        jPanel3.add(jScrollPane1);
        jPanel3.add(jLabel11);

        verCodigo.setText("Ver código");
        verCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCodigoActionPerformed(evt);
            }
        });
        jPanel3.add(verCodigo);
        jPanel3.add(jLabel12);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        getContentPane().add(jPanel3, gridBagConstraints);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel8.setText("Exportar código en formato: ");
        jPanel5.add(jLabel8);

        tipoLenguaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Java", "Python", "C#", "JavaScript" }));
        jPanel5.add(tipoLenguaje);

        jButton3.setText("Exportar");
        jPanel5.add(jButton3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(jPanel5, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAutorActionPerformed
        nombreOut.setText("Ana");
    }//GEN-LAST:event_buttonAutorActionPerformed

    private void verCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCodigoActionPerformed
        // Botón ver código:
        
        //Compruebo que los campos nombreInput y valorVariable no esten vacios
        if (nombreInput.getText().isEmpty() || valorVariable.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Introduzca nombre de la variable y un valor.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Cojo los valores introducidos
        String varName = nombreInput.getText();
        String vaRValorVariable = valorVariable.getText();
        String varComentario = comentarioInput.getText();
        
        //Creo una variable de inicio de comentarios vacio
        String comentarioBarras = "";
        
        //Si hay escrito comentarios cambia el valor de la variable comentarios para poner antes las dos barras
        if(!varComentario.isEmpty()){
        boolean hayComentario = true;
        comentarioBarras = "\\\\";
        }
        
        //Cojo el tipo seleccionado de variable en el comboBox
        String tipoSeleccionado = comboBox.getSelectedItem().toString();
        
        //Dependiendo que tipo de variable coja en el comboBox se ponen comillas en los char o string o noy se convierte el texto a int, double, char o int
        if (tipoSeleccionado.equals("int")) {
            if (vaRValorVariable.matches("\\d+")) { //comprobar que sean numeros
                int valorVariable = Integer.parseInt(vaRValorVariable);
                textPaneJava.setText(tipoSeleccionado + " " + varName + " = " + valorVariable + "; " + comentarioBarras+ varComentario);
                textPanePython.setText(varName + " = " + valorVariable + "; " + comentarioBarras+ varComentario);
            } else {
                JOptionPane.showMessageDialog(null, "Error: El valor debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (tipoSeleccionado.equals("double")) {
            if (vaRValorVariable.matches("[-+]?\\d*\\.\\d+|[-+]?\\d+")) { //comprobar que es un número decimal
                double valorVariable = Double.parseDouble(vaRValorVariable);
                textPaneJava.setText(tipoSeleccionado + " " + varName + " = " + valorVariable + "; " + comentarioBarras+ varComentario);
                textPanePython.setText(varName + " = " + valorVariable + "; " + comentarioBarras+ varComentario);
            } else {
                JOptionPane.showMessageDialog(null, "Error: El valor debe ser un número decimal.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (tipoSeleccionado.equals("char")) {
            if (vaRValorVariable.length() == 1) {
                char valorVariable = vaRValorVariable.charAt(0);
                textPaneJava.setText(tipoSeleccionado + " " + varName + " = '" + vaRValorVariable + "'; " + comentarioBarras+ varComentario);
                textPanePython.setText(varName + " = '" + vaRValorVariable + "'; " + comentarioBarras+ varComentario);
            } else {
                JOptionPane.showMessageDialog(null, "Error: El valor debe ser un solo carácter.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (tipoSeleccionado.equals("String")) {
            textPaneJava.setText(tipoSeleccionado + " " + varName + " = \"" + vaRValorVariable + "\"; " + comentarioBarras+ varComentario);
            textPanePython.setText(varName + " = \"" + vaRValorVariable + "\"; " + comentarioBarras+ varComentario);
        }


    }//GEN-LAST:event_verCodigoActionPerformed

    private void checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxActionPerformed
      
        //Comprobar si se ha selecionado el checkBox para poder habilitar comentarios o no
        if (checkBox.isSelected()) {
            comentarioInput.setEnabled(true);
        } else {
            comentarioInput.setEnabled(false);
            comentarioInput.setText("");
        }

    }//GEN-LAST:event_checkBoxActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Python;
    private javax.swing.JButton buttonAutor;
    private javax.swing.JCheckBox checkBox;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JTextArea comentarioInput;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField nombreInput;
    private javax.swing.JLabel nombreOut;
    private javax.swing.JTextPane textPaneC;
    private javax.swing.JTextPane textPaneJava;
    private javax.swing.JTextPane textPaneJavaScript;
    private javax.swing.JTextPane textPanePython;
    private javax.swing.JComboBox<String> tipoLenguaje;
    private javax.swing.JTextField valorVariable;
    private javax.swing.JButton verCodigo;
    // End of variables declaration//GEN-END:variables
}
