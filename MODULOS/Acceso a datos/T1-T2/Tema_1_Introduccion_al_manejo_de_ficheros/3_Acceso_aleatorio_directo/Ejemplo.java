import java.io.RandomAccessFile;


public class Ejemplo {
    public static void main(String[] args) {
        
      
        try {
            //Definimos el objeto y lo instanciamos al fichero
            RandomAccessFile fichero = new RandomAccessFile(".//datos.txt", "rw" );
            //ponemos la posición del byte
            fichero.seek(5);
            //Nos mueve la posicion
            char unByte = (char) fichero.read();
            long filePointer = fichero.getFilePointer();
            
            System.out.println("La posición actual es: " + filePointer);
            System.out.println("El valor es: " + (char) unByte);

            fichero.write(68);
            fichero.close();

            
        } catch (Exception e) {
            e.printStackTrace();
          
        }


    }
}
