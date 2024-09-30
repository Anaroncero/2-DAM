/* 
 * Ejercicio_Evaluable_1: UI por código
 * Ana Pastor Roncero
 * Desarrolla un programa que permita introducir el nombre, precio y unidades de hasta 5 productos que se van a comprar en una tienda, y calcule el precio total (debe mostrar la suma al pulsar el botón).
 * La interfaz debe verse lo más similar posible a esta:
 * 
 * Puntuación:

Uso correcto de componentes: 3 puntos.
Uso y anidamiento adecuado de layouts que permitan que la interfaz se adapte automáticamente a diferentes tamaños: 4 puntos.
Funcionalidad del botón: 2 puntos.
Planteamiento, estructuración del código y documentación (comentarios): 1 punto.
IMPORTANTE: el ejercicio no se corregirá si no compila.
Entrega:

En esta tarea deberás adjuntar el fichero de código .java y una captura de pantalla de tu interfaz. Los dos ficheros sueltos,
 sin carpetas comprimidas (puedes hacer dos entregas, una con la programación y otra con la captura de pantalla si en una sola 
 entrega no puedes entregar ambos archivos).
 */

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EjercicioEvaluable {

    // Variables
    static double p1;
    static double p2;
    static double p3;
    static double p4;
    static double p5;

    static int u1;
    static int u2;
    static int u3;
    static int u4;
    static int u5;

    static String pro1;
    static String pro2;
    static String pro3;
    static String pro4;
    static String pro5;

    static double mult = 0;
    static double mult2 = 0;
    static double mult3 = 0;
    static double mult4 = 0;
    static double mult5 = 0;

    static boolean datosGuardados = false;

    public static void main(String[] args) {

        // Crear frame(ventana)
        JFrame frame = new JFrame("Cálculo de precios");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new GridLayout(7, 4, 10, 10));

        // Label texto
        JLabel espacio = new JLabel("");
        JLabel espacio2 = new JLabel("");

        JLabel producto = new JLabel("Producto");
        producto.setFont(new Font("Arial", Font.BOLD, 16));
        producto.setHorizontalAlignment(producto.CENTER);

        JLabel precio = new JLabel("Precio");
        precio.setFont(new Font("Arial", Font.BOLD, 16));
        precio.setHorizontalAlignment(producto.CENTER);

        JLabel unidades = new JLabel("Unidades");
        unidades.setFont(new Font("Arial", Font.BOLD, 16));
        unidades.setHorizontalAlignment(unidades.CENTER);

        // Labels numeros
        JLabel numero1 = new JLabel("1");
        numero1.setFont(new Font("Arial", Font.BOLD, 16));
        numero1.setHorizontalAlignment(numero1.RIGHT);
        JLabel numero2 = new JLabel("2");
        numero2.setFont(new Font("Arial", Font.BOLD, 16));
        numero2.setHorizontalAlignment(numero2.RIGHT);
        JLabel numero3 = new JLabel("3");
        numero3.setFont(new Font("Arial", Font.BOLD, 16));
        numero3.setHorizontalAlignment(numero3.RIGHT);
        JLabel numero4 = new JLabel("4");
        numero4.setFont(new Font("Arial", Font.BOLD, 16));
        numero4.setHorizontalAlignment(numero4.RIGHT);
        JLabel numero5 = new JLabel("5");
        numero5.setFont(new Font("Arial", Font.BOLD, 16));
        numero5.setHorizontalAlignment(numero5.RIGHT);

        JLabel resultadoText = new JLabel("Precio Total: ");
        resultadoText.setFont(new Font("Arial", Font.BOLD, 16));
        resultadoText.setHorizontalAlignment(resultadoText.RIGHT);

        // TextField
        JTextField l1 = new JTextField(10);
        JTextField l2 = new JTextField(10);
        JTextField l3 = new JTextField(10);
        JTextField l4 = new JTextField(10);
        JTextField l5 = new JTextField(10);
        JTextField l6 = new JTextField(10);
        JTextField l7 = new JTextField(10);
        JTextField l8 = new JTextField(10);
        JTextField l9 = new JTextField(10);
        JTextField l10 = new JTextField(10);
        JTextField l11 = new JTextField(10);
        JTextField l12 = new JTextField(10);
        JTextField l13 = new JTextField(10);
        JTextField l14 = new JTextField(10);
        JTextField l15 = new JTextField(10);

        JTextField resultado = new JTextField(10);

        // Color
        Color azul = new Color(79, 117, 162);

        // Jbutton
        JButton calcular = new JButton("Calcular");
        calcular.setBackground(azul);

        // Añdir todo
        JComponent[] componentes = { espacio, producto, precio, unidades };
        for (int i = 0; i < componentes.length; i++) {
            frame.add(componentes[i]);
        }

        // Agrupar los componentes en un arreglo
        JComponent[] componentes2 = {
            numero1, l1, l2, l3,
            numero2, l4, l5, l6,
            numero3, l7, l8, l9,
            numero4, l10, l11, l12,
            numero5, l13, l14, l15
        };

        // Añadir todos los componentes al frame
        for (int i = 0; i < componentes2.length; i++) {
            frame.add(componentes2[i]);
        }

        // Agrupar los componentes en un arreglo
        JComponent[] componentes3 = { espacio2, calcular, resultadoText, resultado };

        // Añadir todos los componentes al frame
        for (int i = 0; i < componentes3.length; i++) {
            frame.add(componentes3[i]);
        }

        // Funcionalidad
        calcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Verificar que los campos no estén vacíos antes de guardar
                if (l2.getText().isEmpty() || l5.getText().isEmpty() || l8.getText().isEmpty()
                        || l11.getText().isEmpty()
                        || l14.getText().isEmpty() || l3.getText().isEmpty() || l6.getText().isEmpty()
                        || l9.getText().isEmpty() || l12.getText().isEmpty() || l15.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Por favor, complete todos los campos. En los campos precio y unidades introduzca numeros",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método si hay campos vacíos
                }

                pro1 = l1.getText();
                pro2 = l4.getText();
                pro3 = l7.getText();
                pro4 = l10.getText();
                pro5 = l13.getText();

                p1 = Double.parseDouble(l2.getText());
                p2 = Double.parseDouble(l5.getText());
                p3 = Double.parseDouble(l8.getText());
                p4 = Double.parseDouble(l11.getText());
                p5 = Double.parseDouble(l14.getText());

                u1 = Integer.parseInt(l3.getText());
                u2 = Integer.parseInt(l6.getText());
                u3 = Integer.parseInt(l9.getText());
                u4 = Integer.parseInt(l12.getText());
                u5 = Integer.parseInt(l15.getText());

                // Supongamos que p y u son arreglos que contienen los precios y unidades
                double[] precios = { p1, p2, p3, p4, p5 };
                double[] unidades = { u1, u2, u3, u4, u5 };
                double total = 0;

                for (int i = 0; i < precios.length; i++) {
                    total += precios[i] * unidades[i];
                }

                // Redondeo de resultados
                long totalRedondeado = Math.round(total);
                long[] resultadosRedondeados = {
                    Math.round(mult),
                    Math.round(mult2),
                    Math.round(mult3),
                    Math.round(mult4),
                    Math.round(mult5)
                };

                datosGuardados = true;

                resultado.setText("" + totalRedondeado);

                if (datosGuardados) {
                    StringBuilder mensaje = new StringBuilder();
                    for (int i = 0; i < resultadosRedondeados.length; i++) {
                        mensaje.append("Producto ").append(i + 1).append(": ").append(resultadosRedondeados[i])
                                .append("€\n");
                    }
                    mensaje.append("Precio Total: ").append(totalRedondeado);

                    JOptionPane.showMessageDialog(frame,
                        mensaje.toString(),
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        // visisble
        frame.setVisible(true);

        // centrar
        frame.setLocationRelativeTo(null);
    }
}
 
