package layout;

import java.awt.*;
import javax.swing.*;

public class border {
    public static void main(String[] args) {

        // Crear frame (ventana)
        JFrame frame = new JFrame("borderLayout");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); //establecer layout

        // añadir los botones
        JButton button1 = new JButton("Arriba");
        JButton button2 = new JButton("Abajo");
        JButton button3 = new JButton("Derecha");
        JButton button4 = new JButton("Izquierda");
        JButton button5 = new JButton("Centro");

        // Añadir los bototnes al JFrame
        frame.add(button1, BorderLayout.NORTH);
        frame.add(button2, BorderLayout.SOUTH);
        frame.add(button3, BorderLayout.EAST);
        frame.add(button4, BorderLayout.WEST);
        frame.add(button5, BorderLayout.CENTER);

        
        // Hacer visible y centrar ventana
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

}

// PREGUNTA si utilizo un flow layout como se organizan los componentes y que pasa si no hay espacio suficiente