import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Java 8 Example: Stream API
 */
public class Java8V2 {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Phone", "Electronics", 800.0),
                new Product("Bread", "Food", 2.5),
                new Product("Apple", "Food", 1.0),
                new Product("Monitor", "Electronics", 300.0)
        );

        // Task: Get names of Electronics priced above 500, sorted alphabetically
        List<String> expensiveElectronics = products.stream()
                .filter(p -> p.getCategory().equals("Electronics")) // Intermediate: Filter
                .filter(p -> p.getPrice() > 500)                    // Intermediate: Filter
                .map(Product::getName)                             // Intermediate: Transform to String
                .sorted()                                          // Intermediate: Sort
                .collect(Collectors.toList());                     // Terminal: Produce List

        System.out.println("Expensive Electronics: " + expensiveElectronics);

        // Task: Calculate the total cost of all 'Food' items
        double totalFoodCost = products.stream()
                .filter(p -> p.getCategory().equals("Food"))
                .mapToDouble(Product::getPrice)
                .sum(); // Terminal: Numeric aggregation

        System.out.println("Total Food Cost: $" + totalFoodCost);
    }

    // Simple POJO for the example
    static class Product {
        private String name;
        private String category;
        private double price;

        public Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public String getName() { return name; }
        public String getCategory() { return category; }
        public double getPrice() { return price; }
    }
}