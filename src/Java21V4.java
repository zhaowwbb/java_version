public class Java21V4 {

    public static void main(String[] args) {
        System.out.println("--- Pattern Matching for switch (Java 21) ---");

        // Testing different types and conditions
        System.out.println(formatter(42));               // Integer
        System.out.println(formatter(100L));             // Long
        System.out.println(formatter("Java 21"));        // String (Long)
        System.out.println(formatter("JVM"));            // String (Short)
        System.out.println(formatter(null));             // Null safety
        System.out.println(formatter(3.14));             // Default case
    }

    /**
     * Demonstrates type patterns, null patterns, and guarded patterns.
     */
    static String formatter(Object obj) {
        return switch (obj) {
            // 1. Null Case: No more NullPointerException before the switch!
            case null -> "It's a null value";

            // 2. Type Pattern: Automatically casts 'obj' to 'Integer i'
            case Integer i -> String.format("Integer: %d", i);

            // 3. Guarded Pattern: Use 'when' to add logic to a type match
            case String s when s.length() > 5 -> 
                String.format("Long String (%d chars): %s", s.length(), s);

            // 4. Simple Type Pattern for String
            case String s -> "Short String: " + s;

            // 5. Another Type Pattern
            case Long l -> "A large number: " + l;

            // 6. Default Case: Required if the cases aren't exhaustive
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };
    }
}
