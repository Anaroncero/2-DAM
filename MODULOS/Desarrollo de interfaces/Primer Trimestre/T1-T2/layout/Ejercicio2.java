package layout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio2 {

    /* Crea una ventana con un campo de texto para que el usuario pueda escribir, y debajo un botón que ponga 'Mostrar por consola'.
     * 
     * Al presionar el botón, se debe mostrar el texto escrito del campo de texto, en la consola de VSCode.
     */

     public static void main(String[] args) {
        
        // Crear frame
        JFrame frame = new JFrame("Ejercicio9");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Crear TextField y añadir
        TextField textField = new TextField(20);
        frame.add(textField);

        // Crear Button y añadir
        JButton button = new JButton("Mostrar por consola");
        frame.add(button);

        //hacer visible
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        // ActionListener y ActionEvent al botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String text = textField.getText();
                System.out.println("El texto escrito es: " + text);
            }
        });


     }
    
}
