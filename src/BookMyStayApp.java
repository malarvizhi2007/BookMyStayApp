/**
 * ==========================================================
 * MAIN CLASS - BookMyStayApp
 * ==========================================================
 *
 * Demonstrates centralized room inventory management.
 *
 * @version 3.0
 */

public class  BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Room Inventory System\n");

        RoomInventory inventory = new RoomInventory();

        inventory.displayInventory();

        System.out.println("\nChecking availability for SingleRoom:");
        System.out.println(inventory.getAvailability("SingleRoom"));

        System.out.println("\nUpdating DoubleRoom availability...");

        int current = inventory.getAvailability("DoubleRoom");
        inventory.updateAvailability("DoubleRoom", current + 1);

        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}