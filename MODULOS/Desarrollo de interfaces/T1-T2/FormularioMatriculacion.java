import javax.swing.*;
import java.awt.*;

public class FormularioMatriculacion {
    public static void main(String[] args) {
        
        /* La funcionalidad de este ejercicio esta en la carpeta Acceso a datos ejercicio1_1 
         * https://www.figma.com/design/D9lHEzOfJkh4tjlh0qDBLK/Ejercicio2-Layout?node-id=0-1&t=HvSB6QPyXMKS9xvn-1
        */

        // Crear frame grid 5x1 ------------------------
        JFrame frame = new JFrame("Ejercicio 11: Formulario: matriculación alumno/a");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440, 550);
        frame.setLayout(new GridLayout(5, 1));

        // PANEL1 grid 3x2-------------------------
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 2));
        frame.add(panel1);

        // JLabel Nombre Apellidos
        JLabel name = new JLabel("Nombre y Apellidos:");
        name.setFont(new Font("Arial", Font.BOLD, 12));
         
        // TextField nombre
        JTextField nombre = new JTextField(10);
        

        // JLabel Email
        JLabel email = new JLabel("Email:");
        name.setFont(new Font("Arial", Font.BOLD, 12));
        
        // TextField correo
        JTextField correo = new JTextField(10);
        

        // JLabel fecha nacimiento
        JLabel year = new JLabel("Año nacimiento:");
        name.setFont(new Font("Arial", Font.BOLD, 12));
        
        // TextField año
        JTextField anyo = new JTextField(10);

        panel1.add(name);
        panel1.add(nombre);
        panel1.add(email);
        panel1.add(correo);
        panel1.add(year);
        panel1.add(anyo);

        // PANEL2 grid 1x3-------------------------
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 3));
        frame.add(panel2);
        
        // JLabel genero
        JLabel genero = new JLabel("Género:");
        genero.setFont(new Font("Arial", Font.BOLD, 12));
        
        // JCheckbox
        // Crear los checkboxes
        JCheckBox checkbox1 = new JCheckBox("Femenino");
        JCheckBox checkbox2 = new JCheckBox("Masculino");

        panel2.add(genero);
        panel2.add(checkbox1);
        panel2.add(checkbox2);

        ButtonGroup genGrupo = new ButtonGroup();
        genGrupo.add(checkbox1);
        genGrupo.add(checkbox2);



        // panel3 grid 1x2-------------------------
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 2));
        frame.add(panel3);
        
        //JLabel titulo
        JLabel titulo = new JLabel("Titulación de acceso:");
        titulo.setFont(new Font("Arial", Font.BOLD, 12));
       
        //ComboBox
        String[] opciones = {"FP grado medio", "Bachillerato"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        
        
        panel3.add(titulo);
        panel3.add(comboBox);

        // panel4 grid 2x1-------------------------
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(2, 1));
        frame.add(panel4);

        //JLabel observaciones
        JLabel observaciones = new JLabel("Observaciones:");
        titulo.setFont(new Font("Arial", Font.BOLD, 12));
        
        //TextArea
        JTextArea textArea = new JTextArea();

        
        panel4.add(observaciones);
        panel4.add(textArea);


        // panel5 grid 1x3 o flow-------------------------
        JPanel panel5 = new JPanel();
        panel5.setLayout(new BorderLayout());
        frame.add(panel5);

        //color botones
        Color azul = new Color(79, 117, 162);
        //JButton guardar
        JButton guardar = new JButton("Guardar");
        guardar.setBackground(azul);

        //JButton eliminar
        JButton eliminar = new JButton("Eliminar");
        eliminar.setBackground(azul);

        panel5.add(guardar);
        panel5.add(eliminar);
        panel5.add(guardar, BorderLayout.EAST);
        panel5.add(eliminar, BorderLayout.WEST);


        // Hacer visible y centrar
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
