import module java.base; // Using Java 25 Module Imports

public class Java25V4 {
// 1. Define the ScopedValue
    private final static ScopedValue<String> CURRENT_USER = ScopedValue.newInstance();

    void main() {
        // 2. Bind a value and run a scope
        ScopedValue.where(CURRENT_USER, "Admin_User").run(() -> {
            processRequest();
        });

        // Outside the scope, CURRENT_USER.get() would throw a NoSuchElementException
        CURRENT_USER.get();
    }

    void processRequest() {
        System.out.println("Processing for: " + CURRENT_USER.get());
        saveToDatabase();
    }

    void saveToDatabase() {
        // The value is still accessible here without being passed as an argument
        System.out.println("Audit Log: Data saved by " + CURRENT_USER.get());
    }    
}
