import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java 8 Example: Lambda Expressions & Functional Interfaces
 */
public class Java8V1 {

    // 1. Defining a Custom Functional Interface
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }

    public static void main(String[] args) {
        
        // --- Custom Functional Interface with Lambda ---
        // Syntax: (parameters) -> { body }
        MathOperation addition = (a, b) -> a + b;
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        System.out.println("Addition (10 + 5): " + addition.operate(10, 5));
        System.out.println("Multiplication (10 * 5): " + multiplication.operate(10, 5));

        // --- Using Built-in Functional Interfaces ---
        List<String> languages = List.of("Java", "Python", "C++", "JavaScript", "Go");

        // 2. Predicate<T>: Takes one argument, returns a boolean
        // We use it here to filter strings starting with 'J'
        System.out.print("\nLanguages starting with 'J': ");
        filterAndPrint(languages, (str) -> str.startsWith("J"));

        // 3. Consumer<T>: Takes one argument, returns nothing (void)
        // Used in the forEach method
        System.out.println("\nAll Languages (via Consumer):");
        languages.forEach(lang -> System.out.println(" - " + lang));
    }

    /**
     * Helper method that accepts a Functional Interface (Predicate) as a parameter
     */
    private static void filterAndPrint(List<String> list, Predicate<String> condition) {
        for (String item : list) {
            if (condition.test(item)) {
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }
}