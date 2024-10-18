package layout;
import java.awt.*;
import javax.swing.*;


/* Ejercicio 1: dos paneles en un frame con gridLayout y botones*/
public class Ejercicio1 {
    public static void main(String[] args) {
        
        // Frame  grid 1x2
        JFrame frame = new JFrame("Ejercicio1");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 2));

        // Panel uno  flowLayout
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        frame.add(panel1); //añadir panel1 al frame(ventana)

        // Panel dos gridLayout
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 2));
        frame.add(panel2);

        // Botones
        JButton button1 = new JButton("Botón1");
        JButton button2 = new JButton("Botón2");
        JButton button3 = new JButton("Botón3");
        JButton button4 = new JButton("Botón4");

        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);

        JButton button5 = new JButton("Botón1");
        JButton button6 = new JButton("Botón2");
        JButton button7 = new JButton("Botón3");
        JButton button8 = new JButton("Botón4");

        panel2.add(button5);
        panel2.add(button6);
        panel2.add(button7);
        panel2.add(button8);


        // hacer visible y centrar
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);





    }
    
}
