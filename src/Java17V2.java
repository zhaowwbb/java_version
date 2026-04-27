public class Java17V2 {

    public static void main(String[] args) {
        Object message = "Hello from Java 21!";
        Object number = 100;

        printDetails(message);
        printDetails(number);
        printDetails(null);
    }

    /**
     * Demonstrates Pattern Matching for instanceof.
     * This eliminates the need for an explicit cast after the type check.
     */
    private static void printDetails(Object obj) {
        // 1. Modern approach: Type check and variable declaration in one line
        if (obj instanceof String s) {
            // 's' is automatically cast to String and available in this scope
            System.out.println("String found (length " + s.length() + "): " + s.toUpperCase());
        } 
        
        // 2. Combining with logical conditions (Guards)
        else if (obj instanceof Integer i && i > 50) {
            System.out.println("Large integer found: " + i);
        } 
        
        else if (obj instanceof Integer i) {
            System.out.println("Small integer found: " + i);
        } 
        
        else {
            System.out.println("Input is either null or an unknown type.");
        }
    }
}