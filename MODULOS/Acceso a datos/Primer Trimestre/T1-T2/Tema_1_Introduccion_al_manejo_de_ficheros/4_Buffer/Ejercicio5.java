/* 
 * Ejercicio 5: Copiar un archivo usando buffers
 * 
 * Crea un programa en Java que permita a los usuarios copiar el contenido de un archivo de texto llamado "archivo_origen.txt" en otro archivo de texto llamado "archivo_destino.txt" utilizando buffers para mejorar la eficiencia en la lectura y escritura de archivos. El programa debe seguir estos pasos:

Abre el archivo de origen ("archivo_origen.txt") en modo lectura.

Abre el archivo de destino ("archivo_destino.txt") en modo escritura. Si el archivo de destino ya existe, el programa debe sobrescribir su contenido.

Utiliza un buffer de lectura y un buffer de escritura para copiar el contenido del archivo de origen al archivo de destino en bloques de datos. Puedes definir el tamaño del buffer (por ejemplo, 1024 bytes o más pequeño hasta que veáis el tamaño de cada bloque copiado).

Mientras haya datos disponibles en el archivo de origen, lee un bloque de datos en el buffer de lectura y escribe ese bloque en el archivo de destino utilizando el buffer de escritura. Al final de cada bloque, escribir un comentario tipo "Fin copia bloque 1"

Una vez copiados los datos, introducir una cadena de caracteres al final del documento destino, por ejemplo, "Última modificación: 25-09-2023 15:04:01"
 Cierra ambos archivos después de completar la copia.

Asegúrate de manejar adecuadamente las excepciones en caso de que los archivos no existan o ocurra algún otro error relacionado con la lectura o escritura de archivos.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
 
 public class Ejercicio5 {
     public static void main(String[] args) {
 
         String archivoOrigen = "Texto de ejemplo sin ningun tipo de significado";
         int buffersize = 10;
 
         try {
             File file = new File("C:\\Users\\Usuario\\Desktop\\MEDAC\\2ºDAM\\Acceso a datos\\Tema_1_Introduccion_al_manejo_de_ficheros\\4_Buffer\\Texto_origen.txt");
             File file2 = new File("C:\\Users\\Usuario\\Desktop\\MEDAC\\2ºDAM\\Acceso a datos\\Tema_1_Introduccion_al_manejo_de_ficheros\\4_Buffer\\Texto_destino.txt");
 
             if (file.exists()) {
             } else {
                 file.createNewFile();
             }
 
             try (FileWriter fw = new FileWriter(file)) {
                 fw.write(archivoOrigen);
             }
 
             // con esto abrimos el archivo en modo lectura
             try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
                 // CREAR UN ARRAY DE BYTES PARA ALMACENAR CADA BLOQUE LEIDO
                 byte[] buffer = new byte[buffersize];
                 int info;
                 int blockNumber = 1;
                 // ARRAY DE BYTES PARA ALMACENAR LA COPIA
                 byte[] copia;
 
                 try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file2))) {
                     while ((info = bis.read(buffer)) != -1) {
                         // CONVIERTE EL BLOQUE LEIDO EN TEXTO
                         String contenidoBloque = "Bloque " + blockNumber + ": " + new String(buffer, 0, info, "UTF-8")+"\n";
                         // PASAMOS EL TEXTO RECOGIDO DE EL STRING A ARRAY DE BYTES
                         copia = contenidoBloque.getBytes();
                         // ESCRIBIMOS EL ARRAY
                         bos.write(copia);
                         System.out.print(contenidoBloque);
                         blockNumber++;
                     }
                 }
             }
         } catch (IOException e) {
             System.out.println(e.getMessage());
         }
     }
 }