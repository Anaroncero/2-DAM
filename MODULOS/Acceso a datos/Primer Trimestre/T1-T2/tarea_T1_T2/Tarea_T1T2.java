import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Tarea_T1T2 {
    public static void main(String[] args) {
        // Crear frame
        JFrame frame = new JFrame("Programa Copiar Archivos");
        frame.setSize(600, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 2)); // 1 fila, 2 columnas

        // Panel para la ruta de origen
        JPanel panelOrigen = new JPanel(new GridLayout(3, 1)); // 3 filas, 1 columna
        JLabel labelOrigen = new JLabel("Ruta Origen:");
        JTextField rutaOrigen = new JTextField(20);
        JButton buscarOrigen = new JButton("Buscar");

        panelOrigen.add(labelOrigen);
        panelOrigen.add(rutaOrigen);
        panelOrigen.add(buscarOrigen);

        // Panel para la ruta de destino
        JPanel panelDestino = new JPanel(new GridLayout(3, 1)); // 3 filas, 1 columna
        JLabel labelDestino = new JLabel("Ruta Destino:");
        JTextField rutaDestino = new JTextField(20);
        JButton buscarDestino = new JButton("Buscar");

        panelDestino.add(labelDestino);
        panelDestino.add(rutaDestino);
        panelDestino.add(buscarDestino);

        // Añadir los paneles al frame
        frame.add(panelOrigen);
        frame.add(panelDestino);

        // Mensaje de salida
        JLabel mensajeText = new JLabel("", SwingConstants.CENTER);
        frame.add(mensajeText);

        // Botón de copiar
        JButton botonCopiar = new JButton("Copiar");
        frame.add(botonCopiar);

        // Acciones de los botones "Buscar"
        buscarOrigen.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                rutaOrigen.setText(fileChooser.getSelectedFile().getPath());
            }
        });

        buscarDestino.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                rutaDestino.setText(fileChooser.getSelectedFile().getPath());
            }
        });

        // Acciones del botón de copiar
        botonCopiar.addActionListener(e -> {
            String archivoOrigen = rutaOrigen.getText();
            String archivoDestino = rutaDestino.getText();

            if (archivoOrigen.isEmpty() || archivoDestino.isEmpty()) {
                mensajeText.setText("Por favor, introduzca ambas rutas.");
                return;
            }

            // Deshabilitar botón durante la operación
            botonCopiar.setEnabled(false);

            // Usar un hilo separado para la operación de copia
            new Thread(() -> {
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(archivoOrigen));
                     BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(archivoDestino))) {

                    int byteLeido;
                    while ((byteLeido = bis.read()) != -1) {
                        bos.write(byteLeido);
                    }
                    bos.flush();
                    mensajeText.setText("Copia realizada con éxito");
                } catch (IOException io) {
                    mensajeText.setText("Error al copiar el archivo: " + io.getMessage());
                } finally {
                    // Rehabilitar botón después de la operación
                    botonCopiar.setEnabled(true);
                }
            }).start();

            // Limpiar campos de texto
            rutaOrigen.setText("");
            rutaDestino.setText("");
        });

        // Mostrar ventana
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
