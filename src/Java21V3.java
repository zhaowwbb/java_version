// Define the records
record Point(double x, double y) {}
record ColoredPoint(Point point, String color) {}
record Circle(Point center, double radius) {}

public class Java21V3 {

    public static void main(String[] args) {
        // Creating a nested record structure
        Object obj = new ColoredPoint(new Point(10.5, 20.0), "Red");
        Object shape = new Circle(new Point(0.0, 0.0), 5.5);

        System.out.println("--- Record Pattern Matching (Java 21) ---");
        
        processObject(obj);
        processObject(shape);
    }

    private static void processObject(Object obj) {
        // 1. Nested Record Pattern with 'instanceof'
        // This deconstructs 'ColoredPoint' and the internal 'Point' in one go.
        if (obj instanceof ColoredPoint(Point(double x, double y), String color)) {
            System.out.println("Found a " + color + " point at: x=" + x + ", y=" + y);
        } 
        
        // 2. Record Pattern inside a 'switch' expression
        // Notice we use 'var' for type inference within the pattern.
        else {
            String result = switch (obj) {
                case Circle(Point(var x, var y), var radius) -> 
                    "Circle at (" + x + "," + y + ") with radius " + radius;
                case null -> "Object is null";
                default   -> "Unknown structure: " + obj.toString();
            };
            System.out.println(result);
        }
    }
}