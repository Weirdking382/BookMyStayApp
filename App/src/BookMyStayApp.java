import java.util.LinkedList;

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create LinkedList for train consist
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add bogies
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist: " + trainConsist);

        // Insert Pantry Car at position 2
        trainConsist.add(2, "Pantry Car");
        System.out.println("After adding Pantry Car: " + trainConsist);

        // Remove first and last bogie
        trainConsist.removeFirst();
        trainConsist.removeLast();

        // Final consist
        System.out.println("Final Train Consist: " + trainConsist);
    }
}