package conCoordenadas;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ejercicio2 {

    public static void main(String[] args) {
        /*
         * PREGUNTA
         * TIPO TEST
         */

        // Crear el JFrame(ventana)
        JFrame frame = new JFrame("Familiarizandose con los componentes");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // sin layout (null layout)

        // Crear panel (va añadido a la ventana)
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 500, 400); // Establecer posicion y tamano del JPanel
        panel.setLayout(null); // Sin layout para el panel
        frame.add(panel); // añadimos el panel al frame(a la ventana)

        // Crear JButton (va añadido al panel)
        JButton button = new JButton("Botón");
        button.setBounds(50, 20, 100, 30); // tamaño y posicion
        panel.add(button); // añadimos

        // Crear JLabel texto o img (va añadido al panel)
        JLabel label = new JLabel("Etiqueta (texto o img)");
        label.setBounds(50, 60, 100, 30);
        panel.add(label);
        label.setVisible(true);

        //JTextField
        JTextField textfield = new JTextField(20);
        textfield.setBounds(150, 60, 150, 30);
        panel.add(textfield);

        //Crear JCheckBox
        JCheckBox checkbox = new JCheckBox("Opción 1");
        checkbox.setBounds(50,100,100, 30);
        panel.add(checkbox);


        //Crear JRadioButton
        JRadioButton radiobutton = new JRadioButton("Opción A");
        radiobutton.setBounds(50, 140,100,30);
        panel.add(radiobutton);


        //Crear JComboBox
        String[] opciones = {"Opcion 1", "Opcion 2", "Opcion 3"}; //Array de opciones
        JComboBox<String> comboBox = new JComboBox<>(opciones); //Añadir array al desplegable
        comboBox.setBounds(50,180,150,30); //posicion y tamaño
        panel.add(comboBox);


        //Hacer visible el frame(ventana)
        frame.setVisible(true); // hacer visible la ventana siempre al final del codigo

        //frame (ventana) salga centrada
        frame.setLocationRelativeTo(null);
    }
}
