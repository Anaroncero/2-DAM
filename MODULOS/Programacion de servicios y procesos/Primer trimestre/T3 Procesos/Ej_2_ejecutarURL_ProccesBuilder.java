package T3;
public class Ej_2_ejecutarURL_ProccesBuilder {
    public static void main(String[] args) {
        
        try {

            // Para abrir la aplicación en esa ruta, si no esta ahí no funciona
            String url = "http://medac.es/";
            String rutaChrome = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";

            ProcessBuilder chrome = new ProcessBuilder(rutaChrome, url);
            Thread.sleep(2000);
            chrome.start();

            /*Variable de entorno: En llugar de poner la ruta, poner el nombre de la variable donde windows tiene 
            la ruta de chrome (seria como preguntarle a windows, la forma de que funcione en todos los equipos)*/

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        


    }
}
