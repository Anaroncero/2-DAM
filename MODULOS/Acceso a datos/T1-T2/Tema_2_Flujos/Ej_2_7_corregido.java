import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio7 {
    public static void main(String[] args) {
        try {

            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.bin"));
            dataOutputStream.writeInt(123);
            dataOutputStream.writeInt(987);
            dataOutputStream.writeFloat(123.45F);
            dataOutputStream.writeLong(789);
            dataOutputStream.writeDouble(9.3);
            dataOutputStream.close();

            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("data.bin"));
            //int aByte = dataInputStream.read();
            int entero = dataInputStream.readInt();
            int entero1 = dataInputStream.readInt();
            float numeroFloat = dataInputStream.readFloat();
            long numeroLong = dataInputStream.readLong();
            double numerodouble = dataInputStream.readDouble();
            dataInputStream.close();
            System.out.println("El número entero es: "+entero);
            System.out.println("El número entero es: "+entero1);
            System.out.println("El objeto de tipo float es: "+numeroFloat);
            System.out.println("El double es :"+numerodouble);
            System.out.println("El objeto long es: "+numeroLong);


            } catch (FileNotFoundException e) {
            e.printStackTrace();
            } catch (IOException e) {
            e.printStackTrace();
            }
    }
}
