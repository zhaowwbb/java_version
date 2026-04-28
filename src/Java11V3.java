import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Java 11 Example: Standard API Enhancements
 */
public class Java11V3 {

    public static void main(String[] args) throws Exception {
        stringApiDemo();
        filesApiDemo();
        collectionToArrayDemo();
        predicateNotDemo();
        optionalIsEmptyDemo();
    }

    /**
     * Demonstrates new String methods: isBlank, lines, strip, and repeat.
     */
    private static void stringApiDemo() {
        System.out.println("--- String API Enhancements ---");
        
        String multiLine = "  \n  Line 1  \nLine 2  \n  ";
        
        // isBlank() checks if string is empty or contains only whitespace
        System.out.println("Is blank: " + "   ".isBlank()); 

        // lines() returns a Stream
        long lineCount = multiLine.lines().count();
        System.out.println("Line count: " + lineCount);

        // strip() is Unicode-aware trimming
        System.out.println("Stripped: '" + "  Java 11  ".strip() + "'");

        // repeat(n)
        System.out.println("Repeat: " + "Hi!".repeat(3));
    }

    /**
     * Demonstrates Files.readString and Files.writeString (JEP 330).
     */
    private static void filesApiDemo() throws Exception {
        System.out.println("\n--- Files API Updates ---");
        Path filePath = Files.createTempFile("java11demo", ".txt");

        // writeString() - No more BufferedWriter boilerplate
        Files.writeString(filePath, "Hello Java 11 Files API!");

        // readString() - Quick reading of file content
        String content = Files.readString(filePath);
        System.out.println("File Content: " + content);
    }

    /**
     * Demonstrates the new Collection.toArray(IntFunction) method.
     */
    private static void collectionToArrayDemo() {
        System.out.println("\n--- Collection to Array ---");
        List<String> list = List.of("Apple", "Banana", "Cherry");

        // Java 11 syntax using a constructor reference
        // This is cleaner than the old 'new String[0]' approach
        String[] array = list.toArray(String[]::new);
        
        System.out.println("Array size: " + array.length);
        System.out.println("First element: " + array[0]);
    }

    /**
     * Demonstrates Predicate.not() to negate a predicate.
     */
    private static void predicateNotDemo() {
        System.out.println("\n--- Predicate.not() ---");
        List<String> words = List.of("Java", "", "Kotlin", " ", "Scala");

        // Using Predicate.not to filter out blank strings
        List<String> nonBlank = words.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());

        System.out.println("Non-blank words: " + nonBlank);
    }

    /**
     * Demonstrates Optional.isEmpty() as the inverse of isPresent().
     */
    private static void optionalIsEmptyDemo() {
        System.out.println("\n--- Optional.isEmpty() ---");
        Optional<String> emptyOpt = Optional.empty();

        // Before Java 11: !emptyOpt.isPresent()
        // Java 11: much more readable
        if (emptyOpt.isEmpty()) {
            System.out.println("The Optional is indeed empty.");
        }
    }
}