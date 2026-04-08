import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

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

    static boolean isValidTrainId(String trainId) {
        Pattern pattern = Pattern.compile("^TRN-\\d{4}$");
        return pattern.matcher(trainId).matches();
    }

    static boolean isValidCargoCode(String cargo) {
        Pattern pattern = Pattern.compile("^[A-Z]{3,10}$");
        return pattern.matcher(cargo).matches();
    }

    public static void main(String[] args) {

        String trainId = "TRN-1234";
        String cargo = "COAL";

        System.out.println("Train ID valid: " + isValidTrainId(trainId));
        System.out.println("Cargo valid: " + isValidCargoCode(cargo));

        List<Bogie> bogies = Arrays.asList(
                new PassengerBogie("P1", "Sleeper", 72),
                new PassengerBogie("P2", "AC Chair", 60),
                new PassengerBogie("P3", "First Class", 40),
                new GoodsBogie("G1", "Rectangular", "Coal"),
                new GoodsBogie("G2", "Cylindrical", "Oil"),
                new GoodsBogie("G3", "Cylindrical", "Coal")
        );

        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        groupedBogies.forEach((type, list) -> {
            System.out.println("Type: " + type);
            list.forEach(b -> System.out.println("  Bogie ID: " + b.getId()));
        });

        int totalSeats = bogies.stream()
                .filter(b -> b instanceof PassengerBogie)
                .map(b -> (PassengerBogie) b)
                .map(PassengerBogie::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity: " + totalSeats);

        boolean isSafe = bogies.stream()
                .filter(b -> b instanceof GoodsBogie)
                .map(b -> (GoodsBogie) b)
                .allMatch(g ->
                        (g.getType().equals("Cylindrical") && g.getCargoType().equalsIgnoreCase("Oil")) ||
                        (g.getType().equals("Rectangular") && !g.getCargoType().equalsIgnoreCase("Oil"))
                );

        if (isSafe) {
            System.out.println("All goods bogies are safety compliant");
        } else {
            System.out.println("Safety violation detected in goods bogies");
        }
    }
}