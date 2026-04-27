public class Java17V4 {

    public static void main(String[] args) {
        // 1. Traditional String (The "Old" Way)
        String oldJson = "{\n" +
                         "  \"name\": \"Legacy\",\n" +
                         "  \"version\": 1.0\n" +
                         "}";

        // 2. Text Block (The "Modern" Way)
        // Starts with """ followed by a newline
        String modernJson = """
                {
                  "name": "Modern Java",
                  "version": 17.0,
                  "features": ["Sealed Classes", "Records", "Text Blocks"]
                }
                """;

        // 3. Text Block for SQL with a line wrapper (\)
        String sql = """
                SELECT id, name, email 
                FROM users 
                WHERE active = true \
                AND country = 'Canada'
                ORDER BY name ASC;
                """;

        System.out.println("--- JSON Output ---");
        System.out.println(modernJson);
        
        System.out.println("--- SQL Output ---");
        System.out.println(sql);
    }
}