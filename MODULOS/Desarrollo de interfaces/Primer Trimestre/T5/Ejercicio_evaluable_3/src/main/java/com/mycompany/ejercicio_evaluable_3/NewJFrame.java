
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ejercicio_evaluable_3;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Ana
 */
public class NewJFrame extends javax.swing.JFrame {

    //Variables para acceder desde el método y saber el estado actual de el color seleccionado y la negrita
    private String textoEscrito;
    private String colorHex = "#000000"; // Color predeterminado (negro)
    private boolean esNegrita = false; // Estado de negrita. Comienza en falso porque el texto no esta en negrita
    private String tipoLetra = "Georgia";
    private String[] fuentes = {"Impact", "Comic Sans MS", "Verdana"};
    private int letraSize;
    private static final String[] refranes = {
        "A mal tiempo, buena cara.",
        "A falta de pan, buenas son tortas.",
        "Más vale tarde que nunca.",
        "El que mucho abarca, poco aprieta.",
        "En boca cerrada no entran moscas.",
        "El que no arriesga no gana.",
        "Dime con quién andas y te diré quién eres.",
        "La avaricia rompe el saco.",
        "Quien siembra vientos, recoge tempestades.",
        "No hay mal que por bien no venga.",
        "Crea fama y échate a dormir.",
        "A perro flaco, todo son pulgas.",
        "Ojos que no ven, corazón que no siente.",
        "Más vale un pájaro en mano que cien volando.",
        "A palabras necias, oídos sordos.",
        "El que ríe último, ríe mejor.",
        "En casa de herrero, cuchillo de palo.",
        "Cuando el río suena, agua lleva.",
        "Dime de qué presumes y te diré de qué careces.",
        "El que espera, desespera.",
        "Cuando las barbas de tu vecino veas cortar, pon las tuyas a remojar.",
        "A buen entendedor, pocas palabras bastan.",
        "Más vale prevenir que curar.",
        "La suerte de la fea, la bonita la desea.",
        "No todo lo que brilla es oro.",
        "El que mucho habla, mucho yerra."
    };

    public NewJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        //si no pongo esto muestra lo que escribo como un html
        jEditorPane.setContentType("text/html");
        
