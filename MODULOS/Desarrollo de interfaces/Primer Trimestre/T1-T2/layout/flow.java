package layout;
import java.awt.*;
import javax.swing.*;


public class flow {


    public static void main(String[] args) {
        
        //Crear frame (ventaan)
        JFrame frame = new JFrame("flowLayout");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout()); //establecer layout

        // añadir los botones
        JButton button1 = new JButton("Boton1");
        JButton button2 = new JButton("Boton2");
        JButton button3 = new JButton("Boton3");
        JButton button4 = new JButton("Botón4");
        JButton button5 = new JButton("Botón5");

        // Añadir los bototnes al JFrame
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);

        //PREGUNTA si utilizo un flow layout como se organizan los componentes y que pasa si no hay espacio suficiente 

        // Hacer visible y centrar ventana
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    
    }
}
