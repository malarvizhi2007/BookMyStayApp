public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        String filePath = "inventory.txt";

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistence = new FilePersistenceService();

        // Try loading saved inventory
        persistence.loadInventory(inventory, filePath);

        System.out.println("\nCurrent Inventory:");

        System.out.println("Single: " + inventory.getInventory().get("Single"));
        System.out.println("Double: " + inventory.getInventory().get("Double"));
        System.out.println("Suite: " + inventory.getInventory().get("Suite"));

        // Save inventory snapshot
        persistence.saveInventory(inventory, filePath);

        System.out.println("Inventory saved successfully.");
    }
}