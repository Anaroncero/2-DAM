import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ejercicio1 {

        // Variables funcionalidad
        static String nombre;
        static String email;
        static String fechaNacimiento;
    public static void main(String[] args) {

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
        JTextField nameInput = new JTextField(10);

        // JLabel Email
        JLabel correo = new JLabel("Email:");
        name.setFont(new Font("Arial", Font.BOLD, 12));

        // TextField correo
        JTextField correoInput = new JTextField(10);

        // JLabel fecha nacimiento
        JLabel year = new JLabel("Año nacimiento:");
        name.setFont(new Font("Arial", Font.BOLD, 12));

        // TextField año
        JTextField yearInput = new JTextField(10);

        panel1.add(name);
        panel1.add(nameInput);
        panel1.add(correoInput);
        panel1.add(correo);
        panel1.add(year);
        panel1.add(yearInput);

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

        // panel3 grid 1x2-------------------------
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 2));
        frame.add(panel3);

        // JLabel titulo
        JLabel titulo = new JLabel("Titulación de acceso:");
        titulo.setFont(new Font("Arial", Font.BOLD, 12));

        // ComboBox
        String[] opciones = { "FP grado medio", "Bachillerato" };
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        panel3.add(titulo);
        panel3.add(comboBox);

        // panel4 grid 2x1-------------------------
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(2, 1));
        frame.add(panel4);

        // JLabel observaciones
        JLabel observaciones = new JLabel("Observaciones:");
        titulo.setFont(new Font("Arial", Font.BOLD, 12));

        // TextArea
        JTextArea textArea = new JTextArea();

        panel4.add(observaciones);
        panel4.add(textArea);

        // panel5 grid 1x3 o flow-------------------------
        JPanel panel5 = new JPanel();
        panel5.setLayout(new BorderLayout());
        frame.add(panel5);

        // JButton guardar
        JButton guardar = new JButton("Guardar");

        // JButton eliminar
        JButton eliminar = new JButton("Eliminar");

        panel5.add(guardar);
        panel5.add(eliminar);
        panel5.add(guardar, BorderLayout.EAST);
        panel5.add(eliminar, BorderLayout.WEST);

        // Hacer visible y centrar
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        // Funcionalidad-------------------------------------
        // 1. Guardar
        // El usuario ingresa la información solicitada.
        // La información se almacena en variables globales (puedes modificar esto si
        // prefieres una estructura de datos diferente).

        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (nombreInput.getText().isEmpty() || emailInput.getText().isEmpty() || fechaInput.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Rellene todos los campos antes de guardar", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                nom = nombreInput.getText();
                correo = emailInput.getText();
                fechaNac = fechaInput.getText();
                titulo = (String) jComboBox1.getSelectedItem();
                observa = jTextArea1.getText();

                if (generoInput1.isSelected()) {
                    eleccion = generoInput1.getText();
                } else if (generoInput2.isSelected()) {
                    eleccion = generoInput2.getText();
                }

                datosGuardados = true;
            }

        });

        // Los datos que se guardaron previamente en las variables se escriben en un
        // fichero matricula.txt en un formato óptimo para su lectura.
        imprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (!datosGuardados) {
                    JOptionPane.showMessageDialog(frame, "Guarde los datos antes de imprimir", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {
                    // Crear fichero
                    FileWriter fw = new FileWriter("G:\\Mi unidad\\.\\2º DAM\\.\\Acceso a datos\\.\\Tema_1_Introduccion_al_manejo_de_ficheros\\.\\Formulario matricula\\.\\matricula.txt");
                    
                    fw.write(nombreApellidos.getText() + nom + "\n");
                    fw.write(email.getText() + correo + "\n");
                    fw.write(fechaNacimiento.getText() + fechaNac + "\n");
                    fw.write(eleccion + "\n");
                    fw.write(titulacionAcceso.getText() + titulo + "\n");
                    fw.write(observaciones.getText() + observa + "\n ");

                    fw.close();

                } catch (IOException ioe) {

                }
            }
        });

    }
    }
    
