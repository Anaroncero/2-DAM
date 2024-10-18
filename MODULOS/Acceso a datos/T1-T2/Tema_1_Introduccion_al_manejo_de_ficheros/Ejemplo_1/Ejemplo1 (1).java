import java.io.File;
public class Ejemplo1 {
    public static void main(String[] args) {

        //try catch para manejar errores 
        try{
            File fichero = new File(".\\Ejemplo1.txt"); // crear fichero
            fichero.createNewFile(); 
            // borrar fichero.delete(); 
            


            //CREAR CARPETA con ruta
            File carpeta = new File(".\\Backup"); 
            carpeta.mkdir(); //crear carpeta
            //carpeta.delete();



            //CREAR CARPETA con variable
            String nombreCarpeta = "backup2";
            File carpeta2 = new File(".\\", nombreCarpeta); 
            carpeta2.mkdir(); //crear carpeta
            //fichero.delete(); 



            //MOVER fichero a carpeta backup
            // 1 forma
            fichero.renameTo(new File(carpeta, "Ejemplo1.txt"));
            // 2 forma
            File ficheroDestino = new File (".\\Backup\\Ejemplo1_movido.txt");
            fichero.renameTo(ficheroDestino);

            if(fichero.renameTo(ficheroDestino)){
                System.out.println("Fichero movido con exito");
            }else{
                System.out.println("error al mover el fichero");
            }


            //RENOMBRAR
            File sourceFile = new File("Notes.txt");
            File destFile = new File("Notas.txt");

            if(sourceFile.renameTo(destFile)){
                System.out.println("se ha renombrado con exito");
            }else{
                System.out.println("no se ha podido renombrar");
            }


            //comprobar si la carpeta existe 
            if(carpeta.exists()){
                System.out.println("la carpeta " + carpeta.getName() + " ya existe");
            }else{
                carpeta.mkdirs();
            }

            //Devolver la ruta relativa 
            carpeta.getPath();
            //Devolver la ruta absoluta
            carpeta.getAbsolutePath();

        } catch (Exception e){
            
            
        }
    }
}