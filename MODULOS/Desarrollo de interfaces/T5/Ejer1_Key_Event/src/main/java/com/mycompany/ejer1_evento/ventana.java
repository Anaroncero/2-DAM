/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ejer1_evento;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.TextArea;
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

/*
Ejercicio 5_1
Diseña una interfaz que contenga en la parte superior un título (“aprendiendo eventos de teclado”), un botón que ponga “Ayuda (F1)”, dos JLabel para mostrar coordenadas y un botón de Guardar. 
En la parte inferior tendrá un panel grande tan solo con un JLabel en el centro (con el texto que tú quieras).

Programa eventos de teclado con KeyListener para que se puedan realizar las siguientes acciones:

Que el JLabel se mueva con las teclas de flechas arriba, abajo, derecha e izquierda.
Que las teclas R, G, B cambian el texto del JLabel a Rojo, Verde y Azul.
Que se muestren en los JLabel superiores, en todo momento, las coordenadas donde se encuentra el JLabel.
Que al pulsar el botón “Ayuda F1” se abra un JDialog de ayuda que indique todos los atajos de teclado de esta app.
Que la ayuda también aparezca al presionar F1, no solo al presionar el botón.
Que al presionar F2 se maximice la pantalla.
Que al presionar F3 se vuelva al tamaño original de la pantalla.
Que al presionar F4 se minimice la pantalla.
El botón de guardar guarda la posición y al volver a abrir el programa el texto aparece en la posición donde se quedó al cerrarlo la última vez.

 */
public class ventana extends javax.swing.JFrame {

    public ventana() {
        initComponents();
         setLocationRelativeTo(null); 
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jX = new javax.swing.JLabel();
        jY = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JFrame");
        setMinimumSize(new java.awt.Dimension(504, 300));
        setPreferredSize(new java.awt.Dimension(504, 300));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Aprendiendo eventos de teclado");
        jPanel1.add(jLabel1);

        jButton1.setText("Ayuda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jX.setText("x:");
        jX.setPreferredSize(new java.awt.Dimension(50, 16));
        jPanel1.add(jX);

        jY.setText("y:");
        jY.setPreferredSize(new java.awt.Dimension(50, 16));
        jPanel1.add(jY);

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setMinimumSize(new java.awt.Dimension(400, 300));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });
        jPanel2.setLayout(null);

        jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel.setText("Texto");
        jLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabelKeyPressed(evt);
            }
        });
        jPanel2.add(jLabel);
        jLabel.setBounds(230, 110, 37, 16);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.9;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabelKeyPressed

    }//GEN-LAST:event_jLabelKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed


    }//GEN-LAST:event_formKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Que al pulsar el botón “Ayuda F1” se abra un JDialog de ayuda que indique todos los atajos de teclado de esta app.
        mostrarDialogoAyuda();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        // Evento tecla en el panel (para que se mueva el texto si añadimos botones)

        //Ejercicio 1 Que el JLabel se mueva con las teclas de flechas arriba, abajo, derecha e izquierda.
        //Este evento detecta que ocurre algo en un teclado        
        //Key Pressed en el Frame (porque esta "escuchando")
        //Capturar coordenadas
        int x = jLabel.getX();
        int y = jLabel.getY();

        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_W) { //coge la tecla presionada de evt(tecladp) y si es igual que keyEvnet que haga ño siguiente
            jLabel.setLocation(x, y - 10); //le restas 10 a la y entonces subes
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_S) { //coge la tecla presionada de evt(tecladp) y si es igual que keyEvnet que haga ño siguiente
            jLabel.setLocation(x, y + 10); //le restas 10 a la y entonces subes
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_D) { //coge la tecla presionada de evt(tecladp) y si es igual que keyEvnet que haga ño siguiente
            jLabel.setLocation(x + 10, y); //le restas 10 a la y entonces subes
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_A) { //coge la tecla presionada de evt(tecladp) y si es igual que keyEvnet que haga ño siguiente
            jLabel.setLocation(x - 10, y); //le restas 10 a la y entonces subes
        }

        // Que las teclas R, G, B cambian el texto del JLabel a Rojo, Verde y Azul.
        if (evt.getKeyCode() == KeyEvent.VK_R) {
            jLabel.setForeground(Color.red); // Cambiar color
        }
        if (evt.getKeyCode() == KeyEvent.VK_G) {
            jLabel.setForeground(Color.green);
        }
        if (evt.getKeyCode() == KeyEvent.VK_B) {
            jLabel.setForeground(Color.blue);
        }

        //Ejercicio2 mostrar dialogo de ayuda cuando pulsamos la tecla f1
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            mostrarDialogoAyuda(); // Llama al método
        }

        //Ejercicio 3 
        //Maximizar pulsando F2
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        //Normal pulsando F3
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            setExtendedState(JFrame.NORMAL);
        }
        //Minimizar pulsado F4
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            setExtendedState(JFrame.ICONIFIED);
        }

        // Que se muestren en los JLabel superiores, en todo momento, las coordenadas donde se encuentra el JLabel. jX jY
        jX.setText("x: " + x);
        jY.setText("y: " + y);

    }//GEN-LAST:event_jPanel2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // El botón de guardar guarda la posición y al volver a abrir el programa el texto aparece en la posición donde se quedó al cerrarlo la última vez.
        
        /* todo el codigo de guardar, Como las varaibles desaparecen al cerrar programa 
           se tiene que usar una base de datos o un fichero donde se almacenen  */
        
        
        // En propiedades también podemos quitarle el foco a los botones 
        jPanel2.requestFocus(); // Al llamar a este método, estás pidiendo que el panel jPanel2 reciba el foco de teclado
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf()); //Clase UI que dentro tiene un LookAndFeel y importamos la clase FlatDarkLaf

        } catch (Exception e) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana().setVisible(true);
                //Tenemos que poner la variable (jPanel como statico en propiedades)
                jPanel2.requestFocus(); // poner el panel2 el del texto (que queremos que se mueva) como principal para que funcione
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jX;
    private javax.swing.JLabel jY;
    // End of variables declaration//GEN-END:variables

    //Método Mostrar dialogo
    private void mostrarDialogoAyuda() {
        JDialog dialogoAyuda = new JDialog(this, "Ayuda", true);
        dialogoAyuda.setSize(300, 200);
        JLabel mensaje = new JLabel("<html>Esta es una ventana de ayuda<br>F1: Ayuda <br>F2: Maximizar <br>F3: Normal <br>F4: Minimizar</html>");
        //TextArea mensaje = new TextArea("Esta es una ventana de ayuda. F2: Maximizar, F3: Normal, F4: Minimizar");
        mensaje.setHorizontalAlignment(jLabel.CENTER); //centrar mensaje
        dialogoAyuda.add(mensaje);
        dialogoAyuda.setLocationRelativeTo(null);
        dialogoAyuda.setVisible(true);

    }
}
