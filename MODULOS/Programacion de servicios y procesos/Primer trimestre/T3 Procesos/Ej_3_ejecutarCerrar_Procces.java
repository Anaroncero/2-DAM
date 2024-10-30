package T3;
public class Ej_3_ejecutarCerrar_Procces {
    public static void main(String[] args) {

        /* 
         * Ejemplo de ejecutar y cerrar programa
         */
        
         // Pregunta: ¿¿Cuál es el problema del método destroy()? Se intenta cerrar el proceso, pero puede haber bloqueos del sistema operativo que lo impidan

        try{
            // Ejecutamos programa
            ProcessBuilder paint = new ProcessBuilder("mspaint");
            Process p = paint.start(); // Clase de Java que se utiliza para controlar un proceso después de haber sido lanzado

            // Cerramos programa
            Thread.sleep(5000); //tiempo para cerrarse 5segundos
            p.destroy();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
