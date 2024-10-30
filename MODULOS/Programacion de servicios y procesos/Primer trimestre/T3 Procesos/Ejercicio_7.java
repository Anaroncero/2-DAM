package T3;

import java.io.File;
import java.util.Set;
import java.util.HashSet;

/* 7.Desarrolla un programa que monitoree cada 30 segundos un directorio en busca de nuevos archivos.
        * Si no hay cambios en el directorio, el programa imprimirá por consola la frase "El listado de archivos NO ha cambiado".
        * Si hay cambios en el directorio, el programa imprimirá por consola la frase "El listado de archvos SI ha cambiado".
        * 
        * Bonus: en caso de que haya cambios, ¿serías capaz de indicar qué fichero es el que falta o se ha añadido uno nuevo?
        * 
        * Monitoreando la carpeta imagenes y si hay una nueva por ejemplo que lo diga 
        * (blucle que cuente las lineas que se generen en un archivo con los nombres 
        * y los compare si aumenta de lineas que diga que ha cambiado)
*/
public class Ejercicio_7 {
    private static final String DIRECTORIO = "D:\\GitHub\\2-DAM\\MODULOS\\Programacion de servicios y procesos\\Primer trimestre\\T3\\imagenes";

    public static void main(String[] args) {

        Set<String> archivosPrevios = listarArchivos(DIRECTORIO);

        while (true) {
            try {
                Thread.sleep(30000); // Espera 30 segundos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            Set<String> archivosActuales = listarArchivos(DIRECTORIO);

            if (archivosActuales.equals(archivosPrevios)) {
                System.out.println("El listado de archivos NO ha cambiado.");
            } else {
                System.out.println("El listado de archivos SI ha cambiado.");
                // Archivos añadidos
                Set<String> añadidos = new HashSet<>(archivosActuales);
                añadidos.removeAll(archivosPrevios);
                if (!añadidos.isEmpty()) {
                    System.out.println("Archivos añadidos: " + añadidos);
                }
                // Archivos eliminados
                Set<String> eliminados = new HashSet<>(archivosPrevios);
                eliminados.removeAll(archivosActuales);
                if (!eliminados.isEmpty()) {
                    System.out.println("Archivos eliminados: " + eliminados);
                }
            }

            // Actualiza la lista de archivos previos
            archivosPrevios = archivosActuales;
        }
    }

    private static Set<String> listarArchivos(String directorio) {
        File folder = new File(directorio);
        Set<String> archivos = new HashSet<>();

        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                archivos.add(file.getName());
            }
        }

        return archivos;
    }
}
