/* 
 * Desarrollo de un Gestor de Archivos Simple en Java
 * 
 * El objetivo es crear un programa que pueda crear directorios nuevos, crear ficheros, mover archivos 
y obtener la fecha de la última modificación de los ficheros. Deberás utilizar la clase 'java.io.File' 
y sus métodos 'createNewFile()', 'lastModified()', 'renameTo()', 'mkdirs()', etc. para implementar estas funcionalidades.

 * Esta tarea permitirá practicar el uso de la manipulación de archivos en Java y comprender cómo interactuar con la clase 'File'
 para realizar operaciones básicas de gestión de archivos.
 
 */
import java.io.File;
public class Ejercicio1 {

    public static void main(String[] args) {

        try{
            //comprobar fichero
            String nombre = "ejemplo.txt";
            File fichero = new File(".\\Explicacion_Ejemplo\\" + nombre);
            //comprobar si existe 
            if(fichero.createNewFile()){
                System.out.println("Fichero ya creado: " + fichero.getName());
            }else{
                System.out.println("El fichero ya existe.");
            }

            //Crear una carpeta 
            String nombreCarpeta = "Backup";
            File carpeta = new File(".\\Explicacion_Ejemplo\\" + nombreCarpeta);
            //comprobar si la carpeta existe
            if(carpeta.mkdir()){
                System.out.println("Carpeta creada: " + carpeta.getName());
            }else{
                System.out.println("La carpeta ya existe");
            }

            //Mover fichero a carpeta Backup
            File destinoFichero = new File(carpeta, "Ejemplo.txt");
            

        }catch(Exception e){

        }

    }

}
