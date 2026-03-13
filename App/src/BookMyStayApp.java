import java.util.HashMap;
import java.util.Map;

public class RoomInventory {
    // The Centralized Store
    private Map<String, Integer> inventory = new HashMap<>();

    // Registering Room Types
    public void initializeRoom(String type, int count) {
        inventory.put(type, count);
    }

    // Controlled Updates (The "Logic" Layer)
    public boolean updateAvailability(String type, int change) {
        if (inventory.containsKey(type)) {
            int current = inventory.get(type);
            if (current + change >= 0) {
                inventory.put(type, current + change);
                return true;
            }
        }
        return false; // Insufficient rooms or invalid type
    }

    // Displaying State
    public void showInventory() {
        inventory.forEach((type, count) ->
                System.out.println(type + ": " + count + " available"));
    }
}