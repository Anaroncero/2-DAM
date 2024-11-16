package conCoordenadas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ejercicio4 {

    static int contador = 0; //con static se puede usar desde cualquier parte del programa

    public static void main(String[] args) {
        
        //Crear ventana
        JFrame frame = new JFrame("Ejercicio 4");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        //JLabel
        JLabel label = new JLabel("X");
        label.setBounds(100, 50, 200, 30);
        frame.add(label);

        //JButton
        JButton button = new JButton("Empiexa a contar!");
        button.setBounds(100, 100, 200, 20);
        frame.add(button);

        button.addActionListener(new ActionListener() {
            //Cuando se presione el botón se incrementa el contador y se muestra 
            public void actionPerformed(ActionEvent e){
                contador++;
                label.setText(Integer.toString(contador));
            }
        });
    }
}
