
/* 
 * Esta clase representa un cliente TCP simple para demostrar la 
 * comunicación básica mediante sockets en Java
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClienteTCP {

    //LE ESTOY DANDO LA IP Y EL PUERTO DEL SERVIDOR (para conectarnos al servidor necesitamos el puerto del servidor)

    //Direción de servidor al que se conectará el cliente
    private static final String HOST = "localhost";
    //Puerto en el que escucha el servidor
    private static final int PUERTO = 6000;

    public ClienteTCP(){
        try {
            //Crear un socket cliente para conectarse al servidor en el localhost y puerto 6000
            Socket skCliente = new Socket(HOST, PUERTO); //Esta linea en el cliente es al que se conecta al servidor en el momento que se ejecute esta linea el servidor acepta con accept()
            
            //RECIBE DEL SERVIDOR Obtener el FLUJO DE ENTRADA del cliente (mensajes recibidos)
            InputStream aux = skCliente.getInputStream();
            DataInputStream flujo = new DataInputStream(aux);

            //Mostrar en la consola el mensaje recibido del servidor
            System.out.println("Mensaje recibido del servidor: ");
            System.out.println(flujo.readUTF()); //leo los datos que me llegan y los imprimo

            //Cerrar el socket cliente después de recibir el mensaje
            skCliente.close();


        } catch (IOException e) {
             //Manejar errores de entrada/salida (E/S)
             System.out.println("Error en el cliente: " + e.toString());
        }

    }
    
/* 
 * MAIN
 */
    public static void main(String[] args){
        //Crear una instancia del cliente para iniciar la conexión
        new ClienteTCP();

    }
}
