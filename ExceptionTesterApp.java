import java.io.FileNotFoundException;

public class ExceptionTesterApp {

    public static void main(String[] args) {

        System.err.println("In main: calling method1.");

        try {
            method1();
        }
        catch (FileNotFoundException e) {
            System.err.println("ERROR: File not found. " + e.getMessage());
        }

        System.err.println("In main: returned from method1.");
    }

    public static void method1() throws FileNotFoundException {

        System.err.println("\tIn method1: calling method2.");

        method2();

        System.err.println("\tIn method1: returned from method2.");
    }

    public static void method2() throws FileNotFoundException {

        System.err.println("\t\tIn method2: calling method3.");

        method3();

        System.err.println("\t\tIn method2: returned from method3.");
    }

    public static void method3() {

        System.err.println("\t\t\tIn method3: Entering.");

        // 🔥 Checked exception being thrown (for assignment)
        try {
            throw new FileNotFoundException("Test file not found");
        }
        catch (FileNotFoundException e) {
            System.err.println("\t\t\tCaught in method3: " + e.getMessage());
            throw new RuntimeException(e); // wraps it so it can still propagate
        }

        // unreachable but left for clarity
        // System.err.println("\t\t\tIn method3: Exiting.");
    }
}