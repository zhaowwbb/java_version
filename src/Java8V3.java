import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.time.Duration;
import java.time.Month;

/**
 * Java 8 Example: New Date & Time API (java.time)
 */
public class Java8V3 {

    public static void main(String[] args) {
        
        // 1. LocalDate (Date without time)
        LocalDate today = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2024, Month.JANUARY, 1);
        System.out.println("Today: " + today);
        System.out.println("Plus 2 weeks: " + today.plusWeeks(2));

        // 2. LocalTime (Time without date)
        LocalTime now = LocalTime.now();
        System.out.println("Current Time: " + now);

        // 3. LocalDateTime (Combines date and time)
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Combined: " + currentDateTime);

        // 4. ZonedDateTime (Handling Time Zones)
        ZonedDateTime tokyoTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Time in Tokyo: " + tokyoTime);

        // 5. Formatting Dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentDateTime.format(formatter);
        System.out.println("Formatted: " + formattedDate);

        // 6. Period (Date-based amount of time)
        LocalDate birthDate = LocalDate.of(1995, Month.MAY, 15);
        Period age = Period.between(birthDate, today);
        System.out.println("Age: " + age.getYears() + " years, " + age.getMonths() + " months");

        // 7. Duration (Time-based amount of time in seconds/nanos)
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 30);
        Duration workShift = Duration.between(start, end);
        System.out.println("Work shift duration: " + workShift.toHours() + " hours");
    }
}