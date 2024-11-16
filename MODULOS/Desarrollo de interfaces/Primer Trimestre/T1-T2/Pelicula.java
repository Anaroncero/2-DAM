
import java.awt.*;
import javax.swing.*;

public class Pelicula {
    public static void main(String[] args) {

        /* Ejercicio de información de una pelicula
         * https://www.figma.com/design/D9lHEzOfJkh4tjlh0qDBLK/Ejercicio2-Layout?node-id=0-1&t=HvSB6QPyXMKS9xvn-1
         */

        // Frame grid
        JFrame frame = new JFrame("Ejercicio 10: Mi pelicula favorita");
        frame.setSize(500, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,2));

        // Panel 1 flow
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 1));
        frame.add(panel1);

        // Panel 2 
        JPanel panel2 = new JPanel();
        panel2.setLayout( new GridLayout(1,1));
        frame.add(panel2);

        //JLabel
        JLabel name = new JLabel("Mission Imposible");
        name.setFont(new Font("Arial", Font.BOLD, 24 ));
        panel1.add(name);
        

        JLabel year = new JLabel("2012");

        panel1.add(year);
        

        JLabel director = new JLabel("J. J. Abrams");
        panel1.add(director);

        JLabel sipnosis = new JLabel("<html>Sipnosis: Tras haber llevado a cabo diversas misiones, el agente especial <br> Ethan Hunt se ha retirado del servicio activo y se ha prometido con su amada, Julia. <br> Sin embargo, cuando es secuestrado por uno de los agentes entrenados por él, <br> vuelve de nuevo a la acción. También tiene que enfrentarse a Owen Davian, <br> un individuo sin escrúpulos que trafica con armas y con información. </html>");
        panel1.add(sipnosis);
        sipnosis.setFont(new Font("Arial", Font.PLAIN, 14));
        sipnosis.setPreferredSize(new Dimension(550,100));
        sipnosis.setMaximumSize(new Dimension(550,100));
        
        panel1.add(sipnosis);
       

        // Crear JLabel imagen 
        ImageIcon portada = new ImageIcon("G:\\Mi unidad\\2º-DAM\\MODULOS\\Desarrollo de interfaces\\Tema 1 Introduccion a la confeccion de interfaces\\layout\\mission_imposible.jpg");
        JLabel imagen = new JLabel(portada);
        panel2.add(imagen); 

        // hacer visible y centrar
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        

    }
}
