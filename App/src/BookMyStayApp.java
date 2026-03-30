import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create List of passenger bogies
        List<Bogie> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 54));
        passengerBogies.add(new Bogie("First Class", 30));

        System.out.println("Before Sorting: " + passengerBogies);

        // Sort bogies by capacity (ascending order)
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("After Sorting by Capacity: " + passengerBogies);
    }
}