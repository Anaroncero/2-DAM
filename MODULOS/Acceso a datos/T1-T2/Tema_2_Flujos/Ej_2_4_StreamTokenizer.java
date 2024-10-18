
/* Ejemplo 2.4: Procesamiento de Texto con StreamTokenizer en Java

Objetivo:
Aprender a utilizar la clase StreamTokenizer en Java para procesar el contenido de un archivo, 
identificando palabras y números en el texto. Esta práctica permitirá a los estudiantes trabajar 
con la tokenización de texto, reconociendo palabras, números y opcionalmente fin de línea.

Instrucciones:
Crea un programa en Java que utilice la clase StreamTokenizer para leer un archivo de texto y procesar su contenido.
El programa debe distinguir entre palabras y números en el archivo, imprimiendo cada token que se encuentra.
Opcionalmente, configura el programa para que también identifique el fin de línea y lo imprima. */
import java.io.FileReader;
import java.io.StreamTokenizer;
import java.io.FileReader;

public class Ej_2_4_StreamTokenizer {
    public static void main(String[] args) {

       
        try {
            StreamTokenizer st = new StreamTokenizer(new FileReader("G:\\Mi unidad\\2º-DAM\\MODULOS\\Acceso a datos\\Tema_2_Flujos\\datosE4.txt"));

            //Para que funcione el TT_EOL (fin de linea):
            st.eolIsSignificant(true);
             
            while(st.nextToken() != StreamTokenizer.TT_EOF){ //leyendo hasta el final del fichero
                
                //Muestra solo las palabras del archivo
                if(st.ttype == StreamTokenizer.TT_WORD){ //si el tipo es string (una palabra)
                    System.out.println("Palabra -" + st.sval);
                    
                    
                    //Muestra los numeros del archivo
                }else if(st.ttype == StreamTokenizer.TT_NUMBER){
                    System.out.println("Numero -" + st.nval);

                    //Fin de línea
                }else if(st.ttype == StreamTokenizer.TT_EOL){
                    System.out.println("_______FIN DE LINEA_______");

                }
            }


        }catch(

    Exception e)
    {

    }

}}
