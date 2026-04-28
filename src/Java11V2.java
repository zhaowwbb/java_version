import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class Java11V2 {

    public static void main(String[] args) {
        // 1. Initialize the client (reusable for both sync and async)
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();

        // 2. Build a common request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                .header("Accept", "application/json")
                .GET()
                .build();

        // --- Synchronous Call ---
        System.out.println(">>> Starting Synchronous Call...");
        executeSync(client, request);

        // --- Asynchronous Call (using CompletableFuture) ---
        System.out.println("\n>>> Starting Asynchronous Call...");
        CompletableFuture<Void> asyncTask = executeAsync(client, request);

        // Do other work while the request is processing
        System.out.println(">>> Main thread is free to perform other tasks...");

        // Wait for the async task to complete before exiting the JVM
        asyncTask.join();
        System.out.println("\n>>> All tasks finished.");
    }

    /**
     * Blocks the current thread until the response returns.
     */
    private static void executeSync(HttpClient client, HttpRequest request) {
        try {
            // send() returns HttpResponse directly
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("[Sync Result] Status: " + response.statusCode());
            System.out.println("[Sync Result] Body: " + response.body());
        } catch (Exception e) {
            System.err.println("Sync Error: " + e.getMessage());
        }
    }

    /**
     * Does not block. Returns a CompletableFuture immediately.
     */
    private static CompletableFuture<Void> executeAsync(HttpClient client, HttpRequest request) {
        // sendAsync() returns CompletableFuture<HttpResponse<T>>
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    System.out.println("[Async] Response received.");
                    return response.body();
                })
                .thenAccept(body -> {
                    System.out.println("[Async Result] Body: " + body);
                })
                .exceptionally(ex -> {
                    System.err.println("Async Error: " + ex.getMessage());
                    return null;
                });
    }
}