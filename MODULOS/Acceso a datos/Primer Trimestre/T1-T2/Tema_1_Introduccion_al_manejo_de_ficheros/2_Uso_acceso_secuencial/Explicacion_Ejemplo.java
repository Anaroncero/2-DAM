/* 
 * USO DE ACCESO SECUENCIAL:
 * Caracter (FileReader, FileWriter, BufferedReader, BufferedWriter)
 * Byte (FileInputStream, FileOutputStream)
 */

 import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileReader; 
 import java.io.FileWriter;
 import java.io.IOException;
 import java.io.FileNotFoundException;
 

 public class Explicacion_Ejemplo {
 
 /* CARACTER */
 
             // Ruta del archivo
             String ruta = "ejemplo.txt"; // (yo puedo poner el fichero sin especificar ruta si el fichero esta en la misma carpeta del fichero (no dentro del proyecto, en la misma carpeta) en carpeta que contiene al proyecto)
 
             // 1.VERIFICAR SI EL ARCHIVO EXISTE
             File archivo = new File(ruta); // file es un clase importada y esa clase tiene un metodo exists
             boolean archivoExiste = archivo.exists();
     
             if (!archivoExiste) {
                 System.out.println("El fichero no existe, lo crearemos mas adelante");
             } else {
                 System.out.println("El fichero ya existe, sobreescribimos mas adelante");
             }
     
             // 2.Escribir
             try {
                 // Creamos flujos
                 FileWriter fw /* escritor */ = new FileWriter(ruta, true); // false sobreescribe y borra todo. True deja todo lo que hay y a continuación añadiria hola mundo
                 BufferedWriter bw /* flujoSalida */ = new BufferedWriter(fw);
                 
     
                 // Escribimos algunas lineas
                 bw.write("\nHola mundo soy Ana!\n");
                 bw.write("Este es un archivo de ejemplo. \n");
                 bw.write("Estamos escribiendo...\n");
                 System.out.println("Archivo escrito.");
     
                 // Cerramos flujo
                 bw.close();
     
                 // Posibles excepciones
             } catch (FileNotFoundException fnfee) { // java mira los catch en orden del más especifico a los más génericos. Por eso si tenog más de un catch no se puede poner la generica primero porque siempre que haya un error va a saltar la generica y no sabremos que fallo es
                 System.out.println("No se ha encontrado");
             } catch (IOException ioee) { // ha habido un facho con los archivos no se cual
                 System.out.println("No se puede escribir");
             } catch (Exception ee) { // se suele poner al final
                 System.out.println("Error");
             }
     
             // 3.Leer el archivo
             try {
                 // creamos flujos
                 FileReader fr /* lector */ = new FileReader(ruta); // lector de ficheros
                 BufferedReader br = new BufferedReader(fr); // flujo de lectura
     
                 // Leemos hasta que linea sea null (no haya mas lineas)
                 String linea;
                 System.out.println("Contenido del archivo: ");
     
                 //si no sabemos cuantas lineas hay en el txt creamos un while que lea hasta que llegue a una linea nula
                 //si sabemos el numero de lineas hacemos un for 
                 while ((linea = br.readLine()) != null) { //leo la linea la guardo y compruebo que no sea nula
                     System.out.println(linea);
                 }
     
                 // Cerramos flujo
                 br.close();
     
             } catch (FileNotFoundException fnfe) { // java mira los catch en orden del más especifico a los más génericos. Por eso si tenog más de un catch no se puede poner la generica primero porque siempre que haya un error va a saltar la generica y no sabremos que fallo es
                 System.out.println("No se ha encontrado");
             } catch (IOException ioe) { // ha habido un facho con los archivos no se cual
                 System.out.println("No se puede leer");
             } catch (Exception e) { // se suele poner al final
                 System.out.println("Error");
             }
             
         }
     
 
 
