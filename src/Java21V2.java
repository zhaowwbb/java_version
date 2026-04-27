import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.SequencedCollection;
import java.util.SequencedMap;

public class Java21V2 {

    public static void main(String[] args) {
        // --- 1. SequencedCollection (List/Set) ---
        System.out.println("--- SequencedCollection Demo ---");
        
        // ArrayList now implements SequencedCollection
        SequencedCollection<String> list = new ArrayList<>();
        
        // New methods for predictable element placement
        list.addFirst("Third");  // [Third]
        list.addFirst("Second"); // [Second, Third]
        list.addFirst("First");  // [First, Second, Third]
        list.addLast("Fourth");  // [First, Second, Third, Fourth]

        System.out.println("Original List: " + list);
        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element:  " + list.getLast());

        // The reversed() method provides a live view without copying the data
        System.out.println("Reversed View: " + list.reversed());

        // --- 2. SequencedMap (LinkedHashMap) ---
        System.out.println("\n--- SequencedMap Demo ---");
        
        // LinkedHashMap now implements SequencedMap
        SequencedMap<String, Integer> map = new LinkedHashMap<>();
        
        map.putLast("Alpha", 1);
        map.putLast("Beta", 2);
        map.putFirst("Omega", 0); // Put at the very beginning

        System.out.println("Original Map: " + map);
        System.out.println("First Entry:  " + map.firstEntry());
        System.out.println("Last Entry:   " + map.lastEntry());

        // Remove the last entry easily
        map.pollLastEntry();
        System.out.println("After pollLastEntry: " + map);
    }
}

