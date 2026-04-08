import java.util.*;
import java.util.stream.*;

class InvalidCapacityException extends Exception {
    InvalidCapacityException(String message) {
        super(message);
    }
}

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

    PassengerBogie(String id, String type, int capacity) throws InvalidCapacityException {
        super(id, type);
        if (capacity <= 0) {
            throw new InvalidCapacityException("Invalid capacity for bogie " + id);
        }
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

        List<Bogie> bogies = new ArrayList<>();

        try {
            bogies.add(new PassengerBogie("P1", "Sleeper", 72));
            bogies.add(new PassengerBogie("P2", "AC Chair", 60));
            bogies.add(new PassengerBogie("P3", "First Class", 40));
            bogies.add(new PassengerBogie("P4", "Sleeper", -10));
        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        bogies.add(new GoodsBogie("G1", "Rectangular", "Coal"));
        bogies.add(new GoodsBogie("G2", "Cylindrical", "Oil"));

        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        groupedBogies.forEach((type, list) -> {
            System.out.println("Type: " + type);
            list.forEach(b -> System.out.println("  Bogie ID: " + b.getId()));
        });
    }
}