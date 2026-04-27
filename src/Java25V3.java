// Java 25: Import everything exported by the java.base module
import module java.base;

void main() {
    // List, Collectors, and Path are all available automatically
    var fruits = List.of("apple", "banana", "cherry");
    var result = fruits.stream()
                       .filter(f -> f.startsWith("a"))
                       .collect(Collectors.toList());
                       
    System.out.println("Filtered: " + result);
    
    // URI and Path are also available from java.base
    var path = Path.of("");
    System.out.println("Path: " + path.toAbsolutePath());
}