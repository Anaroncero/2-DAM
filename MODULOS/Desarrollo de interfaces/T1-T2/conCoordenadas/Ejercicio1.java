package conCoordenadas;
import javax.swing.*;
import java.awt.*;

public class Ejercicio1{
    public static void main(String[] args) {
        //Crear objeto Frame
        JFrame f = new JFrame("Mi primera ventana");
        //LLamar a metodos de JFrame para tamano, visibilidad, cierre, etc
        f.setSize(400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        //ventana salga centrada
        f.setLocationRelativeTo(null);
    }
}
