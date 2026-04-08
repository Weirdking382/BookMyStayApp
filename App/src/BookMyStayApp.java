import java.util.*;
import java.util.stream.*;

class InvalidCargoException extends Exception {
    InvalidCargoException(String message) {
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

    void assignCargo(String cargo) throws InvalidCargoException {
        if (type.equals("Cylindrical") && !cargo.equalsIgnoreCase("Oil")) {
            throw new InvalidCargoException("Unsafe cargo for Cylindrical bogie " + id);
        }
        if (type.equals("Rectangular") && cargo.equalsIgnoreCase("Oil")) {
            throw new InvalidCargoException("Unsafe cargo for Rectangular bogie " + id);
        }
        this.cargoType = cargo;
    }

    String getCargoType() {
        return cargoType;
    }
}

public class Main {
    public static void main(String[] args) {

        GoodsBogie g1 = new GoodsBogie("G1", "Cylindrical", "Oil");
        GoodsBogie g2 = new GoodsBogie("G2", "Rectangular", "Coal");

        try {
            g1.assignCargo("Coal");
            System.out.println("Cargo assigned to " + g1.getId());
        } catch (InvalidCargoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempted assignment for " + g1.getId());
        }

        try {
            g2.assignCargo("Oil");
            System.out.println("Cargo assigned to " + g2.getId());
        } catch (InvalidCargoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempted assignment for " + g2.getId());
        }

        List<Bogie> bogies = Arrays.asList(
                new PassengerBogie("P1", "Sleeper", 72),
                new PassengerBogie("P2", "AC Chair", 60),
                new PassengerBogie("P3", "First Class", 40),
                new GoodsBogie("G1", "Rectangular", "Coal"),
                new GoodsBogie("G2", "Cylindrical", "Oil")
        );

        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        groupedBogies.forEach((type, list) -> {
            System.out.println("Type: " + type);
            list.forEach(b -> System.out.println("  Bogie ID: " + b.getId()));
        });
    }
}