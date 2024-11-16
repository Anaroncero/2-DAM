package conCoordenadas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio5 {
    
    static Map<String, String> usuarios = new HashMap<>();
    static int intentos = 0;
    static final int MAX_INTENTOS = 3;

    public static void main(String[] args) {
        
        // Crear objeto JFrame
        JFrame frame = new JFrame("Inicio de Sesión");
        
        // Configurar JFrame
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Agregar usuarios y contraseñas
        usuarios.put("Antonio", "123456");
        usuarios.put("Maria", "abc123");
        usuarios.put("Juan", "password");

        // Crear JLabel para usuario
        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setBounds(50, 60, 100, 30);
        frame.add(usuarioLabel);

        // Crear JTextField para usuario
        JTextField usuarioField = new JTextField(20);
        usuarioField.setBounds(150, 60, 150, 30);
        frame.add(usuarioField);

        // Crear JLabel para contraseña
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setBounds(50, 120, 100, 30);
        frame.add(contrasenaLabel);

        // Crear JTextField para contraseña
        JTextField contrasenaField = new JTextField(20);
        contrasenaField.setBounds(150, 120, 150, 30);
        frame.add(contrasenaField);

        // Crear botón
        JButton boton = new JButton("Inicio de Sesión");
        boton.setBounds(150, 200, 170, 20);
        frame.add(boton);

        // Añadir ActionListener al botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String contrasena = contrasenaField.getText();

                // Verificar usuario y contraseña
                if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contrasena)) {
                    JOptionPane.showMessageDialog(frame, "Usuario correcto", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    intentos = 0; // Reiniciar intentos
                } else {
                    intentos++;
                    if (intentos >= MAX_INTENTOS) {
                        JOptionPane.showMessageDialog(frame, "Bloqueado después de 3 intentos fallidos", "Bloqueado", JOptionPane.ERROR_MESSAGE);
                        boton.setEnabled(false); // Deshabilitar botón
                    } else {
                        JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos. Intentos restantes: " + (MAX_INTENTOS - intentos), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
