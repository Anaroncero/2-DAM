package T3;

import java.io.*;


public class Ejercicio_5 {
    public static void main(String[] args) {
        
        /* 5. Desarrolla un programa capaz de guardar la lista de procesos en ejecución en tu ordenador
        en un txt. Para ello, puedes conecar desd eJava con CMD  o con PowerShell.
        
        CMD > tasklist
        PowerShell > Get-process
        */
        
        try {
            // Variable con el comando
            String comando = "Get-process";

            // Lanzamos el proceso
            ProcessBuilder cmd = new ProcessBuilder("powershell.exe", "/C", comando);
            Process proceso = cmd.start();

            // Leemos el resultado del comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;

            // Creamos archivo
            String ruta = "G:\\Mi unidad\\2º-DAM\\MODULOS\\Programacion de servicios y procesos\\T3\\procesos.txt";
            File file = new File(ruta);

            // Creamos bufferedWriter para escribir en el archivo
            BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));

            // Recorremos las lineas devueltas del comando hasta que sea nulo (leemos del buffered)
            while ((linea = reader.readLine()) != null) {
                writer.write(linea);
                writer.newLine();
            }

            System.out.println("Escrito correctamente");

            // Cerrar archivo y buffered
            writer.close();
            reader.close();

            // Esperar a que el proceso termine
            proceso.waitFor();

            // Salida
            System.out.println("Lista de proesos guardada en: " + ruta);

        } catch (IOException ioe) {
            System.out.println("Error en ficheros/directorios");
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Otro error");
        }
        
    }
}
