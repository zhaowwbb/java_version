import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Java21V1 {

    public static void main(String[] args) {
        int taskCount = 10_000;

        System.out.println("--- Comparison: 10,000 Blocking Tasks ---");

        // 1. Performance of Traditional Platform Threads (Fixed Pool)
        // We limit it to 100 threads to simulate a typical server environment
        testPerformance("Platform Threads (Fixed Pool: 100)", taskCount, () -> 
            Executors.newFixedThreadPool(100)
        );

        // 2. Performance of Virtual Threads
        testPerformance("Virtual Threads", taskCount, () -> 
            Executors.newVirtualThreadPerTaskExecutor()
        );
    }

    private static void testPerformance(String label, int taskCount, java.util.function.Supplier<java.util.concurrent.ExecutorService> executorSupplier) {
        Instant start = Instant.now();

        try (var executor = executorSupplier.get()) {
            IntStream.range(0, taskCount).forEach(i -> {
                executor.submit(() -> {
                    try {
                        // Simulate a blocking I/O call (e.g., database or API)
                        Thread.sleep(Duration.ofMillis(100));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            });
        } // try-with-resources calls executor.close() which waits for all tasks to finish

        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.printf("%-35s : %d ms%n", label, duration);
    }
}