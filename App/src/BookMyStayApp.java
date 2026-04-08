import java.util.*;
import java.util.stream.*;

abstract class Bogie {
    String id;
    String type;

    Bogie(String id, String type) {
        this.id = id;
        this.type = type;
    }

    String getId() {
        return id;
    }

    String getType() {
        return type;
    }
}

class PassengerBogie extends Bogie {
    int capacity;

    PassengerBogie(String id, String type, int capacity) {
        super(id, type);
        this.capacity = capacity;
    }

    int getCapacity() {
        return capacity;
    }
}

class GoodsBogie extends Bogie {
    String cargoType;

    GoodsBogie(String id, String type, String cargoType) {
        super(id, type);
        this.cargoType = cargoType;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Bogie> bogies = Arrays.asList(
                new PassengerBogie("P1", "Sleeper", 72),
                new PassengerBogie("P2", "AC Chair", 60),
                new PassengerBogie("P3", "First Class", 40),
                new GoodsBogie("G1", "Rectangular", "Coal"),
                new GoodsBogie("G2", "Cylindrical", "Oil")
        );

        int totalSeats = bogies.stream()
                .filter(b -> b instanceof PassengerBogie)
                .map(b -> (PassengerBogie) b)
                .map(PassengerBogie::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity: " + totalSeats);
    }
}