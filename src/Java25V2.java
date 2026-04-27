// No class declaration needed!
// No 'public static' or 'String[] args' required if not used.

int count = 0;

void main() {
    String greeting = getGreeting();
    System.out.println(greeting);
    count++;
    System.out.println("Execution count: " + count);
}

String getGreeting() {
    return "Hello from a compact Java 25 source file!";
}
