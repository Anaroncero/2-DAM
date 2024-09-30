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

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 
 public class EjercicioEvaluable_MejoradoPorMi {
 
     // Variables
     static double[] precios = new double[5];
     static double[] unidades = new double[5];
     static String[] nombreProductos = new String[5];
 
     public static void main(String[] args) {
         // Crear frame(ventana)
         JFrame frame = new JFrame("Cálculo de precios");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(800, 600);
         frame.setLayout(new GridLayout(7, 4, 10, 10));
 
         // Labels
         JLabel productoLabel = new JLabel("Producto");
         productoLabel.setHorizontalAlignment(productoLabel.CENTER);

         JLabel precioLabel = new JLabel("Precio");
         precioLabel.setHorizontalAlignment(precioLabel.CENTER);
      
         JLabel unidadesLabel = new JLabel("Unidades");
         unidadesLabel.setHorizontalAlignment(unidadesLabel.CENTER);

         JLabel resultadoText = new JLabel("Precio Total: ");
         resultadoText.setHorizontalAlignment(resultadoText.CENTER);

         JLabel espacio = new JLabel("");
         JLabel espacio1 = new JLabel("");

         JTextField lresultado = new JTextField(10);
         lresultado.setEditable(false); // No editable
 
         // TextFields
         JTextField[] productoFields = new JTextField[5];
         JTextField[] precioFields = new JTextField[5];
         JTextField[] unidadFields = new JTextField[5];
 
         for (int i = 0; i < 5; i++) {
             productoFields[i] = new JTextField(10);
             precioFields[i] = new JTextField(10);
             unidadFields[i] = new JTextField(10);
         }
 
         // Color
         Color azul = new Color(79, 117, 162);
 
         // Botón
         JButton calcular = new JButton("Calcular");
         calcular.setBackground(azul);
 
         // Añadir componentes al frame
         JLabel espacio = new JLabel(" ");
         frame.add(espacio);
         frame.add(productoLabel);
         frame.add(precioLabel);
         frame.add(unidadesLabel);
         frame.add(new JLabel("")); // Espacio vacío
¡
 
         
         for (int i = 0; i < 5; i++) {
             frame.add(new JLabel(String.valueOf(i + 1))); // la columna de números 1 al 5 de la izquierda
             frame.add(productoFields[i]);
             frame.add(precioFields[i]);
             frame.add(unidadFields[i]);
         }
 
         
         frame.add(calcular);
         frame.add(resultadoText);
         frame.add(lresultado);
         frame.add(new JLabel("")); // Espacio vacío
 
         // Funcionalidad del botón
         calcular.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 double total = 0;
 
                 //For que comprueba que los textfields no esten vacios y coge los textos introducidos
                 for (int i = 0; i < 5; i++) {
                     // Comprobar que no estén vacíos
                     if (precioFields[i].getText().isEmpty() || unidadFields[i].getText().isEmpty() || productoFields[i].getText().isEmpty()) {
                         JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                         return;
                     }
 
                     nombreProductos[i] = productoFields[i].getText();
                     precios[i] = Double.parseDouble(precioFields[i].getText());
                     unidades[i] = Double.parseDouble(unidadFields[i].getText());
 
                     total += precios[i] * unidades[i];
                 }
 
                 lresultado.setText(String.format("%.2f", total)); // Mostrar resultado con dos decimales
 
                 // Construir una cadena para mostrar los resultados
                 StringBuilder resultado = new StringBuilder();
                 for (int i = 0; i < 5; i++) {
                     resultado.append(nombreProductos[i]).append(": ").append(String.format("%.2f", precios[i] * unidades[i])).append("€\n");
                 }
                 resultado.append("Precio Total: ").append(String.format("%.2f", total));
                 JOptionPane.showMessageDialog(frame, resultado.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
             }
         });
 
         // Hacer visible y centrar
         frame.setVisible(true);
         frame.setLocationRelativeTo(null);
     }
 }
 
