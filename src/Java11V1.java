import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * Java 11 Example: Using @NotNull with 'var' in Lambda Parameters
 */
public class Java11V1 {

    // Defining a local @NotNull annotation for this example
    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    @interface NotNull {}

    public static void main(String[] args) {
        List<String> items = List.of("Microphone", "Laptop", "Camera");

        // Java 11 allows @Annotation with var
        // This is the only way to use annotations while keeping type inference
        items.forEach((@NotNull var item) -> {
            System.out.println("Item: " + item);
        });

        // Example with multiple parameters
        Calculator multiply = (@NotNull var x, @NotNull var y) -> x * y;
        
        System.out.println("Result: " + multiply.operate(10, 5));
    }

    interface Calculator {
        int operate(int a, int b);
    }
}