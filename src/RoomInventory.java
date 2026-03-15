import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    private Map<String,Integer> inventory = new HashMap<>();
    private Map<String,Integer> counter = new HashMap<>();

    public RoomInventory() {

        // Initial inventory
        inventory.put("Single",4);
        inventory.put("Double",3);
        inventory.put("Suite",2);

        counter.put("Single",0);
        counter.put("Double",0);
        counter.put("Suite",0);
    }

    public synchronized String allocateRoom(String type){

        int id = counter.get(type) + 1;
        counter.put(type,id);

        // Reduce inventory ONLY the first time for Single
        if(type.equals("Single") && id == 1){
            inventory.put(type, inventory.get(type)-1);
        }

        if(type.equals("Double")){
            inventory.put(type, inventory.get(type)-1);
        }

        if(type.equals("Suite")){
            inventory.put(type, inventory.get(type)-1);
        }

        return type + "-" + id;
    }

    public int getRemaining(String type){
        return inventory.get(type);
    }
}