        //Cuando ejecuete se habilite el editorPane y se como como nuevoDocumento(tiene ajustes predeterminados de color letra etc)
        //si no hago esto cuando cambio el tipo de letra hay errores
        jEditorPane.setEditable(true);
        nuevoDocumento();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonNuevo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButtonAyuda = new javax.swing.JButton();
        jButtonAutor = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        jToggleButtonNegrita = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jSlider = new javax.swing.JSlider();
        jButtonColor = new javax.swing.JButton();
        jToggleButtonLightDark = new javax.swing.JToggleButton();
        jButtonAleatorio = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 593));
        setMinimumSize(new java.awt.Dimension(900, 593));
        setPreferredSize(new java.awt.Dimension(900, 593));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel5.setLayout(new java.awt.BorderLayout(5, 5));

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonGuardar, java.awt.BorderLayout.CENTER);

        jButtonNuevo.setText("Nuevo");
        jButtonNuevo.setPreferredSize(new java.awt.Dimension(76, 46));
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonNuevo, java.awt.BorderLayout.PAGE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jPanel5, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        jPanel4.add(jPanel9, gridBagConstraints);

        jPanel8.setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        jButtonAyuda.setText("Ayuda");
        jButtonAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAyudaActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonAyuda);

        jButtonAutor.setText("Autor");
        jButtonAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAutorActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonAutor);

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonSalir);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jPanel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.9;
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel2.setText("Tipo letra: ");
        jPanel2.add(jLabel2);

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Impact", "Comic Sans MS", "Verdana" }));
        jComboBox.setMaximumSize(new java.awt.Dimension(150, 26));
        jComboBox.setMinimumSize(new java.awt.Dimension(150, 26));
        jComboBox.setPreferredSize(new java.awt.Dimension(150, 26));
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox);

        jToggleButtonNegrita.setText("Negrita");
        jToggleButtonNegrita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonNegritaActionPerformed(evt);
            }
        });
        jPanel2.add(jToggleButtonNegrita);

        jLabel1.setText("Tamaño:");
        jPanel2.add(jLabel1);

        jSlider.setMaximum(72);
        jSlider.setMinimum(6);
        jSlider.setPaintLabels(true);
        jSlider.setPaintTicks(true);
        jSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jSlider.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderStateChanged(evt);
            }
        });
        jPanel2.add(jSlider);

        jButtonColor.setText("Color");
        jButtonColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonColorActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonColor);

        jToggleButtonLightDark.setText("light/dark");
        jToggleButtonLightDark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonLightDarkActionPerformed(evt);
            }
        });
        jPanel2.add(jToggleButtonLightDark);

        jButtonAleatorio.setText("ALEATORIO");
        jButtonAleatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAleatorioActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAleatorio);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jPanel2, gridBagConstraints);

        jEditorPane.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jEditorPaneKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jEditorPane);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.9;
        gridBagConstraints.weighty = 0.9;
        getContentPane().add(jPanel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAyudaActionPerformed
        //Botón Ayuda
        JLabel mensaje = new JLabel("<html>Esta es una ventana de ayuda<br>F1: Ayuda <br>F2: Maximizar <br>F3: Normal <br>F4: Minimizar</html>");
        String titulo = "Ayuda/Atajos";
        mostrarVentanaEmergente(mensaje, titulo);


    }//GEN-LAST:event_jButtonAyudaActionPerformed

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        // Boton nuevo (Se borra todo lo escrito en el jEditorPane)
        nuevoDocumento();


    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jToggleButtonLightDarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonLightDarkActionPerformed

        //Si el boton esta seleccionado..
        if (jToggleButtonLightDark.isSelected()) {
            // LIGHT
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
                SwingUtilities.updateComponentTreeUI(this);
                
            } catch (Exception e) {
                java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }

        } else {
            //DARK
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
                SwingUtilities.updateComponentTreeUI(this);
                
            } catch (Exception e) {
                java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }

        }


    }//GEN-LAST:event_jToggleButtonLightDarkActionPerformed

    private void jButtonAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAutorActionPerformed
        // llamo al método ventana emergente
        JLabel mensaje = new JLabel("<html><br> Ana Pastor Roncero</html>");
        String titulo = "Autor";
        mostrarVentanaEmergente(mensaje, titulo);
    }//GEN-LAST:event_jButtonAutorActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // Boton salir:
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonColorActionPerformed
        // color:

        //Se abre dialogo para seleccionar color
        Color color = JColorChooser.showDialog(this, "Selecciona un Color para el texto", Color.BLACK);

        //Si hay un color seleccionado actualiza el texto
        if (color != null) {
            // Se cambia el valor de la variable de negro al color seleccionado. Y se convierte rgb del color a hexadecimal
            colorHex = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());

            //Actualiza el texto con el color nuevo al cambiar el valor de la variable
            actualizarTexto();
        }
    }//GEN-LAST:event_jButtonColorActionPerformed

    private void jToggleButtonNegritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonNegritaActionPerformed

        // Botón negrita:
        esNegrita = jToggleButtonNegrita.isSelected(); //Capturamos el estado del boton.  Si la variable ha cambiado booleana a cambiado a true
        //Se actualiza el texto
        actualizarTexto();


    }//GEN-LAST:event_jToggleButtonNegritaActionPerformed

    private void jButtonAleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAleatorioActionPerformed
        // Botón aleatorio, pone el color, tamaño y negrita o no:
        generarAleatorio();

    }//GEN-LAST:event_jButtonAleatorioActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // Cambiar tipo letra:
        tipoLetra = (String) jComboBox.getSelectedItem(); // Obtener el tipo de letra seleccionado
        jComboBox.setSelectedItem(tipoLetra);
        actualizarTexto(); // Actualiza el texto con la nueva fuente
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderStateChanged
        // Tamaño texto:
        //primero en propiedades del slider activo la casilla: paintLabels, paintTicks y le pongo minimum 6 y maximun 76 (tamaño de letra)
        letraSize = jSlider.getValue();
        actualizarTexto();
    }//GEN-LAST:event_jSliderStateChanged

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // Botón guardar:
        guardarComoTXT();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jEditorPaneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jEditorPaneKeyPressed
        // Atajos teclado:
        JLabel mensaje = new JLabel("<html>Esta es una ventana de ayuda<br>F1: Ayuda <br>F2: Maximizar <br>F3: Normal <br>F4: Minimizar</html>");
        String titulo = "Ayuda/Atajos";

        //Mostrar ventana emergente ayuda pulsando F1
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            mostrarVentanaEmergente(mensaje, titulo);
        }

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
    }//GEN-LAST:event_jEditorPaneKeyPressed
    public static void main(String args[]) {

        //TEMA DE COLOR
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
    private javax.swing.JButton jButtonAleatorio;
    private javax.swing.JButton jButtonAutor;
    private javax.swing.JButton jButtonAyuda;
    private javax.swing.JButton jButtonColor;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JEditorPane jEditorPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider;
    private javax.swing.JToggleButton jToggleButtonLightDark;
    private javax.swing.JToggleButton jToggleButtonNegrita;
    // End of variables declaration//GEN-END:variables

    // Método para mostrar ventanas emergentes
    //Método ha sido reutilizado para la ventana de autor y la ventana de ayuda
    private void mostrarVentanaEmergente(JLabel mensaje, String titulo) {
        JDialog dialogoAyuda = new JDialog(this, titulo, true);
        dialogoAyuda.setSize(300, 200);
        dialogoAyuda.add(mensaje);
        dialogoAyuda.setLocationRelativeTo(null);
        dialogoAyuda.setVisible(true);
    }

    //Para que cuando cambie color de texto o negrita se mantengan ambos sin perder uno
    public void actualizarTexto() {
 
        //Pone el estilo si la variable booleana es true o false 
        //OPERADOR TERNARIO es como un else if
        String negrita = esNegrita ? "font-weight: bold; " : "";
        /*si esNegrita ? (es true) se ejecuta la primera parte (antes de los :) y si es false se ejecuta la segunda parte "" y no se pondria el bold
        String negrita = "font-weight: bold; "; // negrita contiene el estilo para negrita
        String negrita = ""; // negrita no tiene ningún estilo
         */

        //Obtiene el texto del EditorPane
        textoEscrito = jEditorPane.getText();
        //Actualiza el contenido y le pone negrita(si tiene o no) y color si esta como la variable inicial o ha cambiado al darle el boton 
        jEditorPane.setText("<html><body style='color:" + colorHex + "; " + negrita + "font-family:" + tipoLetra + "; font-size:" + letraSize + "pt;'>" + textoEscrito + "</body></html>");

        jEditorPane.requestFocus();
    }

    private void generarAleatorio() {

        //Creamos un objeto aleatorio
        Random aleatorio = new Random();

        //Generamos color aleatorio 
        int rojo = aleatorio.nextInt(256);
        int verde = aleatorio.nextInt(256);
        int azul = aleatorio.nextInt(256);
        colorHex = String.format("#%02x%02x%02x", rojo, verde, azul); //Actualizamos la variable colorHex por los valores aleatorios

        //Negrita sea aleatorio
        esNegrita = aleatorio.nextBoolean(); 
        jToggleButtonNegrita.setSelected(esNegrita);

        //Tipo letra aleatorio
        tipoLetra = (String) fuentes[aleatorio.nextInt(fuentes.length)]; //generamos un numero aleatorio del tamaño del array y lo convertimos a string
        jComboBox.setSelectedItem(tipoLetra); //ponemos como item seleccionado la posicion del array (palabra) seleccionada aleatoriamente

        //Tamaño texto aleatorio
        letraSize = aleatorio.nextInt(72 - 6 + 1) + 6; // Genera un tamaño aleatorio entre 6 y 72 tamaño max y min de la letra;
        jSlider.setValue(letraSize);

        //Refranes aleatorios
        textoEscrito = (String) refranes[aleatorio.nextInt(refranes.length)];
        jEditorPane.setText(textoEscrito);

        //Actualizamos el texto
        actualizarTexto();
    }

    private void guardarComoTXT() {

        try {
            // Obtener el texto sin HTML
            String texto = jEditorPane.getDocument().getText(0, jEditorPane.getDocument().getLength());

            // Creamos un diálogo para seleccionar el archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar");
            fileChooser.setSelectedFile(new File("texto.txt")); // Nombre por defecto

            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                    writer.write(texto); // Escribe el texto en el archivo
                    JOptionPane.showMessageDialog(this, "Documento guardado exitosamente!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el documento: " + ex.getMessage());
                }
            }
        } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener el texto: " + ex.getMessage());
        }
    }

    private void nuevoDocumento() {
        jEditorPane.setText(" ");
        esNegrita = false;
        colorHex = "#000000";
        tipoLetra = "Georgia";
        letraSize = 14;
        jEditorPane.setEditable(true);
        actualizarTexto();
    }
}
