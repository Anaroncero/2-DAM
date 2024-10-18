package T3;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.*;

public class Ejercicio_6 {
    public static void main(String[] args) {
        /*
         * Pregunta ¿Cuál es la Diferencia programa y proceso?
         * rograma conjunto de instrucciones, ficheros, imagenes, codigo. Proceso es el
         * programa ejecutandose
         * por el proceso operativo al que se le otorga una cantidad de memoria ram uso
         * de cpu etc para su funcionamiento
         */

        /*
         * 6. Crea un programa que permita al usuario ingresar el nombre de un proceso
         * (por ejemplo, "notepad.exe") y luego verifique si ese proceso está en
         * ejecución en el sistema. Debe mostrar un
         * mensaje indicando si el proceso está en ejecución o no.
         */

        // Preguntar al usuario
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Introduzca el nombre del proceso y le digo su estado de ejecución?");
        String nameProceso = sc.nextLine();

        
        try {
            // Variable del comando
            String comando = "Get-process";
            Boolean b = false;

            ProcessBuilder cmd = new ProcessBuilder("powershell.exe", "/C", comando);
            Process proceso = cmd.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;

            // Comprobar si el proceso se encuentra en ejecución
            while ((linea = reader.readLine()) != null) {
                if (linea.contains(nameProceso)) {
                    System.out.println("El proceso se encuentra en ejecución");
                    reader.close();
                    b = true;
                }
            }
            
            // Mensaje si no está el proceso en ejecución
            if (b != true) {
                System.out.println("No esta ese proceso en ejecución");
            }

            reader.close();


        } catch (Exception e) {

        }

    }

}

