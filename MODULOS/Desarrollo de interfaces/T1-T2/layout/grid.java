package layout;
import java.awt.*;
import javax.swing.*;

public class grid {
    public static void main(String[] args) {

        // Crear Frame
        JFrame frame = new JFrame("gridLayout");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Establecer el layout Grid
        frame.setLayout(new GridLayout(2, 2));

        // crear los botones
        JButton button1 = new JButton("Boton1");
        JButton button2 = new JButton("Boton2");
        JButton button3 = new JButton("Boton3");
        JButton button4 = new JButton("Botón4");

        // Añadir los bototnes al JFrame
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        
        // Hacer visible y centrar
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

         

        
    }
    
}
