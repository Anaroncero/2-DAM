package conCoordenadas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Ejercicio3 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Ejercicio 3");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        //JLabel
        JLabel label = new JLabel("Hola Mundo!");
        label.setBounds(150, 50, 200, 30);
        frame.add(label);

        //JButton
        JButton button = new JButton("Presióname");
        button.setBounds(150, 100, 120, 30);
        frame.add(button);

        // Añadir ActionListener al botón
        // Listener: hace que el programa 'escuche' o este pendiente del botón
        // Event:es lo que pasa cuando el listener avisa de un clic en el botón
        button.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e){
                //cambiar el texto cuando se haga clic en el botón
                label.setText("Botón presionado!");
            }
        });


    }
}
