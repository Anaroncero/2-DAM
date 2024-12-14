/* 
Proyecto 1_SocketTCP
	-ServidorTCP.java (IP: localhost, Puerto: 6000)
	-ClienteTCP.java (dinámico, se encarga el sistema operativo de asignarle el puerto)
*/

/* 
 * Esta clase representa un servidor TCP simple para demostrar la comunicación 
 * básica mediante sockets en Java.
 */

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

public class ServidorTCP {
    
    //Puerto en el que escucha el servidor
    private static final int PUERTO = 6000; //constantes final se suelen poner nombres en mayuscula

    //Número máximo de clientes a los que el servidor puede atender
    private static final int MAX_CLIENTES = 3;

    //CONSTRUCTOR DE LA CLASE
    public ServidorTCP(){
        try {
            
            //Crear un socket (IP+PUERTO)servidor que escucha en el puerto 6000
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escuchando en el puerto " + PUERTO);

            //Escuchar a un cierto número de clientes
            for(int numCli = 0; numCli < MAX_CLIENTES; numCli++){ //Se mejoraría con Hilos aqui solo podrian recibir mensaje 3 clientes
                //Esperar a que un cliente se conecte
                Socket skCliente = skServidor.accept(); //aceptando al cliente y lo guardo
                
                //accept()
                // 1. Quedarse a la espera de recibir petición
                // 2. Establece conexión con el cliente (aceptarlo)
                // 3. Devolver los datos del cliente en un objeto socket (ip, puerto... lo necesario para luego mandarle cosas
                
                //Mostrar mensaje al servidor cuando un cliente se conecte 
                System.out.println("Constentando al cliente: " + numCli);
                
                //Obtener el FLUJO de SALIDA del cliente (mensajes enviados al cliente)
                OutputStream aux = skCliente.getOutputStream(); //flujo de datos que va desde el servidor(esta clase) hasta el cliente
                DataOutputStream flujo = new DataOutputStream(aux); //convirtiendo el camino anterior a DataOutputStream que trabaja en bytes

                //Enviar un mensaje al cliente
                flujo.writeUTF("Hola cliente " + numCli);

                //Cerrar el socket del cliente después de enviar el mensaje
                skCliente.close();
            }

            //Mostrar un mensaje cuando se alcanza el límite de clientes
            System.out.println("Demasiados clientes por hoy");
            //Cerrar servidor
            skServidor.close();

        } catch (IOException e) {
            // Manejar errores de entrada/salida (E/S)
            System.out.println("Error en el servidor: " + e.getMessage());
            
        }
    }

 /* 
 * MAIN que lanza el constructor
 */ 
    public static void main(String[] args){
        //Crear una instancia del servidor para iniciar la escucha
        new ServidorTCP();
    }


}
