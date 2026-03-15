public class BookMyStayApp {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        CancellationService service = new CancellationService();

        String reservationId = "Single-1";
        String roomType = "Single";

        service.registerBooking(reservationId, roomType);

        System.out.println("Booking Cancellation");

        service.cancelBooking(reservationId, inventory);

        service.showRollbackHistory();

        System.out.println("\nUpdated Single Room Availability: "
                + inventory.getAvailability("Single"));
    }
}