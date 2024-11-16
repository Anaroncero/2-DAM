import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora {

    /* Calculadora de dos números 
     * https://www.figma.com/design/D9lHEzOfJkh4tjlh0qDBLK/Ejercicio2-Layout?node-id=0-1&t=HvSB6QPyXMKS9xvn-1
    */

    static int num1;
    static int num2;
    static int posicion = 0;
    static String operacion = "";

    public static void main(String[] args) {

        // Frame
        JFrame frame = new JFrame(" ");
        frame.setSize(360, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel grid 1x1 ------------------------------
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));

        // textfield
        JTextField resultado = new JTextField();
        resultado.setPreferredSize(new Dimension(700, 80)); //no funciona con grid
        resultado.setEnabled(false);
        panel.add(resultado);
        frame.add(panel, BorderLayout.NORTH);

        // Panel2 grid 4x4 ------------------------------
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4, 4));
        frame.add(panel2);

        // JButton
        JButton boton1 = new JButton("7");
        JButton boton2 = new JButton("8");
        JButton boton3 = new JButton("9");
        JButton boton4 = new JButton("+");
        JButton boton5 = new JButton("4");
        JButton boton6 = new JButton("5");
        JButton boton7 = new JButton("6");
        JButton boton8 = new JButton("-");
        JButton boton9 = new JButton("1");
        JButton boton10 = new JButton("2");
        JButton boton11 = new JButton("3");
        JButton boton12 = new JButton("*");
        JButton boton13 = new JButton("0");
        JButton boton14 = new JButton("c");
        JButton boton15 = new JButton("=");
        JButton boton16 = new JButton("/");

        panel2.add(boton1);
        panel2.add(boton2);
        panel2.add(boton3);
        panel2.add(boton4);
        panel2.add(boton5);
        panel2.add(boton6);
        panel2.add(boton7);
        panel2.add(boton8);
        panel2.add(boton9);
        panel2.add(boton10);
        panel2.add(boton11);
        panel2.add(boton12);
        panel2.add(boton13);
        panel2.add(boton14);
        panel2.add(boton15);
        panel2.add(boton16);

        // cambiar color botones
        Color azul = new Color(70, 113, 152);
        Color verde = new Color(51, 143, 49);
        Color blanco = new Color(255, 255, 255);

        for (JButton botones : new JButton[] { boton1, boton2, boton3, boton5, boton6, boton7, boton9, boton10, boton11,
                boton13 }) {
            botones.setBackground(azul);
        }

        for (JButton botones : new JButton[] { boton4, boton8, boton12, boton16  }) {
            botones.setBackground(verde);
        }

        boton14.setBackground(blanco);
        boton15.setBackground(blanco);

        // Hacer visible y centrar
        frame.setVisible(true);
        // frame.setLocationRelativeTo(null);

        /*
         * Funcionalidad calculadora--------------------
         * Al pulsar el botón de un número,
         * se guarde en una variable y se muestre
         * en el panel de resultados
         */

        /*
         * boton1.addActionListener(new ActionListener() {
         * public void actionPerformed(ActionEvent e) {
         * //es el primer numero
         * if (posicion == 0) {
         * num1 = 7;
         * resultado.setText("" + num1);
         * posicion++;
         * }else{
         * num2 = 7;
         * posicion = 0;
         * }
         * 
         * }
         * });
         */

        ActionListener botonesNumericos = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JButton botonPresionado = (JButton) e.getSource(); // coger la ruta del objeto presionado y convertirlo
                                                                   // a boton
                int number = Integer.parseInt(botonPresionado.getText()); // obtener el texto del boton presionado y
                                                                          // convertirlo a numero entero

                if (posicion == 0) { // si estamos en la posición 0 quiere decir que es el primer boton presionado
                    num1 = number;
                    resultado.setText("" + num1);
                    posicion++; // se incrementa uno ya hemos elegido el primero numero y se cambia a la
                                // posición 1 para elegir el número 2
                } else {
                    num2 = number;
                    resultado.setText("" + num2);
                }
            }
        };

        // añadir el metodo a los botones
        for (JButton botones : new JButton[] { boton1, boton2, boton3, boton5, boton6, boton7, boton9, boton10, boton11,
                boton13 }) {
            botones.addActionListener(botonesNumericos);
        }

        // crear mas eventos para los otros botones
        boton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacion = "suma";
                posicion = 1; // pasamos de posición para que podamos indicar el segundo numero
            }
        });

        boton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacion = "resta";
                posicion = 1;
            }
        });

        boton12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacion = "multiplicacion";
                posicion = 1;
            }
        });

        boton16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacion = "division";
                posicion = 1;
            }
        });

        boton15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int resultadoFinal = 0;

                switch (operacion) {
                    case "suma":
                        resultadoFinal = num1 + num2;
                        break;
                    case "resta":
                        resultadoFinal = num1 - num2;
                        break;
                    case "multiplicacion":
                        resultadoFinal = num1 * num2;
                        break;
                    case "division":
                        if (num2 != 0) {
                            resultadoFinal = num1 / num2;
                            resultado.setText("Error: No se puede dividir un número entre 0");
                            return;
                        }
                        break;
                }

                resultado.setText("" + resultadoFinal);

                // reiniciar para otra operación
                num1 = resultadoFinal;
                num2 = 0;
                operacion = "";
                posicion = 0;
            }
        });

        //boton reiniciar calculadora
        boton14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = 0;
                num2 = 0;
                operacion = "";
                posicion = 0;
                resultado.setText("");

            }
        });

    }
}
