/**
 * A Record automatically generates:
 * - Private final fields
 * - A canonical constructor
 * - Accessor methods (e.g., name(), price())
 * - equals(), hashCode(), and toString()
 */
record Product(String id, String name, double price) {
    // You can still add compact constructors for validation
    public Product {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    // You can also add instance methods
    public String getFormattedPrice() {
        return "$" + String.format("%.2f", price);
    }
}

public class Java17V3 {
    public static void main(String[] args) {
        // Initialize the record
        Product laptop = new Product("P100", "MacBook Pro", 1999.99);

        // 1. Automatic Accessors (no 'get' prefix)
        System.out.println("Product Name: " + laptop.name());
        
        // 2. Automatic toString()
        System.out.println("Record Details: " + laptop);

        // 3. Immutability
        // laptop.price(2000.0); // This would cause a compile error!

        // 4. Automatic equality check
        Product laptop2 = new Product("P100", "MacBook Pro", 1999.99);
        System.out.println("Are they equal? " + laptop.equals(laptop2)); // true
    }
}