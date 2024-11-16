/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tfc.iniciosesios;

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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(70, 70, 70, 70));
        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 20, 80));

        jLabel1.setText("Usuario:");
        jPanel1.add(jLabel1);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);

        jLabel2.setText("Contraseña:");
        jPanel1.add(jLabel2);
        jPanel1.add(jTextField2);

        getContentPane().add(jPanel1);

        jPanel2.setPreferredSize(new java.awt.Dimension(250, 271));

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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Creo Variables
        String usuario1 = "User";
        String usuario2 = "Ana";
        String usuario3 = "Marta";
        
        String contraseña1 = "user";
        String contraseña2 = "123";
        String contraseña3 = "cocaCola";
        
        String usuario = jTextField1.getText();
        String contraseña = jTextField2.getText();
        
       //Creo objeto ventana 2
       Ventana2 ventana2 = new Ventana2(this,true);

        
       //Comprobar el usuario y su contraseña
        if ( usuario.equals(usuario1) && contraseña.equals(contraseña1)  ) {
            
            
            ventana2.obtenerTexto("Usuario y contraseña correcto");
            ventana2.setVisible(true); //ventana se hace visible si el usuario es correcto
            
            ventana2.obtenerUsuario("Usuario: " + usuario);
            ventana2.obtenerContraseña("Contraseña: " + contraseña);
            
        }else if ( usuario.equals(usuario2) && contraseña.equals(contraseña2)  ){
            
             ventana2.obtenerTexto("Usuario y contraseña correcto");
                         ventana2.setVisible(true);
                          ventana2.obtenerUsuario("Usuario: " + usuario);
            ventana2.obtenerContraseña("Contraseña: " + contraseña);


        
        }else if ( usuario.equals(usuario3) && contraseña.equals(contraseña3) ){
            
             ventana2.obtenerTexto("Usuario y contraseña correcto");
                         ventana2.setVisible(true);
                          ventana2.obtenerUsuario("Usuario: " + usuario);
            ventana2.obtenerContraseña("Contraseña: " + contraseña);


        
        }else{
          ventana2.obtenerTexto("Usuario y contraseña incorrectos");
                      ventana2.setVisible(true);
                       ventana2.obtenerUsuario("Usuario: " + usuario);
            ventana2.obtenerContraseña("Contraseña: " + contraseña);


        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
                new PantallaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
