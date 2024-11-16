import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Ejemplo {
    public static void main(String[] args) {

        String archivo = "G:\\Mi unidad\\2º-DAM\\MODULOS\\Acceso a datos\\Tema_1_Introduccion_al_manejo_de_ficheros\\4_Buffer\\archivoOrigen.txt";

        int bufferSize = 10;

        try {

            //lectura input, output escritura
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(archivo));

            //Crear un array de bytes para almacenar cada bloque leido de 10 bytes
            byte[] buffer = new byte[bufferSize];
            int info;
            int blockNumber = 1; //incrementar el bloque que va leyendo

            //leer bloques de datos del archivo
            while((info = bufferedInputStream.read(buffer)) != -1){
                //convierte el bloque leido en texto
                String contenidoBloque = new String(buffer, 0, info, "UTF-8");

                //Imprimir el contenido del bloque
                System.out.println("Contenido del bloque: " + blockNumber + ": ");
                System.out.println(contenidoBloque);
                System.out.println("Fin del bloque " + blockNumber);

                blockNumber++;
            }


        } catch (Exception e) {
            // TODO: handle exception
        }

        
        
    }
}

