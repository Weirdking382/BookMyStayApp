import java.util.HashSet;
import java.util.Set;

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create HashSet for bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Add bogie IDs (including duplicates)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // Duplicate
        bogieIds.add("BG102"); // Duplicate

        // Display unique bogie IDs
        System.out.println("Unique Bogie IDs: " + bogieIds);
    }
}