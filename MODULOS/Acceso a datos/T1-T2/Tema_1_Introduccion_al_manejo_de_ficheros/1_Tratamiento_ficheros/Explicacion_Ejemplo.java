/* 
TRATAMIENTO DE FICHEROS:
 * Crear ficheros
 * Crear carpetas
 * Comprobar si existen
 * Mover fichero
 * Eliminar fichero/carpetas
 * Consultar nombre
 * Renombrar fichero
 * Devolver rutas
 * Directorio padre
 * Listar ficheros de una carpeta
 * Consultar fecha modificación
 */
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;


public class Explicacion_Ejemplo {
    public static void main(String[] args) {

        // Try-catch para manejar errores ficheros
        try {

            // Crear fichero
            File fichero = new File(".\\Tema_1_Introduccion_al_manejo_de_ficheros\\Explicacion_Ejemplo\\Ejemplo1.txt");
            // Comprobar si existe
            if (fichero.createNewFile()) {
                System.out.println("Fichero creado: " + fichero.getName());
            } else {
                System.out.println("El fichero ya existe.");
            }



            // Crear carpeta Backup
            File carpeta = new File(".\\Tema_1_Introduccion_al_manejo_de_ficheros\\Explicacion_Ejemplo\\Backup");
            // Comprobar si existe
            if (carpeta.mkdir()) {
                System.out.println("Carpeta creada: " + carpeta.getName());
            } else {
                System.out.println("La carpeta ya existe.");
            }



            // Crear otra carpeta con variable
            String nombreCarpeta = "backup2";
            File carpeta2 = new File(".\\Tema_1_Introduccion_al_manejo_de_ficheros\\Explicacion_Ejemplo", nombreCarpeta);
            // Comprobar si existe
            if (carpeta2.mkdir()) {
                System.out.println("Carpeta creada: " + carpeta2.getName());
            } else {
                System.out.println("La carpeta ya existe.");
            }

            // Comprobar si la carpeta existe 
            if (carpeta.exists()) {
                System.out.println("La carpeta " + carpeta.getName() + " ya existe.");
            } else {
                System.out.println("creando carpeta");
                carpeta.mkdirs();
                System.out.println("carpeta creada");
            }



            // Mover fichero a carpeta Backup
            File ficheroDestino = new File(carpeta, "Ejemplo1.txt");
            if (fichero.renameTo(ficheroDestino)) {
                System.out.println("Fichero movido con éxito a: " + ficheroDestino.getAbsolutePath());
            } else {
                System.out.println("Error al mover el fichero.");
            }



            // Renombrar fichero
            File sourceFile = new File(".\\Tema_1_Introduccion_al_manejo_de_ficheros\\Explicacion_Ejemplo\\Backup\\Ejemplo1.txt");
            File destFile = new File(".\\Tema_1_Introduccion_al_manejo_de_ficheros\\Explicacion_Ejemplo\\Backup\\Notas.txt");

            if (sourceFile.renameTo(destFile)) {
                System.out.println("Fichero renombrado a: " + destFile.getName());
            } else {
                System.out.println("No se ha podido renombrar.");
            }

            

            // Devolver rutas
            //Devolver la ruta relativa 
            System.out.println("Ruta relativa: " + carpeta.getPath());
            //Devolver la ruta absoluta
            System.out.println("Ruta absoluta: " + carpeta.getAbsolutePath());



            // Listar ficheros de una carpeta
            System.out.println("Ficheros de la carpeta: ");
            File[] ficheros = carpeta.listFiles();
            for (int i=0; i<ficheros.length; i++){
                System.out.println(ficheros[i].getName());
            }

            // Directorio Padre
            System.out.println("El directorio padre de este fichero es: ");
            fichero.lastModified();
            
            
            // Consultar fecha modificación
            long lastModified = destFile.lastModified();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date lastModifiedDate = new Date(lastModified);
            System.out.println("La fecha de moficación es: " + sdf.format(lastModifiedDate));




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
