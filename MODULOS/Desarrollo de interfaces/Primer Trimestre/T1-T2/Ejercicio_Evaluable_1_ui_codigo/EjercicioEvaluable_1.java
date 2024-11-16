
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

En esta tarea deberás adjuntar el fichero de código .java y una captura de pantalla de tu interfaz. Los dos ficheros sueltos, sin carpetas comprimidas (puedes hacer dos entregas, una con la programación y otra con la captura de pantalla si en una sola entrega no puedes entregar ambos archivos).
 */

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 
 public class EjercicioEvaluable_1 {
 
     // Variables
     static double p1;
     static double p2;
     static double p3;
     static double p4;
     static double p5;
 
     static double u1;
     static double u2;
     static double u3;
     static double u4;
     static double u5;
 
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
         frame.setLayout(new GridLayout(7, 4));
 
         // Label texto
         JLabel espacio = new JLabel("");
         JLabel espacio2 = new JLabel("");
         JLabel producto = new JLabel("Producto");
         producto.setFont(new Font("Arial", Font.BOLD, 12));
         JLabel precio = new JLabel("Precio");
         precio.setFont(new Font("Arial", Font.BOLD, 12));
         JLabel unidades = new JLabel("Unidades");
         unidades.setFont(new Font("Arial", Font.BOLD, 12));
 
         // Labels numeros
         JLabel numero1 = new JLabel("1");
         numero1.setFont(new Font("Arial", Font.BOLD, 12));
         JLabel numero2 = new JLabel("2");
         numero2.setFont(new Font("Arial", Font.BOLD, 12));
         JLabel numero3 = new JLabel("3");
         numero3.setFont(new Font("Arial", Font.BOLD, 12));
         JLabel numero4 = new JLabel("4");
         numero4.setFont(new Font("Arial", Font.BOLD, 12));
         JLabel numero5 = new JLabel("5");
         numero5.setFont(new Font("Arial", Font.BOLD, 12));
         JLabel resultadoText = new JLabel("Precio Total: ");
         resultadoText.setFont(new Font("Arial", Font.BOLD, 12));
 
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
 
         JTextField lresultado = new JTextField(10);
 
         // Color
         Color azul = new Color(79, 117, 162);
 
         // Jbutton
         JButton calcular = new JButton("Calcular");
         calcular.setBackground(azul);
 
         // Añdir todo
         frame.add(espacio);
         frame.add(producto);
         frame.add(precio);
         frame.add(unidades);
 
         frame.add(numero1);
         frame.add(l1);
         frame.add(l2); // p1
         frame.add(l3); // u1
         frame.add(numero2);
         frame.add(l4);
         frame.add(l5); // p2
         frame.add(l6); // u2
         frame.add(numero3);
         frame.add(l7);
         frame.add(l8); // p3
         frame.add(l9); // u3
         frame.add(numero4);
         frame.add(l10);
         frame.add(l11); // p4
         frame.add(l12); // u4
         frame.add(numero5);
         frame.add(l13);
         frame.add(l14); // p5
         frame.add(l15); // u5
         frame.add(espacio2);
 
         frame.add(espacio2);
         frame.add(calcular);
         frame.add(resultadoText);
         frame.add(lresultado);
 
         // Funcionalidad
         calcular.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
 
                 // Verificar que los campos no estén vacíos antes de guardar
                 if (l2.getText().isEmpty() || l5.getText().isEmpty() || l8.getText().isEmpty() || l11.getText().isEmpty()
                 || l14.getText().isEmpty() || l3.getText().isEmpty() || l6.getText().isEmpty() || l9.getText().isEmpty() || l12.getText().isEmpty() || l15.getText().isEmpty()
                 ) {
                     JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos. En los campos precio y unidades introduzca numeros", "Error", JOptionPane.ERROR_MESSAGE);
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
 
                 u1 = Double.parseDouble(l3.getText());
                 u2 = Double.parseDouble(l6.getText());
                 u3 = Double.parseDouble(l9.getText());
                 u4 = Double.parseDouble(l12.getText());
                 u5 = Double.parseDouble(l15.getText());
 
                 //Multiplicacion precio y unidades
                 mult = p1 * p2;
                 mult2 = p2 * u2;
                 mult3 = p3 * u3;
                 mult4 = p4 * u4;
                 mult5 = p5 * u5;
 
                 double total = (mult + mult2 + mult3 + mult4 + mult5);
 
                 //Redondeo resultado
                 Math.round(total);
                 Math.round(mult);
                 Math.round(mult2);
                 Math.round(mult3);
                 Math.round(mult4);
                 Math.round(mult5);
 
                 datosGuardados = true;
 
                 lresultado.setText("" + total);

                 if(datosGuardados == true){
                    JOptionPane.showMessageDialog(frame,pro1 + " " + mult + "€" + "\n" + pro2 + " " + mult2 + "€" + "\n" 
                    + pro3 + " " + mult3 + "€" + "\n" + pro4 + " " + mult4 + "€" + "\n" + pro5 + " " + mult5 + "€" + "\n" 
                    + "Precio Total: " + total, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }
 
             }
         });
 
         // Hacer visible y centrar
         frame.setVisible(true);
         frame.setLocationRelativeTo(null);
 
     }
 
 }
 