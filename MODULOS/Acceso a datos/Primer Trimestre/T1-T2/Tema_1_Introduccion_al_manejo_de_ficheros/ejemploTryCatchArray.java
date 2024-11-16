package Tema_1_Introduccion_al_manejo_de_ficheros;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class jdklasjdklsajkdjasl {
    public static void main(String[] args) {

        
        byte[] datos = {65, 66, 67, 68};
        
        try {
            
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("archivo.bin"));
            bos.write(datos);
            bos.flush();
            bos.close();

        } catch (IOException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }

    }
}
