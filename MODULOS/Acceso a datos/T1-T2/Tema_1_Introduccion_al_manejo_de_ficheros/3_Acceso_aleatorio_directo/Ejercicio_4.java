import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;
/* 
 * Ejercicio 4: Uso de acceso aleatorio o directo
 * Acceso aleatorio o directo
 * RandomAccesFile

 * Crea un programa en Java que permita a los usuarios modificar el contenido de un archivo de texto llamado "datos.txt". El programa debe seguir estos pasos:

 * Escribe el abecedario en el fichero de texto mediante FileWriter.

Abre el archivo "datos.txt" en modo de lectura y escritura.
Pide al usuario que ingrese una posición (un número entero) en el archivo donde desea realizar la modificación.

Pide al usuario que ingrese los datos (un carácter, como un espacio) que desea escribir en esa posición. 

Utiliza RandomAccessFile para posicionarte en la posición especificada por el usuario y sobrescribir el contenido con los nuevos datos ingresados.

Cierra el archivo después de realizar la modificación.

Asegúrate de manejar adecuadamente las excepciones en caso de que el archivo no exista, la posición especificada sea inválida o ocurra algún otro error relacionado con la lectura o escritura de archivos.
 */

public class Ejercicio_4 {

    public static void main(String[] args) {
        
        try {
            // Crear fichero
            File fichero = new File(".//3_Acceso_aleatorio_directo//datos.txt");
            if (fichero.createNewFile()) {
                // Escribir el abecedario en el fichero
                FileWriter fw = new FileWriter(fichero);
                fw.write("abcdefghijklmnopqrstuvwxyz"); // Escribimos el abecedario

                fw.close();
            }

            // Abrir archivo en modo lectura y escritura RandomAccessFile
            RandomAccessFile file = new RandomAccessFile(fichero, "rw");

            // Pedir al usuario
            Scanner scan = new Scanner(System.in);
            System.out.println("Indica la posición a modificar (0-25):");
            int pos = scan.nextInt();
            // Validar la posición
            if (pos < 0 || pos >= 26) {
                System.out.println("Posición inválida. Debe estar entre 0 y 25.");
                file.close();
            }

            
            // Muestra el byte en la posición
            file.seek(pos); //seek es el puntero de la posicion
            char letraActual = (char) file.read(); // Leer el carácter actual
            System.out.println("El carácter actual en la posición " + pos + " es: " + letraActual);

            System.out.println("Indica la nueva letra:");
            char nuevaLetra = scan.next().charAt(0); // Leer el nuevo carácter
            file.seek(pos); // Volver a posicionar
            file.write(nuevaLetra); // Escribir el nuevo carácter

            // Mostrar el resultado final
            file.seek(pos); // Volver a posicionar para leer
            char letraModificada = (char) file.read(); // Leer el carácter modificado
            System.out.println("El nuevo carácter en la posición " + pos + " es: " + letraModificada);

            file.close();
            scan.close();

        } catch (Exception e) {
            e.printStackTrace();// Imprimir la traza de la excepción
             
        }

        
    }
}
