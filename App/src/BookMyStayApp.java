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

    String getCargoType() {
        return cargoType;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            bogies.add(new PassengerBogie("P" + i, "Sleeper", 72));
            bogies.add(new GoodsBogie("G" + i, "Cylindrical", "Oil"));
        }

        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        groupedBogies.forEach((type, list) -> {
            System.out.println("Type: " + type);
            list.forEach(b -> System.out.println("  Bogie ID: " + b.getId()));
        });

        long startLoop = System.nanoTime();

        int totalSeatsLoop = 0;
        for (Bogie b : bogies) {
            if (b instanceof PassengerBogie) {
                totalSeatsLoop += ((PassengerBogie) b).getCapacity();
            }
        }

        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();

        int totalSeatsStream = bogies.stream()
                .filter(b -> b instanceof PassengerBogie)
                .map(b -> (PassengerBogie) b)
                .mapToInt(PassengerBogie::getCapacity)
                .sum();

        long endStream = System.nanoTime();

        System.out.println("Loop Total Seats: " + totalSeatsLoop);
        System.out.println("Stream Total Seats: " + totalSeatsStream);
        System.out.println("Loop Time: " + (endLoop - startLoop) + " ns");
        System.out.println("Stream Time: " + (endStream - startStream) + " ns");
    }
}