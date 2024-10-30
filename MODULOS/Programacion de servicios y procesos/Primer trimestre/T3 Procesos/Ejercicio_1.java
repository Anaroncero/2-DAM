package T3;
public class Ejercicio_1 {
    public static void main(String[] args) {

        /* 1. Abre en Chrome y Edge 
        la url de Medac */

        try {

            String url = "http://medac.es/";
            String rutaChrome = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            String rutaEdge = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";

            ProcessBuilder chrome = new ProcessBuilder(rutaChrome, url);
            Thread.sleep(2000);
            chrome.start();

            ProcessBuilder microsoftEdge = new ProcessBuilder(rutaEdge, url);                                                                   
            Thread.sleep(2000);
            microsoftEdge.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
