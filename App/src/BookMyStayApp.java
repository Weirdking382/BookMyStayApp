import java.util.ArrayList;
import java.util.List;

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display bogies after addition
        System.out.println("Passenger Bogies after addition: " + passengerBogies);

        // Remove a bogie (AC Chair)
        passengerBogies.remove("AC Chair");
        System.out.println("After removing AC Chair: " + passengerBogies);

        // Check if Sleeper exists
        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("Is Sleeper present? " + exists);

        // Final state
        System.out.println("Final Passenger Bogies: " + passengerBogies);
    }
}