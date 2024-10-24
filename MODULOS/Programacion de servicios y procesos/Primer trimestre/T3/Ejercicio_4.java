package T3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio_4 {
    public static void main(String[] args) {
        
        /* 4. Haz un programa en el que obtengas tú IP
         * con un comando en cmd
         */

        try {
            String comando = "ipconfig";
            boolean WiFi = false;

            ProcessBuilder cmd = new ProcessBuilder("cmd.exe", "/c", comando);
            Process proceso = cmd.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            String direccionIP = "";

            while ((linea = reader.readLine()) != null) {
                // Imprimir la línea para depuración
                System.out.println(linea);

                // Activar WiFi al encontrar la línea correspondiente
                if (linea.contains("Wi-Fi")) {
                    WiFi = true; 
                } 
                
                // Si estamos en la sección de WiFi, buscar la dirección IP
                if (WiFi && linea.toLowerCase().contains("IPv4")) {
                    direccionIP = linea.substring(linea.indexOf(':') + 1).trim(); // Obtener la IP
                    System.out.println("Dirección IP: " + direccionIP);
                    break; // Salir después de encontrar la IP
                }
                
                // Si encontramos una línea vacía después de Wi-Fi, salir
                if (WiFi && linea.trim().isEmpty()) {
                    break;
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
