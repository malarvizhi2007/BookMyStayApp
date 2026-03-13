import java.util.HashMap;
import java.util.Map;

/**
 * ==========================================================
 * CLASS - RoomInventory
 * ==========================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Stores and manages room availability using HashMap.
 *
 * @version 3.0
 */

public class RoomInventory {

    private Map<String, Integer> inventory;

    public RoomInventory() {

        inventory = new HashMap<>();

        inventory.put("SingleRoom", 5);
        inventory.put("DoubleRoom", 3);
        inventory.put("SuiteRoom", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int newValue) {
        inventory.put(roomType, newValue);
    }

    public void displayInventory() {

        System.out.println("Current Room Inventory:");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " Available: " + entry.getValue());
        }
    }
}