import java.util.*;
import java.util.stream.Collectors;

// Base Class
abstract class Bogie {
    private String id;

    public Bogie(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

// Passenger Bogie Class
class PassengerBogie extends Bogie {
    private String type;
    private int seatingCapacity;

    public PassengerBogie(String id, String type, int seatingCapacity) {
        super(id);
        this.type = type;
        this.seatingCapacity = seatingCapacity;
    }

    public String getType() {
        return type;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    @Override
    public String toString() {
        return "Bogie ID: " + getId() +
                ", Type: " + type +
                ", Capacity: " + seatingCapacity;
    }
}

// Main App
public class TrainConsistApp {
    public static void main(String[] args) {

        List<PassengerBogie> bogies = new ArrayList<>();

        bogies.add(new PassengerBogie("B1", "Sleeper", 72));
        bogies.add(new PassengerBogie("B2", "AC Chair", 45));
        bogies.add(new PassengerBogie("B3", "First Class", 30));
        bogies.add(new PassengerBogie("B4", "Sleeper", 65));
        bogies.add(new PassengerBogie("B5", "AC Chair", 55));

        // ✅ UC8: Filter high-capacity bogies (>50 seats)
        List<PassengerBogie> highCapacity = bogies.stream()
                .filter(b -> b.getSeatingCapacity() > 50)
                .collect(Collectors.toList());

        System.out.println("=== High Capacity Bogies (>50 seats) ===");
        highCapacity.forEach(System.out::println);

        // ✅ Filter only Sleeper bogies
        System.out.println("\n=== Sleeper Bogies ===");
        bogies.stream()
                .filter(b -> b.getType().equalsIgnoreCase("Sleeper"))
                .forEach(System.out::println);

        // ✅ Combined filter (Sleeper + capacity > 60)
        System.out.println("\n=== Sleeper Bogies with Capacity > 60 ===");
        bogies.stream()
                .filter(b -> b.getType().equalsIgnoreCase("Sleeper"))
                .filter(b -> b.getSeatingCapacity() > 60)
                .forEach(System.out::println);
    }
}