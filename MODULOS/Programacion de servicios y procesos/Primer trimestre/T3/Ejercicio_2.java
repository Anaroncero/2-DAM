package T3;
public class Ejercicio_2 {
    public static void main(String[] args) {

        /*
         * 2. Desarrolla un programa que muestre un menú con 3 opciones de 3 programas, y
         * el usuario elige qué programa desea abrir
         */

        System.out.println("Menú");
        System.out.println("1. Abrir Visual Studio Code");
        System.out.println("2. Abrir Git Bash");
        System.out.println("3. Abrir Terminal");
        int opcion = Integer.parseInt(System.console().readLine("INTRODUZCA UNA OPCIÓN (numero): "));

        String ruta;

        Process p; // guardar el proceso
        String respuesta;

        switch (opcion) {
            case 1:
                try {
                    // Ejecuta el programa
                    ruta = "C:\\Users\\Usuario\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe";
                    ProcessBuilder visualCode = new ProcessBuilder(ruta);
                    Thread.sleep(2000);
                    p = visualCode.start();

                    System.out.println("¿Quieres cerrar el programa?(si)(no):");
                    respuesta = System.console().readLine();

                    // Cierra el programa
                    if (respuesta.equalsIgnoreCase("si")) {
                        p.destroy();
                        Thread.sleep(2000);
                        System.out.println("El programa se ha cerrado.");
                    }

                } catch (Exception e) {

                }

                break;
            case 2:
                try {
                    // Ejecuta el programa
                    ruta = "C:\\Program Files\\Git\\git-bash.exe";
                    ProcessBuilder gitBash = new ProcessBuilder(ruta);
                    Thread.sleep(2000);
                    p = gitBash.start();

                    System.out.println("¿Quieres cerrar el programa?(si)(no):");
                    respuesta = System.console().readLine();

                    // Cierra el programa
                    if (respuesta.equalsIgnoreCase("si")) {
                        p.destroy();
                        Thread.sleep(2000);
                        System.out.println("El programa se ha cerrado.");
                    }

                } catch (Exception e) {

                }

                break;
            case 3:
                try {
                    // Ejecuta el programa
                    ruta = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
                    ProcessBuilder cmd = new ProcessBuilder(ruta);
                    Thread.sleep(2000);
                    p = cmd.start();

                    System.out.println("¿Quieres cerrar el programa?(si)(no): ");
                    respuesta = System.console().readLine();

                    // Cierra el programa
                    if (respuesta.equalsIgnoreCase("si")) {
                        p.destroy();
                        Thread.sleep(2000);
                        System.out.println("El programa se ha cerrado.");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;

            default:
                System.out.println("Elija una opción correcta");
                break;
        }
    }
}
