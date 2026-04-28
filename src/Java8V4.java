import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Java 8 Example: Core Language Enhancements
 */
public class Java8V4 {

    public static void main(String[] args) {
        forEachMethodDemo();
        methodReferenceDemo();
        optionalClassDemo();
        interfaceMethodsDemo();
    }

    /**
     * Demonstrates the forEach method added to the Iterable interface.
     */
    private static void forEachMethodDemo() {
        System.out.println("--- forEach Method ---");
        List<String> items = Arrays.asList("A", "B", "C");

        // Internal iteration using a Lambda
        items.forEach(item -> System.out.println("Item: " + item));
    }

    /**
     * Demonstrates Method References (::) as a shorthand for Lambdas.
     */
    private static void methodReferenceDemo() {
        System.out.println("\n--- Method References ---");
        List<String> names = Arrays.asList("java", "python", "scala");

        // Using a method reference to an instance method of an arbitrary object
        // Equivalent to: names.forEach(s -> System.out.println(s))
        names.stream()
             .map(String::toUpperCase) // Reference to String.toUpperCase()
             .forEach(System.out::println); // Reference to System.out.println()
    }

    /**
     * Demonstrates the Optional class for avoiding NullPointerExceptions.
     */
    private static void optionalClassDemo() {
        System.out.println("\n--- Optional Class ---");
        String value = null;
        
        // Wrap a nullable value
        Optional<String> opt = Optional.ofNullable(value);

        // ifPresent: execute code only if the value exists
        opt.ifPresent(v -> System.out.println("Value exists: " + v));

        // orElse: provide a default value if null
        String finalValue = opt.orElse("Default Value");
        System.out.println("Result: " + finalValue);
    }

    /**
     * Demonstrates Default and Static methods in interfaces.
     */
    private static void interfaceMethodsDemo() {
        System.out.println("\n--- Interface Methods ---");
        Vehicle myCar = new Car();
        
        myCar.start();       // Calling abstract method
        myCar.honk();        // Calling default method
        Vehicle.checkFuel(); // Calling static method
    }

    // --- Interface for the demo ---
    interface Vehicle {
        void start(); // Abstract method (old style)

        // Default method: provides a base implementation
        default void honk() {
            System.out.println("Vehicle is honking: Beep Beep!");
        }

        // Static method: utility method belonging to the interface
        static void checkFuel() {
            System.out.println("Static: Checking fuel levels...");
        }
    }

    static class Car implements Vehicle {
        @Override
        public void start() {
            System.out.println("Car is starting...");
        }
    }
}