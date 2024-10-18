import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* Ejemplo7: Copiar un archivo binario (imagen)
En este ejercicio, leeremos una imagen de tipo .jpg con 
BufferedInputStream y la copiaremos a otro archivo usando 
BufferedOutputStream.

Objetivo:
Copiar una imagen binaria de un archivo de origen a un archivo de destino, usando buffers para mejorar la eficiencia en la lectura y escritura
*/

public class Ejercicio7 {

    public static void main(String[] args) {

        String archivoOrigen = "G:\\Mi unidad\\2º-DAM\\MODULOS\\Acceso a datos\\Tema_1_Introduccion_al_manejo_de_ficheros\\4_Buffer\\imagen.jpg";
        String archivoDestino = "G:\\Mi unidad\\2º-DAM\\MODULOS\\Acceso a datos\\Tema_1_Introduccion_al_manejo_de_ficheros\\4_Buffer\\imagen_copia.jpg";

        try {

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(archivoOrigen));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(archivoDestino));

            // Leer todo el contenido
            int byteLeido;
            System.out.println(bis.available()); //información cuantos bytes se pueden leer sin bloquear
            
            while ((byteLeido = bis.read()) != -1) {
                bos.write(byteLeido);
            }
            bos.flush(); // asegurar que se escriban todos los datos

            System.out.println("copia realizada con exito");

        } catch (IOException e) {
            System.out.println("Ocurrio un error " + e.getMessage());
        }

    }

}
