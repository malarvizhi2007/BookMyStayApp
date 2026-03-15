import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);
    }

    public void increaseRoom(String roomType) {
        int count = inventory.getOrDefault(roomType, 0);
        inventory.put(roomType, count + 1);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}