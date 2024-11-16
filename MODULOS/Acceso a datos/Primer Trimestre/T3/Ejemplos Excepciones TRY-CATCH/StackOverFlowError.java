public class StackOverFlowError {

    // Error recursivo. (pararlo con ctrl+c). Un error que no para de repetirse
    public static void main(String[] args) {
        recursiveFunction();
    }

    public static void recursiveFunction(){
        recursiveFunction();
    }
}
